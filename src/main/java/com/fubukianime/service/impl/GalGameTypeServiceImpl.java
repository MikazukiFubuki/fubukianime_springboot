package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.AnimeTypeDao;
import com.fubukianime.dao.GalGameTypeDao;
import com.fubukianime.domain.AnimeType;
import com.fubukianime.domain.GalGameType;
import com.fubukianime.service.AnimeTypeService;
import com.fubukianime.service.GalGameTypeService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GalGameTypeServiceImpl extends ServiceImpl<GalGameTypeDao, GalGameType> implements GalGameTypeService {

    @Autowired
    private GalGameTypeDao galGameTypeDao;

    @Override
    public boolean save(GalGameType galGameType) {
        return galGameTypeDao.insert(galGameType) > 0;
    }

    @Override
    public boolean modify(GalGameType galGameType) {
        return galGameTypeDao.updateById(galGameType) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return galGameTypeDao.deleteById(id) > 0;
    }

    @Override
    public IPage<GalGameType> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        galGameTypeDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<GalGameType> getPage(int currentPage, int pageSize, GalGameType galGameType) {
        LambdaQueryWrapper<GalGameType> lqw = new LambdaQueryWrapper<GalGameType>();
        lqw.like(Strings.isNotEmpty(galGameType.getType()), GalGameType::getType, galGameType.getType());
        IPage page = new Page(currentPage,pageSize);
        galGameTypeDao.selectPage(page,lqw);
        return page;
    }


}
