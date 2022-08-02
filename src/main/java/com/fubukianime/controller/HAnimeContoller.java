package com.fubukianime.controller;

import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.CvCV;
import com.fubukianime.domain.HAnimeMain;
import com.fubukianime.service.HAnimeMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/hanimes")
public class HAnimeContoller {

    @Autowired
    private HAnimeMainService hAnimeMainService;

    @Autowired
    private CacheManager cacheManager;

    @Cacheable(value = "hanimeCache", key = "#root.methodName  +  '_' + #hAnimeMain.name +  '_' + #hAnimeMain.content +  '_' + #hAnimeMain.type +  '_' + #hAnimeMain.layoutType+  '_' + #hAnimeMain.episodes +  '_' + #hAnimeMain.dimensional +  '_' + #hAnimeMain.sexLimit +  '_' + #hAnimeMain.status", unless = "#result == null")
    @GetMapping("/selectMainByCondition")
    public R selectMainByCondition(HAnimeMain hAnimeMain) {
        List<HAnimeMain> list = hAnimeMainService.selectMainByCondition(hAnimeMain);
        return new R(true, list);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Cacheable(value = "hanimeCache", key = "#root.methodName + '_' + #id", unless = "#result == null")
    @GetMapping("/selectMainById/{id}")
    public R selectMainById(@PathVariable Integer id){
        return new R(true, hAnimeMainService.selectMainById(id));
    }

    @CacheEvict(value = "hanimeCache", allEntries = true)
    @PostMapping("/addHAnime")
    public R addHAnime(@RequestBody HAnimeMain hAnimeMain) throws IOException {
        boolean flag = hAnimeMainService.addHAnime(hAnimeMain);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @CacheEvict(value = "hanimeCache", allEntries = true)
    @PutMapping("/updateHAnime")
    public R updateHAnime(@RequestBody HAnimeMain hAnimeMain) {
        boolean flag = hAnimeMainService.updateHAnime(hAnimeMain);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @CacheEvict(value = "hanimeCache", allEntries = true)
    @PutMapping("/hanimeRemove")
    public R removeById(@RequestBody HAnimeMain hAnimeMain){
        boolean flag = hAnimeMainService.removeById(hAnimeMain);
        return new R(flag, flag ? "删除成功^_^" : "删除失败-_-!");
    }
}
