package com.server.common.dao;

import com.gunwoo.common.generic.GenericDaoForBigInt;
import com.server.common.model.vo.MemberInfoVO;
import com.server.common.model.vo.MemberInfoVOForApi;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberInfoDao extends GenericDaoForBigInt<MemberInfoVO> {
    MemberInfoVO selectById(String mbId);
    MemberInfoVOForApi selectForApi(String id);
}
