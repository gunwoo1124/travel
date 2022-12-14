package com.server.common.service.Impl;

import com.server.common.dao.CommonQueryDao;
import com.server.common.service.CommonQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommonQueryServiceImpl implements CommonQueryService
{
    private final CommonQueryDao commonQueryDao;

    @Override
    public String selectNowString()
    {
        return commonQueryDao.selectNowString();
    }
    @Override
    public Date getDatabaseNow()
    {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return dateFormat.parse(selectNowString());
        }
        catch (Exception e) {
            log.error(e.toString());
            e.printStackTrace();
        }
        return null;
    }
}