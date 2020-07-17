package com.xsx.computermall.controller;

import com.xsx.computermall.bean.AdminInfo;
import com.xsx.computermall.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AdminController {

    @Autowired
    private AdminInfoService adminInfoService;

    @PostMapping("/back/login")
    public int login(AdminInfo adminInfo , HttpSession session){
        String aname = adminInfo.getAname();
        String pwd = adminInfo.getPwd();
        Map<String ,Object> map = new HashMap<>(16);
        map.put("aname",aname);
        map.put("pwd", pwd);
        AdminInfo login = adminInfoService.login(map);
        System.out.println("login="+login);
        if (null == login){
            return 0;
        }
        session.setAttribute("currentAdmin", login);
        return 1;
    }
    @PostMapping("/admin/add")
    public int addNewAdminInfo(AdminInfo adminInfo){
        int add = adminInfoService.add(adminInfo);
        System.out.println(add);
        return add;
    }

    @GetMapping("/admin/findAll")
    public List<AdminInfo> findAll(){
        return adminInfoService.findAll();
    }
    @PostMapping("/admin/update")
    public int update(Integer aid){
        return adminInfoService.update(aid);
    }


}
