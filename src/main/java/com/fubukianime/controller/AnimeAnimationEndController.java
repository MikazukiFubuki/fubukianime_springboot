package com.fubukianime.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.AnimeAnimationEnd;
import com.fubukianime.domain.AnimeSexLimit;
import com.fubukianime.service.AnimeAnimationEndService;
import com.fubukianime.service.AnimeSexLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/animeAnimationEnds")
public class AnimeAnimationEndController {

    @Autowired
    private AnimeAnimationEndService animeAnimationEndService;

    @Autowired
    private CacheManager cacheManager;

    @GetMapping
    public R getAll(){
        return new R(true, animeAnimationEndService.list());
    }


    @CacheEvict(value = "animeAnimationEndCache", allEntries = true)
    @PostMapping
    public R save(@RequestBody AnimeAnimationEnd animeAnimationEnd) throws IOException {
        boolean flag = animeAnimationEndService.save(animeAnimationEnd);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @CacheEvict(value = "animeAnimationEndCache", allEntries = true)
    @PutMapping
    public R update(@RequestBody AnimeAnimationEnd animeAnimationEnd) throws IOException {
        boolean flag = animeAnimationEndService.modify(animeAnimationEnd);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @CacheEvict(value = "animeAnimationEndCache", allEntries = true)
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(animeAnimationEndService.delete(id));
    }

    @Cacheable(value = "animeAnimationEndCache", key = "#id", unless = "#result == null")
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, animeAnimationEndService.getById(id));
    }

    @Cacheable(value = "animeAnimationEndCache", key = "#animeAnimationEnd.id + '_' + #animeAnimationEnd.animationEnd + '_' + #currentPage + '_' + #pageSize", unless = "#result == null")
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,AnimeAnimationEnd animeAnimationEnd){
        IPage<AnimeAnimationEnd> page = animeAnimationEndService.getPage(currentPage, pageSize,animeAnimationEnd);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = animeAnimationEndService.getPage((int)page.getPages(), pageSize,animeAnimationEnd);
        }
        return new R(true, page);
    }
}
