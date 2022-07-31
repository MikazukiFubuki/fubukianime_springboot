package com.fubukianime.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.AnimeMerch;
import com.fubukianime.service.AnimeMerchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/animeMerchs")
public class AnimeMerchController {

    @Autowired
    private AnimeMerchService animeMerchService;


    @Autowired
    private CacheManager cacheManager;


    @GetMapping
    public R getAll(){
        return new R(true, animeMerchService.list());
    }


    @CacheEvict(value = "AnimeMerchCache", allEntries = true)
    @PostMapping
    public R save(@RequestBody AnimeMerch AnimeMerch) throws IOException {
        boolean flag = animeMerchService.save(AnimeMerch);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @CacheEvict(value = "AnimeMerchCache", allEntries = true)
    @PutMapping
    public R update(@RequestBody AnimeMerch AnimeMerch) throws IOException {
        boolean flag = animeMerchService.modify(AnimeMerch);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @CacheEvict(value = "AnimeMerchCache", allEntries = true)
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(animeMerchService.delete(id));
    }

    /**
     * Cacheable判断是否有数据，有则直接返回
     * condition满足条件才缓存
     * unless满足条件不缓存
     * @param id
     * @return
     */
    @Cacheable(value = "AnimeMerchCache", key = "#id", unless = "#result == null")
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, animeMerchService.getById(id));
    }

    @Cacheable(value = "AnimeMerchCache", key = "#animeMerch.id + '_' + #animeMerch.animeName + '_' + #animeMerch.merch + '_' + #animeMerch.status + '_' + #currentPage + '_' + #pageSize", unless = "#result == null")
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,AnimeMerch animeMerch){
        IPage<AnimeMerch> page = animeMerchService.getPage(currentPage, pageSize,animeMerch);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = animeMerchService.getPage((int)page.getPages(), pageSize,animeMerch);
        }
        return new R(true, page);
    }
}
