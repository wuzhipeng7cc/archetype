package it.pkg.db.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@Slf4j
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "it.pkg.db.mapper")
public class MybatisConfig {
}
