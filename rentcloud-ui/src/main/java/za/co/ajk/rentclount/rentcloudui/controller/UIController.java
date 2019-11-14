package za.co.ajk.rentclount.rentcloudui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import za.co.ajk.rentcloud.model.customer.Customer;
import za.co.ajk.rentclount.rentcloudui.config.AccessToken;

@Controller
@EnableOAuth2Sso
public class UIController extends WebSecurityConfigurerAdapter {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/")
                .permitAll()
                .anyRequest()
                .authenticated();
    }

    @RequestMapping(value = "/")
    public String loadUI() {
        return "home";
    }

    @RequestMapping(value = "/secure")
    public String loadSecuredUI() {
        return "secure";
    }

    @RequestMapping(value = "/customers")
    public String loadCustomers(Model model) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", AccessToken.getAccessToken());
        HttpEntity<Customer> customerHttpEntity = new HttpEntity<>(httpHeaders);

        try {
            ResponseEntity<Customer[]> responseEntity
                    = restTemplate.exchange("http://localhost:8181/services/customers",
                    HttpMethod.GET,
                    customerHttpEntity,
                    Customer[].class);

            model.addAttribute("customers", responseEntity.getBody());

        } catch (HttpStatusCodeException hs) {

            ResponseEntity responseEntity = ResponseEntity.status(hs.getRawStatusCode()).body(hs.getResponseBodyAsString());
            model.addAttribute("error", responseEntity);
        }
        return "secure";
    }
}
