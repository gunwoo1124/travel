package com.server.common.model.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gunwoo.common.converter.CustomDateTimeSerializer;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class MemberInfoVO
{
    private Long mbIdx;

    private Integer mbState;
    @JsonSerialize(using = CustomDateTimeSerializer.class) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date mbCreateDate;
    private String mbId;
}