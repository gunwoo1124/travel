package com.server.common.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ReqCityInfo
{

    private String cityNameEng;


    private String cityNameKr;


    private String countryEng;

}
