package com.fubukianime.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fubukianime.domain.AnimeMain;
import com.fubukianime.domain.AnimePeriod;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class AnimePeriodDaoTest {

    @Autowired
    private AnimePeriodDao animePeriodDao;


//    @Test
//    public void testGetAll(){
//        Page<AnimeMain> page = new Page<>(148,10);
//        IPage<AnimeMain> animeMainList = animePeriodDao.selectMainAll(page);
//        System.out.println(animeMainList);
//    }

//    @Test
//    public void testSelectByCondition() throws IOException {
//        //接收参数
//        String name = "血";
//        //方式二 ：接口方法参数是 实体类对象 方式调用的方法
//        //封装对象
//        AnimeMain animeMain = new AnimeMain();
//        animeMain.setName(name);
////        QueryWrapper<AnimeMain> queryWrapper = new QueryWrapper<>();
////        queryWrapper.like("name", "a");
//        List<AnimeMain> list = animeMainDao.selectMainByCondition(animeMain);
//        System.out.println(list);;
//        //animeMain.setName(name);*/
//
//        /*Page<AnimeMain> page = new Page<>(1,10);
//        QueryWrapper<AnimeMain> wrapper = new QueryWrapper<>();
//        wrapper.like("name", "你");
//        *//*Page<AnimeMain> page = new Page<>(1,10);*//*
//        List<AnimeMain> ipage = animeMainDao.selectMainByCondition(page, wrapper);
//
//
//        System.out.println(ipage);
//*/
//
//
//        //4. 执行方法
//        //方式三 ：接口方法参数是 map集合对象 方式调用的方法
//        /*Page<AnimeMain> page = new Page<>(1,10);
//        IPage<AnimeMain> ipage = animeMainDao.selectMainByCondition(page);
//        System.out.println(ipage);*/
//
//    }

    /*@Test
    void testGetById() {
        AnimeMain animeMain = animeMainDao.selectMainById(1482);
        System.out.println(animeMain);
    }*/
/*
    //分页查询
    @Test
    void testSelectPage(){
        //1 创建IPage分页对象,设置分页参数,1为当前页码，3为每页显示的记录数
        IPage<AnimeMain> page=new Page(2, 10);
        //2 执行分页查询
        animeMainDao.selectPage(page,null);
        //3 获取分页结果
        System.out.println("当前页码值："+page.getCurrent());
        System.out.println("每页显示数："+page.getSize());
        System.out.println("一共多少页："+page.getPages());
        System.out.println("一共多少条数据："+page.getTotal());
        System.out.println("数据："+page.getRecords());
    }*/


    /*@Test
    void testDelete(){
        animeMainDao.deleteById(1481L);
    }*/

    /*@Test
    public void testAll(){
        List<AnimePeriod> animePeriodList = animePeriodDao.selectComPeriod();
        System.out.println(animePeriodList);
    }*/

    /*@Test
    public void testGetAll1(){
        AnimeMainQuery aq = new AnimeMainQuery();
        aq.setBroadcastStartYear("70");
        aq.setBroadcastStartYear2("72");
        LambdaQueryWrapper<AnimeMain> lqw = new LambdaQueryWrapper<AnimeMain>();
        if (null != aq.getBroadcastStartYear2()){
            lqw.lt(AnimeMain::getBroadcastStartYear, aq.getBroadcastStartYear2());
        }
        if (null != aq.getBroadcastStartYear()){
            lqw.gt(AnimeMain::getBroadcastStartYear, aq.getBroadcastStartYear());
        }
        List<AnimeMain> list = animeMainDao.selectList(lqw);
        System.out.println(list);
    }*/



}
