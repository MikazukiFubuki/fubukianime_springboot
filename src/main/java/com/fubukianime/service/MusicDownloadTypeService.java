package com.fubukianime.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.MusicDownloadType;
import com.fubukianime.domain.MusicType;


public interface MusicDownloadTypeService extends IService<MusicDownloadType> {


    boolean save(MusicDownloadType musicDownloadType);

    boolean modify(MusicDownloadType musicDownloadType);

    boolean delete(Integer id);

    IPage<MusicDownloadType> getPage(int currentPage, int pageSize);

    IPage<MusicDownloadType> getPage(int currentPage, int pageSize, MusicDownloadType musicDownloadType);


}
