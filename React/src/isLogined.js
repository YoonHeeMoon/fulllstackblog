import axios from "axios";

const isLogined = () =>{
    var RToken = localStorage.getItem("Rtoken")
    if(RToken == null){
        return false;
    }else{
       axios.get('http://localhost:8080/token/exp',{params:{
           token:RToken}})
       .then(res =>{
        console.log(res.data)
       })
    }
}
export default isLogined;