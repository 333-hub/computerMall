package com.xsx.computermall.service.impl;

import com.xsx.computermall.bean.GoodsInfo;
import com.xsx.computermall.mapper.GoodsInfoMapper;
import com.xsx.computermall.service.GoodsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 搜索框查找实现类
 * @author Administrator
 */
@Service
public class GoodsInfoServiceImpl implements GoodsInfoService {

    @Autowired
    private GoodsInfoMapper goodsInfoMapper;

    @Override
    public List<GoodsInfo> findInfoAndType() {
        return goodsInfoMapper.findInfoAndType();
    }

    @Override
    public List<GoodsInfo> findByName(String tname) {
        System.out.println("gname=" + tname);
        return goodsInfoMapper.findByName(tname);
    }

    @Override
    public List<GoodsInfo> findByGno(int gno) {
        System.out.println(gno);
        return goodsInfoMapper.findByGno(gno);
    }

    @Override
    public int add(GoodsInfo goodsInfo) {
        return goodsInfoMapper.add(goodsInfo);
    }
}
