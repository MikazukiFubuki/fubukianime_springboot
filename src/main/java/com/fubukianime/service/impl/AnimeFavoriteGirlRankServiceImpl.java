package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.AnimeFavoriteGirlRankDao;
import com.fubukianime.dao.AnimeShowDao;
import com.fubukianime.domain.AnimeFavoriteGirlRank;
import com.fubukianime.domain.AnimeShow;
import com.fubukianime.service.AnimeFavoriteGirlRankService;
import com.fubukianime.service.AnimeShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AnimeFavoriteGirlRankServiceImpl extends ServiceImpl<AnimeFavoriteGirlRankDao, AnimeFavoriteGirlRank> implements AnimeFavoriteGirlRankService {

    @Autowired
    private AnimeFavoriteGirlRankDao animeFavoriteGirlRankDao;

    /**
     * 查询信息
     * @param
     * @return
     */
    @Override
    public List<AnimeFavoriteGirlRank> selectByCondition(AnimeFavoriteGirlRank animeFavoriteGirlRank) {
        List<AnimeFavoriteGirlRank> list = animeFavoriteGirlRankDao.selectByCondition(animeFavoriteGirlRank);
        return list;
    }


}
