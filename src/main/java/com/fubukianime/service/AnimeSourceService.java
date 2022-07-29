package com.fubukianime.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.AnimeLove;
import com.fubukianime.domain.AnimeSource;


public interface AnimeSourceService extends IService<AnimeSource> {


    boolean save(AnimeSource animeSource);

    boolean modify(AnimeSource animeSource);

    boolean delete(Integer id);

    IPage<AnimeSource> getPage(int currentPage, int pageSize);

    IPage<AnimeSource> getPage(int currentPage, int pageSize, AnimeSource animeSource);


}
