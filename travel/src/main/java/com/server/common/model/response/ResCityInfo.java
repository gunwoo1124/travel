package com.server.common.model.response;

import com.server.common.model.BaseResponse;
import com.server.common.model.vo.CityInfoVOForApi;
import lombok.Data;

@Data
public class ResCityInfo extends BaseResponse
{
    CityInfoVOForApi data;
}
