package com.server.common.model.vo;


import lombok.Data;

import java.util.Date;

@Data
public class MemberTripVOForApi {

    private Long tripIndex;
    private Long cityIndex;
    private Long memberIndex;
    private Integer state;
    private Date createDate;
    private String name;
    private String description;

    private Date updateDate;
    private Date deleteDate;
    private Date startDate;
    private Date endDate;

    private String memberId;
    private String cityNameKr;
    private String cityNameEng;
    private String country;

}
