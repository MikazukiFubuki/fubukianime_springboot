package com.fubukianime.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("comic_main")
public class ComicMain implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("author")
    private String author;

    @TableField("content")
    private String content;

    @TableField("type")
    private String type;

    @TableField(exist = false)
    private String layout;

    @TableField("episodes")
    private Integer episodes;

    @TableField("sex")
    private String sex;

    @TableField("dimensional")
    private String dimensional;

    @TableField("status")
    private String status;

    @TableLogic(value="0",delval="1")
    //value为正常数据的值，delval为删除数据的值
    private Integer deleted;
}
