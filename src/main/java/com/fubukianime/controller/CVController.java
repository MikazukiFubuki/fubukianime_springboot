package com.fubukianime.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.CvCV;
import com.fubukianime.domain.CvWorks;
import com.fubukianime.service.CvCVService;
import com.fubukianime.service.CvWorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/cvs")
public class CVController {
    @Autowired
    private CvCVService cvCVService;

    @Autowired
    private CvWorksService cvWorksService;

    @Autowired
    private CacheManager cacheManager;

    @Cacheable(value = "cvCache", key = "#root.methodName  +  '_' + #cvCV.name +  '_' + #cvCV.hiragana +  '_' + #cvCV.sex +  '_' + #cvCV.anotherName+  '_' + #cvCV.company +  '_' + #cvCV.birthday +  '_' + #cvCV.debutYear +  '_' + #cvCV.lived +  '_' + #cvCV.deathDay ", unless = "#result == null")
    @GetMapping("/selectCVByCondition")
    public R selectCVByCondition(CvCV cvCV) {
        List<CvCV> list = cvCVService.selectCVByCondition(cvCV);
        return new R(true, list);
    }

    @Cacheable(value = "cvCache", key = "#root.methodName  +  '_' + #cvCV.name +  '_' + #cvCV.hiragana +  '_' + #cvCV.sex +  '_' + #cvCV.anotherName+  '_' + #cvCV.company +  '_' + #cvCV.birthday +  '_' + #cvCV.debutYear +  '_' + #cvCV.lived +  '_' + #cvCV.deathDay ", unless = "#result == null")
    @GetMapping("/selectCVByConditionLive")
    public R selectCVByConditionLive(CvCV cvCV) {
        List<CvCV> list = cvCVService.selectCVByConditionLive(cvCV);
        return new R(true, list);
    }

    @Cacheable(value = "cvCache", key = "#root.methodName  +  '_' + #cvCV.name +  '_' + #cvCV.hiragana +  '_' + #cvCV.sex +  '_' + #cvCV.anotherName+  '_' + #cvCV.company +  '_' + #cvCV.birthday +  '_' + #cvCV.debutYear +  '_' + #cvCV.lived +  '_' + #cvCV.deathDay ", unless = "#result == null")
    @GetMapping("/selectCVByConditionDead")
    public R selectCVByConditionDead(CvCV cvCV) {
        List<CvCV> list = cvCVService.selectCVByConditionDead(cvCV);
        return new R(true, list);
    }

    @Cacheable(value = "cvCache", key = "#root.methodName  +  '_' + #cvCV.name", unless = "#result == null")
    @GetMapping("/selectCVName")
    public R selectCVName(CvCV cvCV) {
        List<CvCV> list = cvCVService.selectCVName(cvCV);
        return new R(true, list);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Cacheable(value = "cvCache", key = "#root.methodName + '_' + #id", unless = "#result == null")
    @GetMapping("/selectCVById/{id}")
    public R selectCVById(@PathVariable Integer id){
        return new R(true, cvCVService.selectCVById(id));
    }

    @CacheEvict(value = "cvCache", allEntries = true)
    @PostMapping("/addCV")
    public R addCV(@RequestBody CvCV cvCV) throws IOException {
        boolean flag = cvCVService.addCV(cvCV);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @CacheEvict(value = "cvCache", allEntries = true)
    @PutMapping("/updateCV")
    public R updateCV(@RequestBody CvCV cvCV) {
        boolean flag = cvCVService.updateCV(cvCV);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @CacheEvict(value = "cvCache", allEntries = true)
    @PutMapping("/updateCVdeath")
    public R updateCVdeath(@RequestBody CvCV cvCV) {
        boolean flag = cvCVService.updateCVdeath(cvCV);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @CacheEvict(value = "cvCache", allEntries = true)
    @PutMapping("/cvRemove")
    public R removeById(@RequestBody CvCV cvCV){
        boolean flag = cvCVService.removeById(cvCV);
        return new R(flag, flag ? "删除成功^_^" : "删除失败-_-!");
    }

    @Cacheable(value = "cvCache", key = "#root.methodName  +  '_' + #cvWorks.cvName +  '_' + #cvWorks.animeId+  '_' + #cvWorks.animeRole +  '_' + #cvWorks.year", unless = "#result == null")
    @GetMapping("/selectCvWorks")
    public R selectCvWorks(CvWorks cvWorks) {
        List<CvWorks> list = cvWorksService.selectCvWorks(cvWorks);
        return new R(true, list);
    }

    @Cacheable(value = "cvCache", key = "#root.methodName  +  '_' + #cvWorks.cvName +  '_' + #cvWorks.animeId+  '_' + #cvWorks.animeRole +  '_' + #cvWorks.year", unless = "#result == null")
    @GetMapping("/selectAfterAdd")
    public R selectAfterAdd(CvWorks cvWorks) {
        List<CvWorks> list = cvWorksService.selectAfterAdd(cvWorks);
        return new R(true, list);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Cacheable(value = "cvCache", key = "#root.methodName + '_' + #id", unless = "#result == null")
    @GetMapping("/selectCvWorksById/{id}")
    public R selectCvWorksById(@PathVariable Integer id){
        return new R(true, cvWorksService.selectCvWorksById(id));
    }

    @CacheEvict(value = "cvCache", allEntries = true)
    @PostMapping("/addCvWorks")
    public R addCvWorks(@RequestBody CvWorks cvWorks) {
        CvWorks cvWorks1 = cvWorksService.checkCvWorks(cvWorks);
        /*LambdaQueryWrapper<CvWorks> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CvWorks::getAnimeId, cvWorks.getAnimeId());
        queryWrapper.eq(CvCV::getId, cvWorks.getCvName());
        CvWorks cvWorks1 = cvWorksService.getOne(queryWrapper);*/

        if (cvWorks1 != null){
            boolean flag = false;
            return new R(flag, "此声优在此动画已创建角色");
        }else {
            boolean flag = cvWorksService.addCvWorks(cvWorks);
            return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
        }
    }

    @CacheEvict(value = "cvCache", allEntries = true)
    @PutMapping("/updateCvWorks")
    public R updateCvWorks(@RequestBody CvWorks cvWorks) {
        boolean flag = cvWorksService.updateCvWorks(cvWorks);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @CacheEvict(value = "cvCache", allEntries = true)
    @PutMapping("/updateYear")
    public R updateYear(@RequestBody CvWorks cvWorks) {
        boolean flag = cvWorksService.updateYear(cvWorks);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @CacheEvict(value = "cvCache", allEntries = true)
    @PutMapping("/updateRole")
    public R updateRole(@RequestBody CvWorks cvWorks) {
        boolean flag = cvWorksService.updateRole(cvWorks);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @CacheEvict(value = "cvCache", allEntries = true)
    @PutMapping("/worksRemove")
    public R removeById(@RequestBody CvWorks cvWorks) {
        boolean flag = cvWorksService.removeById(cvWorks);
        return new R(flag, flag ? "删除成功^_^" : "删除失败-_-!");
    }
}
