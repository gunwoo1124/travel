package com.server.common.service;

import com.gunwoo.common.generic.GenericServiceForBigInt;
import com.server.common.model.request.ReqTripIndexWithMember;
import com.server.common.model.request.ReqTripInfo;
import com.server.common.model.request.ReqTripModify;
import com.server.common.model.response.ResTripInfo;
import com.server.common.model.vo.MemberTripVO;

public interface MemberTripService extends GenericServiceForBigInt<MemberTripVO>
{
    int STATE_NONE = 0;
    int STATE_DELETE = 1;
    int FLAG_NONE = 1;
    int FLAG_ING = 2;
    int FLAG_END = 0;

    ResTripInfo tripRegister(ReqTripInfo req);

    ResTripInfo tripModify(ReqTripModify req);
    ResTripInfo tripDelete(ReqTripIndexWithMember req);
    ResTripInfo tripInfo(ReqTripIndexWithMember req);

    void processTrip();
    void processTimestamp();

}
