package com.server.common.model.response;

import com.server.common.model.BaseResponse;
import com.server.common.model.vo.MemberInfoVOForApi;
import lombok.Data;

@Data
public class ResUserInfo extends BaseResponse
{
    MemberInfoVOForApi data;
}
