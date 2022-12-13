package com.server.api.web;

import com.server.api.service.ApiService;
import com.server.common.model.request.ReqUserInfo;
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

    @RequestMapping(method = {RequestMethod.POST}, value = "/user/register" ) public ResUserInfo userRegister(@Valid @RequestBody ReqUserInfo req) { return apiService.userRegister(req); }

}
