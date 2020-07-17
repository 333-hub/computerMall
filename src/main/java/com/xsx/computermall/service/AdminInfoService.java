package com.xsx.computermall.service;

import com.xsx.computermall.bean.AdminInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface AdminInfoService {
    /**
     * 管理员登录
     * @param adminInfo
     * @return
     */
    AdminInfo login(Map<String, Object> map);

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

    /**
     * 重置密码
     * @param aid
     * @return
     */
    int update(Integer aid);
}
