package com.server.api.service;

import com.server.common.model.request.*;
import com.server.common.model.response.ResCityInfo;
import com.server.common.model.response.ResTripInfo;
import com.server.common.model.response.ResUserInfo;

public interface ApiService
{
    ResUserInfo userRegister(ReqUserInfo req);
    ResCityInfo cityRegister(ReqCityInfo req);
    ResCityInfo cityModify(ReqCityModify req);
    ResTripInfo tripRegister(ReqTripInfo req);
    ResTripInfo tripModify(ReqTripModify req);
}
