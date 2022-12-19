#초기 DB 셋팅
h2Database
h2Create.sql 을 h2 에서 실행하시면 됩니다.
MYSQL
mysqlCreate.sql 로 크리에이트 하시면됩니다.

기본적인 DB 셋팅은 application.yml에서 로컬에 맞게 수정하시면됩니다.


#MemberInfoVO.
 - 보통 Web 서비스에선 유저가 로그인을 하면 key값을 받아 유저를 서치해서 유저 액션등을 로그로 DB에 남기겠지만,
   본 과제에선 유저 로그인 API나 유저 Key 값이나, Ticket을 발급하는 API를 요구 하고 있지 않기 때문에
   단순 MemberInfoVO를 생성해놓고 그 멤버가 조회를 하거나, 여행을 등록할 수 있도록 해뒀습니다.

#API 활용은 어떤방식이 편하실지 몰라서 두가지로 구분해 두었습니다.
 1.Postman 활용하여 호출.
   tomcat Port에 맞추셔서 body에 json 형태로 담아 호출하시면됩니다.
   아무래도 Request를 하실 때  불편하실 것 같아 swagger 호출 방식을 추천드립니다.
   
 2.swagger 로 호출.
   tomcat port에 맞추셔서 url 접속후 사용하시는 방식입니다.
   ex) 서버 실행후 
      localhost:9091/swagger-ui.html 에 접속하셔서 api를 호출하시면 됩니다.



#기본 API Request 및 설명
    #user
        -/user/register
            : memberId 를 입력하여 user를 등록합니다. 


    #city
        -/city/register
            : cityNameEng 도시의 영문이름
              cityNameKr  도시의 한국어 이름
              countryEng  나라 를 입력하여 City를 등록합니다.

        -/city/modify
            : cityIndex를 NotNull로 받아서 cityNameEng, cityNameKr, countryEng 중 null 이 아닌 값이 잇을때 Update합니다.

        -/city/list
            : memberIndex를 받아 요청사항에 적힌 순서와 중복을 고려하여 리스트를 출력합니다.
                trip 테이블과 log테이블이 조인되어있습니다.
                trip 테이블 같은 경우는 현재 여행중인지 아닌지 판별하기 위함이고
                log 테이블은 유저가 단일조회한 기록으로 Order에 사용하기 위함입니다.

        -/city/info
            : memberIndex와 cityIndex를 받아 도시를 조회합니다.
                memberIndex를 받는 이유는 위에서 말씀드린데로 로그에 누가 언제 검색했는지를 남기기 위함입니다.

        -/city/delete
            : cityIndex를 받아 삭제 처리를 진행합니다. 여행 등록이 되지않았을때 삭제가 가능합니다.
                실제로 DB에서 delete 하지 않고 state만 STATE_DELETE로 바꾸어 처리합니다.


    #trip
        :기본적으로 Trip은 Scheduler를 돌려서 여행상태(mt_flag_trip) 을 자동으로 업데이트합니다.
            여행 시작일이 지나면 여행중, 여행중상태에서 여행종료일이 지나면 여행종료 상태로 업데이트 합니다.

        -/trip/register
            : cityIndex, memberIndex, tripName, description, startDate, endDate 를 받아 등록합니다.
                이중 description은 null 이 가능합니다.
                trip도 city와 조인하여 Response로 넘깁니다.
                여행 종료일이 지나면 등록이 안됩니다.

        -/trip/modify
            : tripIndex를 받아 tripName, description, startDate, endDate 중 Null이 아닌값이 있을때 업데이트합니다.
                이역시 마찬가지로 여행 종료일을 고려하고, 시작시간보다 종료시간이 뒤에있는지 확인합니다.

        -/trip/info
            : tripIndex를 받아 단일 여행 정보를 Response로 넘깁니다.
            
        -/trip/delete
            : tripIndex, memberIndex를 받아 삭제처리를 진행합니다.
                여행등록자와 일치하는지 확인하기 위해 memberIndex를 받습니다.
                이 Api 마찬가지로 실제로 DB에서 delete 하지 않고 state만 STATE_DELETE로 바꾸어 처리합니다.


#ReturnCode
    -각종 returnCode 정보 입니다.

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
	NOT_EXIST_TRIP				(235, "존재하지 않는 Trip 입니다."),
	START_END_ERROR				(236, "시작시간이 종료시간보다 뒤입니다."),

	TRIP_INDEX_ERROR			(237, "Trip Index가 NULL 입니다."),
	NOT_SAME_MEMBER				(238, "작성자와 Member Index가 일치하지 않습니다."),
	ALREADY_DELETE_TRIP			(239, "삭제된 Trip 입니다."),
	CITY_REGISTER_TRIP			(240, "Trip에 등록된 City입니다."),

	HTTP_TROUBLE				(901, "Http trouble."),
	UNKNOWN_ERROR				(999, "Error code not defined.");

#미비된 사항.
    -unitTest : 현재 재직중인 직장업무와 병행하느라 시간이 빠듯해서 작업하지 못하였습니다.
    -h2 Database : api는 정상 동작하지만 date_format을 맞춰주지 않아서 console에서 에러가 발생합니다..

#yml 프로필별 세팅이 적용되지 않을 때 적용방법은 이미지로 같이 첨부하겠습니다.

        
#git 정보

    https://github.com/gunwoo1124/travel.git
    git@github.com:gunwoo1124/travel.git


