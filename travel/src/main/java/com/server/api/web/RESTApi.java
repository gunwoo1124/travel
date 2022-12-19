package com.server.api.web;

import com.server.api.service.ApiService;
import com.server.common.model.request.*;
import com.server.common.model.response.ResCityInfo;
import com.server.common.model.response.ResCityList;
import com.server.common.model.response.ResTripInfo;
import com.server.common.model.response.ResUserInfo;
import io.swagger.v3.oas.annotations.Operation;
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




    //Member 관련 API
    //유저등록
    @Operation(summary = "유저 등록", tags = {"User"})
    @RequestMapping(method = {RequestMethod.POST}, value = "/user/register" ) public ResUserInfo userRegister(@Valid @RequestBody ReqUserInfo req) { return apiService.userRegister(req); }


    //City 관련 API
    //도시등록
    @Operation(summary = "도시 등록" , tags = {"City"})
    @RequestMapping(method = {RequestMethod.POST}, value = "/city/register") public ResCityInfo cityRegister(@Valid @RequestBody ReqCityInfo req) { return apiService.cityRegister(req);}

    //도시수정
    @Operation(summary = "도시 수정" , tags = {"City"})
    @RequestMapping(method = {RequestMethod.POST}, value = "/city/modify") public ResCityInfo cityInfoModify(@Valid @RequestBody ReqCityModify req) { return apiService.cityModify(req);}

    //도시 삭제
    @Operation(summary = "도시 삭제" , tags = {"City"})
    @RequestMapping(method = {RequestMethod.POST}, value = "/city/delete") public ResCityInfo cityInfoDelete(@Valid @RequestBody ReqCityDelete req) { return apiService.cityDelete(req);}

    //단일 도시 조회
    @Operation(summary = "단일 도시 조회" , tags = {"City"})
    @RequestMapping(method = {RequestMethod.POST}, value = "/city/info") public ResCityInfo tripInfo(@Valid @RequestBody ReqCityIndexWithMember req) { return apiService.cityInfo(req);}

    //사용자별 도시 목록 조회
    @Operation(summary = "사용자별 도시 목록 조회" , tags = {"City"})
    @RequestMapping(method = {RequestMethod.POST}, value = "/city/list") public ResCityList tripInfo(@Valid @RequestBody ReqMemberIndex req) { return apiService.cityList(req);}



    //Trip 관련 API
    //여행 등록
    @Operation(summary = "여행 등록" , tags = {"Trip"})
    @RequestMapping(method = {RequestMethod.POST}, value = "/trip/register") public ResTripInfo tripRegister(@Valid @RequestBody ReqTripInfo req) { return apiService.tripRegister(req);}

    //여행 수정
    @Operation(summary = "여행 수정" , tags = {"Trip"})
    @RequestMapping(method = {RequestMethod.POST}, value = "/trip/modify") public ResTripInfo tripModify(@Valid @RequestBody ReqTripModify req) { return apiService.tripModify(req);}

    //여행 삭제
    @Operation(summary = "여행 삭제" , tags = {"Trip"})
    @RequestMapping(method = {RequestMethod.POST}, value = "/trip/delete") public ResTripInfo tripDelete(@Valid @RequestBody ReqTripIndexWithMember req) { return apiService.tripDelete(req);}

    //단일 여행 조회
    @Operation(summary = "단일 여행 조회" , tags = {"Trip"})
    @RequestMapping(method = {RequestMethod.POST}, value = "/trip/info") public ResTripInfo tripInfo(@Valid @RequestBody ReqTripIndexWithMember req) { return apiService.tripInfo(req);}

}



