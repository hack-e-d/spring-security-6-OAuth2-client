package com.hacked.springsecurity6oauth2client.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class DemoController {

    /*
    * Get token endpoint fetches the bearer token from the authorization server
    * @author vijay pv
    * @return bearer token
    * */
    @GetMapping("/getToken")
    public String getToken() {
        return "";
    }
}
