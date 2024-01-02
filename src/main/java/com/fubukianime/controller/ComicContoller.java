package com.fubukianime.controller;

import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.ComicMain;
import com.fubukianime.service.ComicMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/comics")
public class ComicContoller {

    @Autowired
    private ComicMainService comicMainService;

    @Autowired
    private CacheManager cacheManager;

    @Cacheable(value = "comicCache", key = "#root.methodName  +  '_' + #comicMain.name +  '_' + #comicMain.author +  '_' + #comicMain.content +  '_' + #comicMain.type +  '_' + #comicMain.sex+  '_' + #comicMain.episodes +  '_' + #comicMain.dimensional  +  '_' + #comicMain.status", unless = "#result == null")
    @GetMapping("/selectMainByCondition")
    public R selectMainByCondition(ComicMain comicMain) {
        List<ComicMain> list = comicMainService.selectMainByCondition(comicMain);
        return new R(true, list);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Cacheable(value = "comicCache", key = "#root.methodName + '_' + #id", unless = "#result == null")
    @GetMapping("/selectMainById/{id}")
    public R selectMainById(@PathVariable Integer id){
        return new R(true, comicMainService.selectMainById(id));
    }

    @CacheEvict(value = "comicCache", allEntries = true)
    @PostMapping("/addComic")
    public R addComic(@RequestBody ComicMain comicMain) throws IOException {
        boolean flag = comicMainService.addComic(comicMain);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @CacheEvict(value = "comicCache", allEntries = true)
    @PutMapping("/updateComic")
    public R updateComic(@RequestBody ComicMain comicMain) {
        boolean flag = comicMainService.updateComic(comicMain);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }


    /**
     * 对已追动画追更一集
     * @param comicMain
     */
    @CacheEvict(value = "comicCache", allEntries = true)
    @PutMapping("/chasingAPlay")
    public R chasingAPlay(@RequestBody ComicMain comicMain) throws IOException {
        boolean flag = comicMainService.chasingAPlay(comicMain);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @CacheEvict(value = "comicCache", allEntries = true)
    @PutMapping("/comicRemove")
    public R removeById(@RequestBody ComicMain comicMain){
        boolean flag = comicMainService.removeById(comicMain);
        return new R(flag, flag ? "删除成功^_^" : "删除失败-_-!");
    }
}
