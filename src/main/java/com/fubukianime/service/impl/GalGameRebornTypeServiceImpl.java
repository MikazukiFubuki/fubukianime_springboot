package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.GalGameRebornTypeDao;
import com.fubukianime.domain.GalGameRebornType;
import com.fubukianime.service.GalGameRebornTypeService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GalGameRebornTypeServiceImpl extends ServiceImpl<GalGameRebornTypeDao, GalGameRebornType> implements GalGameRebornTypeService {

    @Autowired
    private GalGameRebornTypeDao galGameRebornTypeDao;

    @Override
    public boolean save(GalGameRebornType galGameRebornType) {
        return galGameRebornTypeDao.insert(galGameRebornType) > 0;
    }

    @Override
    public boolean modify(GalGameRebornType galGameRebornType) {
        return galGameRebornTypeDao.updateById(galGameRebornType) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return galGameRebornTypeDao.deleteById(id) > 0;
    }

    @Override
    public IPage<GalGameRebornType> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        galGameRebornTypeDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<GalGameRebornType> getPage(int currentPage, int pageSize, GalGameRebornType galGameRebornType) {
        LambdaQueryWrapper<GalGameRebornType> lqw = new LambdaQueryWrapper<GalGameRebornType>();
        lqw.like(Strings.isNotEmpty(galGameRebornType.getRebornType()), GalGameRebornType::getRebornType, galGameRebornType.getRebornType());
        IPage page = new Page(currentPage,pageSize);
        galGameRebornTypeDao.selectPage(page,lqw);
        return page;
    }


}
