package com.fubukianime.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("galgame_reborn_type")
public class GalGameRebornType implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("reborn_type")
    private String rebornType;

    @TableLogic(value="0",delval="1")
    //value为正常数据的值，delval为删除数据的值
    private Integer deleted;
}
