package com.fubukianime.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.GalGameLoveType;
import com.fubukianime.service.GalGameLoveTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/galGameLoveTypes")
public class GalGameLoveTypeController {

    @Autowired
    private GalGameLoveTypeService galGameLoveTypeService;

    @Autowired
    private CacheManager cacheManager;

    @GetMapping
    public R getAll(){
        return new R(true, galGameLoveTypeService.list());
    }


    @CacheEvict(value = "galGameLoveTypeCache", allEntries = true)
    @PostMapping
    public R save(@RequestBody GalGameLoveType galGameLoveType) throws IOException {
        boolean flag = galGameLoveTypeService.save(galGameLoveType);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @CacheEvict(value = "galGameLoveTypeCache", allEntries = true)
    @PutMapping
    public R update(@RequestBody GalGameLoveType galGameLoveType) throws IOException {
        boolean flag = galGameLoveTypeService.modify(galGameLoveType);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @CacheEvict(value = "galGameLoveTypeCache", allEntries = true)
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(galGameLoveTypeService.delete(id));
    }

    @Cacheable(value = "galGameLoveTypeCache", key = "#id", unless = "#result == null")
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, galGameLoveTypeService.getById(id));
    }

    @Cacheable(value = "galGameLoveTypeCache", key = "#galGameLoveType.id + '_' + #galGameLoveType.loveType + '_' + #currentPage + '_' + #pageSize", unless = "#result == null")
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,GalGameLoveType galGameLoveType){
        IPage<GalGameLoveType> page = galGameLoveTypeService.getPage(currentPage, pageSize,galGameLoveType);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = galGameLoveTypeService.getPage((int)page.getPages(), pageSize,galGameLoveType);
        }
        return new R(true, page);
    }
}
