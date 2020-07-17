package com.xsx.computermall.controller;

import com.xsx.computermall.bean.GoodsInfo;
import com.xsx.computermall.bean.GoodsType;
import com.xsx.computermall.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GoodsTypeController {

    @Autowired
    private GoodsTypeService goodsTypeService;
    //保存路径
    private String savePath = "pics";

    /**
     * 查询所有类型，用于后台显示
     * @return
     */
    @GetMapping("/type/findAll")
    public List<GoodsType> findAllType(){
        System.out.println("进入typefindAll");
        return goodsTypeService.findAllType();
    }

    /**
     * 查找商品类型
     * @param
     * @return
     */
    @PostMapping("/type/getGoodsType")
    public List<GoodsType> findGoodsType(){
        List<GoodsType> goodsType = goodsTypeService.findGoodsType();
        System.out.println("下拉框=" + goodsType);
        return goodsType;
    }

    @GetMapping("/goods")
    public ModelAndView findGoodsByTno(@RequestParam Integer tno){
        List<GoodsType> goodsTypes = goodsTypeService.findsGoodsByTno(tno);
        System.out.println("goodsInfos="+goodsTypes);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("goods.html");
        mv.addObject("goods", goodsTypes);
        System.out.println(mv);
        return mv;
    }

    @PostMapping("/goods/findGoodsMore")
    public List<GoodsType> findGoodsMore(Integer tno, HttpSession session){
        List<GoodsType> goodsMore = goodsTypeService.findsGoodsByTno(tno);
        session.setAttribute("goods",goodsMore);
        return goodsMore;
    }

}
