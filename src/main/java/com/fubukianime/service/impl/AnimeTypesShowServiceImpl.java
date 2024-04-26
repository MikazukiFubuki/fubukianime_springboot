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

    @Override
    public List<AnimeTypesShow> selectLayoutTypeShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowDao.selectLayoutTypeShow(animeTypesShow);
        return list;
    }

    @Override
    public List<AnimeTypesShow> selectBingeWatchingTypeShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowDao.selectBingeWatchingTypeShow(animeTypesShow);
        return list;
    }

    @Override
    public List<AnimeTypesShow> selectStatusShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowDao.selectStatusShow(animeTypesShow);
        return list;
    }

    @Override
    public List<AnimeTypesShow> selectStatusShow2(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowDao.selectStatusShow2(animeTypesShow);
        return list;
    }

    @Override
    public List<AnimeTypesShow> selectMusicTypeShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowDao.selectMusicTypeShow(animeTypesShow);
        return list;
    }

    @Override
    public List<AnimeTypesShow> selectScoreShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowDao.selectScoreShow(animeTypesShow);
        return list;
    }

    @Override
    public List<AnimeTypesShow> selectHAnimeTypeShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowDao.selectHAnimeTypeShow(animeTypesShow);
        return list;
    }

    @Override
    public List<AnimeTypesShow> selectDimensionalShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowDao.selectDimensionalShow(animeTypesShow);
        return list;
    }


}
