
import React, { useEffect, useState } from 'react';
import axios from 'axios';

const Products = () => {
    const [data, setData] = useState([]);

    useEffect(() => {
        fetchData();
    }, []);

    const fetchData = async () => {
        try {
            const response = axios.get('http://localhost:8080/products/'); // Replace with your backend API endpoint
            setData(response.data);
        } catch (error) {
            console.error('Error fetching data:', error);
        }
    };

    return (
        <div>
            <h1>Home Page</h1>
            <h2>List of Data</h2>
            <ul>
                {data.map(item => (
                    <li key={item.id}>{item.name}</li>
                ))}
            </ul>
        </div>
    );
};

export default Products;
