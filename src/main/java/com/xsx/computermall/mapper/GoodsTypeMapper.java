package com.xsx.computermall.mapper;

import com.xsx.computermall.bean.GoodsInfo;
import com.xsx.computermall.bean.GoodsType;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author xsx
 */
public interface GoodsTypeMapper {
    /**
     * 查询所有商品类型
     * @return
     */
    List<GoodsType> findAllType();

    /**
     * 查找所有商品
     * @return java.util.List<com.xsx.computermall.GoodsType></>
     */
    List<GoodsType> findAll();

    /**
     * 查询所有商品类型
     * @return
     */
    List<GoodsType> findGoodsType();

    /**
     * 根据商品类型id查询商品信息
     * @param tno
     * @return
     */
    List<GoodsType> findGoodsByTno(int tno);
}
