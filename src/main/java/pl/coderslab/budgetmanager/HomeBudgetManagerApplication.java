package pl.coderslab.budgetmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class HomeBudgetManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeBudgetManagerApplication.class, args);
    }

}
