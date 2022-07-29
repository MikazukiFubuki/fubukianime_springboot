package com.fubukianime.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.AnimeStatus;


public interface AnimeStatusService extends IService<AnimeStatus> {


    boolean save(AnimeStatus animeStatus);

    boolean modify(AnimeStatus animeStatus);

    boolean delete(Integer id);

    IPage<AnimeStatus> getPage(int currentPage, int pageSize);

    IPage<AnimeStatus> getPage(int currentPage, int pageSize, AnimeStatus animeStatus);


}
