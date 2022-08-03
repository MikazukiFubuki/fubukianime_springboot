package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.GalGameMainDao;
import com.fubukianime.domain.GalGameMain;
import com.fubukianime.service.GalGameMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GalGameMainImpl extends ServiceImpl<GalGameMainDao, GalGameMain> implements GalGameMainService {

    @Autowired
    private GalGameMainDao galGameMainDao;

    @Override
    public List<GalGameMain> selectGalGameMain(GalGameMain galGameMain) {
        List<GalGameMain> list = galGameMainDao.selectGalGameMain(galGameMain);
        return list;
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public GalGameMain selectGalGameMainById(Integer id) {
        return galGameMainDao.selectGalGameMainById(id);
    }

    @Override
    public boolean addGalGameMain(GalGameMain galGameMain) {
        galGameMainDao.addGalGameMain(galGameMain);
        return true;
    }

    @Override
    public boolean updateGalGameMain(GalGameMain galGameMain) {
        galGameMainDao.updateGalGameMain(galGameMain);
        return true;
    }

    @Override
    public boolean removeById(GalGameMain galGameMain) {
        Integer id = galGameMain.getId();
        galGameMainDao.deleteById(id);
        return true;
    }
}
