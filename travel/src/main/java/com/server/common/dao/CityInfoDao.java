package com.server.common.dao;

import com.gunwoo.common.generic.GenericDaoForBigInt;
import com.server.common.model.vo.CityInfoVO;
import com.server.common.model.vo.CityInfoVOForApi;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CityInfoDao extends GenericDaoForBigInt<CityInfoVO> {

    CityInfoVOForApi selectForApi(Long cityIdx);
    List<CityInfoVOForApi> selectBySearchForApi(Map<String, Object> parameter);
}
