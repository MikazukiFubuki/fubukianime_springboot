package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.CvWorksDao;
import com.fubukianime.dao.HAnimeMainDao;
import com.fubukianime.domain.AnimeLayout;
import com.fubukianime.domain.CvWorks;
import com.fubukianime.domain.HAnimeMain;
import com.fubukianime.service.CvWorksService;
import com.fubukianime.service.HAnimeMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HAnimeMainServiceImpl extends ServiceImpl<HAnimeMainDao, HAnimeMain> implements HAnimeMainService {

    @Autowired
    private HAnimeMainDao hAnimeMainDao;


    @Override
    public HAnimeMain selectMainById(Integer id) {
        return hAnimeMainDao.selectMainById(id);
    }

    @Override
    public List<HAnimeMain> selectMainByCondition(HAnimeMain hAnimeMain) {
        List<HAnimeMain> list = hAnimeMainDao.selectMainByCondition(hAnimeMain);
        return list;
    }

    @Override
    public boolean addHAnime(HAnimeMain hAnimeMain) {
        hAnimeMainDao.addHAnime(hAnimeMain);
        return true;
    }

    @Override
    public boolean updateHAnime(HAnimeMain hAnimeMain) {
        hAnimeMainDao.updateHAnime(hAnimeMain);
        return true;
    }

    /**
     * 对已追动画追更一集
     * @param hAnimeMain
     */
    @Override
    public boolean chasingAPlay(HAnimeMain hAnimeMain) {
        hAnimeMainDao.chasingAPlay(hAnimeMain);
        return true;
    }

    @Override
    public boolean removeById(HAnimeMain hAnimeMain) {
        Integer id = hAnimeMain.getId();
        hAnimeMainDao.deleteById(id);
        return true;
    }
}
