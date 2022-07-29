package com.fubukianime.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.AnimeAnimationEnd;
import com.fubukianime.domain.AnimeOriginalEnd;


public interface AnimeOriginalEndService extends IService<AnimeOriginalEnd> {


    boolean save(AnimeOriginalEnd animeOriginalEnd);

    boolean modify(AnimeOriginalEnd animeOriginalEnd);

    boolean delete(Integer id);

    IPage<AnimeOriginalEnd> getPage(int currentPage, int pageSize);

    IPage<AnimeOriginalEnd> getPage(int currentPage, int pageSize, AnimeOriginalEnd animeOriginalEnd);


}
