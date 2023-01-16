package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.GalGameLoveTypeDao;
import com.fubukianime.domain.GalGameLoveType;
import com.fubukianime.service.GalGameLoveTypeService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GalGameLoveTypeServiceImpl extends ServiceImpl<GalGameLoveTypeDao, GalGameLoveType> implements GalGameLoveTypeService {

    @Autowired
    private GalGameLoveTypeDao galGameLoveTypeDao;

    @Override
    public boolean save(GalGameLoveType galGameLoveType) {
        return galGameLoveTypeDao.insert(galGameLoveType) > 0;
    }

    @Override
    public boolean modify(GalGameLoveType galGameLoveType) {
        return galGameLoveTypeDao.updateById(galGameLoveType) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return galGameLoveTypeDao.deleteById(id) > 0;
    }

    @Override
    public IPage<GalGameLoveType> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        galGameLoveTypeDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<GalGameLoveType> getPage(int currentPage, int pageSize, GalGameLoveType galGameLoveType) {
        LambdaQueryWrapper<GalGameLoveType> lqw = new LambdaQueryWrapper<GalGameLoveType>();
        lqw.like(Strings.isNotEmpty(galGameLoveType.getLoveType()), GalGameLoveType::getLoveType, galGameLoveType.getLoveType());
        IPage page = new Page(currentPage,pageSize);
        galGameLoveTypeDao.selectPage(page,lqw);
        return page;
    }


}
