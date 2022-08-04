package com.fubukianime.controller;

import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.AnimeFavoriteGirlRank;
import com.fubukianime.domain.AnimeShow;
import com.fubukianime.service.AnimeFavoriteGirlRankService;
import com.fubukianime.service.AnimeShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/animeFavoriteGirlRanks")
public class AnimeFavoriteGirlRankController {

    @Autowired
    private AnimeFavoriteGirlRankService animeFavoriteGirlRankService;

    @Autowired
    private CacheManager cacheManager;


    @Cacheable(value = "animeFavoriteGirlRankCache", key = "#animeFavoriteGirlRank.season", unless = "#result == null")
    @GetMapping("/selectByCondition")
    public R selectByCondition(AnimeFavoriteGirlRank animeFavoriteGirlRank){
        List<AnimeFavoriteGirlRank> list = animeFavoriteGirlRankService.selectByCondition(animeFavoriteGirlRank);
        return new R(true, list);
    }





}
