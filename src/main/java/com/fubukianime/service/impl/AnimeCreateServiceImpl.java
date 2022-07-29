package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.AnimeCreateDao;
import com.fubukianime.domain.AnimeCreate;
import com.fubukianime.service.AnimeCreateService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnimeCreateServiceImpl extends ServiceImpl<AnimeCreateDao, AnimeCreate> implements AnimeCreateService {

    @Autowired
    private AnimeCreateDao animeCreateDao;

    @Override
    public boolean save(AnimeCreate animeCreate) {
        return animeCreateDao.insert(animeCreate) > 0;
    }

    @Override
    public boolean modify(AnimeCreate animeCreate) {
        return animeCreateDao.updateById(animeCreate) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return animeCreateDao.deleteById(id) > 0;
    }

    @Override
    public IPage<AnimeCreate> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        animeCreateDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<AnimeCreate> getPage(int currentPage, int pageSize, AnimeCreate animeCreate) {
        LambdaQueryWrapper<AnimeCreate> lqw = new LambdaQueryWrapper<AnimeCreate>();
        lqw.like(Strings.isNotEmpty(animeCreate.getCreate()), AnimeCreate::getCreate, animeCreate.getCreate());
        lqw.like(Strings.isNotEmpty(animeCreate.getDescription()), AnimeCreate::getDescription, animeCreate.getDescription());
        IPage page = new Page(currentPage,pageSize);
        animeCreateDao.selectPage(page,lqw);
        return page;
    }


}
