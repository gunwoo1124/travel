package com.server.common.model.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gunwoo.common.converter.CustomDateTimeSerializer;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class MemberLogActionVO {
    private Long maIdx;
    private Integer maState;
    private Integer maType;

    @JsonSerialize(using = CustomDateTimeSerializer.class) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date maCreateDate;
    private Long maMbIdx;
    private Long maCtIdx;
    private Long maMtIdx;

    private Long maCreateTimestamp;

}