package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.GalGameEnvironmentTypeDao;
import com.fubukianime.domain.GalGameEnvironmentType;
import com.fubukianime.service.GalGameEnvironmentTypeService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GalGameEnvironmentTypeServiceImpl extends ServiceImpl<GalGameEnvironmentTypeDao, GalGameEnvironmentType> implements GalGameEnvironmentTypeService {

    @Autowired
    private GalGameEnvironmentTypeDao galGameEnvironmentTypeDao;

    @Override
    public boolean save(GalGameEnvironmentType galGameEnvironmentType) {
        return galGameEnvironmentTypeDao.insert(galGameEnvironmentType) > 0;
    }

    @Override
    public boolean modify(GalGameEnvironmentType galGameEnvironmentType) {
        return galGameEnvironmentTypeDao.updateById(galGameEnvironmentType) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return galGameEnvironmentTypeDao.deleteById(id) > 0;
    }

    @Override
    public IPage<GalGameEnvironmentType> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        galGameEnvironmentTypeDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<GalGameEnvironmentType> getPage(int currentPage, int pageSize, GalGameEnvironmentType galGameEnvironmentType) {
        LambdaQueryWrapper<GalGameEnvironmentType> lqw = new LambdaQueryWrapper<GalGameEnvironmentType>();
        lqw.like(Strings.isNotEmpty(galGameEnvironmentType.getEnvironmentType()), GalGameEnvironmentType::getEnvironmentType, galGameEnvironmentType.getEnvironmentType());
        IPage page = new Page(currentPage,pageSize);
        galGameEnvironmentTypeDao.selectPage(page,lqw);
        return page;
    }


}
