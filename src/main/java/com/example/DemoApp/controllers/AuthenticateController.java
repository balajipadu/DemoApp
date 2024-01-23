package com.example.DemoApp.controllers;

import com.example.DemoApp.beans.HelloWorldBean;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class AuthenticateController {

    //@PostMapping("/authenticate")
    @GetMapping("/helloWorld")
    public String helloWorld()
    {
        return "Hello world ";
    }
    @GetMapping("/helloWorldBean")
    public HelloWorldBean getHelloWorldBean()
    {
        //throw new RuntimeException("reach customer response");
        return new HelloWorldBean("Hello World Bean");
    }
    @GetMapping("/helloWorld/pathVariable/{name}")
    public HelloWorldBean getHelloWorldBean(@PathVariable String name)
    {
        //throw new RuntimeException("reach customer response");
        return new HelloWorldBean("Hello World Bean --> " + name);
    }
}
