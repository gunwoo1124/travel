package com.server.common.service.Impl;

import com.gunwoo.common.paging.PagingData;
import com.gunwoo.common.util.CommonStaticUtil;
import com.server.common.dao.MemberLogActionDao;
import com.server.common.model.vo.MemberInfoVO;
import com.server.common.model.vo.MemberLogActionVO;
import com.server.common.service.MemberLogActionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberLogActionServiceImpl implements MemberLogActionService
{
    private final MemberLogActionDao memberLogActionDao;


    @Override public boolean insert(MemberLogActionVO entity) { return memberLogActionDao.insert(entity); }
    @Override public boolean update(MemberLogActionVO entity) { return memberLogActionDao.update(entity); }
    @Override public boolean delete(Long index) { return memberLogActionDao.deleteByIndex(index); }
    @Override public MemberLogActionVO select(Long index) { return memberLogActionDao.selectByIndex(index); }

    @Override public List<MemberLogActionVO> selectAll() { return memberLogActionDao.selectAll(); }

    @Override public List<MemberLogActionVO> selectBySearch(Map<String, Object> parameter) { return memberLogActionDao.selectBySearch(parameter); }

    @Override
    public PagingData selectPagingBySearch(Map<String, Object> parameter)
    {
        PagingData pagingData = CommonStaticUtil.generateCommonPagingData(parameter, memberLogActionDao.countBySearch(parameter));
        List<MemberLogActionVO> dataList = selectBySearch(parameter);
        pagingData.setObject(dataList);
        pagingData.setCurrentPageRowCount(dataList.size());
        return pagingData;
    }

}
