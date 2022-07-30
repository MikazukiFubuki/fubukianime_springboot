package com.fubukianime.controller;

import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.AnimeQuarter;
import com.fubukianime.service.AnimeQuarterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/animeQuarters")
public class AnimeQuarterController {

    @Autowired
    private AnimeQuarterService animeQuarterService;


    @Autowired
    private CacheManager cacheManager;


    /**
     * Cacheable判断是否有数据，有则直接返回
     * condition满足条件才缓存
     * unless满足条件不缓存
     * @param
     * @return
     */
    @Cacheable(value = "animeQuarterCache", key = "#root.methodName", unless = "#result == null")
    @GetMapping("/selectComQuarter")
    public R selectComQuarter(AnimeQuarter animeQuarter){
        List<AnimeQuarter> list = animeQuarterService.selectComQuarter(animeQuarter);
        return new R(true, list);
    }


    @Cacheable(value = "animeQuarterCache", key = "#root.methodName", unless = "#result == null")
    @GetMapping("/selectComQuarterShow")
    public List<AnimeQuarter> selectComQuarterShow(AnimeQuarter animeQuarter){
        List<AnimeQuarter> list = animeQuarterService.selectComQuarter(animeQuarter);
        return  list;
    }



    @CacheEvict(value = "animeQuarterCache", allEntries = true)
    @PostMapping("/addComQuarter")
    public R addComQuarter(@RequestBody AnimeQuarter animeQuarter) throws IOException {
        boolean flag = animeQuarterService.addComQuarter(animeQuarter);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }



}
