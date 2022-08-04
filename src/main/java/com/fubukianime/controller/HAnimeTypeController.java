package com.fubukianime.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.HAnimeType;
import com.fubukianime.service.HAnimeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@CrossOrigin
@RestController
@RequestMapping("/hAnimeTypes")
public class HAnimeTypeController {

    @Autowired
    private HAnimeTypeService hAnimeTypeService;

    @Autowired
    private CacheManager cacheManager;

    @GetMapping
    public R getAll(){
        return new R(true, hAnimeTypeService.list());
    }


    @CacheEvict(value = "hAnimeTypeCache", allEntries = true)
    @PostMapping
    public R save(@RequestBody HAnimeType hAnimeType) throws IOException {
        boolean flag = hAnimeTypeService.save(hAnimeType);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @CacheEvict(value = "hAnimeTypeCache", allEntries = true)
    @PutMapping
    public R update(@RequestBody HAnimeType hAnimeType) throws IOException {
        boolean flag = hAnimeTypeService.modify(hAnimeType);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @CacheEvict(value = "hAnimeTypeCache", allEntries = true)
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(hAnimeTypeService.delete(id));
    }

    @Cacheable(value = "hAnimeTypeCache", key = "#id", unless = "#result == null")
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, hAnimeTypeService.getById(id));
    }

    @Cacheable(value = "hAnimeTypeCache", key = "#hAnimeType.id + '_' + #hAnimeType.type + '_' + #currentPage + '_' + #pageSize", unless = "#result == null")
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,HAnimeType hAnimeType){
        IPage<HAnimeType> page = hAnimeTypeService.getPage(currentPage, pageSize,hAnimeType);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = hAnimeTypeService.getPage((int)page.getPages(), pageSize,hAnimeType);
        }
        return new R(true, page);
    }
}
