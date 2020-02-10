package com.person.hg.demo.mapper;

import com.person.hg.demo.entity.City;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * 注解版
 */
@Mapper // 指定这是一个操作数据库的mapper，若不想每个mapper类都写，可在application类统一配置@MapperScan(value = "com.person.hg.demo.mapper")
@Repository
public interface CityMapper {

    @Select("select * from city where id = #{id}")
    public City getCityById(Integer id);

    @Options(useGeneratedKeys=true, keyProperty = "id") // 为了匹配主键自增
    @Insert("insert into city(city_name) values(#{cityName})")
    public int addCity(City city);

    @Delete("delete from city where id = #{id}")
    public int deleteCityById(Integer id);

    @Update("update city set city_name = #{cityName} where id = #{id}")
    public int updateCity(City city);
}
