package com.fubukianime.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.AnimeType;
import com.fubukianime.service.AnimeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/animeTypes")
public class AnimeTypeController {

    @Autowired
    private AnimeTypeService animeTypeService;

    @Autowired
    private CacheManager cacheManager;

    @GetMapping
    public R getAll(){
        return new R(true, animeTypeService.list());
    }


    @CacheEvict(value = "animeTypeCache", allEntries = true)
    @PostMapping
    public R save(@RequestBody AnimeType animeType) throws IOException {
        boolean flag = animeTypeService.save(animeType);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @CacheEvict(value = "animeTypeCache", allEntries = true)
    @PutMapping
    public R update(@RequestBody AnimeType animeType) throws IOException {
        boolean flag = animeTypeService.modify(animeType);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @CacheEvict(value = "animeTypeCache", allEntries = true)
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(animeTypeService.delete(id));
    }

    @Cacheable(value = "animeTypeCache", key = "#id", unless = "#result == null")
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, animeTypeService.getById(id));
    }

    @Cacheable(value = "animeTypeCache", key = "#animeType.id + '_' + #animeType.type + '_' + #currentPage + '_' + #pageSize", unless = "#result == null")
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,AnimeType animeType){
        IPage<AnimeType> page = animeTypeService.getPage(currentPage, pageSize,animeType);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = animeTypeService.getPage((int)page.getPages(), pageSize,animeType);
        }
        return new R(true, page);
    }
}
