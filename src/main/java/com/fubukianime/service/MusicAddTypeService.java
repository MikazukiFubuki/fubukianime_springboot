package com.fubukianime.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.MusicAddType;
import com.fubukianime.domain.MusicDownloadType;


public interface MusicAddTypeService extends IService<MusicAddType> {


    boolean save(MusicAddType musicAddType);

    boolean modify(MusicAddType musicAddType);

    boolean delete(Integer id);

    IPage<MusicAddType> getPage(int currentPage, int pageSize);

    IPage<MusicAddType> getPage(int currentPage, int pageSize, MusicAddType musicAddType);


}
