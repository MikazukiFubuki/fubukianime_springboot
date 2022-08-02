package com.fubukianime.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.AnimePeriod;
import com.fubukianime.service.AnimePeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/animePeriods")
public class AnimePeriodController {

    @Autowired
    private AnimePeriodService animePeriodService;


    @Autowired
    private CacheManager cacheManager;


    /**
     * Cacheable判断是否有数据，有则直接返回
     * condition满足条件才缓存
     * unless满足条件不缓存
     * @param
     * @return
     */
    @Cacheable(value = "animePeriodCache", key = "#animePeriod.id + '_' + #animePeriod.sp + '_' + #animePeriod.spid", unless = "#result == null")
    @GetMapping("/selectComPeriod")
    public R selectComPeriod(AnimePeriod animePeriod){
        List<AnimePeriod> list = animePeriodService.selectComPeriod(animePeriod);
        return new R(true, list);
    }

    /**
     * Cacheable判断是否有数据，有则直接返回
     * condition满足条件才缓存
     * unless满足条件不缓存
     * @param
     * @return
     */
    @Cacheable(value = "animePeriodCache", key = "#root.methodName", unless = "#result == null")
    @GetMapping("/selectComPeriodShow")
    public List<AnimePeriod> selectComPeriodShow(AnimePeriod animePeriod){
        List<AnimePeriod> list = animePeriodService.selectComPeriod(animePeriod);
        return list;
    }

    @Cacheable(value = "animePeriodCache", key = "#root.methodName", unless = "#result == null")
    @GetMapping("/selectSPPeriod")
    public R selectSPPeriod(AnimePeriod animePeriod){
        List<AnimePeriod> list = animePeriodService.selectSPPeriod(animePeriod);
        return new R(true, list);
    }

    @CacheEvict(value = "animePeriodCache", allEntries = true)
    @PostMapping
    public R addPeriod(@RequestBody AnimePeriod animePeriod) throws IOException {
        boolean flag = animePeriodService.addPeriod(animePeriod);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }



}
