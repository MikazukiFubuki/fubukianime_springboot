package com.fubukianime.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fubukianime.dao.AnimeMainDao;
import com.fubukianime.domain.AnimeMain;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
public class AnimeMainServiceTest {
    @Autowired
    private AnimeMainService animeMainService;
    @Autowired
    private AnimeMainDao animeMainDao;
    /*@Test
    void testFindAll() {
        List<AnimeMain> list = animeMainService.list();
        System.out.println(list);
    }*/



//    @Test
//    void testSelectMainAll() {
//        List<AnimeMain> list = animeMainService.selectMainAll(1,10);
//        System.out.println(list);
//    }

    /*@Test
    void testFindById(){
        AnimeMain animeMain = animeMainService.getById(1L);
        System.out.println(animeMain);
    }*/
/*
    @Test
    void testSelectMainById(){
        AnimeMain animeMain = animeMainService.selectMainById(1);
        System.out.println(animeMain);
    }*/

    /*@Test
    public void testSelectByCondition() throws IOException {
        //接收参数
        String name = "你";


        // 处理参数
        name = "%" + name + "%";

//方式二 ：接口方法参数是 实体类对象 方式调用的方法
        //封装对象
        AnimeMain animeMain = new AnimeMain();
        animeMain.setName(name);
        LambdaQueryWrapper<AnimeMain> lqw = new LambdaQueryWrapper<AnimeMain>();
        lqw.like(Strings.isNotEmpty(animeMain.getName()), AnimeMain::getName, animeMain.getName());



        //4. 执行方法
        //方式三 ：接口方法参数是 map集合对象 方式调用的方法
        List<AnimeMain> animeMains = (List<AnimeMain>) animeMainService.selectMainByCondition(1, 100, animeMain);
        System.out.println(animeMains);

    }*/

    @Test
    public void testSelectByCondition() throws IOException {
        //接收参数
        String name = "血";
        //方式二 ：接口方法参数是 实体类对象 方式调用的方法
        //封装对象
        AnimeMain animeMain = new AnimeMain();
        animeMain.setName(name);
//        QueryWrapper<AnimeMain> queryWrapper = new QueryWrapper<>();
//        queryWrapper.like("name", "a");


        PageHelper.startPage(1, 10);
        List<AnimeMain> animeMainList = animeMainDao.selectMainByCondition(animeMain);
        PageInfo<AnimeMain> animeMainPageInfo = new PageInfo<>(animeMainList, 10);
        System.out.println(animeMainPageInfo);

    }


}
