package com.server.common.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum ReturnCode
{
	SUCCESS						(0, "Success"),
	PARTIALLY_FAILED			(1, "Partially failed"),
	OUT_OF_AUTHORITY			(2, "Out of Authority"),
	BAD_REQUEST					(3, "Bad request"),
	AUTHENTICATION_FAILED		(4, "Password does not match"),
	FIELD_VALIDATE_FAIL			(5, "Field validation failed."),
	REQUIRED_FIELDS_MISSING		(6, "Required fields missing."),
	IP_NOT_AUTHORIZED           (7, "IP is not authorized"),
	DATA_NOT_FOUND 				(8, "Data not found"),
	DATA_UPDATE_FAILED			(9, "Data update failed"),
	DATA_ALREADY_EXISTS			(10, "Data already exists"),

	REQUEST_ALREADY_PROCESSED	(11, "Request already processed"),
	REQUEST_ALREADY_REJECTED	(12, "Request already rejected"),
    PRIOR_REQUEST_EXIST			(13, "Prior request exists"),
	INVALID_CONFIG				(14, "Invalid config"),
	INVALID_IP					(15, "IP not authorized"),
	INVALID_TIME_FORMAT			(16, "Invalid time format. required : UTC, millisecond, long"),
	INVALID_DATE_RANGE			(17, "Invalid date range"),
	INVALID_REQUEST_DATA		(18, "Invalid request data"),
	INVALID_SQL_REQUEST			(19, "Invalid sql request"),
    INVALID_PRIOR_STATE			(20, "Prior state is wrong"),

	REQUEST_TIMEOUT				(21, "Request timeout"),
	RELATED_DATA_EXIST			(22, "Related data exist"),
	DATA_NOT_READY				(23, "Data not ready"),
    PASSWORD_NOT_MATCH			(24, "password is not match"),
    TOO_MANY_WRONG_REQUEST		(25, "Too many wrong request.  Account is blocked in 3 minute"),
    CANNOT_REQUEST_THIS_TIME    (26, "Cannot request this time"),
    TICKET_NOT_EXIST			(27, "Ticket not exists"),
    TICKET_EXPIRED				(28, "Ticket is expired"),
    TICKET_VALIDATION_FAILED	(29, "Ticket validation failed"),
    TICKET_GENERATE_FAILED		(30, "Ticket generation failed"),


	ACCOUNT_NOT_FOUND			(41, "Account not found"),
	ACCOUNT_ALREADY_EXISTS		(42, "Account already exist"),
	ACCOUNT_BLOCKED				(43, "Account is blocked"),
    ACCOUNT_DELETED				(44, "Account is deleted"),
    ACCOUNT_OUT_OF_BALANCE		(45, "Account balance is not sufficient"),
	CI_ALREADY_IN_USE           (46, "중복 가입은 제한되어 있습니다"),
	REGISTER_LIMITED_BY_AGE     (47, "만19세 미만은 가입할 수 없습니다"),
	OUT_OF_BALANCE				(48, "Account balance is not sufficient"),


	TOKEN_WITHDRAWAL_LOCKED     (63, "Withdrawal is locked on this token"),
	TOKEN_PRICE_UPDATE_FAILED	(64, "Failed to get token price"),
	CANNOT_TRANSFER_TO_SELF		(65, "Cannot transfer to self"),
	UNDER_MIN_WITHDRAW_AMOUNT	(66, "Under min withdraw amount"),


	INTERNAL_ERROR				(101, "Internal error"),
	UNDER_MAINTENANCE			(102, "Service Maintenance"),
	SYSTEM_IS_BUSY_TRY_AGAIN	(103, "System is busy, try again after seconds"),
	NOT_IMPLEMENTED				(104, "Not implemented"),
	CONFIG_DISABLED				(105, "Config disabled"),
	DISABLED_FOR_SCHEDULED_TASK (106, "Disabled for scheduling task."),
	DISABLED_FOR_SCHEDULED_UPDATE(107, "시스템 업데이트중.  3분정도 뒤에 다시 시도하세요"),
	API_RESTRICTED              (108, "Api is restricted for a moment"),


	CERTIFICATION_LIMIT_OVER	(111, "Too many certification request"),
	SMS_SENT					(112, "Sent by SMS"),
	SMS_ERROR					(113, "SMS service error"),
	CERTIFICATION_WRONG			(114, "Certification wrong"),
	CERTIFICATION_MATCH			(115, "Certification match"),
	SMS_NOT_SUPPORTED_AREA		(116, "SMS is not supported on your region"),
	EMAIL_CERTIFICATION_LIMITED_TEMPORARY (117, "Certification service is limited temporary"),
	EMAIL_ERROR 				(118, "Failed to send email"),

	PASSWORD_LENGTH_SHORT		(121, "Password length is short"),
	TEMP_PASSWORD_SENT_BY_SMS	(122, "Temporary password is sent by sms"),


	ERC20_ADDRESS_MISSING		(131, "ERC20 address not set"),
	TOKEN_TYPE_NOT_MATCH		(132, "Token type not match"),
	ERC20_API_ERROR				(133, "ERC20 API error"),
	ERC20_GAS_API_RESPONSE_ERROR(134, "ERC20 Gas API response error"),

	ERC20_NFT_API_ERROR				(135, "ERC20 NFT API error"),


	PHONE_DUPLICATED			(201, "이미 등록된 연락처입니다"),
	PHONE_INFO_NOT_REGISTERED	(202, "Phone info is not registered"),
	PHONE_INFO_REGISTERED_ALREADY(203, "Phone info is registered already"),
	PHONE_INFO_REGISTERED_NOW	(204, "Phone info is registered now"),

	EMAIL_DUPLICATED			(221, "이미 등록된 연락처입니다"),
	EMAIL_INFO_NOT_REGISTERED	(222, "Email info is not registered"),
	EMAIL_INFO_REGISTERED_ALREADY(223, "Email info is registered already"),
	EMAIL_INFO_REGISTERED_NOW	(224, "Email info is registered now"),

	OTP_NOT_MATCH				(241, "OTP 번호가 일치하지 않습니다"),
	AUTH_NOT_MATCH				(242, "인증번호가 일치하지 않습니다"),
	PHONE_CERT_NOT_MATCH		(243, "문자 인증번호가 일치하지 않습니다"),


	//NFT 관련
	BAZAAR_NOT_FOUND			(244, "판매 중인 상품이 아닙니다."),
	INSTANCE_NOT_FOUND			(245, "등록된 인스턴스가 아닙니다."),
	MEMBER_NOT_FOUND			(246, "등록된 멤버가 아닙니다."),
	TOKEN_NOT_FOUND				(247, "등록된 토큰이 아닙니다."),
	TOKEN_POINT_NOT_FOUND		(248, "등록된 토큰 포인트가 아닙니다."),
	HOLDING_INSUFFICIENT		(249, "보유 포인트가 부족합니다."),
	SALE_VOLUME_LOW				(250,"판매 수량이 적습니다."),
	INSTANCE_SPLIT_ERROR		(251,"인스턴스 분할 오류"),
	ITEM_CATEGORY_NOT_FOUND		(252, "등록된 카테고리가 아닙니다."),
	NFT_HOLDING_INSUFFICIENT	( 253 , "인스턴스 갯수가 부족합니다."),
	MEMBER_NFT_NOT_FOUND		(254, "MemberNFT를 찾을수 없습니다."),

	NFT_WITHDRAWAL_LOCKED     (301, "Withdrawal is locked on this NFT"),




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