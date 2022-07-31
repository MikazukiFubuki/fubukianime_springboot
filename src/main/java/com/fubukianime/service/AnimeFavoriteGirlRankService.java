package com.fubukianime.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.AnimeFavoriteGirlRank;
import com.fubukianime.domain.AnimeShow;

import java.util.List;


public interface AnimeFavoriteGirlRankService extends IService<AnimeFavoriteGirlRank> {

    /**
     * 查询信息
     * @param
     * @return
     */
    List<AnimeFavoriteGirlRank> selectByCondition(AnimeFavoriteGirlRank animeFavoriteGirlRank);




}
