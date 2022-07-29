package com.fubukianime.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.AnimeType;


public interface AnimeTypeService extends IService<AnimeType> {


    boolean save(AnimeType animeType);

    boolean modify(AnimeType animeType);

    boolean delete(Integer id);

    IPage<AnimeType> getPage(int currentPage, int pageSize);

    IPage<AnimeType> getPage(int currentPage, int pageSize, AnimeType animeType);


}
