package com.person.hg.demo.controller;

import com.person.hg.demo.entity.City;
import com.person.hg.demo.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
public class CityContoller {

    @Autowired
    CityMapper cityMapper;

    @GetMapping("/getCityById/{id}")
    public City getCityById(@PathVariable Integer id) {
        return cityMapper.getCityById(id);
    }

    @GetMapping(value = {"/getCity"})
    public City getCityById() {
        return cityMapper.getCityById(1);
    }

}
