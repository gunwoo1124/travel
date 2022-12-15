package com.server.common.model.request;

import lombok.Data;

@Data
public class ReqTripModify
{

    private Long tripIndex;
    private String tripName;
    private String description;
    private String startDate;
    private String endDate;

}
