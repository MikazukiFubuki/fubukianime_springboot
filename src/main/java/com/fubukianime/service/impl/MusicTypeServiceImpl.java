package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.AnimeTypeDao;
import com.fubukianime.dao.MusicTypeDao;
import com.fubukianime.domain.AnimeType;
import com.fubukianime.domain.MusicType;
import com.fubukianime.service.AnimeTypeService;
import com.fubukianime.service.MusicTypeService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MusicTypeServiceImpl extends ServiceImpl<MusicTypeDao, MusicType> implements MusicTypeService {

    @Autowired
    private MusicTypeDao musicTypeDao;

    @Override
    public boolean save(MusicType musicType) {
        return musicTypeDao.insert(musicType) > 0;
    }

    @Override
    public boolean modify(MusicType musicType) {
        return musicTypeDao.updateById(musicType) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return musicTypeDao.deleteById(id) > 0;
    }

    @Override
    public IPage<MusicType> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        musicTypeDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<MusicType> getPage(int currentPage, int pageSize, MusicType musicType) {
        LambdaQueryWrapper<MusicType> lqw = new LambdaQueryWrapper<MusicType>();
        lqw.like(Strings.isNotEmpty(musicType.getType()), MusicType::getType, musicType.getType());
        IPage page = new Page(currentPage,pageSize);
        musicTypeDao.selectPage(page,lqw);
        return page;
    }


}
