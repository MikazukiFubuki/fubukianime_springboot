package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.CvWorksDao;
import com.fubukianime.domain.CvCV;
import com.fubukianime.domain.CvWorks;
import com.fubukianime.service.CvWorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvWorksImpl extends ServiceImpl<CvWorksDao, CvWorks> implements CvWorksService {

    @Autowired
    private CvWorksDao cvWorksDao;

    @Override
    public List<CvWorks> selectCvWorks(CvWorks cvWorks) {
        List<CvWorks> list = cvWorksDao.selectCvWorks(cvWorks);
        return list;
    }

    @Override
    public List<CvWorks> selectAfterAdd(CvWorks cvWorks) {
        List<CvWorks> list = cvWorksDao.selectAfterAdd(cvWorks);
        return list;
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public CvWorks selectCvWorksById(Integer id) {
        return cvWorksDao.selectCvWorksById(id);
    }

    /**
     * 新增角色前查验查询
     * @param cvWorks
     * @return
     */
    @Override
    public CvWorks checkCvWorks(CvWorks cvWorks) {
        return cvWorksDao.checkCvWorks(cvWorks);
    }

    @Override
    public boolean addCvWorks(CvWorks cvWorks) {
        cvWorksDao.addCvWorks(cvWorks);
        return true;
    }

    @Override
    public boolean updateYear(CvWorks cvWorks) {
        cvWorksDao.updateYear(cvWorks);
        return true;
    }

    @Override
    public boolean updateCvWorks(CvWorks cvWorks) {
        cvWorksDao.updateCvWorks(cvWorks);
        return true;
    }

    @Override
    public boolean updateRole(CvWorks cvWorks) {
        cvWorksDao.updateRole(cvWorks);
        return true;
    }

    @Override
    public boolean removeById(CvWorks cvWorks) {
        Integer id = cvWorks.getId();
        cvWorksDao.deleteById(id);
        return true;
    }
}
