package com.fubukianime.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.AnimeLeaderGender;
import com.fubukianime.domain.AnimeSexLimit;
import com.fubukianime.service.AnimeLeaderGenderService;
import com.fubukianime.service.AnimeSexLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/animeLeaderGenders")
public class AnimeLeaderGenderController {

    @Autowired
    private AnimeLeaderGenderService animeLeaderGenderService;

    @Autowired
    private CacheManager cacheManager;

    @GetMapping
    public R getAll(){
        return new R(true, animeLeaderGenderService.list());
    }


    @CacheEvict(value = "animeLeaderGenderCache", allEntries = true)
    @PostMapping
    public R save(@RequestBody AnimeLeaderGender animeLeaderGender) throws IOException {
        boolean flag = animeLeaderGenderService.save(animeLeaderGender);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @CacheEvict(value = "animeLeaderGenderCache", allEntries = true)
    @PutMapping
    public R update(@RequestBody AnimeLeaderGender animeLeaderGender) throws IOException {
        boolean flag = animeLeaderGenderService.modify(animeLeaderGender);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @CacheEvict(value = "animeLeaderGenderCache", allEntries = true)
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(animeLeaderGenderService.delete(id));
    }

    @Cacheable(value = "animeLeaderGenderCache", key = "#id", unless = "#result == null")
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, animeLeaderGenderService.getById(id));
    }

    @Cacheable(value = "animeLeaderGenderCache", key = "#animeLeaderGender.id + '_' + #animeLeaderGender.leaderGender + '_' + #currentPage + '_' + #pageSize", unless = "#result == null")
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,AnimeLeaderGender animeLeaderGender){
        IPage<AnimeLeaderGender> page = animeLeaderGenderService.getPage(currentPage, pageSize,animeLeaderGender);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = animeLeaderGenderService.getPage((int)page.getPages(), pageSize,animeLeaderGender);
        }
        return new R(true, page);
    }
}
