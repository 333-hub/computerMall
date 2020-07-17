package com.xsx.computermall.service;

import com.xsx.computermall.bean.GoodsInfo;
import com.xsx.computermall.bean.GoodsType;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author xsx
 */
public interface GoodsTypeService {

    List<GoodsType> findAllType();

    /**
     * 查找所有类型
     * @return
     */
    List<GoodsType> findAll();

    /**
     * 查询所有商品类型，用于主页显示
     * @return
     */
   List<GoodsType> findGoodsType();

    /**
     * 根据tno查询商品信息
     * @param tno
     * @return
     */
   List<GoodsType> findsGoodsByTno(int tno);

}
