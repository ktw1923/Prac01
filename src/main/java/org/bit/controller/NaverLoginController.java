package org.bit.controller;

import org.bit.service.NaverOAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class NaverLoginController {

    @Autowired
    private NaverOAuthService naverOAuthService;

    @GetMapping("/naver/callback")
    public Map<String, Object> naverCallback(@RequestParam String code, @RequestParam String state) {
        return naverOAuthService.getNaverUserInfo(code, state);
    }
}
