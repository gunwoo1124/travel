package com.server.common.service;

import com.gunwoo.common.generic.GenericServiceForBigInt;
import com.server.common.model.vo.MemberLogActionVO;

public interface MemberLogActionService extends GenericServiceForBigInt<MemberLogActionVO>
{
    int TYPE_SEARCH_CITY = 1;

    void processTimestamp();


}
