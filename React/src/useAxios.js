import axios from 'axios';
import {useEffect, useState} from 'react';
const axiosInstance = axios.create({
    baseURL:'http://localhost:8080/',
    headers: {'Content-Type':'application/json',
'Authoration':localStorage.getItem("Rtoken")}
});

const useAxios = (url,param,method) =>{
    const [data,setData] = useState(null);
    
    useEffect(()=>{
        
        .then(res =>{
            console.log(res.data)
            localStorage.setItem("Atoken",res.data.AToken);
            localStorage.setItem("Rtoken",res.data.RToken);
            localStorage.setItem("username",id);
            history.push('/');
        }).catch(err =>{
            console.log(err.response.data.message)
            var message =""
            switch(err.response.data.message){
                case "PASSWORD_NOT_FOUND":
                    message = "패스워드를 찾을 수 없습니다.";
                    break;
                case "ID_NOT_FOUND":
                    message = "아이디를 찾을 수 없습니다."
                    break;
                default:
            }
            alert(message)
        })
    })
}