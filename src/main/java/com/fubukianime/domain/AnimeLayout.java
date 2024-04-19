package com.fubukianime.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("anime_layout")
public class AnimeLayout implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("`layout_id`")
    private Integer layoutId;
    @TableField("layout_type_id")
    private String layoutTypeId;
    @TableField("another_name")
    private String anotherName;
    @TableField("quarter_num")
    private Integer quarterNum;
    @TableField("part")
    private Integer part;
    @TableField("episodes")
    private Integer episodes;
    @TableField("embyId")
    private Integer embyId;
    @TableField(exist = false)
    private String name;

    @TableLogic(value="0",delval="1")
    //value为正常数据的值，delval为删除数据的值
    private Integer deleted;
}
