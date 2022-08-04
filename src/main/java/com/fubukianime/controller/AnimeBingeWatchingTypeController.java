package com.fubukianime.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.AnimeBingeWatchingType;
import com.fubukianime.domain.AnimeLeaderGender;
import com.fubukianime.service.AnimeBingeWatchingTypeService;
import com.fubukianime.service.AnimeLeaderGenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/animeBingeWatchingTypes")
public class AnimeBingeWatchingTypeController {

    @Autowired
    private AnimeBingeWatchingTypeService animeBingeWatchingTypeService;

    @Autowired
    private CacheManager cacheManager;


    @GetMapping
    public R getAll(){
        return new R(true, animeBingeWatchingTypeService.list());
    }


    @CacheEvict(value = "animeBingeWatchingTypeCache", allEntries = true)
    @PostMapping
    public R save(@RequestBody AnimeBingeWatchingType animeBingeWatchingType) throws IOException {
        boolean flag = animeBingeWatchingTypeService.save(animeBingeWatchingType);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @CacheEvict(value = "animeBingeWatchingTypeCache", allEntries = true)
    @PutMapping
    public R update(@RequestBody AnimeBingeWatchingType animeBingeWatchingType) throws IOException {
        boolean flag = animeBingeWatchingTypeService.modify(animeBingeWatchingType);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @CacheEvict(value = "animeBingeWatchingTypeCache", allEntries = true)
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(animeBingeWatchingTypeService.delete(id));
    }

    @Cacheable(value = "animeBingeWatchingTypeCache", key = "#id", unless = "#result == null")
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, animeBingeWatchingTypeService.getById(id));
    }

    @Cacheable(value = "animeBingeWatchingTypeCache", key = "#animeBingeWatchingType.id + '_' + #animeBingeWatchingType.bingeWatchingType + '_' + #currentPage + '_' + #pageSize", unless = "#result == null")
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,AnimeBingeWatchingType animeBingeWatchingType){
        IPage<AnimeBingeWatchingType> page = animeBingeWatchingTypeService.getPage(currentPage, pageSize,animeBingeWatchingType);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = animeBingeWatchingTypeService.getPage((int)page.getPages(), pageSize,animeBingeWatchingType);
        }
        return new R(true, page);
    }
}
