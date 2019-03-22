package com.mzyan.elastic;

import com.mzyan.elastic.bean.Article;
import com.mzyan.elastic.bean.Book;
import com.mzyan.elastic.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot11ElasticApplicationTests {

    @Autowired
    JestClient jestClient;

    @Autowired
    BookRepository bookRepository;

    @Test
    public void test(){
        Book book = new Book();
        book.setId(1);
        book.setBookName("西游记");
        book.setAuthor("吴承恩");
        bookRepository.index(book);
    }



    @Test
    public void contextLoads(){

        // 1、给 ES 中索引（保存）一个文档
        Article article = new Article();
        article.setId(1);
        article.setAuthor("mzyan");
        article.setTitle("good news");
        article.setContent("haha");

        // 构建一个索引功能
        Index index = new Index.Builder(article).index("mzyan").type("news").build();

        try {
            //执行
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 测试搜索
    @Test
    public void search(){
        String json = "{\n" +
                "\t\"query\":{\n" +
                "\t\t\"match\":{\n" +
                "\t\t\t\"content\":\"haha\"\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";

        Search search = new Search.Builder(json).addIndex("mzyan").addType("news").build();

        try {
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
