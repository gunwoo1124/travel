package com.server.common.model.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gunwoo.common.converter.CustomDateTimeSerializer;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class CityInfoVO
{
    private Long ctIdx;
    private Integer ctState;
    @JsonSerialize(using = CustomDateTimeSerializer.class) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ctCreateDate;
    @JsonSerialize(using = CustomDateTimeSerializer.class) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ctUpdateDate;
    @JsonSerialize(using = CustomDateTimeSerializer.class) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ctDeleteDate;
    private String ctNameKr;
    private String ctNameEn;
    private String ctCountryEn;
    private Long ctLikeCount;

}