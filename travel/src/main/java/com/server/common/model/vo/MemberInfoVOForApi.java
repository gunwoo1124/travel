package com.server.common.model.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gunwoo.common.converter.CustomDateTimeSerializer;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class MemberInfoVOForApi
{
    private Long memberIndex;

    private Integer state;

    @JsonSerialize(using = CustomDateTimeSerializer.class) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    private String memberId;
}
