package org.bit.controller;

import org.bit.service.KakaoOAuthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class KakaoLoginController {

    private KakaoOAuthService kakaoOAuthService;

    @GetMapping("/kakao/callback")
    public Map<String, Object> kakaoCallback(@RequestParam String code) {
        return kakaoOAuthService.getKakaoUserInfo(code);
    }
}
