package com.xsx.computermall.mapper;

import com.xsx.computermall.bean.GoodsInfo;

import java.util.List;

/**
 * @author Administrator
 */
public interface GoodsInfoMapper {
    /**
     * 查询所有商品
     * @return
     */
    List<GoodsInfo> findInfoAndType();
    /**
     * 根据名字进行模糊查询
     * @param gname
     * @return 返回的是GoodsInfo对象
     */
    List<GoodsInfo> findByName(String gname);

    /**
     * 根据商品编号查询商品详细信息
     * @param gno
     * @return
     */
    List<GoodsInfo> findByGno(int gno);

    int add(GoodsInfo goodsInfo);
}
