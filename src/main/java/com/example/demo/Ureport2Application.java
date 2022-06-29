package com.example.demo;

import com.bstek.ureport.console.UReportServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

@SpringBootApplication(scanBasePackages = {"com.example.demo"})
//定义mapper区
@MapperScan(basePackages = "com.example.demo.Mapper",annotationClass = Repository.class)
@ImportResource("classpath:context.xml")
public class Ureport2Application {

    public static void main(String[] args) {
        SpringApplication.run(Ureport2Application.class, args);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        //获取Bean对象
        //String[] allBeanNames = applicationContext.getBeanDefinitionNames();
       // applicationContext.getBean(AopForUs.class);
    }

    @Bean
    public ServletRegistrationBean buildUReportServlet(){
        return new ServletRegistrationBean(new UReportServlet(),"/ureport/*");
    }


}
