package com.server.common.service.Impl;


import com.gunwoo.common.paging.PagingData;
import com.gunwoo.common.util.CommonStaticUtil;
import com.server.common.dao.MemberInfoDao;
import com.server.common.model.ReturnCode;
import com.server.common.model.response.ResUserInfo;
import com.server.common.model.vo.MemberInfoVO;
import com.server.common.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService
{

    private final MemberInfoDao memberInfoDao;

    @Override public boolean insert(MemberInfoVO entity) { return false; }
    @Override public boolean update(MemberInfoVO entity) { return memberInfoDao.update(entity); }
    @Override public boolean delete(Long index) { return memberInfoDao.deleteByIndex(index); }
    @Override public MemberInfoVO select(Long index) { return memberInfoDao.selectByIndex(index); }

    @Override public List<MemberInfoVO> selectAll() { return memberInfoDao.selectAll(); }
    @Override public MemberInfoVO selectById(String mbId)
    {
        if( ! StringUtils.hasText(mbId))
        {
            log.error("mbId is empty");
            return null;
        }

        return memberInfoDao.selectById(mbId.trim().toLowerCase(Locale.ROOT));
    }

    @Override public List<MemberInfoVO> selectBySearch(Map<String, Object> parameter) { return memberInfoDao.selectBySearch(parameter); }

    @Override
    public PagingData selectPagingBySearch(Map<String, Object> parameter)
    {
        PagingData pagingData = CommonStaticUtil.generateCommonPagingData(parameter, memberInfoDao.countBySearch(parameter));
        List<MemberInfoVO> dataList = selectBySearch(parameter);
        pagingData.setObject(dataList);
        pagingData.setCurrentPageRowCount(dataList.size());
        return pagingData;
    }


    @Override
    public ResUserInfo userRegister(String id)
    {
        ResUserInfo response = new ResUserInfo();
        ReturnCode returnCode = ReturnCode.INTERNAL_ERROR;
        try
        {
            if(!StringUtils.hasText(id) && id.equals(""))
                returnCode = ReturnCode.ID_ERROR;
            else
            {
                Map<String, Object> parameter = new HashMap<>();
                parameter.put("mbId", id);
                parameter.put("mbState", MemberService.STATE_NONE);

                List<MemberInfoVO> dataList = selectBySearch(parameter);

                if(dataList.size() != 0)
                    returnCode = ReturnCode.ID_ALREADY_EXISTS;
                else
                {
                    MemberInfoVO entity = new MemberInfoVO();
                    entity.setMbId(id);
                    if(memberInfoDao.insert(entity))
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
