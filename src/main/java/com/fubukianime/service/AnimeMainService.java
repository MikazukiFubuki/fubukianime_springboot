package com.fubukianime.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.*;
import com.fubukianime.domain.AnimeMain;
import com.fubukianime.entity.PageResult;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @author wyx
 * @description 针对表【anime_main】的数据库操作Service
 * @createDate 2022-07-14 15:07:06
 */
public interface AnimeMainService extends IService<AnimeMain> {

    /**
     * 新增动画
     * @param animeMain
     * @return
     */
    boolean addAnime(AnimeMain animeMain);

    /**
     * 对已有动画新增形式
     * @param id
     */
    boolean addAnimeLayoutById(Integer id);

    /**
     * 开始追番，修改动画信息
     * @param animeMain
     */
    boolean startAnime(AnimeMain animeMain);

    /**
     * 增加动画来源
     * @param animeMain
     */
    boolean addSource(AnimeMain animeMain);

    /**
     * 延长追番，修改追番类型
     * @param animeMain
     */
    boolean extendAnime(AnimeMain animeMain);

    /**
     * 番剧补完，修改动画信息
     * @param animeMain
     */
    boolean endAnime(AnimeMain animeMain);

    /**
     * 对已追动画修改它的形式
     * @param animeLayout
     */
    boolean saveLayout(AnimeLayout animeLayout);

    /**
     * 对已追动画追更一集
     * @param animeLayout
     */
    boolean chasingAPlay(AnimeLayout animeLayout);

    /**
     * 番剧重温
     * @param id
     */
    boolean reviewAnime(Integer id);

    /**
     * 删除选中动画
     * @param animeMain
     * @return
     */
    boolean deleteAnime(AnimeMain animeMain);

    /**
     * 修改动画全部信息
     * @param animeMain
     * @return
     */
    boolean updateAnime(AnimeMain animeMain);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    AnimeMain selectMainById(Integer id);

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    IPage<AnimeMain> getPage(int currentPage, int pageSize);

    /**
     * 全部分页查询
     * @param currentPage
     * @param pageSize
     * @param animeMain
     * @return
     */
    IPage<AnimeMain> getPage(int currentPage, int pageSize, AnimeMain animeMain);

    /**
     * 条件查询
     * @param
     * @return
     */
    PageInfo<AnimeMain> selectByCondition(Integer pageNum, Integer pageSize, AnimeMain animeMain);


    /**
     * 查找要修改动画的全部形式
     * @param id
     * @return
     */
    List<AnimeLayout> selectAnimeLayoutByAnimeId(Integer id);

    /**
     * 根据要修改动画的形式id查询
     * @param id
     * @return
     */
    AnimeLayout selectLayoutById(Integer id);


    /**
     * 修改补番序号
     * @param
     * @return
     */
    boolean updateCompleteId(AnimeMain animeMain);

    /**
     * 修改追番序号
     * @param
     * @return
     */
    boolean updateBingeWatchingId(AnimeMain animeMain);

    /**
     * 修改重温序号
     * @param
     * @return
     */
    boolean updateReviewId(AnimeMain animeMain);


    /**
     * 对已追动画修改它的形式
     * @param animeLayout
     */
    boolean deleteAnimeLayoutById(AnimeLayout animeLayout);


    /**
     * 范围条件查询
     * @param
     * @return
     */
    PageInfo<AnimeMainQuery> selectMainByYearQuarterCondition(Integer pageNum, Integer pageSize, AnimeMainQuery animeMainQuery);

    /**
     * 查询全部动画名称
     * @param animeMain
     * @return
     */
    List<AnimeMain> selectAllAnimeName(AnimeMain animeMain);


    /**
     * 动画原作完结
     * @param animeMain
     * @return
     */
    boolean updateOriginalEnd(AnimeMain animeMain);

    /**
     * 动画播出跨年
     * @param animeMain
     * @return
     */
    boolean overYear(AnimeMain animeMain);

    /**
     * 修改动画名
     * @param animeMain
     * @return
     */
    boolean updateAnimeName(AnimeMain animeMain);

    /**
     * 修改动画评分
     * @param animeMain
     * @return
     */
    boolean updateAnimeScore(AnimeMain animeMain);

    /**
     * 修改动画来源
     * @param animeMain
     */
    boolean updateAnimeSource(AnimeMain animeMain);

    /**
     * 修改动画全部类型
     * @param animeMain
     */
    boolean updateAnimeType(AnimeMain animeMain);

    /**
     * 修改动画恋爱
     * @param animeMain
     */
    boolean updateAnimeLove(AnimeMain animeMain);

    /**
     * 修改动画工口
     * @param animeMain
     */
    boolean updateAnimeSexLimit(AnimeMain animeMain);

    /**
     * 修改动画创作
     * @param animeMain
     */
    boolean updateAnimeCreate(AnimeMain animeMain);

    /**
     * 修改动画主角
     * @param animeMain
     */
    boolean updateAnimeLeaderGender(AnimeMain animeMain);

    /**
     * 修改动画女主
     * @param animeMain
     */
    boolean updateAnimeFavoriteHeroine(AnimeMain animeMain);

    /**
     * 修改动画动画结局
     * @param animeMain
     */
    boolean updateAnimeAnimationEnd(AnimeMain animeMain);

    /**
     * 修改动画播出年份
     * @param animeMain
     */
    boolean updateAnimeBroadcastYear(AnimeMain animeMain);

    /**
     * 修改动画播出类型
     * @param animeMain
     */
    boolean updateAnimeBingeWatchingType(AnimeMain animeMain);

    /**
     * 修改动画追番时间
     * @param animeMain
     */
    boolean updateAnimeBingeWatching(AnimeMain animeMain);

    /**
     * 修改动画补完时间
     * @param animeMain
     */
    boolean updateAnimeComplete(AnimeMain animeMain);

    /**
     * 修改动画状态
     * @param animeMain
     */
    boolean updateAnimeStatus(AnimeMain animeMain);


    /**
     * 查询全部动画名及其评分
     * @param animeMain
     * @return
     */
    List<AnimeMain> selectAnimeWithScore(AnimeMain animeMain);

















}
