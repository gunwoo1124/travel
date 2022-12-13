package com.server.common.service.Impl;

import com.gunwoo.common.paging.PagingData;
import com.gunwoo.common.util.CommonStaticUtil;
import com.server.common.dao.CityInfoDao;
import com.server.common.model.ReturnCode;
import com.server.common.model.request.ReqCityInfo;
import com.server.common.model.response.ResCityInfo;
import com.server.common.model.vo.CityInfoVO;
import com.server.common.model.vo.MemberInfoVO;
import com.server.common.service.CityInfoService;
import com.server.common.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class CityInfoServiceImpl implements CityInfoService {

    private final CityInfoDao cityInfoDao;

    @Override public boolean insert(CityInfoVO entity) { return cityInfoDao.insert(entity); }
    @Override public boolean update(CityInfoVO entity) { return cityInfoDao.update(entity); }
    @Override public boolean delete(Long index) { return cityInfoDao.deleteByIndex(index); }

    @Override public CityInfoVO select(Long index) { return cityInfoDao.selectByIndex(index); }
    @Override public List<CityInfoVO> selectAll() { return cityInfoDao.selectAll(); }
    @Override public List<CityInfoVO> selectBySearch(Map<String, Object> parameter) { return cityInfoDao.selectBySearch(parameter); }

    @Override
    public PagingData selectPagingBySearch(Map<String, Object> parameter)
    {
        PagingData pagingData = CommonStaticUtil.generateCommonPagingData(parameter, cityInfoDao.countBySearch(parameter));
        List<CityInfoVO> dataList = selectBySearch(parameter);

        pagingData.setObject(dataList);
        pagingData.setCurrentPageRowCount(dataList.size());
        return pagingData;
    }

    @Override
    public ResCityInfo cityRegister(ReqCityInfo req)
    {
        ResCityInfo response = new ResCityInfo();
        ReturnCode returnCode = ReturnCode.INTERNAL_ERROR;
        try
        {
            if(!StringUtils.hasText(req.getCityNameKr()) || req.getCityNameKr().equals("") || req.getCityNameKr() == null)
                returnCode = ReturnCode.CITY_NAME_KR_ERROR;
            else if(!StringUtils.hasText(req.getCityNameEng()) || req.getCityNameEng().equals("") || req.getCityNameEng() == null)
            {
                returnCode = ReturnCode.CITY_NAME_ENG_ERROR;
            }
            else if(!StringUtils.hasText(req.getCountryEng()) || req.getCountryEng().equals("") || req.getCountryEng() == null )
            {
                returnCode = ReturnCode.COUNTRY_ENG_ERROR;
            }
            else
            {
                Map<String, Object> parameter = new HashMap<>();
                parameter.put("ctNameEn", req.getCityNameEng());
                parameter.put("ctNameKr", req.getCityNameKr());
                parameter.put("ctCountryEn", req.getCountryEng());
                parameter.put("ctState", CityInfoService.STATE_NONE);

                List<CityInfoVO> dataList = selectBySearch(parameter);

                if(dataList.size() != 0)
                    returnCode = ReturnCode.CITY_ALREADY_EXISTS;
                else
                {
                    CityInfoVO entity = new CityInfoVO();
                    entity.setCtNameEn(req.getCityNameEng());
                    entity.setCtNameKr(req.getCityNameKr());
                    entity.setCtCountryEn(req.getCountryEng());

                    if(cityInfoDao.insert(entity))
                        returnCode = ReturnCode.SUCCESS;
                }
            }

        }
        catch (Exception e)
        {
            log.error(e.toString());
            e.printStackTrace();
        }
        response.setReturnCode(returnCode);
        response.setDescription(response.getReturnCode().getMessage());
        return response;
    }
    


}
