package com.server.city;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.server.api.service.ApiService;
import com.server.api.web.RESTApi;
import com.server.common.model.ReturnCode;
import com.server.common.model.request.ReqCityInfo;
import com.server.common.model.response.ResCityInfo;
import com.server.common.model.vo.CityInfoVOForApi;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.StandardCharsets;

@ExtendWith(MockitoExtension.class)
public class CityRegisterTest {

    @InjectMocks
    private RESTApi restApi;

    @Mock
    private ApiService apiService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void init(){
        mockMvc = MockMvcBuilders.standaloneSetup(restApi).build();
    }

    @DisplayName("City Register Success")
    @Test
    void registerSuccess() throws Exception {
        //given
        ReqCityInfo reqCityInfo = registerRequest();
        ResCityInfo resCityInfo = registerResponse();

        BDDMockito.given(restApi.cityRegister(reqCityInfo)).willReturn(resCityInfo);
//        Mockito.doReturn(resCityInfo).when(apiService)
//                .cityRegister(reqCityInfo);

        //when
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(reqCityInfo);


        mockMvc.perform(MockMvcRequestBuilders.post("/city/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonString)
                        .characterEncoding(StandardCharsets.UTF_8)
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.returnCode").value(ReturnCode.SUCCESS.getCode()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.cityNameKr").value(resCityInfo.getData().getCityNameKr()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.cityNameEng").value(resCityInfo.getData().getCityNameEng()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.country").value(resCityInfo.getData().getCountry()))
                .andDo(MockMvcResultHandlers.print());
    }


    private ReqCityInfo registerRequest() {
        ReqCityInfo reqCityInfo = new ReqCityInfo();
        reqCityInfo.setCityNameKr("성남");
        reqCityInfo.setCityNameEng("SeoungNam");
        reqCityInfo.setCountryEng("South Korea");

        return reqCityInfo;
    }
    private ResCityInfo registerResponse() {
        ResCityInfo resCityInfo = new ResCityInfo();
        resCityInfo.setReturnCode(ReturnCode.SUCCESS);

        CityInfoVOForApi cityInfoVOForApi = new CityInfoVOForApi();

        cityInfoVOForApi.setCityNameKr("성남");
        cityInfoVOForApi.setCityNameEng("SeoungNam");
        cityInfoVOForApi.setCountry("South Korea");

        resCityInfo.setData(cityInfoVOForApi);

        return resCityInfo;
    }


}
