package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.AnimeLayoutTypeDao;
import com.fubukianime.domain.AnimeLayoutType;
import com.fubukianime.service.AnimeLayoutTypeService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnimeLayoutTypeServiceImpl extends ServiceImpl<AnimeLayoutTypeDao, AnimeLayoutType> implements AnimeLayoutTypeService {

    @Autowired
    private AnimeLayoutTypeDao animeLayoutTypeDao;

    @Override
    public boolean save(AnimeLayoutType animeLayoutType) {
        return animeLayoutTypeDao.insert(animeLayoutType) > 0;
    }

    @Override
    public boolean modify(AnimeLayoutType animeLayoutType) {
        return animeLayoutTypeDao.updateById(animeLayoutType) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return animeLayoutTypeDao.deleteById(id) > 0;
    }

    @Override
    public IPage<AnimeLayoutType> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        animeLayoutTypeDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<AnimeLayoutType> getPage(int currentPage, int pageSize, AnimeLayoutType animeLayoutType) {
        LambdaQueryWrapper<AnimeLayoutType> lqw = new LambdaQueryWrapper<AnimeLayoutType>();
        lqw.like(Strings.isNotEmpty(animeLayoutType.getLayoutType()), AnimeLayoutType::getLayoutType, animeLayoutType.getLayoutType());
        IPage page = new Page(currentPage,pageSize);
        animeLayoutTypeDao.selectPage(page,lqw);
        return page;
    }


}
