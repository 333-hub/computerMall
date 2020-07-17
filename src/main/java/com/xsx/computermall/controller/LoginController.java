package com.xsx.computermall.controller;

import com.xsx.computermall.bean.MemberInfo;
import com.xsx.computermall.service.MemberInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

import java.util.List;
import java.util.Map;


/**
 * 登录控制器
 * @author Administrator
 */
@RestController
public class LoginController {

    @Autowired
    private MemberInfoService memberInfoService;

    @GetMapping("/member/findAll")
    public List<MemberInfo> findAll(){
        System.out.println("进入findAll");
        return memberInfoService.findAll();
    }

    /**
     * 用户注册
     */

    @PostMapping(value = {"/member/register"})
    @ResponseBody
    public int register(MemberInfo memberInfo){
        return memberInfoService.add(memberInfo);
    }

    /**
     * 用户登录
     * @param nickName
     * @param pwd
     * @param session
     * @return
     */
    @PostMapping(value = "/member/login")
    public int login(String nickName,  String pwd, HttpSession session){
        if (nickName==null || pwd == null){
            return 0;
        }
        Map<String,String> map = new HashMap<>();
        map.put("nickName", nickName);
        map.put("pwd",pwd);
        MemberInfo memberInfo = memberInfoService.login(map);
        if (memberInfo != null){
            session.setAttribute("currentMember", memberInfo);
            return 1;

        }else {
            return 0;
        }
    }

    /**
     * 登录检查
     * @param session
     * @return
     */
    @PostMapping("/member/check")
    public MemberInfo checkLogin(HttpSession session){
        Object obj = session.getAttribute("currentMember");
        if (null == obj){
            return new MemberInfo();
        }
        return (MemberInfo) obj;
    }
}
