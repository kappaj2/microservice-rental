package za.co.ajk.rentclount.rentcloudui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@SpringBootApplication
public class RentcloudUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentcloudUiApplication.class, args);
    }

}
