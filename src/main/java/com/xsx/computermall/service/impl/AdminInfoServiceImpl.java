package com.xsx.computermall.service.impl;

import com.xsx.computermall.bean.AdminInfo;
import com.xsx.computermall.mapper.AdminInfoMapper;
import com.xsx.computermall.service.AdminInfoService;
import com.xsx.computermall.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminInfoServiceImpl implements AdminInfoService {

    @Autowired
    private AdminInfoMapper adminInfoMapper;

    @Override
    public AdminInfo login(Map<String , Object> map) {
        return adminInfoMapper.login(map);
    }

    @Override
    public int add(AdminInfo adminInfo) {
        return adminInfoMapper.add(adminInfo);
    }

    @Override
    public List<AdminInfo> findAll() {
        return adminInfoMapper.findAll();
    }

    @Override
    public int update(Integer aid) {
        return adminInfoMapper.update(aid);
    }


}
