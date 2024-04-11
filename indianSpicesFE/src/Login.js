// Login.js

import React, { useState } from 'react';
import './Login.css'; // Import CSS file for styles
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const Login = () => {
    const navigate = useNavigate();
    const [formData, setFormData] = useState({
        username: '',
        password: ''
    });
    // const [loginInfo, setLoginInfo] = useState(null);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log('Form Data:', formData);
        try {
            const response = axios.post('http://localhost:8080/loginPage/login', { // Replace with your backend endpoint
                username: formData.username,
                password: formData.password
            });
            if (!response.ok) {
                throw new Error('Failed to login');
            }
            console.log('Login successful');
            // const data = await response.json(); // Parse response data as JSON
            // Handle successful login
            //setLoginInfo(response.data);
           
        } catch (error) {
            console.error('Error logging in:', error);
            // Handle login error
        }
        navigate('/products');
    };

    return (
        <div className="login-container">
            <div className="login-header">
                <h1>Login</h1>
            </div>
            <form className="login-form" onSubmit={handleSubmit}>
                <div className="input-container">
                    <label htmlFor="username">Username</label>
                    <input
                        type="text"
                        id="username"
                        name="username"
                        placeholder="Enter your username"
                        value={formData.username}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="input-container">
                    <label htmlFor="password">Password</label>
                    <input
                        type="password"
                        id="password"
                        name="password"
                        placeholder="Enter your password"
                        value={formData.password}
                        onChange={handleChange}
                        required
                    />
                </div>
                <button type="submit">Login</button>
            </form>
        </div>
    );
};

export default Login;
