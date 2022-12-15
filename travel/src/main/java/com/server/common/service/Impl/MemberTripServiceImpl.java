package com.server.common.service.Impl;

import com.gunwoo.common.paging.PagingData;
import com.gunwoo.common.util.CommonStaticUtil;
import com.server.common.dao.CityInfoDao;
import com.server.common.dao.MemberInfoDao;
import com.server.common.dao.MemberTripDao;
import com.server.common.model.ReturnCode;
import com.server.common.model.request.ReqTripInfo;
import com.server.common.model.response.ResCityInfo;
import com.server.common.model.response.ResTripInfo;
import com.server.common.model.vo.CityInfoVO;
import com.server.common.model.vo.MemberInfoVO;
import com.server.common.model.vo.MemberTripVO;
import com.server.common.model.vo.MemberTripVOForApi;
import com.server.common.service.CityInfoService;
import com.server.common.service.CommonQueryService;
import com.server.common.service.MemberTripService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.parameters.P;
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

        Date now = commonQueryService.getDatabaseNow();
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
                            now = commonQueryService.getDatabaseNow();

                            Long nowTimestamp = now.getTime();
                            Long endTimeStamp = endDate.getTime();

                            if(endTimeStamp < nowTimestamp)
                            {
                                returnCode = ReturnCode.TRIP_END_DATE_OVER;
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


}
