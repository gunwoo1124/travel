package com.server.common.service.Impl;

import com.gunwoo.common.paging.PagingData;
import com.gunwoo.common.util.CommonDateUtil;
import com.gunwoo.common.util.CommonStaticUtil;
import com.server.common.dao.CityInfoDao;
import com.server.common.dao.MemberInfoDao;
import com.server.common.dao.MemberLogActionDao;
import com.server.common.dao.MemberTripDao;
import com.server.common.model.ReturnCode;
import com.server.common.model.request.*;
import com.server.common.model.response.ResCityInfo;
import com.server.common.model.response.ResCityList;
import com.server.common.model.vo.*;
import com.server.common.service.CityInfoService;
import com.server.common.service.CommonQueryService;
import com.server.common.service.MemberLogActionService;
import com.server.common.service.MemberTripService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;

import java.lang.reflect.Member;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class CityInfoServiceImpl implements CityInfoService {

    private final CityInfoDao cityInfoDao;
    private final MemberInfoDao memberInfoDao;
    private final MemberLogActionDao memberLogActionDao;
    private final MemberTripDao memberTripDao;
    private final CommonQueryService commonQueryService;

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

    @Override
    public ResCityInfo cityModify(ReqCityModify req)
    {
        ResCityInfo response = new ResCityInfo();
        ReturnCode returnCode = ReturnCode.INTERNAL_ERROR;
        CityInfoVO cityInfoVO = cityInfoDao.selectByIndex(req.getCityIndex());

        if(cityInfoVO == null)
        {
            returnCode = ReturnCode.NOT_EXIST_CITY;
        }
        else
        {
            if(req.getCityNameKr() != null)
            {
                if (req.getCityNameKr().equals(""))
                {
                    returnCode = ReturnCode.BLANK_ERROR;
                    response.setReturnCode(returnCode);
                    response.setDescription(response.getReturnCode().getMessage());
                    return response;
                }
                else
                {
                    cityInfoVO.setCtNameKr(req.getCityNameKr());
                }
            }

            if(req.getCityNameEng() != null)
            {
                if (req.getCityNameEng().equals(""))
                {
                    returnCode = ReturnCode.BLANK_ERROR;
                    response.setReturnCode(returnCode);
                    response.setDescription(response.getReturnCode().getMessage());
                    return response;
                }
                else
                {
                    cityInfoVO.setCtNameEn(req.getCityNameEng());
                }
            }

            if(req.getCountryEng() != null)
            {
                if (req.getCountryEng().equals(""))
                {
                    returnCode = ReturnCode.BLANK_ERROR;
                    response.setReturnCode(returnCode);
                    response.setDescription(response.getReturnCode().getMessage());
                    return response;
                }
                else
                {
                    cityInfoVO.setCtCountryEn(req.getCountryEng());
                }
            }

            Date now = commonQueryService.getDatabaseNow();
            cityInfoVO.setCtUpdateDate(now);

            if(cityInfoDao.update(cityInfoVO))
            {
                CityInfoVOForApi data = cityInfoDao.selectForApi(req.getCityIndex());
                response.setData(data);
                log.info("cityIndex : " + data.getCityIndex());
                log.info("cityNameKr : " + data.getCityNameKr());
                log.info("cityNameEng : " + data.getCityNameEng());
                log.info("country : " + data.getCountry());
                log.info("updateDate : " + data.getUpdateDate());
                returnCode = ReturnCode.SUCCESS;
            }
        }
        response.setReturnCode(returnCode);
        response.setDescription(response.getReturnCode().getMessage());
        return response;
    }

    @Override
    public ResCityInfo cityDelete(ReqCityDelete req)
    {
        ResCityInfo response = new ResCityInfo();
        ReturnCode returnCode = ReturnCode.INTERNAL_ERROR;

        try
        {
            if (req.getCityIndex() == null )
            {
                returnCode = ReturnCode.CITY_INDEX_ERROR;
            }
            else
            {
                CityInfoVO cityInfoVO = cityInfoDao.selectByIndex(req.getCityIndex());

                if(cityInfoVO == null)
                {
                    returnCode = ReturnCode.NOT_EXIST_CITY;
                }
                else
                {
                    Map<String, Object> parameter = new HashMap<>();
                    parameter.put("mtCtIdx", req.getCityIndex());
                    parameter.put("mtState", MemberTripService.STATE_NONE);

                    List<MemberTripVO> memberTripVOList = memberTripDao.selectBySearch(parameter);

                    if(memberTripVOList.size() >0)
                    {
                        returnCode = ReturnCode.CITY_REGISTER_TRIP;
                    }
                    else
                    {
                        Date now = commonQueryService.getDatabaseNow();
                        cityInfoVO.setCtState(CityInfoService.STATE_DELETE);
                        cityInfoVO.setCtDeleteDate(now);

                        if(cityInfoDao.update(cityInfoVO))
                        {
                            CityInfoVOForApi data = cityInfoDao.selectForApi(req.getCityIndex());
                            response.setData(data);

                            log.info("cityInfoState : " + data.getState());
                            log.info("deleteDate : " + data.getDeleteDate());

                            returnCode = ReturnCode.SUCCESS;
                        }
                    }
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

    @Override
    public ResCityInfo cityInfo(ReqCityIndexWithMember req)
    {
        ResCityInfo response = new ResCityInfo();
        ReturnCode returnCode = ReturnCode.INTERNAL_ERROR;
        try
        {
            if (req.getMemberIndex() == null )
            {
                returnCode = ReturnCode.MEMBER_INDEX_ERROR;
            }
            else if(req.getCityIndex() == null)
            {
                returnCode = ReturnCode.CITY_INDEX_ERROR;
            }
            else
            {
                MemberInfoVO memberInfoVO = memberInfoDao.selectByIndex(req.getMemberIndex());
                CityInfoVO cityInfoVO = cityInfoDao.selectByIndex(req.getCityIndex());
                if(memberInfoVO == null)
                {
                    returnCode = ReturnCode.NOT_EXIST_MEMBER;
                }
                else if(cityInfoVO == null)
                {
                    returnCode = ReturnCode.NOT_EXIST_CITY;
                }
                else
                {
                    MemberLogActionVO forInsert = new MemberLogActionVO();
                    forInsert.setMaType(MemberLogActionService.TYPE_SEARCH_CITY);
                    forInsert.setMaMbIdx(memberInfoVO.getMbIdx());
                    forInsert.setMaCtIdx(cityInfoVO.getCtIdx());

                    if(memberLogActionDao.insert(forInsert))
                    {
                        CityInfoVOForApi data = cityInfoDao.selectForApi(req.getCityIndex());
                        response.setData(data);
                        returnCode = ReturnCode.SUCCESS;
                    }
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

    @Override
    public ResCityList cityList(ReqMemberIndex req)
    {
        ResCityList response = new ResCityList();
        ReturnCode returnCode = ReturnCode.INTERNAL_ERROR;
        try
        {
            Map<String, Object> parameter = new HashMap<>();
            parameter.put("mtState", MemberTripService.STATE_NONE);
            parameter.put("mtFlag", MemberTripService.FLAG_ING);
            parameter.put("orderColumn","mt_flag_trip");
            parameter.put("order", "DESC");
            parameter.put("orderColumn2", "mt_start_date");
            parameter.put("order2","ASC");
            parameter.put("memberIndex", req.getMemberIndex());

            Date now = commonQueryService.getDatabaseNow();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            String oneDay = CommonDateUtil.addDay(now, -1).toString();
//            String oneWeek = CommonDateUtil.addDay(now, -7).toString();
//            Date oneDayAgo = dateFormat.parse(oneDay);
//            Date oneWeekAgo = dateFormat.parse(oneWeek);
            Date oneDayAgo = CommonDateUtil.addDay(now, -1);
            Date oneWeekAgo = CommonDateUtil.addDay(now, -7);

//            Date oneDay = dateFormat.format(oneDayAgo);

            parameter.put("oneDay", oneDayAgo.getTime());
            parameter.put("oneWeek",oneWeekAgo.getTime());

            Map<String, Object> limitParameter = new HashMap<>();
            limitParameter.put("memberIndex", req.getMemberIndex());
            limitParameter.put("mtFlag", MemberTripService.FLAG_ING);
            limitParameter.put("mtState", MemberTripService.STATE_NONE);

            //중복되는 City가 10개 이하..
            if(cityInfoDao.countBySearchList(limitParameter) <= 10)
            {
                Map<String, Object> tripParameter = new HashMap<>();
                tripParameter.put("mtMbIdx", req.getMemberIndex());
                tripParameter.put("mtState", MemberTripService.STATE_NONE);
                tripParameter.put("mtFlagTrip",MemberTripService.FLAG_ING);

                parameter.put("limit", memberTripDao.countBySearch(tripParameter)+10);

            }
            //중복되는 City가 10개이상
            else
            {
                List<CityInfoVOForApiJoin> list = cityInfoDao.selectBySearchListForCount(limitParameter);
                CityInfoVOForApiJoin cityInfoVOForApiJoin =list.get(9);



                Map<String, Object> tripParameter = new HashMap<>();
                tripParameter.put("mtMbIdx", req.getMemberIndex());
                tripParameter.put("mtState", MemberTripService.STATE_NONE);
                tripParameter.put("mtFlagTrip",MemberTripService.FLAG_ING);
               tripParameter.put("searchStartDateUnder" , cityInfoVOForApiJoin.getTripStartDate());

                parameter.put("limit", memberTripDao.countBySearch(tripParameter)+10);
            }

            List<CityInfoVOForApiJoin> list = cityInfoDao.selectBySearchList(parameter);
            response.setList(list);
            returnCode = ReturnCode.SUCCESS;


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
