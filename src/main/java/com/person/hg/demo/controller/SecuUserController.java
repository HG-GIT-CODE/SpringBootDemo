package com.person.hg.demo.controller;

import com.person.hg.demo.model.SecuUser;
import com.person.hg.demo.service.SecuUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/SecuUser")
public class SecuUserController{

    @Autowired
    private SecuUserService secuUserService;

    @GetMapping("/getDeptById/{id}")
    public SecuUser getModelByKey(@PathVariable String id) {
        return secuUserService.getModelByKey(id);
    }
}

