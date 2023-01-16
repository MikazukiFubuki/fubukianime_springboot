package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.GalGameBranchTypeDao;
import com.fubukianime.domain.GalGameBranchType;
import com.fubukianime.service.GalGameBranchTypeService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GalGameBranchTypeServiceImpl extends ServiceImpl<GalGameBranchTypeDao, GalGameBranchType> implements GalGameBranchTypeService {

    @Autowired
    private GalGameBranchTypeDao galGameBranchTypeDao;

    @Override
    public boolean save(GalGameBranchType galGameBranchType) {
        return galGameBranchTypeDao.insert(galGameBranchType) > 0;
    }

    @Override
    public boolean modify(GalGameBranchType galGameBranchType) {
        return galGameBranchTypeDao.updateById(galGameBranchType) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return galGameBranchTypeDao.deleteById(id) > 0;
    }

    @Override
    public IPage<GalGameBranchType> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        galGameBranchTypeDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<GalGameBranchType> getPage(int currentPage, int pageSize, GalGameBranchType galGameBranchType) {
        LambdaQueryWrapper<GalGameBranchType> lqw = new LambdaQueryWrapper<GalGameBranchType>();
        lqw.like(Strings.isNotEmpty(galGameBranchType.getBranchType()), GalGameBranchType::getBranchType, galGameBranchType.getBranchType());
        IPage page = new Page(currentPage,pageSize);
        galGameBranchTypeDao.selectPage(page,lqw);
        return page;
    }


}
