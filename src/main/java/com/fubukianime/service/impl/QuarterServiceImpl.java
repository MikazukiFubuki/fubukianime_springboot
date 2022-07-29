package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.QuarterDao;
import com.fubukianime.domain.Quarter;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class QuarterServiceImpl extends ServiceImpl<QuarterDao, Quarter> implements com.fubuki.service.QuarterService {

    @Autowired
    private QuarterDao quarterDao;

    @Override
    public IPage<Quarter> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        quarterDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<Quarter> getPage(int currentPage, int pageSize, Quarter quarter) {
        LambdaQueryWrapper<Quarter> lqw = new LambdaQueryWrapper<Quarter>();
        lqw.like(Strings.isNotEmpty(quarter.getQuarter()), Quarter::getQuarter, quarter.getQuarter());
        lqw.like(Strings.isNotEmpty(quarter.getQuarterCN()), Quarter::getQuarterCN, quarter.getQuarterCN());
        IPage page = new Page(currentPage,pageSize);
        quarterDao.selectPage(page,lqw);
        return page;
    }


}
