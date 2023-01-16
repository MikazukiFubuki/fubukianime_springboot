package com.fubukianime.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.GalGameBranchType;


public interface GalGameBranchTypeService extends IService<GalGameBranchType> {


    boolean save(GalGameBranchType galGameBranchType);

    boolean modify(GalGameBranchType galGameBranchType);

    boolean delete(Integer id);

    IPage<GalGameBranchType> getPage(int currentPage, int pageSize);

    IPage<GalGameBranchType> getPage(int currentPage, int pageSize, GalGameBranchType galGameBranchType);


}
