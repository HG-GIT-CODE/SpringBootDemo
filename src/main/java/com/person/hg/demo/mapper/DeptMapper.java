package com.person.hg.demo.mapper;

import com.person.hg.demo.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper // 指定mapper类
@Repository
public interface DeptMapper {

    public Dept getDeptById(Integer id);
}
