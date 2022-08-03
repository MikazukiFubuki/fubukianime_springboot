package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.MusicEditionDao;
import com.fubukianime.domain.MusicEdition;
import com.fubukianime.service.MusicEditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MusicEditionServiceImpl extends ServiceImpl<MusicEditionDao, MusicEdition> implements MusicEditionService {

    @Autowired
    private MusicEditionDao musicEditionDao;


    @Override
    public boolean addLargeEdition(MusicEdition musicEdition) {
        musicEditionDao.addLargeEdition(musicEdition);
        return true;
    }

    @Override
    public boolean addMinorEdition(MusicEdition musicEdition) {
        musicEditionDao.addMinorEdition(musicEdition);
        return true;
    }

    @Override
    public List<MusicEdition> selectEdition(MusicEdition musicEdition) {
        List<MusicEdition> list = musicEditionDao.selectEdition(musicEdition);
        return list;
    }
}
