package com.fubukianime.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.AnimeBingeWatchingType;
import com.fubukianime.domain.AnimeLeaderGender;


public interface AnimeBingeWatchingTypeService extends IService<AnimeBingeWatchingType> {


    boolean save(AnimeBingeWatchingType animeBingeWatchingType);

    boolean modify(AnimeBingeWatchingType animeBingeWatchingType);

    boolean delete(Integer id);

    IPage<AnimeBingeWatchingType> getPage(int currentPage, int pageSize);

    IPage<AnimeBingeWatchingType> getPage(int currentPage, int pageSize, AnimeBingeWatchingType animeBingeWatchingType);


}
