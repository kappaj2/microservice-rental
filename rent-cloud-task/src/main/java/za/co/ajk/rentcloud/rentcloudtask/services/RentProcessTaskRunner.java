package za.co.ajk.rentcloud.rentcloudtask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class RentProcessTaskRunner implements CommandLineRunner {

    @Autowired
    private RentProcessService rentProcessService;

    @Override
    public void run(String... args) throws Exception {

        if (args.length > 0) {
            if (rentProcessService.validateDL(args[0])) {
                System.out.println("Valid dl");
            } else {
                System.out.println("Invalid dl");
            }
        } else {
            System.out.println("Dunning without arguments");
        }
    }
}
