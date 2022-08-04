package com.fubukianime.controller;

import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.GalGameMain;
import com.fubukianime.service.GalGameMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/galGames")
public class GalGameMainController {
    @Autowired
    private GalGameMainService galGameMainService;

    @Autowired
    private CacheManager cacheManager;

    @Cacheable(value = "galGamesCache", key = "#root.methodName  +  '_' + #galGameMain.name +  '_' + #galGameMain.storyScore +  '_' + #galGameMain.roleScore +  '_' + #galGameMain.imgQualityScore +  '_' + #galGameMain.musicScore +  '_' + #galGameMain.environmentType +  '_' + #galGameMain.type +  '_' + #galGameMain.rebornType +  '_' + #galGameMain.loveType +  '_' + #galGameMain.branchType +  '_' + #galGameMain.spType +  '_' + #galGameMain.language +  '_' + #galGameMain.area +  '_' + #galGameMain.status", unless = "#result == null")
    @GetMapping("/selectGalGameMain")
    public R selectGalGameMain(GalGameMain galGameMain) {
        List<GalGameMain> list = galGameMainService.selectGalGameMain(galGameMain);
        return new R(true, list);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Cacheable(value = "galGamesCache", key = "#root.methodName + '_' + #id", unless = "#result == null")
    @GetMapping("/selectGalGameMainById/{id}")
    public R selectGalGameMainById(@PathVariable Integer id){
        return new R(true, galGameMainService.selectGalGameMainById(id));
    }

    @CacheEvict(value = "galGamesCache", allEntries = true)
    @PostMapping("/addGalGameMain")
    public R addGalGameMain(@RequestBody GalGameMain galGameMain) throws IOException {
        boolean flag = galGameMainService.addGalGameMain(galGameMain);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @CacheEvict(value = "galGamesCache", allEntries = true)
    @PutMapping("/updateGalGameMain")
    public R updateGalGameMain(@RequestBody GalGameMain galGameMain) {
        boolean flag = galGameMainService.updateGalGameMain(galGameMain);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @CacheEvict(value = "galGamesCache", allEntries = true)
    @PutMapping("/galGameRemove")
    public R removeById(@RequestBody GalGameMain galGameMain){
        boolean flag = galGameMainService.removeById(galGameMain);
        return new R(flag, flag ? "删除成功^_^" : "删除失败-_-!");
    }


}
