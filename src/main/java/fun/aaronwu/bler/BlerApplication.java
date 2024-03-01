package fun.aaronwu.bler;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("fun.aaronwu.bler.mapper")
@EnableCaching
public class BlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlerApplication.class, args);
    }

}
