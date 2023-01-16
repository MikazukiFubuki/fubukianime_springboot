package com.fubukianime.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.GalGameSpType;
import com.fubukianime.service.GalGameSpTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/galGameSpTypes")
public class GalGameSpTypeController {

    @Autowired
    private GalGameSpTypeService galGameSpTypeService;

    @Autowired
    private CacheManager cacheManager;

    @GetMapping
    public R getAll(){
        return new R(true, galGameSpTypeService.list());
    }


    @CacheEvict(value = "galGameSpTypeCache", allEntries = true)
    @PostMapping
    public R save(@RequestBody GalGameSpType galGameSpType) throws IOException {
        boolean flag = galGameSpTypeService.save(galGameSpType);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @CacheEvict(value = "galGameSpTypeCache", allEntries = true)
    @PutMapping
    public R update(@RequestBody GalGameSpType galGameSpType) throws IOException {
        boolean flag = galGameSpTypeService.modify(galGameSpType);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @CacheEvict(value = "galGameSpTypeCache", allEntries = true)
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(galGameSpTypeService.delete(id));
    }

    @Cacheable(value = "galGameSpTypeCache", key = "#id", unless = "#result == null")
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, galGameSpTypeService.getById(id));
    }

    @Cacheable(value = "galGameSpTypeCache", key = "#galGameSpType.id + '_' + #galGameSpType.spType + '_' + #currentPage + '_' + #pageSize", unless = "#result == null")
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,GalGameSpType galGameSpType){
        IPage<GalGameSpType> page = galGameSpTypeService.getPage(currentPage, pageSize,galGameSpType);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = galGameSpTypeService.getPage((int)page.getPages(), pageSize,galGameSpType);
        }
        return new R(true, page);
    }
}
