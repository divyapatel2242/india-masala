package com.masala.indianSpices.login.controller;

import com.masala.indianSpices.Dto.Customer;
import com.masala.indianSpices.Dto.LoginCreds;
import com.masala.indianSpices.Dto.Password;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loginPage")
public interface LoginController {

    @GetMapping("/")
    public String getLoginPage();

    @PostMapping("/login")
    public Customer loginInto(LoginCreds loginCreds);

    @PostMapping("/forgotPassword")
    public String updatePasssword(Password password);

}
