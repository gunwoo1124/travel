package com.server.common.service;

import com.gunwoo.common.generic.GenericServiceForBigInt;
import com.gunwoo.common.paging.PagingData;
import com.server.common.model.response.ResUserInfo;
import com.server.common.model.vo.MemberInfoVO;

import java.util.Map;

public interface MemberService extends GenericServiceForBigInt<MemberInfoVO>
{
    PagingData selectPagingBySearch(Map<String, Object> parameter);

    ResUserInfo userRegister(String id);
    MemberInfoVO selectById(String id);
}
