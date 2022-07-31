package com.fubukianime.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("anime_favorite_girl_rank")
public class AnimeFavoriteGirlRank implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("season")
    private String season;
    @TableField("time")
    private String time;
    @TableField("ranking")
    private String ranking;
    @TableField("name")
    private String name;
    @TableField("cv")
    private String cv;


    @TableLogic(value="0",delval="1")
    //value为正常数据的值，delval为删除数据的值
    private Integer deleted;
}


