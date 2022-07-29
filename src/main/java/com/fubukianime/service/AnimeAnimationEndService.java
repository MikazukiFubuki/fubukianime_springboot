package com.fubukianime.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.AnimeAnimationEnd;
import com.fubukianime.domain.AnimeSexLimit;


public interface AnimeAnimationEndService extends IService<AnimeAnimationEnd> {


    boolean save(AnimeAnimationEnd animeAnimationEnd);

    boolean modify(AnimeAnimationEnd animeAnimationEnd);

    boolean delete(Integer id);

    IPage<AnimeAnimationEnd> getPage(int currentPage, int pageSize);

    IPage<AnimeAnimationEnd> getPage(int currentPage, int pageSize, AnimeAnimationEnd animeAnimationEnd);


}
