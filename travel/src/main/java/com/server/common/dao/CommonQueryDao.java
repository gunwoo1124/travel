package com.server.common.dao;


import com.gunwoo.common.generic.GenericDao;
import com.server.common.model.vo.CommonQueryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface CommonQueryDao extends GenericDao<CommonQueryVO>
{
    Integer countTable(Map<String, Object> searchMap);
    boolean directQuery(Map<String, Object> searchMap);
    String selectNowString();
}