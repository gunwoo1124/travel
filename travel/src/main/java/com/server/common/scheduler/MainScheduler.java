package com.server.common.scheduler;

import com.server.common.service.MemberLogActionService;
import com.server.common.service.MemberTripService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MainScheduler
{
    private final int STARTUP_DELAY = 1;

    private final MemberTripService memberTripService;
    private final MemberLogActionService memberLogActionService;

    @Scheduled(fixedDelay = 1000, initialDelay = 1000 * STARTUP_DELAY)
    private void scheduled_main_1()
    {
        memberTripService.processTrip();
        memberTripService.processTimestamp();
        memberLogActionService.processTimestamp();

    }
}
