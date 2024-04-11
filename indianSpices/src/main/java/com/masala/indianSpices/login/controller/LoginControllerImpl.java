package com.masala.indianSpices.login.controller;

import com.masala.indianSpices.Dto.Customer;
import com.masala.indianSpices.Dto.LoginCreds;
import com.masala.indianSpices.Dto.Password;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LoginControllerImpl implements LoginController{
    @Override
    public String getLoginPage() {
        return "Hi Welcome to Indian Spices Market!!";
    }

    @Override
    public Customer loginInto(LoginCreds loginCreds) {
//        Customer customer = new Customer();
//        customer.setId(34567);
//        customer.setName("Divya");
        return null;
    }

    @Override
    public String updatePasssword(Password password) {
        return null;
    }
}
