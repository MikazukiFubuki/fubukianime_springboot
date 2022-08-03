package com.fubukianime.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.MusicDownloadType;
import com.fubukianime.service.MusicDownloadTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/musicDownloadTypes")
public class MusicDownloadTypeController {

    @Autowired
    private MusicDownloadTypeService musicDownloadTypeService;

    @Autowired
    private CacheManager cacheManager;

    @GetMapping
    public R getAll(){
        return new R(true, musicDownloadTypeService.list());
    }


    @CacheEvict(value = "musicDownloadTypeCache", allEntries = true)
    @PostMapping
    public R save(@RequestBody MusicDownloadType musicDownloadType) throws IOException {
        boolean flag = musicDownloadTypeService.save(musicDownloadType);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @CacheEvict(value = "musicDownloadTypeCache", allEntries = true)
    @PutMapping
    public R update(@RequestBody MusicDownloadType musicDownloadType) throws IOException {
        boolean flag = musicDownloadTypeService.modify(musicDownloadType);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @CacheEvict(value = "musicDownloadTypeCache", allEntries = true)
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(musicDownloadTypeService.delete(id));
    }

    @Cacheable(value = "musicDownloadTypeCache", key = "#id", unless = "#result == null")
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, musicDownloadTypeService.getById(id));
    }

    @Cacheable(value = "musicDownloadTypeCache", key = "#musicDownloadType.id + '_' + #musicDownloadType.downloadType + '_' + #currentPage + '_' + #pageSize", unless = "#result == null")
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,MusicDownloadType musicDownloadType){
        IPage<MusicDownloadType> page = musicDownloadTypeService.getPage(currentPage, pageSize,musicDownloadType);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = musicDownloadTypeService.getPage((int)page.getPages(), pageSize,musicDownloadType);
        }
        return new R(true, page);
    }
}
