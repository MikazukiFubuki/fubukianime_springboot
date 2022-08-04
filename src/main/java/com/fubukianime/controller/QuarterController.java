package com.fubukianime.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.Quarter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@CrossOrigin
@RestController
@RequestMapping("/quarters")
public class QuarterController {

    @Autowired
    private com.fubuki.service.QuarterService quarterService;

    @Autowired
    private CacheManager cacheManager;

    @GetMapping
    public R getAll(){
        return new R(true, quarterService.list());
    }

    @Cacheable(value = "quarterCache", key = "#id", unless = "#result == null")
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, quarterService.getById(id));
    }

    @Cacheable(value = "quarterCache", key = "#quarter.id + '_' + #quarter.quarter + '_' + #currentPage + '_' + #pageSize", unless = "#result == null")
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,Quarter quarter){
        IPage<Quarter> page = quarterService.getPage(currentPage, pageSize,quarter);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = quarterService.getPage((int)page.getPages(), pageSize,quarter);
        }
        return new R(true, page);
    }
}
