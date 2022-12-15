package com.server.common.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum ReturnCode
{
	SUCCESS						(0, "Success"),

	INTERNAL_ERROR				(101, "Internal error"),
	BLANK_ERROR					(102, "공백이면 안됩니다."),
	ID_ERROR					(201, "ID가 NULL 입니다."),
	ID_ALREADY_EXISTS			(202, "이미 존재하는 ID 입니다."),

	CITY_NAME_ENG_ERROR			(203,"City 영문 이름이 NULL 입니다."),
	CITY_NAME_KR_ERROR			(204, "City 한글 이름이 NULL 입니다."),
	COUNTRY_ENG_ERROR			(205, "Country 영문 이름이 NULL 입니다."),
	CITY_ALREADY_EXISTS			(206, "이미 존재하는 City 입니다."),
	NOT_EXIST_CITY				(207, "존재하지 않는 City 입니다."),
	NOT_EXIST_MEMBER			(208, "존재하지 않는 Member 입니다."),



	CITY_INDEX_ERROR			(230, "City Index가 NULL 입니다."),
	MEMBER_INDEX_ERROR			(231, "Member Index가 NULL 입니다."),
	TRIP_NAME_ERROR				(232, "Trip Name이 NULL 입니다."),
	TRIP_START_DATE_ERROR		(233, "Trip Start Date가 NULL 입니다."),
	TRIP_END_DATE_ERROR			(233, "Trip End Date가 NULL 입니다."),
	TRIP_ALREADY_EXISTS			(234, "이미 존재하는 Trip 입니다."),
	TRIP_END_DATE_OVER			(234, "여행 종료일이 지났습니다."),








	HTTP_TROUBLE				(901, "Http trouble."),
	UNKNOWN_ERROR				(999, "Error code not defined.");

	private Integer code;
	private String message;

	ReturnCode(Integer code, String message)
	{
		this.code = code;
		this.message = message;
	}

	public static ReturnCode convertCodeToEnum(int code)
	{
		ReturnCode result = null;

		ReturnCode[] returnCodes = ReturnCode.values();

		for (ReturnCode returnCode : returnCodes)
		{
			if (returnCode.getCode() == code)
			{
				result = returnCode;
				break;
			}
		}

		return result;
	}


	@JsonCreator
	public static ReturnCode getNameByValue(final int value) {
		for (final ReturnCode s: ReturnCode.values()) {
			if (s.code== value) {
				return s;
			}
		}
		return null;
	}


	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}