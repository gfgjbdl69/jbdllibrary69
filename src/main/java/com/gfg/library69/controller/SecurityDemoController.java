package com.gfg.library69.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityDemoController {


    @GetMapping("greet/{username}")
    public String greet(@PathVariable String username){
        return "Hello "+username;
    }
    //Url -> localhost:8080/admin/greet/john
    //RequestMapperHandlerMapping Map<String(url),String(controller method)>
    //key -> admin/greet/{username} -> Controller Method -> SecurityDemoController.adminGreet


    @GetMapping("admin/greet/{username}")
    public String adminGreet(@PathVariable String username){
        return "Hello Admin "+username;
    }

    @GetMapping("/csrf")
    public String homePage(HttpServletRequest request){
        CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        return csrfToken.getToken();

    }

    @GetMapping("/readoauth")
    public String readOauth(Authentication authentication){
        ObjectMapper mapper=new ObjectMapper();
        try {
            return mapper.writeValueAsString(authentication);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
