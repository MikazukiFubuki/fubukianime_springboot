package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.AnimeBingeWatchingTypeDao;
import com.fubukianime.dao.AnimeLeaderGenderDao;
import com.fubukianime.domain.AnimeBingeWatchingType;
import com.fubukianime.domain.AnimeLeaderGender;
import com.fubukianime.service.AnimeBingeWatchingTypeService;
import com.fubukianime.service.AnimeLeaderGenderService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnimeBingeWatchingTypeServiceImpl extends ServiceImpl<AnimeBingeWatchingTypeDao, AnimeBingeWatchingType> implements AnimeBingeWatchingTypeService {

    @Autowired
    private AnimeBingeWatchingTypeDao animeBingeWatchingTypeDao;

    @Override
    public boolean save(AnimeBingeWatchingType animeBingeWatchingType) {
        return animeBingeWatchingTypeDao.insert(animeBingeWatchingType) > 0;
    }

    @Override
    public boolean modify(AnimeBingeWatchingType animeBingeWatchingType) {
        return animeBingeWatchingTypeDao.updateById(animeBingeWatchingType) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return animeBingeWatchingTypeDao.deleteById(id) > 0;
    }

    @Override
    public IPage<AnimeBingeWatchingType> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        animeBingeWatchingTypeDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<AnimeBingeWatchingType> getPage(int currentPage, int pageSize, AnimeBingeWatchingType animeBingeWatchingType) {
        LambdaQueryWrapper<AnimeBingeWatchingType> lqw = new LambdaQueryWrapper<AnimeBingeWatchingType>();
        lqw.like(Strings.isNotEmpty(animeBingeWatchingType.getBingeWatchingType()), AnimeBingeWatchingType::getBingeWatchingType, animeBingeWatchingType.getBingeWatchingType());
        IPage page = new Page(currentPage,pageSize);
        animeBingeWatchingTypeDao.selectPage(page,lqw);
        return page;
    }


}
