import {useState} from 'react';

const useAxios = (url,param,method) =>{
    const [data,setData] = useState(null);
    const [isPending, setIsPending] = useState(true);
    const [error, setError] = useState(null);
}