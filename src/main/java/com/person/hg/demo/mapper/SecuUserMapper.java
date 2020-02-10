package com.person.hg.demo.mapper;

import com.person.hg.demo.model.SecuUser;
import com.suncreate.core.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public class SecuUserMapper extends BaseMapper<SecuUser, String> {

    public SecuUserMapper() {
        super();
    }

    @Override
    public Class getEntityClass() {
        return SecuUserMapper.class;
    }
}
