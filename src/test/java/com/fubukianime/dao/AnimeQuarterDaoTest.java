package com.fubukianime.dao;

import com.fubukianime.domain.AnimeQuarter;
import com.fubukianime.domain.Quarter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AnimeQuarterDaoTest {

    @Autowired
    private AnimeQuarterDao animeQuarterDao;


//    @Test
//    public void testGetAll(){
//        AnimeQuarter animeQuarter = new AnimeQuarter();
//        List<AnimeQuarter> animeQuarterList = animeQuarterDao.selectComQuarter(animeQuarter);
//        System.out.println(animeQuarterList);
//    }

    /*@Test
    void testGetById() {
        AnimeQuarter animeQuarter = animeQuarterDao.selectById(1L);
        System.out.println(animeQuarter);
    }*/
}
