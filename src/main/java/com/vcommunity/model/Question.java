package com.vcommunity.model;

import lombok.Data;

/**
 * @author ：mingV
 * @description：
 * @date ：Created in 2019/9/28 23:48
 */
@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
}
