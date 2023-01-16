package com.fubukianime.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.GalGameRebornType;
import com.fubukianime.service.GalGameRebornTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/galGameRebornTypes")
public class GalGameRebornTypeController {

    @Autowired
    private GalGameRebornTypeService galGameRebornTypeService;

    @Autowired
    private CacheManager cacheManager;

    @GetMapping
    public R getAll(){
        return new R(true, galGameRebornTypeService.list());
    }


    @CacheEvict(value = "galGameRebornTypeCache", allEntries = true)
    @PostMapping
    public R save(@RequestBody GalGameRebornType galGameRebornType) throws IOException {
        boolean flag = galGameRebornTypeService.save(galGameRebornType);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @CacheEvict(value = "galGameRebornTypeCache", allEntries = true)
    @PutMapping
    public R update(@RequestBody GalGameRebornType galGameRebornType) throws IOException {
        boolean flag = galGameRebornTypeService.modify(galGameRebornType);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @CacheEvict(value = "galGameRebornTypeCache", allEntries = true)
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(galGameRebornTypeService.delete(id));
    }

    @Cacheable(value = "galGameRebornTypeCache", key = "#id", unless = "#result == null")
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, galGameRebornTypeService.getById(id));
    }

    @Cacheable(value = "galGameRebornTypeCache", key = "#galGameRebornType.id + '_' + #galGameRebornType.rebornType + '_' + #currentPage + '_' + #pageSize", unless = "#result == null")
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,GalGameRebornType galGameRebornType){
        IPage<GalGameRebornType> page = galGameRebornTypeService.getPage(currentPage, pageSize,galGameRebornType);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = galGameRebornTypeService.getPage((int)page.getPages(), pageSize,galGameRebornType);
        }
        return new R(true, page);
    }
}
