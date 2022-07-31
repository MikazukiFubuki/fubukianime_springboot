package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.AnimeEditionDao;
import com.fubukianime.domain.AnimeEdition;
import com.fubukianime.service.AnimeEditionService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AnimeEditionServiceImpl extends ServiceImpl<AnimeEditionDao, AnimeEdition> implements AnimeEditionService {

    @Autowired
    private AnimeEditionDao animeEditionDao;


    @Override
    public boolean addLargeEdition(AnimeEdition animeEdition) {
        animeEditionDao.addLargeEdition(animeEdition);
        return true;
    }

    @Override
    public boolean addMinorEdition(AnimeEdition animeEdition) {
        animeEditionDao.addMinorEdition(animeEdition);
        return true;
    }

    @Override
    public List<AnimeEdition> selectEdition(AnimeEdition animeEdition) {
        List<AnimeEdition> list = animeEditionDao.selectEdition(animeEdition);
        return list;
    }
}
