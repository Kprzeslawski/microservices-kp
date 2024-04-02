package com.przeslawskik.loc_n_mob_module.contoller;

import com.przeslawskik.loc_n_mob_module.service.LNMMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/battle")
public class LNMMContoller {
    @Autowired
    private LNMMService service;
}
