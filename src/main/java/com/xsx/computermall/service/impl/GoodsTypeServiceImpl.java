package com.xsx.computermall.service.impl;

import com.xsx.computermall.bean.GoodsType;
import com.xsx.computermall.mapper.GoodsTypeMapper;
import com.xsx.computermall.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
/**
 * @author xsx
 */
@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Autowired
    private GoodsTypeMapper goodsTypeMapper;

    @Override
    public List<GoodsType> findAllType() {
        return goodsTypeMapper.findAllType();
    }

    @Override
    public List<GoodsType> findAll() {
        return goodsTypeMapper.findAll();
    }

    @Override
    public List<GoodsType> findGoodsType() {
        return goodsTypeMapper.findGoodsType();
    }

    @Override
    public List<GoodsType> findsGoodsByTno(int tno) {
        return goodsTypeMapper.findGoodsByTno(tno);
    }
}
