package com.fubukianime.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.AnimeCreate;
import com.fubukianime.domain.AnimeLove;


public interface AnimeLoveService extends IService<AnimeLove> {


    boolean save(AnimeLove animeLove);

    boolean modify(AnimeLove animeLove);

    boolean delete(Integer id);

    IPage<AnimeLove> getPage(int currentPage, int pageSize);

    IPage<AnimeLove> getPage(int currentPage, int pageSize, AnimeLove animeLove);


}
