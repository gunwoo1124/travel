package com.server.api.service;

import com.server.common.model.request.ReqCityInfo;
import com.server.common.model.request.ReqUserInfo;
import com.server.common.model.response.ResCityInfo;
import com.server.common.model.response.ResUserInfo;

public interface ApiService
{
    public ResUserInfo userRegister(ReqUserInfo req);

    public ResCityInfo cityRegister(ReqCityInfo req);
}
