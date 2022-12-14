package com.server.common.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ReqCityInfo
{
    @NotBlank
    private String cityNameEng;

    @NotBlank
    private String cityNameKr;

    @NotBlank
    private String countryEng;

}
