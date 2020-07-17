package com.xsx.computermall.mapper;

import com.xsx.computermall.bean.CartInfo;

import java.util.List;

/**
 * @author xsx
 */
public interface CartInfoMapper {
    /**
     * 根据用户编号，查询购物车商品数量
     * @param mno
     * @return
     */
    int getTotal(Integer mno);
    /**
     *
     * @return CartIndfo对象
     */
    int add(CartInfo cartInfo);

    /**
     * 根据用户编号查找商品信息
     * @param mno
     * @return
     */
    List<CartInfo> findByMno(int mno);

    /**
     * 根据用户id简单查询
     * @param mno
     * @return
     */
    List<CartInfo> finds(int mno);

    /**
     * 根据购物车号删除商品
     * @param cno
     * @return
     */
    int deleteByCno(String cno);

    /**
     * 更新数量
     * @param cno
     * @param num
     * @return
     */
    int update(CartInfo cartInfo);

    List<CartInfo> findByCnos(String[] cnos);
}
