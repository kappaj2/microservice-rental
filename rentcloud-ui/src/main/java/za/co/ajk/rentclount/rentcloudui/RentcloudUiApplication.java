package za.co.ajk.rentclount.rentcloudui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RentcloudUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentcloudUiApplication.class, args);
    }

}
