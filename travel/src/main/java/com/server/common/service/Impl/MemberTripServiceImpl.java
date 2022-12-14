package com.server.common.service.Impl;

import com.gunwoo.common.paging.PagingData;
import com.gunwoo.common.util.CommonStaticUtil;
import com.server.common.dao.MemberTripDao;
import com.server.common.model.vo.MemberTripVO;
import com.server.common.service.MemberTripService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberTripServiceImpl implements MemberTripService {

    private final MemberTripDao memberTripDao;

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


}
