package com.fubukianime.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.AnimeType;
import com.fubukianime.domain.HAnimeType;


public interface HAnimeTypeService extends IService<HAnimeType> {


    boolean save(HAnimeType hAnimeType);

    boolean modify(HAnimeType hAnimeType);

    boolean delete(Integer id);

    IPage<HAnimeType> getPage(int currentPage, int pageSize);

    IPage<HAnimeType> getPage(int currentPage, int pageSize, HAnimeType hAnimeType);


}
