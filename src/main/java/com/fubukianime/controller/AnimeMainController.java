package com.fubukianime.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fubukianime.controller.utils.R;
import com.fubukianime.dao.AnimeMainDao;
import com.fubukianime.domain.AnimeLayout;
import com.fubukianime.domain.AnimeLove;
import com.fubukianime.domain.AnimeMain;
import com.fubukianime.domain.AnimeMainQuery;
import com.fubukianime.service.AnimeMainService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/animeMains")
public class AnimeMainController {

    @Autowired
    private AnimeMainService animeMainService;

    @Autowired
    private CacheManager cacheManager;

    /**
     * 新增动画
     * @param animeMain
     * @return
     * @throws IOException
     */
    @CacheEvict(value = "animeMainCache", allEntries = true)
    @PostMapping
    public R addAnime(@RequestBody AnimeMain animeMain) throws IOException{
        boolean flag =  animeMainService.addAnime(animeMain);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    /**
     * 查询全部
     * @return
     */
    @GetMapping
    public R getAll(){
        return new R(true, animeMainService.list());
    }

    /**
     * 对已有动画新增形式
     * @param id
     */
    @CacheEvict(value = "animeLayoutCache", allEntries = true)
    @GetMapping("/addAnimeLayoutById/{id}")
    public R addAnimeLayoutById(@PathVariable Integer id){
        return new R(true, animeMainService.addAnimeLayoutById(id));
    }

    /**
     * 番剧重温
     * @param id
     */
    @CacheEvict(value = "animeMainCache", allEntries = true)
    @GetMapping("/reviewAnime/{id}")
    public R reviewAnime(@PathVariable Integer id){
        return new R(true, animeMainService.reviewAnime(id));
    }



    /**
     * 查找要修改动画的全部形式
     * @param id
     * @return
     */
    @Cacheable(value = "animeLayoutCache", key = "#root.methodName + '_' + #id", unless = "#result == null")
    @GetMapping("/selectAnimeLayoutByAnimeId/{id}")
    public R selectAnimeLayoutByAnimeId(@PathVariable Integer id){
        List<AnimeLayout> list = animeMainService.selectAnimeLayoutByAnimeId(id);
        return new R(true, list);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Cacheable(value = "animeMainCache", key = "#root.methodName + '_' + #id", unless = "#result == null")
    @GetMapping("/{id}")
    public R selectMainById(@PathVariable Integer id){
        return new R(true, animeMainService.selectMainById(id));
    }

    /**
     * 分页查询全部
     * @param currentPage
     * @param pageSize
     * @param animeMain
     * @return
     */
    @Cacheable(value = "animeMainCache", key = "#animeMain.id +  '_' + #currentPage + '_' + #pageSize", unless = "#result == null")
    @GetMapping("/{currentPage}/{pageSize}")
    public R selectMainAll(@PathVariable Integer currentPage,@PathVariable Integer pageSize, AnimeMain animeMain){
        IPage<AnimeMain> page = animeMainService.getPage(currentPage, pageSize,animeMain);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = animeMainService.getPage((int)page.getPages(), pageSize,animeMain);
        }
        return new R(true, page);
    }

    /**
     * 条件查询
     * @param animeMain
     * @return
     */
    @Cacheable(value = "animeMainCache", key = "#animeMain.id + '_' + #animeMain.name + '_' + #animeMain.source + '_' + #animeMain.layout + '_' + #animeMain.type + '_' + #animeMain.create + '_' + #animeMain.love + '_' + #animeMain.sexLimit + '_' + #animeMain.bingeWatchingId + '_' + #animeMain.completeId + '_' + #animeMain.reviewId+ '_' + #animeMain.leaderGender + '_' + #animeMain.favoriteHeroine + '_' + #animeMain.animationEnd+ '_' + #animeMain.originalEnd + '_' + #animeMain.broadcastStartYear + '_' + #animeMain.broadcastEndYear+ '_' + #animeMain.bingeWatchingType + '_' + #animeMain.bingeWatchingYear + '_' + #animeMain.bingeWatchingQuarter+ '_' + #animeMain.completeYear + '_' + #animeMain.completeQuarter + '_' + #animeMain.status + '_' + #currentPage+ '_' + #pageSize", unless = "#result == null")
    @GetMapping("/byCondition/{currentPage}/{pageSize}")
    public R selectByCondition(@PathVariable Integer currentPage,@PathVariable Integer pageSize, AnimeMain animeMain){
        PageInfo<AnimeMain> pageInfo = animeMainService.selectByCondition(currentPage, pageSize,animeMain);
        return new R(true, pageInfo);
    }

    /**
     * 范围条件查询
     * @param animeMainQuery
     * @return
     */
    @Cacheable(value = "animeMainCache", key = "#animeMainQuery.id + '_' + #animeMainQuery.name + '_' + #animeMainQuery.score + '_' + #animeMainQuery.score2 + '_' + #animeMainQuery.source  + '_' " +
            "+ #animeMainQuery.layout + '_' + #animeMainQuery.type + '_' + #animeMainQuery.create + '_' + #animeMainQuery.love + '_' " +
            "+ #animeMainQuery.sexLimit + '_' + #animeMainQuery.bingeWatchingId + '_' + #animeMainQuery.bingeWatchingId2 + '_' + #animeMainQuery.completeId + '_' + #animeMainQuery.completeId2 + '_' + #animeMainQuery.reviewId + '_' + #animeMainQuery.reviewId2 " +
            "+ '_' + #animeMainQuery.leaderGender + '_' + #animeMainQuery.favoriteHeroine + '_' + #animeMainQuery.animationEnd " +
            "+ '_' + #animeMainQuery.originalEnd + '_' + #animeMainQuery.broadcastStartYear + '_' + #animeMainQuery.broadcastEndYear " +
            "+ '_' + #animeMainQuery.bingeWatchingType + '_' + #animeMainQuery.bingeWatchingYear + '_' + #animeMainQuery.bingeWatchingQuarter " +
            "+ '_' + #animeMainQuery.completeYear + '_' + #animeMainQuery.completeQuarter " +
            "+ '_' + #animeMainQuery.broadcastStartYear2 + '_' + #animeMainQuery.broadcastEndYear2 + '_' + #animeMainQuery.bingeWatchingYear2 " +
            "+ '_' + #animeMainQuery.bingeWatchingQuarter2 + '_' + #animeMainQuery.completeYear2 + '_' + #animeMainQuery.completeQuarter2 + '_' + #animeMainQuery.status + '_' + #currentPage+ '_' + #pageSize", unless = "#result == null")
    @GetMapping("/byYearQuarterCondition/{currentPage}/{pageSize}")
    public R selectMainByYearQuarterCondition(@PathVariable Integer currentPage,@PathVariable Integer pageSize, AnimeMainQuery animeMainQuery){
        PageInfo<AnimeMainQuery> pageInfo = animeMainService.selectMainByYearQuarterCondition(currentPage, pageSize, animeMainQuery);
        return new R(true, pageInfo);
    }

    /**
     * 开始追番，修改动画信息
     * @param animeMain
     */
    @CacheEvict(value = "animeMainCache", allEntries = true)
    @PutMapping("/startAnime")
    public R startAnime(@RequestBody AnimeMain animeMain) throws IOException {
        boolean flag = animeMainService.startAnime(animeMain);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    /**
     * 增加动画来源
     * @param animeMain
     */
    @CacheEvict(value = "animeMainCache", allEntries = true)
    @PutMapping("/addSource")
    public R addSource(@RequestBody AnimeMain animeMain) throws IOException {
        boolean flag = animeMainService.addSource(animeMain);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    /**
     * 延长追番，修改追番类型
     * @param animeMain
     */
    @CacheEvict(value = "animeMainCache", allEntries = true)
    @PutMapping("/extendAnime")
    public R extendAnime(@RequestBody AnimeMain animeMain) throws IOException {
        boolean flag = animeMainService.extendAnime(animeMain);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    /**
     * 番剧补完，修改动画信息
     * @param animeMain
     */
    @CacheEvict(value = "animeMainCache", allEntries = true)
    @PutMapping("/endAnime")
    public R endAnime(@RequestBody AnimeMain animeMain) throws IOException {
        boolean flag = animeMainService.endAnime(animeMain);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    /**
     * 修改动画全部信息
     * @param animeMain
     */
    @CacheEvict(value = "animeMainCache", allEntries = true)
    @PutMapping("/updateAnime")
    public R updateAnime(@RequestBody AnimeMain animeMain) throws IOException{
        boolean flag = animeMainService.updateAnime(animeMain);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }


    /**
     * 对已追动画修改它的形式
     * @param animeLayout
     */
    @CacheEvict(value = {"animeLayoutCache", "animeMainCache" }, allEntries = true)
    @PutMapping("/saveLayout")
    public R saveLayout(@RequestBody AnimeLayout animeLayout) throws IOException {
        boolean flag = animeMainService.saveLayout(animeLayout);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    /**
     * 对已追动画追更一集
     * @param animeLayout
     */
    @CacheEvict(value = {"animeLayoutCache", "animeMainCache" }, allEntries = true)
    @PutMapping("/chasingAPlay")
    public R chasingAPlay(@RequestBody AnimeLayout animeLayout) throws IOException {
        boolean flag = animeMainService.chasingAPlay(animeLayout);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    /**
     * 根据要修改动画的形式id查询
     * @param id
     * @return
     */
    @Cacheable(value = "animeLayoutCache", key = "#root.methodName + '_' + #id", unless = "#result == null")
    @GetMapping("/selectLayoutById/{id}")
    public R selectLayoutById(@PathVariable Integer id){

        return new R(true, animeMainService.selectLayoutById(id));
    }

    /**
     * 修改补番序号
     * @param
     * @return
     */
    @CacheEvict(value = "animeMainCache", allEntries = true)
    @PutMapping("/updateCompleteId")
    public R updateCompleteId(@RequestBody AnimeMain animeMain){

        return new R(true, animeMainService.updateCompleteId(animeMain));
    }

    /**
     * 修改追番序号
     * @param
     * @return
     */
    @CacheEvict(value = "animeMainCache", allEntries = true)
    @PutMapping("/updateBingeWatchingId")
    public R updateBingeWatchingId(@RequestBody AnimeMain animeMain){

        return new R(true, animeMainService.updateBingeWatchingId(animeMain));
    }

    /**
     * 修改重温序号
     * @param
     * @return
     */
    @CacheEvict(value = "animeMainCache", allEntries = true)
    @PutMapping("/updateReviewId")
    public R updateReviewId(@RequestBody AnimeMain animeMain){

        return new R(true, animeMainService.updateReviewId(animeMain));
    }

    /**
     * 删除动画
     * @param animeMain
     * @return
     * @throws IOException
     */
    @CacheEvict(value = "animeMainCache", allEntries = true)
    @PutMapping("/deleteAnime")
    public R deleteAnime(@RequestBody AnimeMain animeMain) throws IOException{
        return new R(true, animeMainService.deleteAnime(animeMain));
    }


    /**
     * 对已有动画删除形式
     * @param animeLayout
     */
    @CacheEvict(value = {"animeLayoutCache", "animeMainCache" }, allEntries = true)
    @PutMapping("/deleteAnimeLayoutById")
    public R deleteAnimeLayoutById(@RequestBody AnimeLayout animeLayout) throws IOException {
        boolean flag = animeMainService.deleteAnimeLayoutById(animeLayout);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    /**
     * 查询全部动画名称
     * @param animeMain
     * @return
     */
    @Cacheable(value = "animeMainCache", key = "#animeMain.id + '_' + #animeMain.name", unless = "#result == null")
    @GetMapping("/selectAllAnimeName")
    public R selectAllAnimeName(AnimeMain animeMain){
        List<AnimeMain> animeAllAnimeNameList = animeMainService.selectAllAnimeName(animeMain);
        return new R(true, animeAllAnimeNameList);
    }

    /**
     * 动画原作完结
     * @param animeMain
     */
    @CacheEvict(value = "animeMainCache", allEntries = true)
    @PutMapping("/updateOriginalEnd")
    public R updateOriginalEnd(@RequestBody AnimeMain animeMain) throws IOException{
        boolean flag = animeMainService.updateOriginalEnd(animeMain);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    /**
     * 动画播出跨年
     * @param animeMain
     */
    @CacheEvict(value = "animeMainCache", allEntries = true)
    @PutMapping("/overYear")
    public R overYear(@RequestBody AnimeMain animeMain) throws IOException{
        boolean flag = animeMainService.overYear(animeMain);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    /**
     * 修改动画名
     * @param animeMain
     */
    @CacheEvict(value = "animeMainCache", allEntries = true)
    @PutMapping("/updateAnimeName")
    public R updateAnimeName(@RequestBody AnimeMain animeMain) throws IOException{
        boolean flag = animeMainService.updateAnimeName(animeMain);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    /**
     * 修改动画评分
     * @param animeMain
     */
    @CacheEvict(value = "animeMainCache", allEntries = true)
    @PutMapping("/updateAnimeScore")
    public R updateAnimeScore(@RequestBody AnimeMain animeMain) throws IOException{
        boolean flag = animeMainService.updateAnimeScore(animeMain);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

}
