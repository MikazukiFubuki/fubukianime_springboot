package com.fubukianime.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.AnimeType;
import com.fubukianime.domain.MusicType;


public interface MusicTypeService extends IService<MusicType> {


    boolean save(MusicType musicType);

    boolean modify(MusicType musicType);

    boolean delete(Integer id);

    IPage<MusicType> getPage(int currentPage, int pageSize);

    IPage<MusicType> getPage(int currentPage, int pageSize, MusicType musicType);


}
