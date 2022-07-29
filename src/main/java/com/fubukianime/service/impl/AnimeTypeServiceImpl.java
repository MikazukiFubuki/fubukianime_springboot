package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.AnimeTypeDao;
import com.fubukianime.domain.AnimeType;
import com.fubukianime.service.AnimeTypeService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnimeTypeServiceImpl extends ServiceImpl<AnimeTypeDao, AnimeType> implements AnimeTypeService {

    @Autowired
    private AnimeTypeDao animeTypeDao;

    @Override
    public boolean save(AnimeType animeType) {
        return animeTypeDao.insert(animeType) > 0;
    }

    @Override
    public boolean modify(AnimeType animeType) {
        return animeTypeDao.updateById(animeType) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return animeTypeDao.deleteById(id) > 0;
    }

    @Override
    public IPage<AnimeType> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        animeTypeDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<AnimeType> getPage(int currentPage, int pageSize, AnimeType animeType) {
        LambdaQueryWrapper<AnimeType> lqw = new LambdaQueryWrapper<AnimeType>();
        lqw.like(Strings.isNotEmpty(animeType.getType()), AnimeType::getType, animeType.getType());
        IPage page = new Page(currentPage,pageSize);
        animeTypeDao.selectPage(page,lqw);
        return page;
    }


}
