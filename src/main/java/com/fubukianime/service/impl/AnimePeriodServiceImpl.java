package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.AnimeLoveDao;
import com.fubukianime.dao.AnimePeriodDao;
import com.fubukianime.domain.AnimeLove;
import com.fubukianime.domain.AnimePeriod;
import com.fubukianime.service.AnimeLoveService;
import com.fubukianime.service.AnimePeriodService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;


@Service
public class AnimePeriodServiceImpl extends ServiceImpl<AnimePeriodDao, AnimePeriod> implements AnimePeriodService {

    @Autowired
    private AnimePeriodDao animePeriodDao;



    /**
     * 新增时期点
     * @param animePeriod
     * @return
     */
    @Override
    public boolean addPeriod(AnimePeriod animePeriod) {
        animePeriodDao.addPeriod(animePeriod);
        return true;
    }

    /**
     * 查询普通时期点
     * @param
     * @return
     */
    @Override
    public List<AnimePeriod> selectComPeriod(AnimePeriod animePeriod) {
        List<AnimePeriod> list = animePeriodDao.selectComPeriod(animePeriod);
        return list;
    }

    /**
     * 查询特殊时期点
     * @param
     * @return
     */
    @Override
    public List<AnimePeriod> selectSPPeriod(AnimePeriod animePeriod) {
        List<AnimePeriod> list = animePeriodDao.selectSPPeriod(animePeriod);
        return list;
    }

    /**
     * 查询补完时期点
     * @param
     * @return
     */
    @Override
    public List<AnimePeriod> selectCPeriod(AnimePeriod animePeriod) {
        List<AnimePeriod> list = animePeriodDao.selectCPeriod(animePeriod);
        return list;
    }

    /**
     * 查询实际补时期点
     * @param
     * @return
     */
    @Override
    public List<AnimePeriod> selectRCPeriod(AnimePeriod animePeriod) {
        List<AnimePeriod> list = animePeriodDao.selectRCPeriod(animePeriod);
        return list;
    }

    /**
     * 查询追番时期点
     * @param
     * @return
     */
    @Override
    public List<AnimePeriod> selectBPeriod(AnimePeriod animePeriod) {
        List<AnimePeriod> list = animePeriodDao.selectBPeriod(animePeriod);
        return list;
    }

    /**
     * 查询年终时期点
     */
    @Override
    public List<AnimePeriod> selectYPeriod(AnimePeriod animePeriod) {
        List<AnimePeriod> list = animePeriodDao.selectYPeriod(animePeriod);
        return list;
    }
}
