package com.fubukianime.controller;

import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.AnimeShow;
import com.fubukianime.domain.AnimeTypesShow;
import com.fubukianime.service.AnimeShowService;
import com.fubukianime.service.AnimeTypesShowService;
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
@RequestMapping("/animeTypesShow")
public class AnimeTypesShowController {

    @Autowired
    private AnimeTypesShowService animeTypesShowService;

    @Autowired
    private CacheManager cacheManager;


    /**
     * 用于展示统计
     * @param animeTypesShow
     * @return
     */
    @Cacheable(value = "animeSourceCache", key = "#root.methodName", unless = "#result == null")
    @GetMapping("/selectSourceShow")
    public List<AnimeTypesShow> selectSourceShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowService.selectSourceShow(animeTypesShow);
        return list;
    }

    @Cacheable(value = "animeTypeCache", key = "#root.methodName", unless = "#result == null")
    @GetMapping("/selectTypeShow")
    public List<AnimeTypesShow> selectTypeShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowService.selectTypeShow(animeTypesShow);
        return list;
    }

    @Cacheable(value = "animeLoveCache", key = "#root.methodName", unless = "#result == null")
    @GetMapping("/selectLoveShow")
    public List<AnimeTypesShow> selectLoveShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowService.selectLoveShow(animeTypesShow);
        return list;
    }

    @Cacheable(value = "animeSexLimitCache", key = "#root.methodName", unless = "#result == null")
    @GetMapping("/selectSexLimitShow")
    public List<AnimeTypesShow> selectSexLimitShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowService.selectSexLimitShow(animeTypesShow);
        return list;
    }

    @Cacheable(value = "animeCreateCache", key = "#root.methodName", unless = "#result == null")
    @GetMapping("/selectCreateShow")
    public List<AnimeTypesShow> selectCreateShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowService.selectCreateShow(animeTypesShow);
        return list;
    }

    @Cacheable(value = "animeLeaderGenderCache", key = "#root.methodName", unless = "#result == null")
    @GetMapping("/selectLeaderGenderShow")
    public List<AnimeTypesShow> selectLeaderGenderShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowService.selectLeaderGenderShow(animeTypesShow);
        return list;
    }

    @Cacheable(value = "animeAnimationEndCache", key = "#root.methodName", unless = "#result == null")
    @GetMapping("/selectAnimationEndShow")
    public List<AnimeTypesShow> selectAnimationEndShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowService.selectAnimationEndShow(animeTypesShow);
        return list;
    }

    @Cacheable(value = "animeOriginalEndCache", key = "#root.methodName", unless = "#result == null")
    @GetMapping("/selectOriginalEndShow")
    public List<AnimeTypesShow> selectOriginalEndShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowService.selectOriginalEndShow(animeTypesShow);
        return list;
    }

    @Cacheable(value = "animeLayoutCache", key = "#root.methodName", unless = "#result == null")
    @GetMapping("/selectLayoutTypeShow")
    public List<AnimeTypesShow> selectLayoutTypeShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowService.selectLayoutTypeShow(animeTypesShow);
        return list;
    }

    @Cacheable(value = "animeBingeWatchingTypeCache", key = "#root.methodName", unless = "#result == null")
    @GetMapping("/selectBingeWatchingTypeShow")
    public List<AnimeTypesShow> selectBingeWatchingTypeShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowService.selectBingeWatchingTypeShow(animeTypesShow);
        return list;
    }

    @Cacheable(value = "animeStatusCache", key = "#root.methodName", unless = "#result == null")
    @GetMapping("/selectStatusShow")
    public List<AnimeTypesShow> selectStatusShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowService.selectStatusShow(animeTypesShow);
        return list;
    }

    @Cacheable(value = "animeStatusCache", key = "#root.methodName", unless = "#result == null")
    @GetMapping("/selectStatusShow2")
    public List<AnimeTypesShow> selectStatusShow2(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowService.selectStatusShow2(animeTypesShow);
        return list;
    }

    @Cacheable(value = "musicTypeCache", key = "#root.methodName", unless = "#result == null")
    @GetMapping("/selectMusicTypeShow")
    public List<AnimeTypesShow> selectMusicTypeShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowService.selectMusicTypeShow(animeTypesShow);
        return list;
    }

    @Cacheable(value = "musicsCache", key = "#root.methodName", unless = "#result == null")
    @GetMapping("/selectScoreShow")
    public List<AnimeTypesShow> selectScoreShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowService.selectScoreShow(animeTypesShow);
        return list;
    }

    @Cacheable(value = "hAnimeTypeCache", key = "#root.methodName", unless = "#result == null")
    @GetMapping("/selectHAnimeTypeShow")
    public List<AnimeTypesShow> selectHAnimeTypeShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowService.selectHAnimeTypeShow(animeTypesShow);
        return list;
    }

    @Cacheable(value = "hanimeCache", key = "#root.methodName", unless = "#result == null")
    @GetMapping("/selectDimensionalShow")
    public List<AnimeTypesShow> selectDimensionalShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowService.selectDimensionalShow(animeTypesShow);
        return list;
    }


    /**
     * 用于主表选择框
     * @param animeTypesShow
     * @return
     */
    @Cacheable(value = "animeSourceCache", key = "#root.methodName", unless = "#result == null")
    @GetMapping("/selectSource")
    public R selectSource(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowService.selectSourceShow(animeTypesShow);
        return new R(true, list);
    }

    @Cacheable(value = "animeTypeCache", key = "#root.methodName", unless = "#result == null")
    @GetMapping("/selectType")
    public R selectType(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowService.selectTypeShow(animeTypesShow);
        return new R(true, list);
    }

    @Cacheable(value = "animeLoveCache", key = "#root.methodName", unless = "#result == null")
    @GetMapping("/selectLove")
    public R selectLove(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowService.selectLoveShow(animeTypesShow);
        return new R(true, list);
    }

    @Cacheable(value = "animeSexLimitCache", key = "#root.methodName", unless = "#result == null")
    @GetMapping("/selectSexLimit")
    public R selectSexLimit(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowService.selectSexLimitShow(animeTypesShow);
        return new R(true, list);
    }

    @Cacheable(value = "animeCreateCache", key = "#root.methodName", unless = "#result == null")
    @GetMapping("/selectCreate")
    public R selectCreate(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowService.selectCreateShow(animeTypesShow);
        return new R(true, list);
    }

    @Cacheable(value = "animeLeaderGenderCache", key = "#root.methodName", unless = "#result == null")
    @GetMapping("/selectLeaderGender")
    public R selectLeaderGender(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowService.selectLeaderGenderShow(animeTypesShow);
        return new R(true, list);
    }

    @Cacheable(value = "animeAnimationEndCache", key = "#root.methodName", unless = "#result == null")
    @GetMapping("/selectAnimationEnd")
    public R selectAnimationEnd(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowService.selectAnimationEndShow(animeTypesShow);
        return new R(true, list);
    }

    @Cacheable(value = "animeOriginalEndCache", key = "#root.methodName", unless = "#result == null")
    @GetMapping("/selectOriginalEnd")
    public R selectOriginalEnd(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowService.selectOriginalEndShow(animeTypesShow);
        return new R(true, list);
    }

    @Cacheable(value = "animeLayoutCache", key = "#root.methodName", unless = "#result == null")
    @GetMapping("/selectLayoutType")
    public R selectLayoutType(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowService.selectLayoutTypeShow(animeTypesShow);
        return new R(true, list);
    }






}
