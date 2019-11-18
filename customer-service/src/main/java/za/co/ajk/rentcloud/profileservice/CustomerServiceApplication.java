package za.co.ajk.rentcloud.profileservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EntityScan(basePackages = "za.co.ajk.rentcloud.model.customer")
//@EnableResourceServer    //secure profile service by making this a resource server as well
//@EnableGlobalMethodSecurity(prePostEnabled = true)    //	needed for role access
@EnableEurekaClient
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

}
