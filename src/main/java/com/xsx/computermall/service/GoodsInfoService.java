package com.xsx.computermall.service;

import com.xsx.computermall.bean.GoodsInfo;

import java.util.List;


/**
 * @author Administrator
 */
public interface GoodsInfoService {
    /**
     *
     * @param tname
     * @return
     */
    List<GoodsInfo> findInfoAndType();
    /**
     * 搜索框模糊查询
     * @param gname
     * @return
     */
    List<GoodsInfo> findByName(String tname);

    /**
     * 根据商品编号查询商品详情
     * @param gno
     * @return
     */
    List<GoodsInfo> findByGno(int gno);

    /**
     * 添加商品
     * @param goodsInfo
     * @return
     */
    int add(GoodsInfo goodsInfo);
}
