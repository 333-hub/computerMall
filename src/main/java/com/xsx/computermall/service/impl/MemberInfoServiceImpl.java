package com.xsx.computermall.service.impl;

import com.xsx.computermall.bean.MemberInfo;
import com.xsx.computermall.mapper.MemberMapper;
import com.xsx.computermall.service.MemberInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * member接口的实现类
 */
@Service
public class MemberInfoServiceImpl implements MemberInfoService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public List<MemberInfo> findAll() {
        return memberMapper.findAll();
    }

    @Override
    public MemberInfo login(Map<String, String> map) {
        return memberMapper.login(map);
    }

    @Override
    public int add(MemberInfo memberInfo) {
        if (memberInfo == null){
            return 0;
        }else {
            return memberMapper.add(memberInfo);
        }
    }
}
