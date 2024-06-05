import React, { useState, useEffect } from 'react';

function App() {
    const [messages, setMessages] = useState([]);
    const [ws, setWs] = useState(null);

    useEffect(() => {
        const socket = new WebSocket('ws://localhost:8080/ws');

        socket.onopen = () => {
            console.log('WebSocket connection established');
            setWs(socket); // WebSocket 객체를 상태로 설정
        };

        socket.onmessage = (event) => {
            setMessages(prevMessages => [...prevMessages, event.data]);
        };

        socket.onclose = () => {
            console.log('WebSocket connection closed');
        };

        socket.onerror = (error) => {
            console.error('WebSocket error:', error);
        };

        // WebSocket 연결을 닫기 전에 상태를 확인
        return () => {
            if (socket.readyState === WebSocket.OPEN) {
                socket.close();
            }
        };
    }, []);

    const sendMessage = () => {
        if (ws && ws.readyState === WebSocket.OPEN) {
            ws.send('Hello, WebSocket!');
            setMessages(prevMessages => [...prevMessages, 'Sent: Hello, WebSocket!']);
        }
    };

    return (
        <div>
            <h1>WebSocket Messages</h1>
            <ul>
                {messages.map((message, index) => (
                    <li key={index}>{message}</li>
                ))}
            </ul>
            <button onClick={sendMessage}>Send Message</button>
        </div>
    );
}

export default App;
