package com.server.common.dao;

import com.gunwoo.common.generic.GenericDaoForBigInt;
import com.server.common.model.vo.CityInfoVOForApi;
import com.server.common.model.vo.MemberTripVO;
import com.server.common.model.vo.MemberTripVOForApi;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberTripDao extends GenericDaoForBigInt<MemberTripVO> {

    MemberTripVOForApi selectForApi(Long tripIdx);
    List<MemberTripVOForApi> selectBySearchForApi(Map<String, Object> parameter);
}
