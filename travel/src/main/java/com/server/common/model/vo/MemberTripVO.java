package com.server.common.model.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gunwoo.common.converter.CustomDateTimeSerializer;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class MemberTripVO {
    private Long mtIdx;

    private Long mtCtIdx;

    private Long mtMbIdx;

    private Integer mtState;

    @JsonSerialize(using = CustomDateTimeSerializer.class) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date mtCreateDate;

    private String mtName;

    private String mtDescription;

    @JsonSerialize(using = CustomDateTimeSerializer.class) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date mtUpdateDate;

    @JsonSerialize(using = CustomDateTimeSerializer.class) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date mtDeleteDate;

    @JsonSerialize(using = CustomDateTimeSerializer.class) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date mtStartDate;

    @JsonSerialize(using = CustomDateTimeSerializer.class) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date mtEndDate;

    private Integer mtFlagTrip;
}