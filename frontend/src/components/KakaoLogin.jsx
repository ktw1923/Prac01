import React, { useEffect } from 'react';

const KakaoLoginComponent = () => {
    useEffect(() => {
        // Kakao SDK 초기화
        window.Kakao.init('968999b5870ed199c9714edd0e7e2e63');
    }, []);

    const handleLogin = () => {
        window.Kakao.Auth.authorize({
            redirectUri: 'http://localhost:8080/kakao/callback'
        });
    };

    return (
        <div>
            <button onClick={handleLogin}>Login with Kakao</button>
        </div>
    );
};

export default KakaoLoginComponent;
