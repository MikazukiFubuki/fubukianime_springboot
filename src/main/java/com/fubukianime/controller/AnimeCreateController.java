package com.fubukianime.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.AnimeCreate;
import com.fubukianime.service.AnimeCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/animeCreates")
public class AnimeCreateController {

    @Autowired
    private AnimeCreateService animeCreateService;

    @Autowired
    private CacheManager cacheManager;

    @GetMapping
    public R getAll(){
        return new R(true, animeCreateService.list());
    }


    @CacheEvict(value = "animeCreateCache", allEntries = true)
    @PostMapping
    public R save(@RequestBody AnimeCreate animeCreate) throws IOException {
        boolean flag = animeCreateService.save(animeCreate);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @CacheEvict(value = "animeCreateCache", allEntries = true)
    @PutMapping
    public R update(@RequestBody AnimeCreate animeCreate) throws IOException {
        boolean flag = animeCreateService.modify(animeCreate);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @CacheEvict(value = "animeCreateCache", allEntries = true)
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(animeCreateService.delete(id));
    }

    @Cacheable(value = "animeCreateCache", key = "#id", unless = "#result == null")
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, animeCreateService.getById(id));
    }

    @Cacheable(value = "animeCreateCache", key = "#animeCreate.id + '_' + #animeCreate.create + '_' + #animeCreate.description + '_' + #currentPage + '_' + #pageSize", unless = "#result == null")
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,AnimeCreate animeCreate){
        IPage<AnimeCreate> page = animeCreateService.getPage(currentPage, pageSize,animeCreate);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = animeCreateService.getPage((int)page.getPages(), pageSize,animeCreate);
        }
        return new R(true, page);
    }
}
