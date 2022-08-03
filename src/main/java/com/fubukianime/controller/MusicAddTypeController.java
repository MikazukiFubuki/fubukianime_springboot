package com.fubukianime.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.MusicAddType;
import com.fubukianime.service.MusicAddTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/musicAddTypes")
public class MusicAddTypeController {

    @Autowired
    private MusicAddTypeService musicAddTypeService;

    @Autowired
    private CacheManager cacheManager;

    @GetMapping
    public R getAll(){
        return new R(true, musicAddTypeService.list());
    }


    @CacheEvict(value = "musicAddTypeCache", allEntries = true)
    @PostMapping
    public R save(@RequestBody MusicAddType musicAddType) throws IOException {
        boolean flag = musicAddTypeService.save(musicAddType);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @CacheEvict(value = "musicAddTypeCache", allEntries = true)
    @PutMapping
    public R update(@RequestBody MusicAddType musicAddType) throws IOException {
        boolean flag = musicAddTypeService.modify(musicAddType);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @CacheEvict(value = "musicAddTypeCache", allEntries = true)
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(musicAddTypeService.delete(id));
    }

    @Cacheable(value = "musicAddTypeCache", key = "#id", unless = "#result == null")
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, musicAddTypeService.getById(id));
    }

    @Cacheable(value = "musicAddTypeCache", key = "#musicAddType.id + '_' + #musicAddType.addType + '_' + #currentPage + '_' + #pageSize", unless = "#result == null")
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,MusicAddType musicAddType){
        IPage<MusicAddType> page = musicAddTypeService.getPage(currentPage, pageSize,musicAddType);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = musicAddTypeService.getPage((int)page.getPages(), pageSize,musicAddType);
        }
        return new R(true, page);
    }
}
