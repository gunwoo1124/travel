package com.server.api.service;

import com.server.common.model.request.ReqCityInfo;
import com.server.common.model.request.ReqCityModify;
import com.server.common.model.request.ReqTripInfo;
import com.server.common.model.request.ReqUserInfo;
import com.server.common.model.response.ResCityInfo;
import com.server.common.model.response.ResTripInfo;
import com.server.common.model.response.ResUserInfo;

public interface ApiService
{
    ResUserInfo userRegister(ReqUserInfo req);
    ResCityInfo cityRegister(ReqCityInfo req);
    ResCityInfo cityModify(ReqCityModify req);

    ResTripInfo tripRegister(ReqTripInfo req);
}
