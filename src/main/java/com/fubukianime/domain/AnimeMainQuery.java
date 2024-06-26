package com.fubukianime.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName anime_main
 */
@TableName(value ="anime_main")
@Data
public class AnimeMainQuery extends AnimeMain implements Serializable {

    /**
     * 动画评分
     */
   private Double score2;

    /**
     * 动画补完序号
     */
    private Integer completeId2;

    /**
     * 动画追番序号
     */
    private Integer bingeWatchingId2;

    /**
     * 动画重温序号
     */
    private Integer reviewId2;


    /**
     * 动画播出起始年份
     */
    private String broadcastStartYear2;

    /**
     * 动画播出最终年份
     */
    private String broadcastEndYear2;

    /**
     * 动画补完季
     */
    private String completeQuarter2;

    /**
     * 动画追番季
     */
    private String bingeWatchingQuarter2;

    /**
     * 动画追番年
     */
    private String bingeWatchingYear2;

    /**
     * 动画补完年
     */
    private String completeYear2;

}