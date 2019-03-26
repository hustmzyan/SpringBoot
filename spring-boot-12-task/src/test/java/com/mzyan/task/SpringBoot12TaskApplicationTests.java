package com.mzyan.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot12TaskApplicationTests {


    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Test
    public void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();

        //邮件设置
        message.setSubject("通知-今晚开会");
        message.setText("今晚7：30开会。");

        message.setTo("651466909@qq.com");
        message.setFrom("2524094@qq.com");

        javaMailSender.send(message);

    }

    @Test
    public void test02() throws MessagingException {
        //1、创建一个复杂的消息邮件
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        //2、邮件设置
        helper.setSubject("通知-今晚开会");
        helper.setText("<b style='color:red'>今天 7：30 开会</b>", true);

        helper.setTo("651466909@qq.com");
        helper.setFrom("2524094@qq.com");

        //3、上传文件
        helper.addAttachment("1.png", new File("/Users/macbook/Desktop/SpringBoot/1.png"));
        helper.addAttachment("2.png", new File("/Users/macbook/Desktop/SpringBoot/2.png"));

        javaMailSender.send(message);
    }

}
