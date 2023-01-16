package com.fubukianime.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.GalGameRebornType;


public interface GalGameRebornTypeService extends IService<GalGameRebornType> {


    boolean save(GalGameRebornType galGameRebornType);

    boolean modify(GalGameRebornType galGameRebornType);

    boolean delete(Integer id);

    IPage<GalGameRebornType> getPage(int currentPage, int pageSize);

    IPage<GalGameRebornType> getPage(int currentPage, int pageSize, GalGameRebornType galGameRebornType);


}
