package pch.huellaschile.msgestionveterinarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MsGestionVeterinariosApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsGestionVeterinariosApplication.class, args);
    }

}
