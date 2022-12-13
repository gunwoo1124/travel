package com.gunwoo.common.util;

import com.gunwoo.common.paging.PagingData;
import com.gunwoo.common.paging.PagingManager;

import java.util.Map;

public class CommonStaticUtil
{
    public static PagingData generateCommonPagingData(Map<String, Object> parameter, Integer totalRecode) { return generateCommonPagingData(parameter, Long.valueOf("" + totalRecode)); }
    public static PagingData generateCommonPagingData(Map<String, Object> parameter, Long totalRecode)
    {
        Integer pageSize = null;
        Integer pageNo = null;

        if(parameter.containsKey("pageNo"))
        {
            if(parameter.get("pageNo").getClass().equals(String.class)) pageNo = Integer.valueOf((String) parameter.get("pageNo")) ;
            else if(parameter.get("pageNo").getClass().equals(Integer.class)) pageNo = (Integer) parameter.get("pageNo");
            else if(parameter.get("pageNo").getClass().equals(Long.class)) pageNo = ((Long) parameter.get("pageNo")).intValue();
        }
        if(parameter.containsKey("pageSize"))
        {
            if(parameter.get("pageSize").getClass().equals(String.class)) pageSize = Integer.valueOf((String) parameter.get("pageSize")) ;
            else if(parameter.get("pageSize").getClass().equals(Integer.class)) pageSize = (Integer) parameter.get("pageSize");
            else if(parameter.get("pageSize").getClass().equals(Long.class)) pageSize = ((Long) parameter.get("pageSize")).intValue();
        }

        if(pageNo == null) pageNo = 1;
        if(pageSize == null) pageSize = 20;
        PagingData pagingData = PagingManager.getPagingList(pageNo, totalRecode, pageSize, 10);
        parameter.put("startRow", pagingData.getStartRow()); parameter.put("rowCount", pagingData.getPageSize());
        return pagingData;
    }
}