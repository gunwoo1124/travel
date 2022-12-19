package com.server.common.model.response;

import com.server.common.model.BaseResponse;
import com.server.common.model.vo.CityInfoVOForApiJoin;
import lombok.Data;

import java.util.List;

@Data
public class ResCityList extends BaseResponse
{
    List<CityInfoVOForApiJoin> list;
}
