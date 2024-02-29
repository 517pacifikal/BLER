package fun.aaronwu.bler;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("fun.aaronwu.bler.mapper")
public class BlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlerApplication.class, args);
    }

}
