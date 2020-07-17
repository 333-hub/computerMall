package com.xsx.computermall.controller;

import com.xsx.computermall.bean.GoodsInfo;
import com.xsx.computermall.bean.GoodsType;
import com.xsx.computermall.service.GoodsInfoService;
import com.xsx.computermall.service.GoodsTypeService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 商品处理类
 * @author Administrator
 */
@RestController
public class GoodsInfoController {

    @Autowired
    private GoodsInfoService goodsInfoService;

    /**
     * 根据商品名称模糊查询
     * @param gname
     * @param session
     * @return
     */

    @GetMapping("/goodsName")
    public ModelAndView findByName(String tname){
        List<GoodsInfo> goods = goodsInfoService.findByName(tname);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("goods.html");
        mv.addObject("goods",goods);
        return mv;
    }

    /**
     * 根据商品编号查询
     * @param gno
     * @param session
     * @return
     */
    @GetMapping("/details")
    public ModelAndView findByGno(Integer gno){
        List<GoodsInfo> list = goodsInfoService.findByGno(gno);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("details.html");
        mv.addObject("goodsDetails",list);
        return mv;
    }

    @PostMapping("/goods/findinfoAndType")
    public List<GoodsInfo> findinfoAndType(HttpSession session){
        List<GoodsInfo> InfoAndType = goodsInfoService.findInfoAndType();
        System.out.println("Infoandtype="+InfoAndType);
        session.setAttribute("InfoAndTypes",InfoAndType);
        return InfoAndType;
    }


    @PostMapping("/goods/addGoods")
    public int add(@RequestParam("pic") MultipartFile pics, HttpServletRequest request, GoodsInfo goodsInfo) throws IOException {
        System.out.println("开始添加");
        //获取文件名称
        String OldFileName = pics.getOriginalFilename();
        //获取文件后缀
        String extension = "."+FilenameUtils.getExtension(pics.getOriginalFilename());
        //生成新的文件名
        String NewFileName = new SimpleDateFormat("yyyyMMddHHmmss")+ UUID.randomUUID().toString().replace("_","")+extension;
        //处理根据日期生成目录
        String realPath = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\pics";
        String dataDirPath = realPath + "/" +new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        System.out.println("dataDirPath="+dataDirPath);
        File dest = new File(dataDirPath);
        System.out.println("dest="+dest);
        if (!dest.exists()) {
            System.out.println("创建目录");
            dest.mkdirs();
        }
        //处理文件上传
        pics.transferTo(new File(dest, NewFileName));
        //图片路径插入
        //图片路径
        String picsPath = dataDirPath.substring(47) + "/" + NewFileName;
        goodsInfo.setPics(picsPath);
        return goodsInfoService.add(goodsInfo);
    }
}
