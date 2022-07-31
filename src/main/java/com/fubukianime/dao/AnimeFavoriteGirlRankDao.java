package com.fubukianime.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fubukianime.domain.AnimeFavoriteGirlRank;
import com.fubukianime.domain.AnimeMain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnimeFavoriteGirlRankDao extends BaseMapper<AnimeFavoriteGirlRank> {

    /**
     * 条件查询
     * @param
     * @return
     */
    List<AnimeFavoriteGirlRank> selectByCondition(AnimeFavoriteGirlRank animeFavoriteGirlRank);
}
