package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
@RestController
@SpringBootApplication
@ServletComponentScan
@RequestMapping("/")
public class SpringbootDemoApplication{
    @RequestMapping("/hello")
	String hello(){
		return "hello world!";
	}
	@RequestMapping("/now")
	String hehe(){
		return "现在时间"+(new Date()).toLocaleString();
	}



	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}
	/*@Override
	protected  void configurePathMatch(PathMatchConfigurer configurer){
		super.configurePathMatch(configurer);
		// 常用的两种
		// 匹配结尾 / :会识别 url 的最后一个字符是否为 /
		// localhost:8080/test 与 localhost:8080/test/ 等价
		configurer.setUseTrailingSlashMatch(true);
		// 匹配后缀名：会识别 xx.* 后缀的内容
		// localhost:8080/test 与 localhost:8080/test.jsp 等价
		configurer.setUseSuffixPatternMatch(true);

	}*/
}
