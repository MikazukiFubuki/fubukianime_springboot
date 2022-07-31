package com.fubukianime.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.AnimeMerch;


public interface AnimeMerchService extends IService<AnimeMerch> {


    boolean save(AnimeMerch animeMerch);

    boolean modify(AnimeMerch animeMerch);

    boolean delete(Integer id);

    IPage<AnimeMerch> getPage(int currentPage, int pageSize);

    IPage<AnimeMerch> getPage(int currentPage, int pageSize, AnimeMerch animeMerch);


}
