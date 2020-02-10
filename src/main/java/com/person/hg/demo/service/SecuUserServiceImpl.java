package com.person.hg.demo.service;

import com.alibaba.fastjson.JSON;
import com.person.hg.demo.model.SecuUser;
import com.suncreate.core.BaseService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SecuUserServiceImpl extends BaseService<SecuUser, String> implements SecuUserService{

    @Override
    public List<SecuUser> getCountGroupByDeptId(SecuUser model) {
        return null;
    }

    @Override
    public Long getMaxUserPriority(SecuUser model) {
        return null;
    }

    @Override
    public JSON getTreeList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return null;
    }

    @Override
    public JSON deleteById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return null;
    }
}
