package com.server.common.model.request;

import lombok.Data;

@Data
public class ReqTripDelete
{
    private Long tripIndex;

    //요청자 member의 Index Log를 남기기 위함.
    //여행을 등록한 member 가 여행을 삭제할 수 있어야함.
    private Long memberIndex;
}
