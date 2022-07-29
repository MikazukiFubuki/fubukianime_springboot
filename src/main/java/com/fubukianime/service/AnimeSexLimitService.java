package com.fubukianime.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.AnimeLove;
import com.fubukianime.domain.AnimeSexLimit;


public interface AnimeSexLimitService extends IService<AnimeSexLimit> {


    boolean save(AnimeSexLimit animeSexLimit);

    boolean modify(AnimeSexLimit animeSexLimit);

    boolean delete(Integer id);

    IPage<AnimeSexLimit> getPage(int currentPage, int pageSize);

    IPage<AnimeSexLimit> getPage(int currentPage, int pageSize, AnimeSexLimit animeSexLimit);


}
