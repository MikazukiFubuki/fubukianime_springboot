package com.fubukianime.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.AnimeLayoutType;
import com.fubukianime.service.AnimeLayoutTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/animeLayoutTypes")
public class AnimeLayoutTypeController {

    @Autowired
    private AnimeLayoutTypeService animeLayoutTypeService;

    @Autowired
    private CacheManager cacheManager;

    @GetMapping
    public R getAll(){
        return new R(true, animeLayoutTypeService.list());
    }


    @CacheEvict(value = "animeLayoutTypeCache", allEntries = true)
    @PostMapping
    public R save(@RequestBody AnimeLayoutType animeLayoutType) throws IOException {
        boolean flag = animeLayoutTypeService.save(animeLayoutType);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @CacheEvict(value = "animeLayoutTypeCache", allEntries = true)
    @PutMapping
    public R update(@RequestBody AnimeLayoutType animeLayoutType) throws IOException {
        boolean flag = animeLayoutTypeService.modify(animeLayoutType);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @CacheEvict(value = "animeLayoutTypeCache", allEntries = true)
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(animeLayoutTypeService.delete(id));
    }

    @Cacheable(value = "animeLayoutTypeCache", key = "#id", unless = "#result == null")
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, animeLayoutTypeService.getById(id));
    }

    @Cacheable(value = "animeLayoutTypeCache", key = "#animeLayoutType.id + '_' + #animeLayoutType.layoutType + '_' + #currentPage + '_' + #pageSize", unless = "#result == null")
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,AnimeLayoutType animeLayoutType){
        IPage<AnimeLayoutType> page = animeLayoutTypeService.getPage(currentPage, pageSize,animeLayoutType);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = animeLayoutTypeService.getPage((int)page.getPages(), pageSize,animeLayoutType);
        }
        return new R(true, page);
    }
}
