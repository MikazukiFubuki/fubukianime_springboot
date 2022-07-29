package com.fubukianime.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.AnimeSexLimit;
import com.fubukianime.domain.AnimeLeaderGender;


public interface AnimeLeaderGenderService extends IService<AnimeLeaderGender> {


    boolean save(AnimeLeaderGender animeLeaderGender);

    boolean modify(AnimeLeaderGender animeLeaderGender);

    boolean delete(Integer id);

    IPage<AnimeLeaderGender> getPage(int currentPage, int pageSize);

    IPage<AnimeLeaderGender> getPage(int currentPage, int pageSize, AnimeLeaderGender animeLeaderGender);


}
