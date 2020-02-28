#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = "${package}")
@EnableFeignClients(value = "${package}")
@EnableTransactionManagement
@EnableScheduling
@MapperScan("${package}.db.mapper")
public class Main {


        public static void main(String[] args) {
            SpringApplication.run(Main.class, args);
        }

}
