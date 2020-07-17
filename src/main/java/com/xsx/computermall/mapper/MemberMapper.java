package com.xsx.computermall.mapper;

import com.xsx.computermall.bean.MemberInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@Component
public interface MemberMapper {
    /**
     * @deprecated 用户注册
     * @param memberInfo
     * @return int
     */
    int add(MemberInfo memberInfo);

    /**
     * 查找所有用户
     * @return java.util.List<com.xsx.computermall.bean.MemberInfo>
     */
    List<MemberInfo> findAll();

    /**
     * 用户登录
     * @param map
     * @return int
     */
    MemberInfo login(Map<String,String> map);
}
