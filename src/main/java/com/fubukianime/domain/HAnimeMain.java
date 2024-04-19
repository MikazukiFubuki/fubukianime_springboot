package com.fubukianime.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("hanime_main")
public class HAnimeMain implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("content")
    private String content;

    @TableField("type")
    private String type;

    @TableField(exist = false)
    private String layout;

    @TableField("layout_type")
    private String layoutType;

    @TableField("episodes")
    private Integer episodes;

    @TableField("dimensional")
    private String dimensional;

    @TableField("sex_limit")
    private String sexLimit;

    @TableField("status")
    private String status;

    @TableField("embyId")
    private Integer embyId;

    @TableLogic(value="0",delval="1")
    //value为正常数据的值，delval为删除数据的值
    private Integer deleted;
}
