package com.vcommunity.controller;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.vcommunity.dto.AccessTokenDTO;
import com.vcommunity.dto.GithubUser;
import com.vcommunity.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ：mingV
 * @description：
 * @date ：Created in 2019/9/15 22:59
 */
@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("918b177f86ac48592efb");
        accessTokenDTO.setClient_secret("230580e6abf95d39898c0024e93eb4469a86eef8");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8080/callback");
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}
