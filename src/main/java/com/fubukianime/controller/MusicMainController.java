package com.fubukianime.controller;

import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.CvCV;
import com.fubukianime.domain.CvWorks;
import com.fubukianime.domain.MusicMain;
import com.fubukianime.service.CvCVService;
import com.fubukianime.service.CvWorksService;
import com.fubukianime.service.MusicMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/musics")
public class MusicMainController {
    @Autowired
    private MusicMainService musicMainService;

    @Autowired
    private CacheManager cacheManager;

    @Cacheable(value = "musicsCache", key = "#root.methodName  +  '_' + #musicMain.mid +  '_' + #musicMain.animeName  +  '_' + #musicMain.musicName  +  '_' + #musicMain.type  +  '_' + #musicMain.time  +  '_' + #musicMain.singer  +  '_' + #musicMain.score  +  '_' + #musicMain.form  +  '_' + #musicMain.source  +  '_' + #musicMain.downloadType  +  '_' + #musicMain.addType  +  '_' + #musicMain.year  +  '_' + #musicMain.quarter", unless = "#result == null")
    @GetMapping("/selectMusicMain")
    public R selectMusicMain(MusicMain musicMain) {
        List<MusicMain> list = musicMainService.selectMusicMain(musicMain);
        return new R(true, list);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Cacheable(value = "musicsCache", key = "#root.methodName + '_' + #id", unless = "#result == null")
    @GetMapping("/selectMusicMainById/{id}")
    public R selectMusicMainById(@PathVariable Integer id){
        return new R(true, musicMainService.selectMusicMainById(id));
    }

    @CacheEvict(value = "musicsCache", allEntries = true)
    @PostMapping("/addMusicMain")
    public R addMusicMain(@RequestBody MusicMain musicMain) throws IOException {
        boolean flag = musicMainService.addMusicMain(musicMain);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @CacheEvict(value = "musicsCache", allEntries = true)
    @PutMapping("/updateMusicMain")
    public R updateMusicMain(@RequestBody MusicMain musicMain) {
        boolean flag = musicMainService.updateMusicMain(musicMain);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @CacheEvict(value = "musicsCache", allEntries = true)
    @PutMapping("/Listened")
    public R Listened(@RequestBody MusicMain musicMain) {
        boolean flag = musicMainService.Listened(musicMain);
        return new R(flag, flag ? "鉴赏成功^_^" : "鉴赏失败-_-!");
    }

    @CacheEvict(value = "musicsCache", allEntries = true)
    @PutMapping("/musicRemove")
    public R removeById(@RequestBody MusicMain musicMain){
        boolean flag = musicMainService.removeById(musicMain);
        return new R(flag, flag ? "删除成功^_^" : "删除失败-_-!");
    }


}
