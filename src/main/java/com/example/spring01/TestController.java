package com.example.spring01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/test")
public class TestController {

    @GetMapping("/message")
    //@RequestMapping(value = "/message", method = RequestMethod.GET)
    @ResponseBody
    public String getMessage(){
        return "Merhaba Godoro";
    }
}
