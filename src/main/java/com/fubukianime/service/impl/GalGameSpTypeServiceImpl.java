package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.GalGameSpTypeDao;
import com.fubukianime.domain.GalGameSpType;
import com.fubukianime.service.GalGameSpTypeService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GalGameSpTypeServiceImpl extends ServiceImpl<GalGameSpTypeDao, GalGameSpType> implements GalGameSpTypeService {

    @Autowired
    private GalGameSpTypeDao galGameSpTypeDao;

    @Override
    public boolean save(GalGameSpType galGameSpType) {
        return galGameSpTypeDao.insert(galGameSpType) > 0;
    }

    @Override
    public boolean modify(GalGameSpType galGameSpType) {
        return galGameSpTypeDao.updateById(galGameSpType) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return galGameSpTypeDao.deleteById(id) > 0;
    }

    @Override
    public IPage<GalGameSpType> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        galGameSpTypeDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<GalGameSpType> getPage(int currentPage, int pageSize, GalGameSpType galGameSpType) {
        LambdaQueryWrapper<GalGameSpType> lqw = new LambdaQueryWrapper<GalGameSpType>();
        lqw.like(Strings.isNotEmpty(galGameSpType.getSpType()), GalGameSpType::getSpType, galGameSpType.getSpType());
        IPage page = new Page(currentPage,pageSize);
        galGameSpTypeDao.selectPage(page,lqw);
        return page;
    }


}
