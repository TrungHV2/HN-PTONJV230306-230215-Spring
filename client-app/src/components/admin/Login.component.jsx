import React, { useState } from 'react'
import axios from 'axios'
import {Navigate, useNavigate} from 'react-router-dom';

export default function Login() {
    const [username, setUsername] = useState('customer');
    const [password, setPassword] = useState('123456');
    const navigate = useNavigate();
    
    const btnLoginClick = () => {
        console.log('Login...');
        axios.post('http://localhost:8181/token', {
            username: username,
            password: password
        }).then(res => {
            console.log(res);
            sessionStorage.setItem('token', res.data.token);
            navigate('/admin', {replace: true});
        });
    }

    return (
        <div>
            <h1>Login Admin</h1>
            <p><input type="text" onChange={e => setUsername(e.target.value)} value={username} placeholder="Tài khoản...."/></p>
            <p><input type="text" onChange={e => setPassword(e.target.value)} value={password} placeholder="Mật khẩu...."/></p>
            <button onClick={e => btnLoginClick()}>Đăng nhập</button>
        </div>
    )
}
