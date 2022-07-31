package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.AnimeMerchDao;
import com.fubukianime.domain.AnimeMerch;
import com.fubukianime.service.AnimeMerchService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnimeMerchServiceImpl extends ServiceImpl<AnimeMerchDao, AnimeMerch> implements AnimeMerchService {

    @Autowired
    private AnimeMerchDao animeMerchDao;

    @Override
    public boolean save(AnimeMerch AnimeMerch) {
        return animeMerchDao.insert(AnimeMerch) > 0;
    }

    @Override
    public boolean modify(AnimeMerch AnimeMerch) {
        return animeMerchDao.updateById(AnimeMerch) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return animeMerchDao.deleteById(id) > 0;
    }

    @Override
    public IPage<AnimeMerch> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        animeMerchDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<AnimeMerch> getPage(int currentPage, int pageSize, AnimeMerch animeMerch) {
        LambdaQueryWrapper<AnimeMerch> lqw = new LambdaQueryWrapper<AnimeMerch>();
        lqw.like(Strings.isNotEmpty(animeMerch.getAnimeName()), AnimeMerch::getAnimeName, animeMerch.getAnimeName());
        lqw.like(Strings.isNotEmpty(animeMerch.getMerch()), AnimeMerch::getMerch, animeMerch.getMerch());
        lqw.like(Strings.isNotEmpty(animeMerch.getStatus()), AnimeMerch::getStatus, animeMerch.getStatus());
        IPage page = new Page(currentPage,pageSize);
        animeMerchDao.selectPage(page,lqw);
        return page;
    }


}
