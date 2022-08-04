package com.fubukianime.controller;

import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.AnimeShow;
import com.fubukianime.service.AnimeShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/animeShows")
public class AnimeShowController {

    @Autowired
    private AnimeShowService animeShowService;

    @GetMapping("/selectAnimeShow")
    public List<AnimeShow> selectAnimeShow(AnimeShow animeShow){
        List<AnimeShow> list = animeShowService.selectAnimeShow(animeShow);
        return list;
    }





}
