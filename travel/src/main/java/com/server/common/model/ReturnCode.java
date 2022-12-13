package com.server.common.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum ReturnCode
{
	SUCCESS						(0, "Success"),

	INTERNAL_ERROR				(101, "Internal error"),
	ID_ERROR					(201, "ID가 NULL입니다."),
	ID_ALREADY_EXISTS			(202, "이미 존재하는 ID 입니다."),




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