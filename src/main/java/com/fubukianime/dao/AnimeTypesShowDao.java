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





}
