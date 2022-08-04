package com.fubukianime.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.AnimeType;
import com.fubukianime.domain.GalGameType;
import com.fubukianime.service.AnimeTypeService;
import com.fubukianime.service.GalGameTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/galGameTypes")
public class GalGameTypeController {

    @Autowired
    private GalGameTypeService galGameTypeService;

    @Autowired
    private CacheManager cacheManager;

    @GetMapping
    public R getAll(){
        return new R(true, galGameTypeService.list());
    }


    @CacheEvict(value = "galGameTypeCache", allEntries = true)
    @PostMapping
    public R save(@RequestBody GalGameType galGameType) throws IOException {
        boolean flag = galGameTypeService.save(galGameType);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @CacheEvict(value = "galGameTypeCache", allEntries = true)
    @PutMapping
    public R update(@RequestBody GalGameType galGameType) throws IOException {
        boolean flag = galGameTypeService.modify(galGameType);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @CacheEvict(value = "galGameTypeCache", allEntries = true)
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(galGameTypeService.delete(id));
    }

    @Cacheable(value = "galGameTypeCache", key = "#id", unless = "#result == null")
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, galGameTypeService.getById(id));
    }

    @Cacheable(value = "galGameTypeCache", key = "#galGameType.id + '_' + #galGameType.type + '_' + #currentPage + '_' + #pageSize", unless = "#result == null")
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,GalGameType galGameType){
        IPage<GalGameType> page = galGameTypeService.getPage(currentPage, pageSize,galGameType);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = galGameTypeService.getPage((int)page.getPages(), pageSize,galGameType);
        }
        return new R(true, page);
    }
}
