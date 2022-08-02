package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.HAnimeTypeDao;
import com.fubukianime.domain.HAnimeType;
import com.fubukianime.service.HAnimeTypeService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HAnimeTypeServiceImpl extends ServiceImpl<HAnimeTypeDao, HAnimeType> implements HAnimeTypeService {

    @Autowired
    private HAnimeTypeDao hAnimeTypeDao;

    @Override
    public boolean save(HAnimeType hAnimeType) {
        return hAnimeTypeDao.insert(hAnimeType) > 0;
    }

    @Override
    public boolean modify(HAnimeType hAnimeType) {
        return hAnimeTypeDao.updateById(hAnimeType) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return hAnimeTypeDao.deleteById(id) > 0;
    }

    @Override
    public IPage<HAnimeType> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        hAnimeTypeDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<HAnimeType> getPage(int currentPage, int pageSize, HAnimeType hAnimeType) {
        LambdaQueryWrapper<HAnimeType> lqw = new LambdaQueryWrapper<HAnimeType>();
        lqw.like(Strings.isNotEmpty(hAnimeType.getType()), HAnimeType::getType, hAnimeType.getType());
        IPage page = new Page(currentPage,pageSize);
        hAnimeTypeDao.selectPage(page,lqw);
        return page;
    }


}
