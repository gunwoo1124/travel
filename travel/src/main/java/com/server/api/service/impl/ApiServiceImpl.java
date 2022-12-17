package com.server.api.service.impl;

import com.server.api.service.ApiService;
import com.server.common.model.request.*;
import com.server.common.model.response.ResCityInfo;
import com.server.common.model.response.ResTripInfo;
import com.server.common.model.response.ResUserInfo;
import com.server.common.service.CityInfoService;
import com.server.common.service.MemberService;
import com.server.common.service.MemberTripService;
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

    private final MemberTripService memberTripService;
    @Override public ResUserInfo userRegister(ReqUserInfo req) { return memberService.userRegister(req.getMemberId()); }
    @Override public ResCityInfo cityRegister(ReqCityInfo req) { return cityInfoService.cityRegister(req); }
    @Override public ResCityInfo cityModify(ReqCityModify req) { return cityInfoService.cityModify(req);}
    @Override public ResTripInfo tripRegister(ReqTripInfo req) { return memberTripService.tripRegister(req); }

    @Override public ResTripInfo tripModify(ReqTripModify req) { return memberTripService.tripModify(req); }

    @Override public ResTripInfo tripDelete(ReqTripIndexWithMember req) { return memberTripService.tripDelete(req); }

    @Override public ResTripInfo tripInfo(ReqTripIndexWithMember req) { return memberTripService.tripInfo(req);}
}
