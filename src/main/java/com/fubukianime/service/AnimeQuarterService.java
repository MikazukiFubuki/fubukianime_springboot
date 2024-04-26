package com.fubukianime.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.AnimeQuarter;

import java.util.List;


public interface AnimeQuarterService extends IService<AnimeQuarter> {


    /**
     * 新增较季点
     * @param animeQuarter
     * @return
     */
    boolean addComQuarter(AnimeQuarter animeQuarter);

    /**
     * 查询较季
     * @param
     * @return
     */
    List<AnimeQuarter> selectComQuarter(AnimeQuarter animeQuarter);

    /**
     * 查询当季在看展示
     * @param
     * @return
     */
    List<AnimeQuarter> selectNowQuarter(AnimeQuarter animeQuarter);




}
