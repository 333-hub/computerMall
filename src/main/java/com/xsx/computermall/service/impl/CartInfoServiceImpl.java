package com.xsx.computermall.service.impl;

import com.xsx.computermall.bean.CartInfo;
import com.xsx.computermall.mapper.CartInfoMapper;
import com.xsx.computermall.service.CartInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author xsx
 */
@Service
public class CartInfoServiceImpl implements CartInfoService {

    @Autowired
    private CartInfoMapper cartInfoMapper;

    @Override
    public int getTotal(Integer mno) {
        return cartInfoMapper.getTotal(mno);
    }

    @Override
    public int add(CartInfo cartInfo) {
        cartInfo.setCno(System.currentTimeMillis() + "" +new Random().nextInt(999));
        //更新数据库
        cartInfoMapper.add(cartInfo);
        return 1;
    }

    @Override
    public List<CartInfo> finds(int mno) {
        return this.findByMno(mno);
        
    }

    @Override
    public List<CartInfo> findByMno(int mno) {
        return (List<CartInfo>) cartInfoMapper.findByMno(mno);
    }

    @Override
    public int deleteByCno(String cno) {
        if (cno!=null){
            cartInfoMapper.deleteByCno(cno);
            return 1;
        }else {
            return 0;
        }

    }

    @Override
    public int update(CartInfo cartInfo) {
        return cartInfoMapper.update(cartInfo);
    }

    @Override
    public List<CartInfo> findByCnos(String[] cnos, int mno) {
        List<CartInfo> list = this.findByMno(mno);
        list = list.stream().filter(it
                -> Arrays.asList(cnos).contains(it.getCno())).collect(Collectors.toList());
        return list;
    }
}
