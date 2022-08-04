package com.fubukianime.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.AnimeLove;
import com.fubukianime.domain.AnimeSexLimit;
import com.fubukianime.service.AnimeLoveService;
import com.fubukianime.service.AnimeSexLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@CrossOrigin
@RestController
@RequestMapping("/animeSexLimits")
public class AnimeSexLimitController {

    @Autowired
    private AnimeSexLimitService animeSexLimitService;

    @Autowired
    private CacheManager cacheManager;

    @GetMapping
    public R getAll(){
        return new R(true, animeSexLimitService.list());
    }


    @CacheEvict(value = "animeSexLimitCache", allEntries = true)
    @PostMapping
    public R save(@RequestBody AnimeSexLimit animeSexLimit) throws IOException {
        boolean flag = animeSexLimitService.save(animeSexLimit);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @CacheEvict(value = "animeSexLimitCache", allEntries = true)
    @PutMapping
    public R update(@RequestBody AnimeSexLimit animeSexLimit) throws IOException {
        boolean flag = animeSexLimitService.modify(animeSexLimit);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @CacheEvict(value = "animeSexLimitCache", allEntries = true)
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(animeSexLimitService.delete(id));
    }

    @Cacheable(value = "animeSexLimitCache", key = "#id", unless = "#result == null")
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, animeSexLimitService.getById(id));
    }

    @Cacheable(value = "animeSexLimitCache", key = "#animeSexLimit.id + '_' + #animeSexLimit.sexLimit + '_' + #currentPage + '_' + #pageSize", unless = "#result == null")
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,AnimeSexLimit animeSexLimit){
        IPage<AnimeSexLimit> page = animeSexLimitService.getPage(currentPage, pageSize,animeSexLimit);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = animeSexLimitService.getPage((int)page.getPages(), pageSize,animeSexLimit);
        }
        return new R(true, page);
    }
}
