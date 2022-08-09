package com.fubukianime.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fubukianime.dao.AnimeLayoutDao;
import com.fubukianime.dao.AnimeLayoutTypeDao;
import com.fubukianime.dao.AnimeMainDao;
import com.fubukianime.dao.AnimeMainDao;
import com.fubukianime.domain.*;
import com.fubukianime.domain.AnimeMain;
import com.fubukianime.entity.PageResult;
import com.fubukianime.service.AnimeMainService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wyx
 * @description 针对表【anime_main】的数据库操作Service实现
 * @createDate 2022-07-14 15:07:06
 */
@Service
public class AnimeMainServiceImpl extends ServiceImpl<AnimeMainDao, AnimeMain> implements AnimeMainService {

    @Autowired
    private AnimeMainDao animeMainDao;

    @Autowired
    private AnimeLayoutDao animeLayoutDao;

    /**
     * 新增动画
     * @param animeMain
     * @return
     */
    @Override
    public boolean addAnime(AnimeMain animeMain) {
        animeMainDao.addAnime(animeMain);
        animeMainDao.addAnimeLayout();
        return true;
    }

    /**
     * 对已有动画新增形式
     * @param id
     */
    @Override
    public boolean addAnimeLayoutById(Integer id){
        animeMainDao.addAnimeLayoutById(id);
        return true;
    }

    /**
     * 开始追番，修改动画信息
     * @param animeMain
     */
    @Override
    public boolean startAnime(AnimeMain animeMain) {
        animeMainDao.startAnime(animeMain);
        return true;
    }

    /**
     * 增加动画来源
     * @param animeMain
     */
    @Override
    public boolean addSource(AnimeMain animeMain) {
        animeMainDao.addSource(animeMain);
        return true;
    }

    /**
     * 延长追番，修改追番类型
     * @param animeMain
     */
    @Override
    public boolean extendAnime(AnimeMain animeMain) {
        animeMainDao.extendAnime(animeMain);
        return true;
    }

    /**
     * 番剧补完，修改动画信息
     * @param animeMain
     */
    @Override
    public boolean endAnime(AnimeMain animeMain) {
        animeMainDao.endAnime(animeMain);
        return true;
    }

    /**
     * 修改动画全部信息
     * @param animeMain
     * @return
     */
    @Override
    public boolean updateAnime(AnimeMain animeMain){
        animeMainDao.updateAnime(animeMain);
        return true;
    }

    /**
     * 对已追动画修改它的形式
     * @param animeLayout
     */
    @Override
    public boolean saveLayout(AnimeLayout animeLayout) {
        animeMainDao.saveLayout(animeLayout);
        return true;
    }

    /**
     * 对已追动画追更一集
     * @param animeLayout
     */
    @Override
    public boolean chasingAPlay(AnimeLayout animeLayout) {
        animeMainDao.chasingAPlay(animeLayout);
        return true;
    }

    /**
     * 番剧重温
     * @param id
     */
    @Override
    public boolean reviewAnime(Integer id) {
        animeMainDao.reviewAnime(id);
        return true;
    }



    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public AnimeMain selectMainById(Integer id) {
        return animeMainDao.selectMainById(id);
    }

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public IPage<AnimeMain> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        animeMainDao.selectPage(page,null);
        return page;
    }

    /**
     * 全部分页查询
     * @param currentPage
     * @param pageSize
     * @param animeMain
     * @return
     */
    @Override
    public IPage<AnimeMain> getPage(int currentPage, int pageSize, AnimeMain animeMain) {
        Page<AnimeMain> page = new Page<>(currentPage,pageSize);
        animeMainDao.selectMainAll(page);
        return page;
    }

    /**
     * 条件查询
     * @param
     * @return
     */
    @Override
    public PageInfo<AnimeMain> selectByCondition(Integer pageNum, Integer pageSize, AnimeMain animeMain) {
        PageHelper.startPage(pageNum, pageSize);
        List<AnimeMain> animeMainList = animeMainDao.selectMainByCondition(animeMain);
        PageInfo<AnimeMain> animeMainPageInfo = new PageInfo<>(animeMainList, pageSize);
        return animeMainPageInfo;
    }

    /**
     * 查找要修改动画的全部形式
     * @param id
     * @return
     */
    @Override
    public List<AnimeLayout> selectAnimeLayoutByAnimeId(Integer id) {
        List<AnimeLayout> animeLayoutList = animeMainDao.selectAnimeLayoutByAnimeId(id);
        return animeLayoutList;
    }

    /**
     * 根据要修改动画的形式id查询
     * @param id
     * @return
     */
    @Override
    public AnimeLayout selectLayoutById(Integer id) {
        return animeMainDao.selectLayoutById(id);
    }

    /**
     * 修改补番序号
     * @param
     * @return
     */
    @Override
    public boolean updateCompleteId(AnimeMain animeMain) {
        Integer oldCompleteId = animeMain.getCompleteId();
        Integer oldId = animeMain.getId();
        Integer modifyId = animeMain.getModifyId();
        Integer i;
        Integer j;

        //判断更改补完序号为增大还是减小
        //更改为增大补完序号
        if(oldCompleteId < modifyId){
            //根据更改前补完序号的id将序号修改为0
            animeMain.setCompleteId(0);
            //animeMainDao.updateBCRId(animeMain);
            /**判断i值是否超过更改后补完序号
             * 未超过就修改更改之间数据的补完序号
             */
            //更改变量为更改前补完序号+1
            for(i = oldCompleteId + 1 ; i<=modifyId; i++){
                //根据i值获取对应id
                animeMain.setCompleteId(i);
                j = animeMainDao.selectIdByCompleteId(animeMain);
                //更改对应id
                animeMain.setId(j);
                //根据id将补完序号修改为i值-1
                animeMain.setCompleteId(i-1);
                animeMainDao.updateCompleteId(animeMain);
            }
        }else if(oldCompleteId > modifyId){
            //更改为减小补完序号
            //根据更改前补完序号的id将序号修改为0
            animeMain.setCompleteId(0);
            //animeMainDao.updateBCRId(animeMain);
            /**判断i值是否小于更改后补完序号
             * 未小于就修改更改之间数据的补完序号
             */
            //更改变量为更改前补完序号-1
            for(i = oldCompleteId - 1 ; i>=modifyId; i--){
                //根据i值获取对应id
                animeMain.setCompleteId(i);
                j = animeMainDao.selectIdByCompleteId(animeMain);
                //更改对应id
                animeMain.setId(j);
                //根据id将补完序号修改为i值+1
                animeMain.setCompleteId(i+1);
                animeMainDao.updateCompleteId(animeMain);
            }
        }
        //根据更改前补完序号id将更改前补完序号修改更改后补完序号值
        animeMain.setId(oldId);
        animeMain.setCompleteId(modifyId);
        animeMainDao.updateCompleteId(animeMain);

        return true;
    }

    /**
     * 修改追番序号
     * @param
     * @return
     */
    @Override
    public boolean updateBingeWatchingId(AnimeMain animeMain) {
        Integer oldBingeWatchingId = animeMain.getBingeWatchingId();
        Integer oldId = animeMain.getId();
        Integer modifyId = animeMain.getModifyId();
        Integer i;
        Integer j;

        //判断更改追番序号为增大还是减小
        //更改为增大追番序号
        if(oldBingeWatchingId < modifyId){
            //根据更改前追番序号的id将序号修改为0
            animeMain.setBingeWatchingId(0);
            //animeMainDao.updateBCRId(animeMain);
            /**判断i值是否超过更改后追番序号
             * 未超过就修改更改之间数据的追番序号
             */
            //更改变量为更改前追番序号+1
            for(i = oldBingeWatchingId + 1 ; i<=modifyId; i++){
                //根据i值获取对应id
                animeMain.setBingeWatchingId(i);
                j = animeMainDao.selectIdByBingeWatchingId(animeMain);
                //更改对应id
                animeMain.setId(j);
                //根据id将追番序号修改为i值-1
                animeMain.setBingeWatchingId(i-1);
                animeMainDao.updateBingeWatchingId(animeMain);
            }
        }else if(oldBingeWatchingId > modifyId){
            //更改为减小追番序号
            //根据更改前追番序号的id将序号修改为0
            animeMain.setBingeWatchingId(0);
            //animeMainDao.updateBCRId(animeMain);
            /**判断i值是否小于更改后追番序号
             * 未小于就修改更改之间数据的追番序号
             */
            //更改变量为更改前追番序号-1
            for(i = oldBingeWatchingId - 1 ; i>=modifyId; i--){
                //根据i值获取对应id
                animeMain.setBingeWatchingId(i);
                j = animeMainDao.selectIdByBingeWatchingId(animeMain);
                //更改对应id
                animeMain.setId(j);
                //根据id将追番序号修改为i值+1
                animeMain.setBingeWatchingId(i+1);
                animeMainDao.updateBingeWatchingId(animeMain);
            }
        }
        //根据更改前追番序号id将更改前追番序号修改更改后追番序号值
        animeMain.setId(oldId);
        animeMain.setBingeWatchingId(modifyId);
        animeMainDao.updateBingeWatchingId(animeMain);

        return true;
    }

    /**
     * 修改重温序号
     * @param
     * @return
     */
    @Override
    public boolean updateReviewId(AnimeMain animeMain) {
        Integer oldReviewId = animeMain.getReviewId();
        Integer oldId = animeMain.getId();
        Integer modifyId = animeMain.getModifyId();
        Integer i;
        Integer j;

        //判断更改重温序号为增大还是减小
        //更改为增大重温序号
        if(oldReviewId < modifyId){
            //根据更改前重温序号的id将序号修改为0
            animeMain.setReviewId(0);
            //animeMainDao.updateBCRId(animeMain);
            /**判断i值是否超过更改后重温序号
             * 未超过就修改更改之间数据的重温序号
             */
            //更改变量为更改前重温序号+1
            for(i = oldReviewId + 1 ; i<=modifyId; i++){
                //根据i值获取对应id
                animeMain.setReviewId(i);
                j = animeMainDao.selectIdByReviewId(animeMain);
                //更改对应id
                animeMain.setId(j);
                //根据id将重温序号修改为i值-1
                animeMain.setReviewId(i-1);
                animeMainDao.updateReviewId(animeMain);
            }
        }else if(oldReviewId > modifyId){
            //更改为减小重温序号
            //根据更改前重温序号的id将序号修改为0
            animeMain.setReviewId(0);
            //animeMainDao.updateBCRId(animeMain);
            /**判断i值是否小于更改后重温序号
             * 未小于就修改更改之间数据的重温序号
             */
            //更改变量为更改前重温序号-1
            for(i = oldReviewId - 1 ; i>=modifyId; i--){
                //根据i值获取对应id
                animeMain.setReviewId(i);
                j = animeMainDao.selectIdByReviewId(animeMain);
                //更改对应id
                animeMain.setId(j);
                //根据id将重温序号修改为i值+1
                animeMain.setReviewId(i+1);
                animeMainDao.updateReviewId(animeMain);
            }
        }
        //根据更改前重温序号id将更改前重温序号修改更改后重温序号值
        animeMain.setId(oldId);
        animeMain.setReviewId(modifyId);
        animeMainDao.updateReviewId(animeMain);

        return true;
    }

    /**
     * 删除动画，即在主表和形式表中修改deleted = 1，并修改追补重番id
     * @param animeMain
     * @return
     */
    @Override
    public boolean deleteAnime(AnimeMain animeMain) {
        //获取要删除动画的id和形式id
        Integer deleteId = animeMain.getId();
        Integer deleteLayoutId = animeMainDao.selectLayoutIdById(deleteId);
        //逻辑删除动画，即修改动画表和对应形式表中deleted=1
        animeMainDao.deleteById(deleteId);
        animeMainDao.deleteAnimeLayout(deleteLayoutId);
        //获取要删除动画的追补重番id
        Integer deletedCompleteId = animeMain.getCompleteId();
        Integer deletedBingeWatchingId = animeMain.getBingeWatchingId();
        Integer deletedReviewId = animeMain.getReviewId();
        //获取当前最大追补重番id
        Integer maxCompleteId = animeMainDao.selectMaxCompleteId();
        Integer maxBingeWatchingId = animeMainDao.selectMaxBingeWatchingId();
        Integer maxReviewId = animeMainDao.selectMaxReviewId();

        Integer i;
        Integer j;

        //循环修改删除动画后续补番id-1，直到动画表补番id最大值修改完
        for(i = deletedCompleteId + 1;  i<=maxCompleteId; i++){
            //根据i值获取对应id
            animeMain.setCompleteId(i);
            j = animeMainDao.selectIdByCompleteId(animeMain);
            //更改对应id
            animeMain.setId(j);
            //根据id将补完序号修改为i值-1
            animeMain.setCompleteId(i-1);
            animeMainDao.updateCompleteId(animeMain);
        }

        //循环修改删除动画后续追番id-1，直到动画表追番id最大值修改完
        for(i = deletedBingeWatchingId + 1 ; i<=maxBingeWatchingId; i++){
            //根据i值获取对应id
            animeMain.setBingeWatchingId(i);
            j = animeMainDao.selectIdByBingeWatchingId(animeMain);
            //更改对应id
            animeMain.setId(j);
            //根据id将追番序号修改为i值-1
            animeMain.setBingeWatchingId(i-1);
            animeMainDao.updateBingeWatchingId(animeMain);
        }

        //循环修改删除动画后续重温id-1，直到动画表重温id最大值修改完
        for(i = deletedReviewId + 1 ; i<=maxReviewId; i++){
            //根据i值获取对应id
            animeMain.setReviewId(i);
            j = animeMainDao.selectIdByReviewId(animeMain);
            //更改对应id
            animeMain.setId(j);
            //根据id将重温序号修改为i值-1
            animeMain.setReviewId(i-1);
            animeMainDao.updateReviewId(animeMain);
        }

        return true;
    }

    /**
     * 对已追动画删除它的形式
     * @param animeLayout
     */
    @Override
    public boolean deleteAnimeLayoutById(AnimeLayout animeLayout) {
        Integer id = animeLayout.getId();
        animeLayoutDao.deleteById(id);
        return true;
    }

    /**
     * 条件查询年间
     * @param
     * @return
     */
    @Override
    public List<AnimeMainQuery> selectMainByYearQuarterCondition(AnimeMainQuery animeMainQuery) {

        List<AnimeMainQuery> animeMainList = animeMainDao.selectMainByYearQuarterCondition(animeMainQuery);
        return animeMainList;
    }


}
