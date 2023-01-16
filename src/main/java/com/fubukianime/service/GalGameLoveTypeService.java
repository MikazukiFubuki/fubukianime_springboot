package com.fubukianime.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.GalGameLoveType;


public interface GalGameLoveTypeService extends IService<GalGameLoveType> {


    boolean save(GalGameLoveType galGameLoveType);

    boolean modify(GalGameLoveType galGameLoveType);

    boolean delete(Integer id);

    IPage<GalGameLoveType> getPage(int currentPage, int pageSize);

    IPage<GalGameLoveType> getPage(int currentPage, int pageSize, GalGameLoveType galGameLoveType);


}
