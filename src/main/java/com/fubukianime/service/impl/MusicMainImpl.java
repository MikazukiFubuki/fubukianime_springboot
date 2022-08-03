package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.CvWorksDao;
import com.fubukianime.dao.MusicMainDao;
import com.fubukianime.domain.CvWorks;
import com.fubukianime.domain.MusicMain;
import com.fubukianime.service.CvWorksService;
import com.fubukianime.service.MusicMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicMainImpl extends ServiceImpl<MusicMainDao, MusicMain> implements MusicMainService {

    @Autowired
    private MusicMainDao musicMainDao;

    @Override
    public List<MusicMain> selectMusicMain(MusicMain musicMain) {
        List<MusicMain> list = musicMainDao.selectMusicMain(musicMain);
        return list;
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public MusicMain selectMusicMainById(Integer id) {
        return musicMainDao.selectMusicMainById(id);
    }

    @Override
    public boolean addMusicMain(MusicMain musicMain) {
        musicMainDao.addMusicMain(musicMain);
        return true;
    }

    @Override
    public boolean updateMusicMain(MusicMain musicMain) {
        musicMainDao.updateMusicMain(musicMain);
        return true;
    }

    @Override
    public boolean removeById(MusicMain musicMain) {
        Integer id = musicMain.getId();
        musicMainDao.deleteById(id);
        return true;
    }
}
