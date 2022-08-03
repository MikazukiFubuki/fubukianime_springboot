package com.fubukianime.controller;

import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.MusicEdition;
import com.fubukianime.service.MusicEditionService;
import com.fubukianime.service.MusicEditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/musicEditions")
public class MusicEditionController {

    @Autowired
    private MusicEditionService musicEditionService;


    @Autowired
    private CacheManager cacheManager;

    @CacheEvict(value = "musicEditionCache", allEntries = true)
    @PostMapping("/addLargeEdition")
    public R addLargeEdition(@RequestBody MusicEdition musicEdition) throws IOException {
        boolean flag = musicEditionService.addLargeEdition(musicEdition);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @CacheEvict(value = "musicEditionCache", allEntries = true)
    @PostMapping("/addMinorEdition")
    public R addMinorEdition(@RequestBody MusicEdition musicEdition) throws IOException {
        boolean flag = musicEditionService.addMinorEdition(musicEdition);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }


    /**
     * Cacheable判断是否有数据，有则直接返回
     * condition满足条件才缓存
     * unless满足条件不缓存
     *
     * @param musicEdition
     * @return
     */
    @Cacheable(value = "musicEditionCache", key = "#musicEdition.id + '_' + #musicEdition.largeVersion + '_' + #musicEdition.minorVersion + '_' + #musicEdition.content + '_' + #musicEdition.newContent + '_' + #musicEdition.obsoleteContent + '_' + #musicEdition.onlineTime", unless = "#result == null")
    @GetMapping("/selectEdition")
    public R selectEdition(MusicEdition musicEdition) {
        return new R(true, musicEditionService.selectEdition(musicEdition));
    }

}
