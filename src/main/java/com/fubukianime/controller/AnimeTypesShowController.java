package com.fubukianime.controller;

import com.fubukianime.domain.AnimeShow;
import com.fubukianime.domain.AnimeTypesShow;
import com.fubukianime.service.AnimeShowService;
import com.fubukianime.service.AnimeTypesShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/animeTypesShow")
public class AnimeTypesShowController {

    @Autowired
    private AnimeTypesShowService animeTypesShowService;


    @GetMapping("/selectSourceShow")
    public List<AnimeTypesShow> selectSourceShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowService.selectSourceShow(animeTypesShow);
        return list;
    }

    @GetMapping("/selectTypeShow")
    public List<AnimeTypesShow> selectTypeShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowService.selectTypeShow(animeTypesShow);
        return list;
    }

    @GetMapping("/selectLoveShow")
    public List<AnimeTypesShow> selectLoveShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowService.selectLoveShow(animeTypesShow);
        return list;
    }

    @GetMapping("/selectSexLimitShow")
    public List<AnimeTypesShow> selectSexLimitShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowService.selectSexLimitShow(animeTypesShow);
        return list;
    }

    @GetMapping("/selectCreateShow")
    public List<AnimeTypesShow> selectCreateShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowService.selectCreateShow(animeTypesShow);
        return list;
    }

    @GetMapping("/selectLeaderGenderShow")
    public List<AnimeTypesShow> selectLeaderGenderShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowService.selectLeaderGenderShow(animeTypesShow);
        return list;
    }

    @GetMapping("/selectAnimationEndShow")
    public List<AnimeTypesShow> selectAnimationEndShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowService.selectAnimationEndShow(animeTypesShow);
        return list;
    }

    @GetMapping("/selectOriginalEndShow")
    public List<AnimeTypesShow> selectOriginalEndShow(AnimeTypesShow animeTypesShow) {
        List<AnimeTypesShow> list = animeTypesShowService.selectOriginalEndShow(animeTypesShow);
        return list;
    }





}
