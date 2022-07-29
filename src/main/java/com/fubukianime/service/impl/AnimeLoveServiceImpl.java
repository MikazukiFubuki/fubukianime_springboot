package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.AnimeCreateDao;
import com.fubukianime.dao.AnimeLoveDao;
import com.fubukianime.domain.AnimeCreate;
import com.fubukianime.domain.AnimeLove;
import com.fubukianime.service.AnimeCreateService;
import com.fubukianime.service.AnimeLoveService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnimeLoveServiceImpl extends ServiceImpl<AnimeLoveDao, AnimeLove> implements AnimeLoveService {

    @Autowired
    private AnimeLoveDao animeLoveDao;

    @Override
    public boolean save(AnimeLove animeLove) {
        return animeLoveDao.insert(animeLove) > 0;
    }

    @Override
    public boolean modify(AnimeLove animeLove) {
        return animeLoveDao.updateById(animeLove) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return animeLoveDao.deleteById(id) > 0;
    }

    @Override
    public IPage<AnimeLove> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        animeLoveDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<AnimeLove> getPage(int currentPage, int pageSize, AnimeLove animeLove) {
        LambdaQueryWrapper<AnimeLove> lqw = new LambdaQueryWrapper<AnimeLove>();
        lqw.like(Strings.isNotEmpty(animeLove.getLove()), AnimeLove::getLove, animeLove.getLove());
        IPage page = new Page(currentPage,pageSize);
        animeLoveDao.selectPage(page,lqw);
        return page;
    }


}
