package za.co.ajk.rentcloud.authorizationserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class JdbcAuthServerProfileConfiguration implements CommandLineRunner {

    @Autowired
    private Environment environment;

    public String getUrl() {
        return environment.getProperty("spring.datasource.url");
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("URL Value : " + getUrl());
    }
}
