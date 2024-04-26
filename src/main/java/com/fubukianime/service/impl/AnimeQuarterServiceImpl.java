package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.AnimeQuarterDao;
import com.fubukianime.domain.AnimeQuarter;
import com.fubukianime.service.AnimeQuarterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AnimeQuarterServiceImpl extends ServiceImpl<AnimeQuarterDao, AnimeQuarter> implements AnimeQuarterService {

    @Autowired
    private AnimeQuarterDao animeQuarterDao;



    /**
     * 新增较季点
     * @param animeQuarter
     * @return
     */
    @Override
    public boolean addComQuarter(AnimeQuarter animeQuarter) {
        animeQuarterDao.addComQuarter(animeQuarter);
        return true;
    }

    /**
     * 查询较季
     * @param
     * @return
     */
    @Override
    public List<AnimeQuarter> selectComQuarter(AnimeQuarter animeQuarter) {
        List<AnimeQuarter> list = animeQuarterDao.selectComQuarter(animeQuarter);
        return list;
    }

    /**
     * 查询当季在看展示
     * @param
     * @return
     */
    @Override
    public List<AnimeQuarter> selectNowQuarter(AnimeQuarter animeQuarter) {
        List<AnimeQuarter> list = animeQuarterDao.selectNowQuarter(animeQuarter);
        return list;
    }




}
