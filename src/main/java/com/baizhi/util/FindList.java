package com.baizhi.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindList {
    public static Map<String,Object> findList(Long total,List list){
        Map<String, Object> resultList=new HashMap<String,Object>();
            resultList.put("total",total);
            resultList.put("rows",list);
        return resultList;
    }
}
