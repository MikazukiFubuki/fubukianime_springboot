package com.fubukianime.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.GalGameSpType;


public interface GalGameSpTypeService extends IService<GalGameSpType> {


    boolean save(GalGameSpType galGameSpType);

    boolean modify(GalGameSpType galGameSpType);

    boolean delete(Integer id);

    IPage<GalGameSpType> getPage(int currentPage, int pageSize);

    IPage<GalGameSpType> getPage(int currentPage, int pageSize, GalGameSpType galGameSpType);


}
