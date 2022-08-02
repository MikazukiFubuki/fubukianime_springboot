package com.fubukianime.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.CvWorks;
import com.fubukianime.domain.HAnimeMain;

import java.util.List;

public interface HAnimeMainService extends IService<HAnimeMain> {
    /**
     * 根据id查询
     * @param id
     * @return
     */
    HAnimeMain selectMainById(Integer id);


    /**
     * 条件查询
     * @param
     * @return
     */
    List<HAnimeMain> selectMainByCondition(HAnimeMain hAnimeMain);

    /**
     * 新增动画
     * @param hAnimeMain
     */
    boolean addHAnime(HAnimeMain hAnimeMain);


    /**
     * 修改动画信息
     * @param hAnimeMain
     */
    boolean updateHAnime(HAnimeMain hAnimeMain);

    boolean removeById(HAnimeMain hAnimeMain);
}
