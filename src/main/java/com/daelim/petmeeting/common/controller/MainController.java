package com.daelim.petmeeting.common.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Log4j2
@RestController
@RequestMapping(value = "/main/", method = RequestMethod.GET)
public class MainController {
    @GetMapping("/hello")
    public String hello() {
        return "hello react";
    }
}
