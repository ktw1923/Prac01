package org.bit.controller;

import org.bit.util.GoogleIdTokenVerifierUtil;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {


    @PostMapping("/google-login")
    public ResponseEntity<String> googleLogin(@RequestBody Map<String, String> request) {
        String tokenId = request.get("tokenId");
        try {
            GoogleIdToken idToken = GoogleIdTokenVerifierUtil.verifyToken(tokenId);
            if (idToken != null) {
                GoogleIdToken.Payload payload = idToken.getPayload();
                String userId = payload.getSubject();
                String email = payload.getEmail();
                boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
                String name = (String) payload.get("name");
                String pictureUrl = (String) payload.get("picture");

                // 사용자 정보 저장 또는 세션 생성 로직 추가
                return ResponseEntity.ok("Google login successful for user: " + email);
            } else {
                return ResponseEntity.status(401).body("Invalid ID token.");
            }
        } catch (GeneralSecurityException | IOException e) {
            return ResponseEntity.status(500).body("Failed to verify ID token.");
        }
    }
}
