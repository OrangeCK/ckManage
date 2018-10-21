package com.example.baseframe.myspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * @author 01378803
 * @date 2018/10/17 15:06
 * Description  :
 */
@SpringBootApplication
@EnableTransactionManagement
@PropertySource("classpath:config/sys.properties")
public class MyspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyspringbootApplication.class, args);
	}
}
