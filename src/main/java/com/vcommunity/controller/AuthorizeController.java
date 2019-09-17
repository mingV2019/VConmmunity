package com.vcommunity.controller;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.vcommunity.dto.AccessTokenDTO;
import com.vcommunity.dto.GithubUser;
import com.vcommunity.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：mingV
 * @description：
 * @date ：Created in 2019/9/15 22:59
 */
@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUrl;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUrl);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        if (user != null) {
            //登录成功，写cookie和session
            request.getSession().setAttribute("user",user);
            return "redirect:/";
        } else {
            //登录失败，重新登陆
            return "redirect:/";

        }
//        System.out.println(user.getName());
    }
}
