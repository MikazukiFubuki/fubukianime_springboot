package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.MusicDownloadTypeDao;
import com.fubukianime.domain.MusicDownloadType;
import com.fubukianime.service.MusicDownloadTypeService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MusicDownloadTypeServiceImpl extends ServiceImpl<MusicDownloadTypeDao, MusicDownloadType> implements MusicDownloadTypeService {

    @Autowired
    private MusicDownloadTypeDao musicDownloadTypeDao;

    @Override
    public boolean save(MusicDownloadType musicDownloadType) {
        return musicDownloadTypeDao.insert(musicDownloadType) > 0;
    }

    @Override
    public boolean modify(MusicDownloadType musicDownloadType) {
        return musicDownloadTypeDao.updateById(musicDownloadType) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return musicDownloadTypeDao.deleteById(id) > 0;
    }

    @Override
    public IPage<MusicDownloadType> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        musicDownloadTypeDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<MusicDownloadType> getPage(int currentPage, int pageSize, MusicDownloadType musicDownloadType) {
        LambdaQueryWrapper<MusicDownloadType> lqw = new LambdaQueryWrapper<MusicDownloadType>();
        lqw.like(Strings.isNotEmpty(musicDownloadType.getDownloadType()), MusicDownloadType::getDownloadType, musicDownloadType.getDownloadType());
        IPage page = new Page(currentPage,pageSize);
        musicDownloadTypeDao.selectPage(page,lqw);
        return page;
    }


}
