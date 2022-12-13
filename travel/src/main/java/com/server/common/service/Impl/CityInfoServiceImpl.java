package com.server.common.service.Impl;

import com.gunwoo.common.paging.PagingData;
import com.gunwoo.common.util.CommonStaticUtil;
import com.server.common.dao.CityInfoDao;
import com.server.common.model.vo.CityInfoVO;
import com.server.common.service.CityInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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


}
