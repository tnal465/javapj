package project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("project.repository")  
public class MyBatisConfig {
}
