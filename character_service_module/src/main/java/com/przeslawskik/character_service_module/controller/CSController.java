package com.przeslawskik.character_service_module.controller;

import com.przeslawskik.character_service_module.service.CSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class CSController {

    @Autowired
    private CSService service;

}
