package com.jiean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 *
 * @author george
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class JieAnApplication {
    public static void main(String[] args) {
        SpringApplication.run(JieAnApplication.class, args);
    }
}
