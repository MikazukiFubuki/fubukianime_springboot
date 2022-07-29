package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.AnimeLoveDao;
import com.fubukianime.dao.AnimeSexLimitDao;
import com.fubukianime.domain.AnimeLove;
import com.fubukianime.domain.AnimeSexLimit;
import com.fubukianime.service.AnimeLoveService;
import com.fubukianime.service.AnimeSexLimitService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnimeSexLimitServiceImpl extends ServiceImpl<AnimeSexLimitDao, AnimeSexLimit> implements AnimeSexLimitService {

    @Autowired
    private AnimeSexLimitDao animeSexLimitDao;

    @Override
    public boolean save(AnimeSexLimit animeSexLimit) {
        return animeSexLimitDao.insert(animeSexLimit) > 0;
    }

    @Override
    public boolean modify(AnimeSexLimit animeSexLimit) {
        return animeSexLimitDao.updateById(animeSexLimit) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return animeSexLimitDao.deleteById(id) > 0;
    }

    @Override
    public IPage<AnimeSexLimit> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        animeSexLimitDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<AnimeSexLimit> getPage(int currentPage, int pageSize, AnimeSexLimit animeSexLimit) {
        LambdaQueryWrapper<AnimeSexLimit> lqw = new LambdaQueryWrapper<AnimeSexLimit>();
        lqw.like(Strings.isNotEmpty(animeSexLimit.getSexLimit()), AnimeSexLimit::getSexLimit, animeSexLimit.getSexLimit());
        IPage page = new Page(currentPage,pageSize);
        animeSexLimitDao.selectPage(page,lqw);
        return page;
    }


}
