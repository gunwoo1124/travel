package com.server.city;

import com.server.common.dao.MemberInfoDao;
import com.server.common.model.request.ReqUserInfo;
import com.server.common.model.response.ResUserInfo;
import com.server.common.service.Impl.MemberServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.web.WebAppConfiguration;


@MybatisTest
@WebAppConfiguration
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CityInfoServiceTest {

    @InjectMocks
    MemberServiceImpl memberService;

    @Spy
    MemberInfoDao memberInfoDao;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
        memberService = new MemberServiceImpl(memberInfoDao);
    }

    @Test
    @DisplayName("create Test")
    void createTest()
    {
        ReqUserInfo memberInfoVO = new ReqUserInfo();

        memberInfoVO.setMemberId("gmgm");
        ResUserInfo resUserInfo = memberService.userRegister(memberInfoVO.getMemberId());


        ReqUserInfo memberInfoVO1 = new ReqUserInfo();
        memberInfoVO1.setMemberId("gmgm");

        System.out.println(memberService.userRegister(memberInfoVO.getMemberId()));
    }

}
