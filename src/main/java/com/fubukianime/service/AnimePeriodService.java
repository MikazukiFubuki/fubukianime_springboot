package com.fubukianime.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.AnimeLayout;
import com.fubukianime.domain.AnimeLove;
import com.fubukianime.domain.AnimeMain;
import com.fubukianime.domain.AnimePeriod;

import java.util.List;


public interface AnimePeriodService extends IService<AnimePeriod> {


    /**
     * 新增时期点
     * @param animePeriod
     * @return
     */
    boolean addPeriod(AnimePeriod animePeriod);

    /**
     * 查询普通时期点
     * @param
     * @return
     */
    List<AnimePeriod> selectComPeriod(AnimePeriod animePeriod);

    /**
     * 查询普通时期点
     * @param
     * @return
     */
    List<AnimePeriod> selectSPPeriod(AnimePeriod animePeriod);


}
