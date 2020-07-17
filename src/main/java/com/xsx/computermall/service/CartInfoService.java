package com.xsx.computermall.service;

import com.xsx.computermall.bean.CartInfo;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface CartInfoService {
    /**
     * 根据用户编号，查询购物车总数
     * @param mno
     * @return
     */
    int getTotal(Integer mno);
    /**
     * 添加购物车
     * @param cartInfo
     * @return int
     */
    int add(CartInfo cartInfo);

    /**
     * @Description: 根据用户信息简单查询商品，用于判断购物车中商品数量
     * @Author: xsx
     * @param: mno
     * @return: java.util.List<com.yc.fresh.bean.CartInfo>
     **/
    List<CartInfo> finds(int mno);

    /**
     * 根据用户编号查找商品信息
     * @param mno
     * @return
     */
    List<CartInfo> findByMno(int mno);

    int deleteByCno(String cno);

    int update(CartInfo cartInfo);

    List<CartInfo> findByCnos(String[] cnos, int mno);
}

