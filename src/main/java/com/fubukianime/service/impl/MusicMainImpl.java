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
    public boolean Listened(MusicMain musicMain) {
        musicMainDao.Listened(musicMain);
        return true;
    }

    @Override
    public boolean removeById(MusicMain musicMain) {
        //获取要删除音乐的id和形式id
        Integer deleteId = musicMain.getId();
        //逻辑删除音乐，即修改音乐表和对应形式表中deleted=1
        musicMainDao.deleteById(deleteId);
        //获取要删除音乐编号
        Integer deletedMId = musicMain.getMid();
        //获取当前最大追补重番id
        Integer maxMId = musicMainDao.selectMaxMId();

        Integer i;
        Integer j;

        //循环修改删除音乐后续编号-1，直到音乐编号最大值修改完
        for(i = deletedMId + 1;  i<=maxMId; i++){
            //根据i值获取对应id
            musicMain.setMid(i);
            j = musicMainDao.selectIdByMID(musicMain);
            //更改对应id
            musicMain.setId(j);
            //根据id将编号修改为i值-1
            musicMain.setMid(i-1);
            musicMainDao.updateMIDBYId(musicMain);
        }

        return true;
    }
}
