package com.fubukianime.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.AnimeType;
import com.fubukianime.domain.GalGameType;


public interface GalGameTypeService extends IService<GalGameType> {


    boolean save(GalGameType galGameType);

    boolean modify(GalGameType galGameType);

    boolean delete(Integer id);

    IPage<GalGameType> getPage(int currentPage, int pageSize);

    IPage<GalGameType> getPage(int currentPage, int pageSize, GalGameType galGameType);


}
