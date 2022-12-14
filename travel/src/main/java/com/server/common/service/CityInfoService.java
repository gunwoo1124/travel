package com.server.common.service;

import com.gunwoo.common.generic.GenericServiceForBigInt;
import com.server.common.model.request.*;
import com.server.common.model.response.ResCityInfo;
import com.server.common.model.response.ResCityList;
import com.server.common.model.response.ResUserInfo;
import com.server.common.model.vo.CityInfoVO;

public interface CityInfoService extends GenericServiceForBigInt<CityInfoVO>
{
    int STATE_NONE = 0;
    int STATE_DELETE = 1;
    ResCityInfo cityRegister(ReqCityInfo req);
    ResCityInfo cityModify(ReqCityModify req);
    ResCityInfo cityDelete(ReqCityDelete req);
    ResCityInfo cityInfo(ReqCityIndexWithMember req);

    ResCityList cityList(ReqMemberIndex req);
}
