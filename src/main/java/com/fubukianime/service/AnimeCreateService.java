package com.fubukianime.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.AnimeCreate;



public interface AnimeCreateService extends IService<AnimeCreate> {

    boolean save(AnimeCreate animeCreate);

    boolean modify(AnimeCreate animeCreate);

    boolean delete(Integer id);

    IPage<AnimeCreate> getPage(int currentPage, int pageSize);

    IPage<AnimeCreate> getPage(int currentPage, int pageSize, AnimeCreate animeCreate);


}
