package com.server.api.service.impl;

import com.server.api.service.ApiService;
import com.server.common.model.request.ReqCityInfo;
import com.server.common.model.request.ReqCityModify;
import com.server.common.model.request.ReqUserInfo;
import com.server.common.model.response.ResCityInfo;
import com.server.common.model.response.ResUserInfo;
import com.server.common.service.CityInfoService;
import com.server.common.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApiServiceImpl implements ApiService
{
    private final MemberService memberService;
    private final CityInfoService cityInfoService;
    @Override public ResUserInfo userRegister(ReqUserInfo req) { return memberService.userRegister(req.getMemberId()); }
    @Override public ResCityInfo cityRegister(ReqCityInfo req) { return cityInfoService.cityRegister(req); }

    @Override public ResCityInfo cityModify(ReqCityModify req) { return cityInfoService.cityModify(req);}
}
