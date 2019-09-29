package com.vcommunity.model;

import lombok.Data;

/**
 * @author ：mingV
 * @description：
 * @date ：Created in 2019/9/18 23:51
 */
@Data
public class User  {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;
}
