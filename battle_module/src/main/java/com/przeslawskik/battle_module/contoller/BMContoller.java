package com.przeslawskik.battle_module.contoller;

import com.przeslawskik.battle_module.service.BMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/battle")
public class BMContoller {
    @Autowired
    private BMService service;
}
