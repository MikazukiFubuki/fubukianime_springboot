package com.fubukianime.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.GalGameEnvironmentType;
import com.fubukianime.domain.GalGameType;


public interface GalGameEnvironmentTypeService extends IService<GalGameEnvironmentType> {


    boolean save(GalGameEnvironmentType galGameEnvironmentType);

    boolean modify(GalGameEnvironmentType galGameEnvironmentType);

    boolean delete(Integer id);

    IPage<GalGameEnvironmentType> getPage(int currentPage, int pageSize);

    IPage<GalGameEnvironmentType> getPage(int currentPage, int pageSize, GalGameEnvironmentType galGameEnvironmentType);


}
