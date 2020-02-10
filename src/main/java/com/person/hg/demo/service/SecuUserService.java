package com.person.hg.demo.service;

import com.alibaba.fastjson.JSON;
import com.person.hg.demo.model.SecuUser;
import com.suncreate.core.IBaseService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * <p>
 * Title: SecuUser.java</p>
 * <p>
 * Description:系统管理用户服务接口</p>
 * <p>
 * Copyright: Copyright (c) 2014</p>
 *
 * @author fanlianwei
 * @date 2014-10-3 23:50:32
 * @version V1.0
 */
@Service
public interface SecuUserService extends IBaseService<SecuUser, String> {

    /**
     * 按机构ID分组
     * @param model
     * @return
     */
    public List<SecuUser> getCountGroupByDeptId(SecuUser model);

    /**
     * 获取最大的排序
     * @param model
     * @return
     */
    public Long getMaxUserPriority(SecuUser model);

    /**
     * 按用户ID获取用户信息
     */
    public SecuUser getModelByKey(String userId);

    /** (non-Javadoc)
     * @see com.suncreate.core.IBaseService#countAll(java.lang.Object)
     */
    public Long countAll(SecuUser model);

    /**
     * 获取用户树形数据
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public JSON getTreeList(HttpServletRequest request, HttpServletResponse response)throws Exception;

    /**
     * 异步删除
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    JSON deleteById (HttpServletRequest request, HttpServletResponse response) throws  Exception;
}

