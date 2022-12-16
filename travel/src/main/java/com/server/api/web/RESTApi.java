package com.server.api.web;

import com.server.api.service.ApiService;
import com.server.common.model.request.*;
import com.server.common.model.response.ResCityInfo;
import com.server.common.model.response.ResTripInfo;
import com.server.common.model.response.ResUserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbcp.BasicDataSource;
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



    //Trip 관련 API
    //여행 등록
    @RequestMapping(method = {RequestMethod.POST}, value = "/trip/register") public ResTripInfo tripRegister(@Valid @RequestBody ReqTripInfo req) { return apiService.tripRegister(req);}

    //여행 수정
    @RequestMapping(method = {RequestMethod.POST}, value = "/trip/modify") public ResTripInfo tripModify(@Valid @RequestBody ReqTripModify req) { return apiService.tripModify(req);}

    //여행 삭제
    @RequestMapping(method = {RequestMethod.POST}, value = "/trip/delete") public ResTripInfo tripDelete(@Valid @RequestBody ReqTripDelete req) { return apiService.tripDelete(req);}

}



