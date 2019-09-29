package com.vcommunity.dto;

import lombok.Data;

/**
 * @author ：mingV
 * @description：
 * @date ：Created in 2019/9/15 23:21
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
