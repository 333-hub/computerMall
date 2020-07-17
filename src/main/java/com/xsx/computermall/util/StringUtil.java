package com.xsx.computermall.util;

import java.util.Iterator;
import java.util.List;
import java.util.Random;


/**
 *  @Description: 字符串工具类
 *  @author: xh
 *  @Date: 2019/7/30 11:51
 */
public class StringUtil {
    /**
     * @Description: 判断为空,是空输出真
     * @Author: xh
     * @param: strs   传入的不定参数
     * @return: boolean  其中有一个为空则返回false
     **/
    public static boolean isNull(String... strs) {
        if (strs == null || strs.length == 0) {
            return true;
        }

        for (String str : strs) {
            if (str == null || "".equals(str)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @Description: 产生随机数大小写数字
     * @Author: xh
     * @param: length  要生成的随机数长度
     * @return: java.lang.String
     **/
    public static String getItemID(int length) {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int temp = random.nextInt(3);
            switch (temp) {
                case 0:
                    val += (char) (65 + random.nextInt(26));
                    break;
                case 1:
                    val += (char) (97 + random.nextInt(26));
                    break;
                case 2:
                    val += String.valueOf(random.nextInt(10));
                    break;
            }
        }
        return val;
    }

    /**
     * @Description: 大文本的字符串替换
     * @Author: xh
     * @param: str  字符串文本
     * @param: fromStr  要被替换的字符串
     * @param: toStr   替换的字符
     * @return: java.lang.String
     **/
    public static String replaceLongStr(String str, String fromStr, String toStr) {
        StringBuffer result = new StringBuffer();
        if (str != null && !str.equals("")) {
            while (str.indexOf(fromStr) > 0) {
                result.append(str.substring(0, str.indexOf(fromStr)));
                result.append(toStr);
                str = str.substring(str.indexOf(fromStr) + fromStr.length(), str.length());
            }
            result.append(str);
        }
        return result.toString();
    }

    /**
     * 从listA里删除listB里有的数据
     *
     * @param listA
     * @param listB
     * @return
     */
    public static List<Object> listrem(List<Object> listA, List<Object> listB) {
        for (Iterator<Object> itA = listA.iterator(); itA.hasNext(); ) {
            Object temp = itA.next();
            for (int i = 0; i < listB.size(); i++) {
                if (temp.equals(listB.get(i))){
                    itA.remove();
                }
            }
        }
        return listA;
    }
}
