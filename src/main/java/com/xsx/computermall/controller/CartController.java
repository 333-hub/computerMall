package com.xsx.computermall.controller;

import com.xsx.computermall.bean.CartInfo;
import com.xsx.computermall.bean.GoodsInfo;
import com.xsx.computermall.bean.MemberInfo;
import com.xsx.computermall.service.CartInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author xsx
 */
@RestController
public class CartController {
    @Autowired
    private CartInfoService cartInfoService;

    @PostMapping("/getTotal")
    public int getTotal(int mno){
        return cartInfoService.getTotal(mno);
    }

    @PostMapping("/goods/add_cart")
    public int add_cart(CartInfo cartInfo, HttpSession session){
        MemberInfo memberInfo = (MemberInfo) session.getAttribute("currentMember");
        if (null == memberInfo){
            return -1;
        }

        cartInfo.setMno(memberInfo.getMno());
        cartInfo.setNum(1);

        return cartInfoService.add(cartInfo);
    }

    @PostMapping("/cart/finds")
    @ResponseBody
    public List<CartInfo> finds(HttpSession session) {
        //先校验用户是否登录
        Object obj = session.getAttribute("currentMember");
        if (null == obj) {
            return null;
        }
        MemberInfo memberInfo = (MemberInfo) obj;
        return cartInfoService.finds((int) memberInfo.getMno());
    }
    @PostMapping("/cart/findByMno")
    public List<CartInfo> findByMno(Integer mno,HttpSession session){
        //先校验用户是否登录
        Object obj =session.getAttribute("currentMember");
        if (null == obj) {
            return null;
        }
        MemberInfo memberInfo = (MemberInfo) obj;
        return cartInfoService.findByMno(mno);
    }

    /**
     * 根据购物车号删除商品
     * @param cno
     * @param session
     * @return
     */
    @PostMapping("/cart/del")
    public int deleteByCno(String cno, HttpSession session){
        System.out.println("进入deleteByCno");
        System.out.println("cno="+cno);
        return cartInfoService.deleteByCno(cno);
    }

    @PostMapping("/cart/update")
    public int update(CartInfo cartInfo){
        return cartInfoService.update(cartInfo);
    }

    @PostMapping("/cart/find")
    public List<CartInfo> find(HttpSession session) {
        //先校验用户是否登录
        Object obj = session.getAttribute("currentMember");

        if (null == obj) {
            return null;
        }
        MemberInfo menberInfo = (MemberInfo) obj;
        List<CartInfo> byMno = cartInfoService.findByMno((int) menberInfo.getMno());
        System.out.println("byMno="+byMno);
        return byMno;
    }
    @PostMapping("/cart/findByCnos")
    public List<CartInfo> findByCnos(String cno, HttpSession session){
        Object obj = session.getAttribute("currentMember");
        if (null == obj) {
            return null;
        }
        MemberInfo menberInfo = (MemberInfo) obj;
        String[] cnos = cno.split(",");
        return cartInfoService.findByCnos(cnos, (int)menberInfo.getMno());
    }
}
