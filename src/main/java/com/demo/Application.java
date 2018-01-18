package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
@Configuration // 相当于在xml配置beans标签元素
@SpringBootApplication // 表示开启spring注解
@ServletComponentScan // 使用后，Servlet、Filter、Listener 可以直接通过
// @WebServlet、@WebFilter、@WebListener 注解自动注册
@EnableScheduling // 表示允许执行定时器
@EnableAsync // 表示允许异步执行，即开启多线程
public class Application extends SpringBootServletInitializer {
    @RequestMapping("/")
	String hello(){
		return "index";
	}
	@RequestMapping("/now")
	String hehe(){
		return "现在时间"+(new Date()).toLocaleString();
	}
	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

}
