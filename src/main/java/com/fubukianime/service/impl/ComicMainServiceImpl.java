package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.ComicMainDao;
import com.fubukianime.domain.ComicMain;
import com.fubukianime.service.ComicMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComicMainServiceImpl extends ServiceImpl<ComicMainDao, ComicMain> implements ComicMainService {

    @Autowired
    private ComicMainDao comicMainDao;


    @Override
    public ComicMain selectMainById(Integer id) {
        return comicMainDao.selectMainById(id);
    }

    @Override
    public List<ComicMain> selectMainByCondition(ComicMain comicMain) {
        List<ComicMain> list = comicMainDao.selectMainByCondition(comicMain);
        return list;
    }

    @Override
    public boolean addComic(ComicMain comicMain) {
        comicMainDao.addComic(comicMain);
        return true;
    }

    @Override
    public boolean updateComic(ComicMain comicMain) {
        comicMainDao.updateComic(comicMain);
        return true;
    }

    /**
     * 对已追动画追更一集
     * @param comicMain
     */
    @Override
    public boolean chasingAPlay(ComicMain comicMain) {
        comicMainDao.chasingAPlay(comicMain);
        return true;
    }

    @Override
    public boolean removeById(ComicMain comicMain) {
        Integer id = comicMain.getId();
        comicMainDao.deleteById(id);
        return true;
    }
}
