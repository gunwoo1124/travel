package com.server.common.model.response;

import com.server.common.model.BaseResponse;
import com.server.common.model.vo.MemberTripVOForApi;
import lombok.Data;

@Data
public class ResTripInfo extends BaseResponse
{
    MemberTripVOForApi data;
}
