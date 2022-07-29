package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.AnimeStatusDao;
import com.fubukianime.domain.AnimeStatus;
import com.fubukianime.service.AnimeStatusService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnimeStatusServiceImpl extends ServiceImpl<AnimeStatusDao, AnimeStatus> implements AnimeStatusService {

    @Autowired
    private AnimeStatusDao animeStatusDao;

    @Override
    public boolean save(AnimeStatus animeStatus) {
        return animeStatusDao.insert(animeStatus) > 0;
    }

    @Override
    public boolean modify(AnimeStatus animeStatus) {
        return animeStatusDao.updateById(animeStatus) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return animeStatusDao.deleteById(id) > 0;
    }

    @Override
    public IPage<AnimeStatus> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        animeStatusDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<AnimeStatus> getPage(int currentPage, int pageSize, AnimeStatus animeStatus) {
        LambdaQueryWrapper<AnimeStatus> lqw = new LambdaQueryWrapper<AnimeStatus>();
        lqw.like(Strings.isNotEmpty(animeStatus.getStatus()), AnimeStatus::getStatus, animeStatus.getStatus());
        IPage page = new Page(currentPage,pageSize);
        animeStatusDao.selectPage(page,lqw);
        return page;
    }


}
