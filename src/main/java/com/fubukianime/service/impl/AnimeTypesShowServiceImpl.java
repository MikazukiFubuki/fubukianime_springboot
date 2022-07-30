package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.AnimeTypesShowDao;
import com.fubukianime.domain.AnimeTypesShow;
import com.fubukianime.service.AnimeTypesShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AnimeTypesShowServiceImpl extends ServiceImpl<AnimeTypesShowDao, AnimeTypesShow> implements AnimeTypesShowService {

    @Autowired
    private AnimeTypesShowDao animeTypesShowDao;

    @Override
    public List<AnimeTypesShow> selectSourceShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowDao.selectSourceShow(animeTypesShow);
        return list;
    }

    @Override
    public List<AnimeTypesShow> selectTypeShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowDao.selectTypeShow(animeTypesShow);
        return list;
    }

    @Override
    public List<AnimeTypesShow> selectLoveShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowDao.selectLoveShow(animeTypesShow);
        return list;
    }

    @Override
    public List<AnimeTypesShow> selectSexLimitShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowDao.selectSexLimitShow(animeTypesShow);
        return list;
    }

    @Override
    public List<AnimeTypesShow> selectCreateShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowDao.selectCreateShow(animeTypesShow);
        return list;
    }

    @Override
    public List<AnimeTypesShow> selectLeaderGenderShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowDao.selectLeaderGenderShow(animeTypesShow);
        return list;
    }

    @Override
    public List<AnimeTypesShow> selectAnimationEndShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowDao.selectAnimationEndShow(animeTypesShow);
        return list;
    }

    @Override
    public List<AnimeTypesShow> selectOriginalEndShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowDao.selectOriginalEndShow(animeTypesShow);
        return list;
    }
}
