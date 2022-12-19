package com.server.api.service;

import com.server.common.model.request.*;
import com.server.common.model.response.ResCityInfo;
import com.server.common.model.response.ResCityList;
import com.server.common.model.response.ResTripInfo;
import com.server.common.model.response.ResUserInfo;

public interface ApiService
{
    ResUserInfo userRegister(ReqUserInfo req);
    ResCityInfo cityRegister(ReqCityInfo req);
    ResCityInfo cityModify(ReqCityModify req);
    ResCityInfo cityDelete(ReqCityDelete req);
    ResCityList cityList(ReqMemberIndex req);

    ResCityInfo cityInfo(ReqCityIndexWithMember req);
    ResTripInfo tripRegister(ReqTripInfo req);
    ResTripInfo tripModify(ReqTripModify req);
    ResTripInfo tripDelete(ReqTripIndexWithMember req);
    ResTripInfo tripInfo(ReqTripIndexWithMember req);

}
