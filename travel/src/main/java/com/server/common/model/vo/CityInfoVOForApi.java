package com.server.common.model.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gunwoo.common.converter.CustomDateTimeSerializer;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class CityInfoVOForApi
{

    private Long cityIndex;
    private Boolean state;
    @JsonSerialize(using = CustomDateTimeSerializer.class) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    @JsonSerialize(using = CustomDateTimeSerializer.class) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;
    @JsonSerialize(using = CustomDateTimeSerializer.class) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date deleteDate;
    private String cityNameKr;
    private String cityNameEng;
    private String country;
    private Long likeCount;
}
