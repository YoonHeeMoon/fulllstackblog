import axios from 'axios';
import {useEffect, useState} from 'react';

const axiosInstance = axios.create({
    baseURL:'http://localhost:8080/',
    headers: {'Content-Type':'application/json',
'Authorization':localStorage.getItem("Rtoken")}
});

const UseAxios = (url,param,method) =>{
    const [data,setData] = useState(null);
    const [error, setError] = useState(null);
    
    useEffect(()=>{
        axiosInstance.request({
            url:url,
            params:param,
            method:method
        })
        .then(res =>{
            console.log(res.json());
            return res.json();
        }).then(data =>{
            setData(data);
        }).catch(err =>{
            setError(err.response.data.message)
        })
    },[url,param,method]);
    return {data, error}
}

export default UseAxios;