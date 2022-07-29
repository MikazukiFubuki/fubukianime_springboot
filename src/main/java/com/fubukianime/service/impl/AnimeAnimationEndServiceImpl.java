package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.AnimeAnimationEndDao;
import com.fubukianime.dao.AnimeSexLimitDao;
import com.fubukianime.domain.AnimeAnimationEnd;
import com.fubukianime.domain.AnimeSexLimit;
import com.fubukianime.service.AnimeAnimationEndService;
import com.fubukianime.service.AnimeSexLimitService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnimeAnimationEndServiceImpl extends ServiceImpl<AnimeAnimationEndDao, AnimeAnimationEnd> implements AnimeAnimationEndService {

    @Autowired
    private AnimeAnimationEndDao animeAnimationEndDao;

    @Override
    public boolean save(AnimeAnimationEnd animeAnimationEnd) {
        return animeAnimationEndDao.insert(animeAnimationEnd) > 0;
    }

    @Override
    public boolean modify(AnimeAnimationEnd animeAnimationEnd) {
        return animeAnimationEndDao.updateById(animeAnimationEnd) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return animeAnimationEndDao.deleteById(id) > 0;
    }

    @Override
    public IPage<AnimeAnimationEnd> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        animeAnimationEndDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<AnimeAnimationEnd> getPage(int currentPage, int pageSize, AnimeAnimationEnd animeAnimationEnd) {
        LambdaQueryWrapper<AnimeAnimationEnd> lqw = new LambdaQueryWrapper<AnimeAnimationEnd>();
        lqw.like(Strings.isNotEmpty(animeAnimationEnd.getAnimationEnd()), AnimeAnimationEnd::getAnimationEnd, animeAnimationEnd.getAnimationEnd());
        IPage page = new Page(currentPage,pageSize);
        animeAnimationEndDao.selectPage(page,lqw);
        return page;
    }


}
