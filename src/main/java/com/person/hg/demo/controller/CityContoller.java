package com.person.hg.demo.controller;

import com.person.hg.demo.entity.City;
import com.person.hg.demo.mapper.CityMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(description = "City操作接口")
@RestController
@RequestMapping("/city")
public class CityContoller {

    @Autowired
    CityMapper cityMapper;

    @ApiOperation(value = "根据id获取城市", notes="根据id获取城市notes")
    @ApiImplicitParam(name = "id", value = "2", paramType = "path", required = true, dataType = "Integer")
    @GetMapping("/getCityById/{id}")
    public City getCityById(@PathVariable Integer id) {
        return cityMapper.getCityById(id);
    }

    @ApiOperation(value = "获取城市", notes="获取城市notes")
    @GetMapping(value = {"/getCity"})
    public City getCityById() {
        return cityMapper.getCityById(1);
    }

}
