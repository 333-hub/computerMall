package com.xsx.computermall;

import com.xsx.computermall.bean.GoodsInfo;
import com.xsx.computermall.bean.GoodsType;
import com.xsx.computermall.mapper.GoodsTypeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class ComputermallApplicationTests {
    @Autowired
    DataSource dataSource;
    private GoodsTypeMapper goodsTypeMapper;

    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    public void test() throws FileNotFoundException {
        String realPath = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\pics";
        String dataDirPath = realPath + "/" +new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String pics = dataDirPath.substring(47);
        System.out.println(pics);
    }
}
