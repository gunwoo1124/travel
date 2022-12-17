package com.server.common.dao;

import com.gunwoo.common.generic.GenericDaoForBigInt;
import com.server.common.model.vo.MemberLogActionVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberLogActionDao extends GenericDaoForBigInt<MemberLogActionVO> {
}
