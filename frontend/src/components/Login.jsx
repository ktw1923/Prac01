import React from 'react';
import { GoogleOAuthProvider, GoogleLogin } from '@react-oauth/google';
import axios from 'axios';

const clientId = '975411602786-m61p0e7053pnrpi7j4gl92ftmdpjkj8u.apps.googleusercontent.com'; // 여기에 새로 생성한 클라이언트 ID를 입력하세요

const Login = () => {
    const onSuccess = async (response) => {
        const { credential } = response;
        try {
            const res = await axios.post('http://localhost:8080/api/google-login', { tokenId: credential });
            console.log('Google login success', res.data);
        } catch (error) {
            console.error('Google login error', error);
        }
    };

    const onError = (response) => {
        console.error('Google login failed', response);
    };

    return (
        <GoogleOAuthProvider clientId={clientId}>
            <div>
                <h2>Login</h2>
                <GoogleLogin
                    onSuccess={onSuccess}
                    onError={onError}
                    useOneTap
                />
            </div>
        </GoogleOAuthProvider>
    );
};

export default Login;
