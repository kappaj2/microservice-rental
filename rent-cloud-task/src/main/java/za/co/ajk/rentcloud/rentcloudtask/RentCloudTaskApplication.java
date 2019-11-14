package za.co.ajk.rentcloud.rentcloudtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;
import za.co.ajk.rentcloud.rentcloudtask.services.RentProcessTaskRunner;

@SpringBootApplication
@EnableTask
public class RentCloudTaskApplication {

    @Bean
    RentProcessTaskRunner getRentProcesTaskRunner() {
        return new RentProcessTaskRunner();
    }

    public static void main(String[] args) {
        SpringApplication.run(RentCloudTaskApplication.class, args);
    }

}
