package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.AnimeAnimationEndDao;
import com.fubukianime.dao.AnimeOriginalEndDao;
import com.fubukianime.domain.AnimeAnimationEnd;
import com.fubukianime.domain.AnimeOriginalEnd;
import com.fubukianime.service.AnimeAnimationEndService;
import com.fubukianime.service.AnimeOriginalEndService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnimeOriginalEndServiceImpl extends ServiceImpl<AnimeOriginalEndDao, AnimeOriginalEnd> implements AnimeOriginalEndService {

    @Autowired
    private AnimeOriginalEndDao animeOriginalEndDao;

    @Override
    public boolean save(AnimeOriginalEnd animeOriginalEnd) {
        return animeOriginalEndDao.insert(animeOriginalEnd) > 0;
    }

    @Override
    public boolean modify(AnimeOriginalEnd animeOriginalEnd) {
        return animeOriginalEndDao.updateById(animeOriginalEnd) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return animeOriginalEndDao.deleteById(id) > 0;
    }

    @Override
    public IPage<AnimeOriginalEnd> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        animeOriginalEndDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<AnimeOriginalEnd> getPage(int currentPage, int pageSize, AnimeOriginalEnd animeOriginalEnd) {
        LambdaQueryWrapper<AnimeOriginalEnd> lqw = new LambdaQueryWrapper<AnimeOriginalEnd>();
        lqw.like(Strings.isNotEmpty(animeOriginalEnd.getOriginalEnd()), AnimeOriginalEnd::getOriginalEnd, animeOriginalEnd.getOriginalEnd());
        IPage page = new Page(currentPage,pageSize);
        animeOriginalEndDao.selectPage(page,lqw);
        return page;
    }


}
