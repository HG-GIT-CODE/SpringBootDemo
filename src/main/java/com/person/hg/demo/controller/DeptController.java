package com.person.hg.demo.controller;

import com.person.hg.demo.entity.Dept;
import com.person.hg.demo.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptMapper deptMapper;

    @GetMapping("/getDeptById/{id}")
    public Dept getDeptById(@PathVariable Integer id) {
        return deptMapper.getDeptById(id);
    }
}
