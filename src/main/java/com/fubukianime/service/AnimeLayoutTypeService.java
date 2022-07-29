package com.fubukianime.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.AnimeLayoutType;
import com.fubukianime.domain.AnimeLove;


public interface AnimeLayoutTypeService extends IService<AnimeLayoutType> {


    boolean save(AnimeLayoutType animeLayoutType);

    boolean modify(AnimeLayoutType animeLayoutType);

    boolean delete(Integer id);

    IPage<AnimeLayoutType> getPage(int currentPage, int pageSize);

    IPage<AnimeLayoutType> getPage(int currentPage, int pageSize, AnimeLayoutType animeLayoutType);


}
