package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.AnimeSourceDao;
import com.fubukianime.domain.AnimeSource;
import com.fubukianime.service.AnimeSourceService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnimeSourceServiceImpl extends ServiceImpl<AnimeSourceDao, AnimeSource> implements AnimeSourceService {

    @Autowired
    private AnimeSourceDao AnimeSourceDao;

    @Override
    public boolean save(AnimeSource animeSource) {
        return AnimeSourceDao.insert(animeSource) > 0;
    }

    @Override
    public boolean modify(AnimeSource animeSource) {
        return AnimeSourceDao.updateById(animeSource) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return AnimeSourceDao.deleteById(id) > 0;
    }

    @Override
    public IPage<AnimeSource> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        AnimeSourceDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<AnimeSource> getPage(int currentPage, int pageSize, AnimeSource animeSource) {
        LambdaQueryWrapper<AnimeSource> lqw = new LambdaQueryWrapper<AnimeSource>();
        lqw.like(Strings.isNotEmpty(animeSource.getSource()), AnimeSource::getSource, animeSource.getSource());
        lqw.like(Strings.isNotEmpty(animeSource.getDebut()), AnimeSource::getDebut, animeSource.getDebut());
        IPage page = new Page(currentPage,pageSize);
        AnimeSourceDao.selectPage(page,lqw);
        return page;
    }


}
