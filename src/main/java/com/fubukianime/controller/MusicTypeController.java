package com.fubukianime.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.AnimeType;
import com.fubukianime.domain.MusicType;
import com.fubukianime.service.AnimeTypeService;
import com.fubukianime.service.MusicTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/musicTypes")
public class MusicTypeController {

    @Autowired
    private MusicTypeService musicTypeService;

    @Autowired
    private CacheManager cacheManager;

    @GetMapping
    public R getAll(){
        return new R(true, musicTypeService.list());
    }


    @CacheEvict(value = "musicTypeCache", allEntries = true)
    @PostMapping
    public R save(@RequestBody MusicType musicType) throws IOException {
        boolean flag = musicTypeService.save(musicType);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @CacheEvict(value = "musicTypeCache", allEntries = true)
    @PutMapping
    public R update(@RequestBody MusicType musicType) throws IOException {
        boolean flag = musicTypeService.modify(musicType);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @CacheEvict(value = "musicTypeCache", allEntries = true)
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(musicTypeService.delete(id));
    }

    @Cacheable(value = "musicTypeCache", key = "#id", unless = "#result == null")
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, musicTypeService.getById(id));
    }

    @Cacheable(value = "musicTypeCache", key = "#musicType.id + '_' + #musicType.type + '_' + #currentPage + '_' + #pageSize", unless = "#result == null")
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,MusicType musicType){
        IPage<MusicType> page = musicTypeService.getPage(currentPage, pageSize,musicType);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = musicTypeService.getPage((int)page.getPages(), pageSize,musicType);
        }
        return new R(true, page);
    }
}
