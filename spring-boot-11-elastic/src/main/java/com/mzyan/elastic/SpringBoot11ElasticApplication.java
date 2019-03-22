package com.mzyan.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  SpringBoot 默认支持两种技术来和ES交互
 *  1、Jest （默认不支持)：需要导入Jest的工具包(io.searchbox.client.JestClient)
 *  2、SpringData ElasticSearch
 *      1) Client 节点信息 clusterNodes、clusterName
 *      2) ElasticSearchTemplate 操作 es
 *      3）编写一个 ElasticsearchRepository 的子接口来操作ES
 */

@SpringBootApplication
public class SpringBoot11ElasticApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot11ElasticApplication.class, args);
    }

}
