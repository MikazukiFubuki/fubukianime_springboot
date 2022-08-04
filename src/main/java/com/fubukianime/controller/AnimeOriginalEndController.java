package com.fubukianime.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.AnimeAnimationEnd;
import com.fubukianime.domain.AnimeOriginalEnd;
import com.fubukianime.service.AnimeAnimationEndService;
import com.fubukianime.service.AnimeOriginalEndService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/animeOriginalEnds")
public class AnimeOriginalEndController {

    @Autowired
    private AnimeOriginalEndService animeOriginalEndService;

    @Autowired
    private CacheManager cacheManager;

    @GetMapping
    public R getAll(){
        return new R(true, animeOriginalEndService.list());
    }

    @CacheEvict(value = "animeOriginalEndCache", allEntries = true)
    @PostMapping
    public R save(@RequestBody AnimeOriginalEnd animeOriginalEnd) throws IOException {
        boolean flag = animeOriginalEndService.save(animeOriginalEnd);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @CacheEvict(value = "animeOriginalEndCache", allEntries = true)
    @PutMapping
    public R update(@RequestBody AnimeOriginalEnd animeOriginalEnd) throws IOException {
        boolean flag = animeOriginalEndService.modify(animeOriginalEnd);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @CacheEvict(value = "animeOriginalEndCache", allEntries = true)
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(animeOriginalEndService.delete(id));
    }

    @Cacheable(value = "animeOriginalEndCache", key = "#id", unless = "#result == null")
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, animeOriginalEndService.getById(id));
    }

    @Cacheable(value = "animeOriginalEndCache", key = "#animeOriginalEnd.id + '_' + #animeOriginalEnd.originalEnd + '_' + #currentPage + '_' + #pageSize", unless = "#result == null")
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,AnimeOriginalEnd animeOriginalEnd){
        IPage<AnimeOriginalEnd> page = animeOriginalEndService.getPage(currentPage, pageSize,animeOriginalEnd);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = animeOriginalEndService.getPage((int)page.getPages(), pageSize,animeOriginalEnd);
        }
        return new R(true, page);
    }
}
