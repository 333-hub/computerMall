package com.xsx.computermall.mapper;

import com.xsx.computermall.bean.AdminInfo;

import java.util.List;
import java.util.Map;

public interface AdminInfoMapper {
    /**
     * 管理员登录
     * @param map
     * @return
     */
    AdminInfo login(Map<String ,Object> map);

    /**
     * 添加管理员
     * @param adminInfo
     * @return
     */
    int add(AdminInfo adminInfo);

    /**
     * 查询所有管理员信息
     * @return
     */
    List<AdminInfo> findAll();

    int update(Integer aid);
}
