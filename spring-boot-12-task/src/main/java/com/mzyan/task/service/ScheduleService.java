package com.mzyan.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    /**
     * second \ minute \ hour \ day of month \ month \ day of week
     * 0 * * * * MON-FRI
     *
     * eg:
     * 【 0 0/5 14,18 * * ? 】 每天14点整、18点整，每隔5分钟执行；
     * 【 0 15 10 ? * 1-6 】 每个月的周一到周六，10：15执行
     * 【 0 0 2 ? * 6L 】 每个月最后一个周六凌晨2点执行
     * 【 0 0 2 LW * ? 】 每个月最后一个工作日2点执行
     * 【 0 0 2-4 ? * 1#1 】 每个月的第一个周一的2点到4点，整点执行
     *
     */
    @Scheduled(cron = "0/4 * * * * MON-FRI")
    public void hello(){
        System.out.println("hello...");
    }
}
