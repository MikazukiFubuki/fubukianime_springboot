package com.fubukianime.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.AnimeEdition;
import com.fubukianime.service.AnimeEditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/animeEditions")
public class AnimeEditionController {

    @Autowired
    private AnimeEditionService animeEditionService;


    @Autowired
    private CacheManager cacheManager;

    @CacheEvict(value = "AnimeEditionCache", allEntries = true)
    @PostMapping("/addLargeEdition")
    public R addLargeEdition(@RequestBody AnimeEdition animeEdition) throws IOException {
        boolean flag = animeEditionService.addLargeEdition(animeEdition);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @CacheEvict(value = "AnimeEditionCache", allEntries = true)
    @PostMapping("/addMinorEdition")
    public R addMinorEdition(@RequestBody AnimeEdition animeEdition) throws IOException {
        boolean flag = animeEditionService.addMinorEdition(animeEdition);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }


    /**
     * Cacheable判断是否有数据，有则直接返回
     * condition满足条件才缓存
     * unless满足条件不缓存
     *
     * @param animeEdition
     * @return
     */
    @Cacheable(value = "AnimeEditionCache", key = "#animeEdition.id + '_' + #animeEdition.largeVersion + '_' + #animeEdition.minorVersion + '_' + #animeEdition.content + '_' + #animeEdition.newContent + '_' + #animeEdition.obsoleteContent + '_' + #animeEdition.onlineTime", unless = "#result == null")
    @GetMapping("/selectEdition")
    public R selectEdition(AnimeEdition animeEdition) {
        return new R(true, animeEditionService.selectEdition(animeEdition));
    }

}
