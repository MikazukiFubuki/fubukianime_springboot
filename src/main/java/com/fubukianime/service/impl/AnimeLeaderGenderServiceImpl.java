package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.AnimeLeaderGenderDao;
import com.fubukianime.dao.AnimeSexLimitDao;
import com.fubukianime.domain.AnimeLeaderGender;
import com.fubukianime.domain.AnimeSexLimit;
import com.fubukianime.service.AnimeLeaderGenderService;
import com.fubukianime.service.AnimeSexLimitService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnimeLeaderGenderServiceImpl extends ServiceImpl<AnimeLeaderGenderDao, AnimeLeaderGender> implements AnimeLeaderGenderService {

    @Autowired
    private AnimeLeaderGenderDao animeLeaderGenderDao;

    @Override
    public boolean save(AnimeLeaderGender animeLeaderGender) {
        return animeLeaderGenderDao.insert(animeLeaderGender) > 0;
    }

    @Override
    public boolean modify(AnimeLeaderGender animeLeaderGender) {
        return animeLeaderGenderDao.updateById(animeLeaderGender) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return animeLeaderGenderDao.deleteById(id) > 0;
    }

    @Override
    public IPage<AnimeLeaderGender> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        animeLeaderGenderDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<AnimeLeaderGender> getPage(int currentPage, int pageSize, AnimeLeaderGender animeLeaderGender) {
        LambdaQueryWrapper<AnimeLeaderGender> lqw = new LambdaQueryWrapper<AnimeLeaderGender>();
        lqw.like(Strings.isNotEmpty(animeLeaderGender.getLeaderGender()), AnimeLeaderGender::getLeaderGender, animeLeaderGender.getLeaderGender());
        IPage page = new Page(currentPage,pageSize);
        animeLeaderGenderDao.selectPage(page,lqw);
        return page;
    }


}
