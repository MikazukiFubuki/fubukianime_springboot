package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.CvCVDao;
import com.fubukianime.domain.AnimeMain;
import com.fubukianime.domain.CvCV;
import com.fubukianime.service.CvCVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvCVServiceImpl extends ServiceImpl<CvCVDao, CvCV> implements CvCVService {

    @Autowired
    private CvCVDao cvCVDao;


    @Override
    public List<CvCV> selectCVByCondition(CvCV cvCV) {
        List<CvCV> list = cvCVDao.selectCVByCondition(cvCV);
        return list;
    }

    @Override
    public List<CvCV> selectCVByConditionLive(CvCV cvCV) {
        List<CvCV> list = cvCVDao.selectCVByConditionLive(cvCV);
        return list;
    }

    @Override
    public List<CvCV> selectCVByConditionDead(CvCV cvCV) {
        List<CvCV> list = cvCVDao.selectCVByConditionDead(cvCV);
        return list;
    }

    @Override
    public List<CvCV> selectCVName(CvCV cvCV) {
        List<CvCV> list = cvCVDao.selectCVName(cvCV);
        return list;
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public CvCV selectCVById(Integer id) {
        return cvCVDao.selectCVById(id);
    }

    @Override
    public boolean addCV(CvCV cvCV) {
        cvCVDao.addCV(cvCV);
        return true;
    }

    @Override
    public boolean updateCV(CvCV cvCV) {
        cvCVDao.updateCV(cvCV);
        return true;
    }

    @Override
    public boolean updateCVdeath(CvCV cvCV) {
        cvCVDao.updateCVdeath(cvCV);
        return true;
    }

    @Override
    public boolean removeById(CvCV cvCV){
        Integer id = cvCV.getId();
        cvCVDao.deleteById(id);
        return true;
    }


}
