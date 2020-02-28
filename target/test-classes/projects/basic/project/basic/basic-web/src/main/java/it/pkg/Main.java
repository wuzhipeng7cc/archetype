package it.pkg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = "it.pkg")
@EnableFeignClients(value = "it.pkg")
@EnableTransactionManagement
@EnableScheduling
@MapperScan("it.pkg.db.mapper")
public class Main {


        public static void main(String[] args) {
            SpringApplication.run(Main.class, args);
        }

}
