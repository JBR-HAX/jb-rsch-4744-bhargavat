package org.jetbrains.assignment;

<<<<<<< HEAD
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

=======
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

>>>>>>> 8515ef6 (Initial commit)
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
