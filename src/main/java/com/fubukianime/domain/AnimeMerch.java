package com.fubukianime.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;

@Data
public class AnimeMerch implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("anime_name")
    private String animeName;
    @TableField("merch")
    private String merch;
    @TableField("status")
    private String status;

    @TableLogic(value="0",delval="1")
    //value为正常数据的值，delval为删除数据的值
    private Integer deleted;
}
