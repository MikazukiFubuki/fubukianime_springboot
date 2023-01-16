package com.fubukianime.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.GalGameEnvironmentType;
import com.fubukianime.service.GalGameEnvironmentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/galGameEnvironmentTypes")
public class GalGameEnvironmentTypeController {

    @Autowired
    private GalGameEnvironmentTypeService galGameEnvironmentTypeService;

    @Autowired
    private CacheManager cacheManager;

    @GetMapping
    public R getAll(){
        return new R(true, galGameEnvironmentTypeService.list());
    }


    @CacheEvict(value = "galGameEnvironmentTypeCache", allEntries = true)
    @PostMapping
    public R save(@RequestBody GalGameEnvironmentType galGameEnvironmentType) throws IOException {
        boolean flag = galGameEnvironmentTypeService.save(galGameEnvironmentType);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @CacheEvict(value = "galGameEnvironmentTypeCache", allEntries = true)
    @PutMapping
    public R update(@RequestBody GalGameEnvironmentType galGameEnvironmentType) throws IOException {
        boolean flag = galGameEnvironmentTypeService.modify(galGameEnvironmentType);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @CacheEvict(value = "galGameEnvironmentTypeCache", allEntries = true)
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(galGameEnvironmentTypeService.delete(id));
    }

    @Cacheable(value = "galGameEnvironmentTypeCache", key = "#id", unless = "#result == null")
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, galGameEnvironmentTypeService.getById(id));
    }

    @Cacheable(value = "galGameEnvironmentTypeCache", key = "#galGameEnvironmentType.id + '_' + #galGameEnvironmentType.environmentType + '_' + #currentPage + '_' + #pageSize", unless = "#result == null")
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,GalGameEnvironmentType galGameEnvironmentType){
        IPage<GalGameEnvironmentType> page = galGameEnvironmentTypeService.getPage(currentPage, pageSize,galGameEnvironmentType);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = galGameEnvironmentTypeService.getPage((int)page.getPages(), pageSize,galGameEnvironmentType);
        }
        return new R(true, page);
    }
}
