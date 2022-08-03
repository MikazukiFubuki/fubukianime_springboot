package com.fubukianime.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("music_main")
public class MusicMain implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("music_name")
    private String musicName;

    @TableField("anime_name")
    private String animeName;

    @TableField("type")
    private String type;

    @TableField("time")
    private String time;

    @TableField("singer")
    private String singer;

    @TableField("score")
    private Integer score;

    @TableField("form")
    private String form;

    @TableField("source")
    private String source;

    @TableField("downloadType")
    private String downloadType;

    @TableField("addType")
    private String addType;

    @TableField("year")
    private String year;

    @TableField("quarter")
    private String quarter;

    @TableField(exist = false)
    private String bingeTime;

    @TableLogic(value="0",delval="1")
    //value为正常数据的值，delval为删除数据的值
    private Integer deleted;
}
