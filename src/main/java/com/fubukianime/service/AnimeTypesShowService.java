package com.fubukianime.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.AnimeTypesShow;

import java.util.List;


public interface AnimeTypesShowService extends IService<AnimeTypesShow> {

    /**
     * 查询来源信息
     * @param
     * @return
     */
    List<AnimeTypesShow> selectSourceShow(AnimeTypesShow animeTypesShow);

    /**
     * 查询类型信息
     * @param
     * @return
     */
    List<AnimeTypesShow> selectTypeShow(AnimeTypesShow animeTypesShow);

    /**
     * 查询恋爱信息
     * @param
     * @return
     */
    List<AnimeTypesShow> selectLoveShow(AnimeTypesShow animeTypesShow);

    /**
     * 查询工口信息
     * @param
     * @return
     */
    List<AnimeTypesShow> selectSexLimitShow(AnimeTypesShow animeTypesShow);

    /**
     * 查询创作信息
     * @param
     * @return
     */
    List<AnimeTypesShow> selectCreateShow(AnimeTypesShow animeTypesShow);

    /**
     * 查询主角信息
     * @param
     * @return
     */
    List<AnimeTypesShow> selectLeaderGenderShow(AnimeTypesShow animeTypesShow);

    /**
     * 查询动画结局信息
     * @param
     * @return
     */
    List<AnimeTypesShow> selectAnimationEndShow(AnimeTypesShow animeTypesShow);

    /**
     * 查询原作结局信息
     * @param
     * @return
     */
    List<AnimeTypesShow> selectOriginalEndShow(AnimeTypesShow animeTypesShow);




}
