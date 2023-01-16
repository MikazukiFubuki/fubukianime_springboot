package com.fubukianime.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.GalGameBranchType;
import com.fubukianime.service.GalGameBranchTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/galGameBranchTypes")
public class GalGameBranchTypeController {

    @Autowired
    private GalGameBranchTypeService galGameBranchTypeService;

    @Autowired
    private CacheManager cacheManager;

    @GetMapping
    public R getAll(){
        return new R(true, galGameBranchTypeService.list());
    }


    @CacheEvict(value = "galGameBranchTypeCache", allEntries = true)
    @PostMapping
    public R save(@RequestBody GalGameBranchType galGameBranchType) throws IOException {
        boolean flag = galGameBranchTypeService.save(galGameBranchType);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @CacheEvict(value = "galGameBranchTypeCache", allEntries = true)
    @PutMapping
    public R update(@RequestBody GalGameBranchType galGameBranchType) throws IOException {
        boolean flag = galGameBranchTypeService.modify(galGameBranchType);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @CacheEvict(value = "galGameBranchTypeCache", allEntries = true)
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(galGameBranchTypeService.delete(id));
    }

    @Cacheable(value = "galGameBranchTypeCache", key = "#id", unless = "#result == null")
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, galGameBranchTypeService.getById(id));
    }

    @Cacheable(value = "galGameBranchTypeCache", key = "#galGameBranchType.id + '_' + #galGameBranchType.branchType + '_' + #currentPage + '_' + #pageSize", unless = "#result == null")
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,GalGameBranchType galGameBranchType){
        IPage<GalGameBranchType> page = galGameBranchTypeService.getPage(currentPage, pageSize,galGameBranchType);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = galGameBranchTypeService.getPage((int)page.getPages(), pageSize,galGameBranchType);
        }
        return new R(true, page);
    }
}
