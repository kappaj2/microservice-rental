package zo.co.config.consumer.consumer.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class MemberProfileConfiguration {

    @Autowired
    Environment environment;

    public String getDefaultModel() {
        return environment.getProperty("vehicle.default.model");
    }

    public String getMinRentalPeriod() {
        return environment.getProperty("member.rent.min");
    }
}
