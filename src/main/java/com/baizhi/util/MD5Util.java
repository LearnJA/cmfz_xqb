package com.baizhi.util;

import org.springframework.util.DigestUtils;

public class MD5Util {

    /**
     * 传入明文
     * 字符串MD5加密处理
     * 返回密文
     * */
    public static String md5(String target){
        byte[] bytes=target.getBytes();
        return DigestUtils.md5DigestAsHex(bytes);
    }
    /**
     * 密文解析对比
     * 明文 --src、密文 --mdCode做参数
     * 返回true 或者 false
     */
    public static boolean isCodeValidate(String src,String mdCode){
        if(src==null) throw new RuntimeException("src 为空不能验证！！");
        if(md5(src).equals(mdCode)){
            return true;
        }
        return false;
    }
}
