package com.fubuki.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.Quarter;
import com.fubukianime.domain.Quarter;


public interface QuarterService extends IService<Quarter> {

    IPage<Quarter> getPage(int currentPage, int pageSize);

    IPage<Quarter> getPage(int currentPage, int pageSize, Quarter quarter);


}
