package com.server.common.service.Impl;

import com.gunwoo.common.paging.PagingData;
import com.gunwoo.common.util.CommonStaticUtil;
import com.server.common.dao.CityInfoDao;
import com.server.common.dao.MemberInfoDao;
import com.server.common.dao.MemberTripDao;
import com.server.common.model.ReturnCode;
import com.server.common.model.request.ReqTripIndexWithMember;
import com.server.common.model.request.ReqTripInfo;
import com.server.common.model.request.ReqTripModify;
import com.server.common.model.response.ResTripInfo;
import com.server.common.model.vo.*;
import com.server.common.service.CommonQueryService;
import com.server.common.service.MemberTripService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberTripServiceImpl implements MemberTripService {

    private final CommonQueryService commonQueryService;
    private final MemberTripDao memberTripDao;
    private final CityInfoDao cityInfoDao;
    private final MemberInfoDao memberInfoDao;

    @Override public boolean insert(MemberTripVO entity) { return memberTripDao.insert(entity); }
    @Override public boolean update(MemberTripVO entity) { return memberTripDao.update(entity); }
    @Override public boolean delete(Long index) { return memberTripDao.deleteByIndex(index); }

    @Override public MemberTripVO select(Long index) { return memberTripDao.selectByIndex(index); }
    @Override public List<MemberTripVO> selectAll() { return memberTripDao.selectAll(); }
    @Override public List<MemberTripVO> selectBySearch(Map<String, Object> parameter) { return memberTripDao.selectBySearch(parameter); }

    @Override
    public PagingData selectPagingBySearch(Map<String, Object> parameter)
    {
        PagingData pagingData = CommonStaticUtil.generateCommonPagingData(parameter, memberTripDao.countBySearch(parameter));
        List<MemberTripVO> dataList = selectBySearch(parameter);

        pagingData.setObject(dataList);
        pagingData.setCurrentPageRowCount(dataList.size());
        return pagingData;
    }


    @Override
    public ResTripInfo tripRegister(ReqTripInfo req)
    {
        ResTripInfo response = new ResTripInfo();
        ReturnCode returnCode = ReturnCode.INTERNAL_ERROR;

        try
        {
            if(req.getCityIndex() == null)
                returnCode = ReturnCode.CITY_INDEX_ERROR;
            else if(req.getMemberIndex() == null)
            {
                returnCode = ReturnCode.MEMBER_INDEX_ERROR;
            }
            else if(!StringUtils.hasText(req.getTripName()) || req.getTripName().equals("") || req.getTripName() == null )
            {
                returnCode = ReturnCode.TRIP_NAME_ERROR;
            }
            else if(req.getStartDate() == null)
            {
                returnCode = ReturnCode.TRIP_START_DATE_ERROR;
            }
            else if(req.getEndDate() == null)
            {
                returnCode = ReturnCode.TRIP_END_DATE_ERROR;
            }

            else
            {
                Map<String, Object> parameter = new HashMap<>();
                parameter.put("mtName", req.getTripName());
                parameter.put("mtCtIdx", req.getCityIndex());
                parameter.put("mtMbIdx", req.getMemberIndex());

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date startDate = dateFormat.parse(req.getStartDate());
                Date endDate = dateFormat.parse(req.getEndDate());
                parameter.put("mtState", MemberTripService.STATE_NONE);
                parameter.put("mtFlagTrip", MemberTripService.FLAG_NONE);
                List<MemberTripVO> dataList = selectBySearch(parameter);

                if(dataList.size() != 0)
                    returnCode = ReturnCode.TRIP_ALREADY_EXISTS;
                else
                {
                    CityInfoVO cityInfoVO = cityInfoDao.selectByIndex(req.getCityIndex());

                    if(cityInfoVO == null)
                    {
                        returnCode = ReturnCode.NOT_EXIST_CITY;
                    }
                    else
                    {
                        MemberInfoVO memberInfoVO =memberInfoDao.selectByIndex(req.getMemberIndex());

                        if(memberInfoVO == null)
                        {
                            returnCode = ReturnCode.NOT_EXIST_MEMBER;
                        }
                        else
                        {
                            Date now = commonQueryService.getDatabaseNow();

                            Long nowTimestamp = now.getTime();
                            Long endTimestamp = endDate.getTime();
                            Long startTimeStamp = startDate.getTime();

                            if(endTimestamp < nowTimestamp)
                            {
                                returnCode = ReturnCode.TRIP_END_DATE_OVER;
                            }
                            else if(endTimestamp < startTimeStamp)
                            {
                                returnCode = ReturnCode.START_END_ERROR;
                            }
                            else
                            {
                                MemberTripVO entity = new MemberTripVO();
                                entity.setMtName(req.getTripName());
                                entity.setMtCtIdx(req.getCityIndex());
                                entity.setMtMbIdx(req.getMemberIndex());
                                entity.setMtStartDate(startDate);
                                entity.setMtEndDate(endDate);

                                if(req.getDescription() != null)
                                {
                                    entity.setMtDescription(req.getDescription());
                                }

                                if(memberTripDao.insert(entity))
                                    returnCode = ReturnCode.SUCCESS;
                            }
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
    public ResTripInfo tripModify(ReqTripModify req)
    {

        ResTripInfo response = new ResTripInfo();
        ReturnCode returnCode = ReturnCode.INTERNAL_ERROR;
        try
        {

            MemberTripVO memberTripVO = memberTripDao.selectByIndex(req.getTripIndex());
            Date now = commonQueryService.getDatabaseNow();

            if(memberTripVO == null)
            {
                returnCode = ReturnCode.NOT_EXIST_TRIP;
            }
            else
            {
                if(req.getTripName() != null)
                {
                    if(req.getTripName().equals(""))
                    {
                        returnCode = ReturnCode.BLANK_ERROR;
                        response.setReturnCode(returnCode);
                        response.setDescription(response.getReturnCode().getMessage());
                        return response;
                    }
                    else
                    {
                        memberTripVO.setMtName(req.getTripName());
                    }
                }

                if(req.getDescription() != null)
                {
                    if(req.getDescription().equals(""))
                    {
                        returnCode = ReturnCode.BLANK_ERROR;
                        response.setReturnCode(returnCode);
                        response.setDescription(response.getReturnCode().getMessage());
                        return response;
                    }
                    else
                    {
                        memberTripVO.setMtDescription(req.getDescription());
                    }
                }

                if(req.getStartDate() != null)
                {
                    if(req.getStartDate().equals(""))
                    {
                        returnCode = ReturnCode.BLANK_ERROR;
                        response.setReturnCode(returnCode);
                        response.setDescription(response.getReturnCode().getMessage());
                        return response;
                    }
                    else
                    {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        Date startDate = dateFormat.parse(req.getStartDate());
                        memberTripVO.setMtStartDate(startDate);
                    }
                }

                if(req.getStartDate() != null)
                {
                    if(req.getStartDate().equals(""))
                    {
                        returnCode = ReturnCode.BLANK_ERROR;
                        response.setReturnCode(returnCode);
                        response.setDescription(response.getReturnCode().getMessage());
                        return response;
                    }
                    else
                    {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        Date startDate = dateFormat.parse(req.getStartDate());
                        memberTripVO.setMtStartDate(startDate);
                    }
                }

                if(req.getEndDate() != null)
                {
                    if(req.getEndDate().equals(""))
                    {
                        returnCode = ReturnCode.BLANK_ERROR;
                        response.setReturnCode(returnCode);
                        response.setDescription(response.getReturnCode().getMessage());
                        return response;
                    }
                    else
                    {

                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        Date endDate = dateFormat.parse(req.getEndDate());
                        Date startDate = new Date();
                        if(req.getStartDate() != null)
                        {
                            startDate = dateFormat.parse(req.getStartDate());
                        }
                        else
                        {
                            startDate = memberTripVO.getMtStartDate();
                        }


                        Long nowTimestamp = now.getTime();
                        Long startTimestamp = startDate.getTime();
                        Long endTimestamp = endDate.getTime();

                        if(endTimestamp < nowTimestamp)
                        {
                            returnCode = ReturnCode.TRIP_END_DATE_OVER;
                            response.setReturnCode(returnCode);
                            response.setDescription(response.getReturnCode().getMessage());
                            return response;
                        }
                        else if(endTimestamp < startTimestamp)
                        {
                            returnCode = ReturnCode.START_END_ERROR;
                            response.setReturnCode(returnCode);
                            response.setDescription(response.getReturnCode().getMessage());
                            return response;
                        }
                        else
                        {
                            memberTripVO.setMtEndDate(endDate);
                        }
                    }
                }

                memberTripVO.setMtUpdateDate(now);

                if(memberTripDao.update(memberTripVO))
                {
                    MemberTripVOForApi data = memberTripDao.selectForApi(req.getTripIndex());
                    response.setData(data);

                    log.info("tripIndex : " + data.getTripIndex());
                    log.info("tripName : " + data.getName());
                    log.info("description : " + data.getDescription());
                    log.info("startDate : " + data.getStartDate());
                    log.info("endDate : " + data.getEndDate());
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
    public ResTripInfo tripDelete(ReqTripIndexWithMember req)
    {
        ResTripInfo response = new ResTripInfo();
        ReturnCode returnCode = ReturnCode.INTERNAL_ERROR;
        try {
            if (req.getMemberIndex() == null )
            {
                returnCode = ReturnCode.MEMBER_INDEX_ERROR;
            }
            else if(req.getTripIndex() == null)
            {
                returnCode = ReturnCode.TRIP_INDEX_ERROR;
            }
            else
            {
                MemberInfoVO memberInfoVO = memberInfoDao.selectByIndex(req.getMemberIndex());
                MemberTripVO memberTripVO = memberTripDao.selectByIndex(req.getTripIndex());
                if(memberInfoVO == null)
                {
                    returnCode = ReturnCode.NOT_EXIST_MEMBER;
                }
                else if(memberTripVO == null)
                {
                    returnCode = ReturnCode.NOT_EXIST_TRIP;
                }
                else
                {
                    if(!memberInfoVO.getMbIdx().equals(memberTripVO.getMtMbIdx()))
                    {
                        returnCode = ReturnCode.NOT_SAME_MEMBER;
                    }
                    else
                    {
                        Date now = commonQueryService.getDatabaseNow();
                        memberTripVO.setMtState(MemberTripService.STATE_DELETE);
                        memberTripVO.setMtDeleteDate(now);

                        if(memberTripDao.update(memberTripVO))
                        {
                            MemberTripVOForApi data = memberTripDao.selectForApi(req.getTripIndex());
                            response.setData(data);

                            log.info("tripState : " + data.getState());
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
    public ResTripInfo tripInfo(ReqTripIndexWithMember req)
    {

        ResTripInfo response = new ResTripInfo();
        ReturnCode returnCode = ReturnCode.INTERNAL_ERROR;
        try
        {
            if (req.getMemberIndex() == null )
            {
                returnCode = ReturnCode.MEMBER_INDEX_ERROR;
            }
            else if(req.getTripIndex() == null)
            {
                returnCode = ReturnCode.TRIP_INDEX_ERROR;
            }
            else
            {
                MemberInfoVO memberInfoVO = memberInfoDao.selectByIndex(req.getMemberIndex());
                MemberTripVO memberTripVO = memberTripDao.selectByIndex(req.getTripIndex());
                if(memberInfoVO == null)
                {
                    returnCode = ReturnCode.NOT_EXIST_MEMBER;
                }
                else if(memberTripVO == null)
                {
                    returnCode = ReturnCode.NOT_EXIST_TRIP;
                }
                else
                {
                   if(memberTripVO.getMtState().equals(MemberTripService.STATE_DELETE))
                       returnCode = ReturnCode.ALREADY_DELETE_TRIP;
                   else
                   {
                       MemberTripVOForApi data = memberTripDao.selectForApi(req.getTripIndex());
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
    public void processTrip()
    {
        Map<String, Object> startDateMap = new HashMap<>();

        Date now = commonQueryService.getDatabaseNow();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        startDateMap.put("searchStartDateUnder",now);
        startDateMap.put("mtFlagTrip",MemberTripService.FLAG_NONE);
        startDateMap.put("mtState", MemberTripService.STATE_NONE);

        List<MemberTripVO> startList = memberTripDao.selectBySearch(startDateMap);

        if(startList.size()>0)
        {
            for(MemberTripVO memberTripVO : startList)
            {
                memberTripVO.setMtFlagTrip(MemberTripService.FLAG_ING);
                memberTripDao.update(memberTripVO);
            }
        }

        Map<String, Object> endDateMap = new HashMap<>();
         endDateMap.put("searchEndDateUnder",now);
        endDateMap.put("mtFlagTrip",MemberTripService.FLAG_ING);
        endDateMap.put("mtState", MemberTripService.STATE_NONE);

        List<MemberTripVO> endList = memberTripDao.selectBySearch(endDateMap);

        if(endList.size()>0)
        {
           for(MemberTripVO memberTripVO : endList)
           {
                memberTripVO.setMtFlagTrip(MemberTripService.FLAG_END);
               memberTripDao.update(memberTripVO);
           }
        }
    }

    @Override
    public void processTimestamp()
    {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("mtCreateTimestamp", -1);

        List<MemberTripVO> list = memberTripDao.selectBySearch(parameter);

        if(list.size()>0)
        {
            for(MemberTripVO memberTripVO : list)
            {
                memberTripVO.setMtCreateTimestamp(memberTripVO.getMtCreateDate().getTime());
                memberTripDao.update(memberTripVO);
            }
        }

    }




}
