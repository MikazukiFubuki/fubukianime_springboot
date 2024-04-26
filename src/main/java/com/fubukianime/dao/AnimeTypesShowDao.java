package com.fubukianime.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fubukianime.domain.AnimeShow;
import com.fubukianime.domain.AnimeTypesShow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnimeTypesShowDao extends BaseMapper<AnimeTypesShow> {


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

    /**
     * 查询形式信息
     * @param
     * @return
     */
    List<AnimeTypesShow> selectLayoutTypeShow(AnimeTypesShow animeTypesShow);

    /**
     * 查询追番情况信息
     * @param
     * @return
     */
    List<AnimeTypesShow> selectBingeWatchingTypeShow(AnimeTypesShow animeTypesShow);

    /**
     * 查询待看状态信息
     * @param
     * @return
     */
    List<AnimeTypesShow> selectStatusShow(AnimeTypesShow animeTypesShow);

    /**
     * 查询在看状态信息
     * @param
     * @return
     */
    List<AnimeTypesShow> selectStatusShow2(AnimeTypesShow animeTypesShow);

    /**
     * 查询音乐类型信息
     * @param
     * @return
     */
    List<AnimeTypesShow> selectMusicTypeShow(AnimeTypesShow animeTypesShow);

    /**
     * 查询音乐评分信息
     * @param
     * @return
     */
    List<AnimeTypesShow> selectScoreShow(AnimeTypesShow animeTypesShow);

    /**
     * 查询H动漫类型信息
     * @param
     * @return
     */
    List<AnimeTypesShow> selectHAnimeTypeShow(AnimeTypesShow animeTypesShow);

    /**
     * 查询H动漫维度信息
     * @param
     * @return
     */
    List<AnimeTypesShow> selectDimensionalShow(AnimeTypesShow animeTypesShow);





}
