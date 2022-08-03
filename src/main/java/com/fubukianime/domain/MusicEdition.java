package com.fubukianime.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("music_edition")
public class MusicEdition implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("large_version")
    private Integer largeVersion;
    @TableField("minor_version")
    private Integer minorVersion;
    @TableField("content")
    private String content;
    @TableField("new_content")
    private String newContent;
    @TableField("obsolete_content")
    private String obsoleteContent;
    @TableField("online_time")
    private String onlineTime;
    @TableField(exist = false)
    private String version;

    @TableLogic(value="0",delval="1")
    //value为正常数据的值，delval为删除数据的值
    private Integer deleted;
}
