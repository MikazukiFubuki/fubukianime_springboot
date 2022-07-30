package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.AnimeShowDao;
import com.fubukianime.domain.AnimeShow;
import com.fubukianime.service.AnimeShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AnimeShowServiceImpl extends ServiceImpl<AnimeShowDao, AnimeShow> implements AnimeShowService {

    @Autowired
    private AnimeShowDao animeShowDao;

    /**
     * 查询信息
     * @param
     * @return
     */
    @Override
    public List<AnimeShow> selectAnimeShow(AnimeShow animeShow) {
        List<AnimeShow> list = animeShowDao.selectAnimeShow(animeShow);
        return list;
    }


}
