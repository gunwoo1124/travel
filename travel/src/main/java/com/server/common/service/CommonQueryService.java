package com.server.common.service;

import java.util.Date;

public interface CommonQueryService
{
    String selectNowString();
    Date getDatabaseNow();
}