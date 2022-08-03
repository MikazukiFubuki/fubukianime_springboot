package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.MusicAddTypeDao;
import com.fubukianime.domain.MusicAddType;
import com.fubukianime.service.MusicAddTypeService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MusicAddTypeServiceImpl extends ServiceImpl<MusicAddTypeDao, MusicAddType> implements MusicAddTypeService {

    @Autowired
    private MusicAddTypeDao musicAddTypeDao;

    @Override
    public boolean save(MusicAddType musicAddType) {
        return musicAddTypeDao.insert(musicAddType) > 0;
    }

    @Override
    public boolean modify(MusicAddType musicAddType) {
        return musicAddTypeDao.updateById(musicAddType) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return musicAddTypeDao.deleteById(id) > 0;
    }

    @Override
    public IPage<MusicAddType> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        musicAddTypeDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<MusicAddType> getPage(int currentPage, int pageSize, MusicAddType musicAddType) {
        LambdaQueryWrapper<MusicAddType> lqw = new LambdaQueryWrapper<MusicAddType>();
        lqw.like(Strings.isNotEmpty(musicAddType.getAddType()), MusicAddType::getAddType, musicAddType.getAddType());
        IPage page = new Page(currentPage,pageSize);
        musicAddTypeDao.selectPage(page,lqw);
        return page;
    }


}
