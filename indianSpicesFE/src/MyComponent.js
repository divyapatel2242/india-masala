import React, { useState, useEffect } from 'react';
import axios from 'axios';

const MyComponent = () => {
    const [responseData, setResponseData] = useState('');

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = axios.get('http://localhost:8080/loginPage/');
                setResponseData(response.data); // Set the string response to state
            } catch (error) {
                console.error('Error fetching data:', error);
            }
        };

        fetchData();
    }, []);

    return (
        <div>
            <h1>Response from Spring Backend:</h1>
            <p>{responseData}</p> {/* Render the string response */}
        </div>
    );
};

export default MyComponent;
