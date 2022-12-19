package com.server.api.web;

import com.server.api.service.ApiService;
import com.server.common.model.request.*;
import com.server.common.model.response.ResCityInfo;
import com.server.common.model.response.ResCityList;
import com.server.common.model.response.ResTripInfo;
import com.server.common.model.response.ResUserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@RequiredArgsConstructor
public class RESTApi
{
    private final ApiService apiService;

    @GetMapping("/home")
    public String welcome()
    {

        return "Gunwoo";
    }


    //Member 관련 API
    //유저등록
    @RequestMapping(method = {RequestMethod.POST}, value = "/user/register" ) public ResUserInfo userRegister(@Valid @RequestBody ReqUserInfo req) { return apiService.userRegister(req); }


    //City 관련 API
    //도시등록
    @RequestMapping(method = {RequestMethod.POST}, value = "/city/register") public ResCityInfo cityRegister(@Valid @RequestBody ReqCityInfo req) { return apiService.cityRegister(req);}

    //도시수정
    @RequestMapping(method = {RequestMethod.POST}, value = "/city/modify") public ResCityInfo cityInfoModify(@Valid @RequestBody ReqCityModify req) { return apiService.cityModify(req);}

    //도시 삭제
    @RequestMapping(method = {RequestMethod.POST}, value = "/city/delete") public ResCityInfo cityInfoDelete(@Valid @RequestBody ReqCityDelete req) { return apiService.cityDelete(req);}

    //단일 도시 조회
    @RequestMapping(method = {RequestMethod.POST}, value = "/city/info") public ResCityInfo tripInfo(@Valid @RequestBody ReqCityIndexWithMember req) { return apiService.cityInfo(req);}

    //사용자별 도시 목록 조회
    @RequestMapping(method = {RequestMethod.POST}, value = "/city/list") public ResCityList tripInfo(@Valid @RequestBody ReqMemberIndex req) { return apiService.cityList(req);}



    //Trip 관련 API
    //여행 등록
    @RequestMapping(method = {RequestMethod.POST}, value = "/trip/register") public ResTripInfo tripRegister(@Valid @RequestBody ReqTripInfo req) { return apiService.tripRegister(req);}

    //여행 수정
    @RequestMapping(method = {RequestMethod.POST}, value = "/trip/modify") public ResTripInfo tripModify(@Valid @RequestBody ReqTripModify req) { return apiService.tripModify(req);}

    //여행 삭제
    @RequestMapping(method = {RequestMethod.POST}, value = "/trip/delete") public ResTripInfo tripDelete(@Valid @RequestBody ReqTripIndexWithMember req) { return apiService.tripDelete(req);}

    //단일 여행 조회
    @RequestMapping(method = {RequestMethod.POST}, value = "/trip/info") public ResTripInfo tripInfo(@Valid @RequestBody ReqTripIndexWithMember req) { return apiService.tripInfo(req);}

}



