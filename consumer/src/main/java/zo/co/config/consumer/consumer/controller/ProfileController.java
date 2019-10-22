package zo.co.config.consumer.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zo.co.config.consumer.consumer.model.MemberProfileConfiguration;

@Controller
public class ProfileController {

    @Autowired
    private MemberProfileConfiguration memberProfileConfiguration;

    @RequestMapping("/profile")
    public ResponseEntity<MemberProfileConfiguration> getConfig() {

        return ResponseEntity.ok().body(memberProfileConfiguration);

    }

    @RequestMapping("/profile2")
    public String getConfig(Model model) {

        model.addAttribute("model", memberProfileConfiguration.getDefaultModel());
        model.addAttribute("min", memberProfileConfiguration.getMinRentalPeriod());
        return "mprofile";

    }
}
