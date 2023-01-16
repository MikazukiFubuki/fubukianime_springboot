package com.fubukianime.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("galgame_love_type")
public class GalGameLoveType implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("love_type")
    private String loveType;

    @TableLogic(value="0",delval="1")
    //value为正常数据的值，delval为删除数据的值
    private Integer deleted;
}
