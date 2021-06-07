import axios from "axios";
import { useState } from "react";

const LoginForm = () => {
    const [id,setId] = useState('');
    const [pw,setPw] = useState('');
    const submit = (e)=>{
        e.preventDefault();
        axios.post('http://localhost:8080/login',{id,pw})
        .then(res =>{
            console.log(res.data)
            localStorage.setItem("Atoken",res.data.AToken)
            localStorage.setItem("Rtoken",res.data.RToken)
            localStorage.setItem("username",id)
        }).catch(e =>{
            console.log(e.message)
        })
    }
    return ( 
        <div className="login">
            <form onSubmit={submit}>
                <label>ID</label>
                <input className="loginInput"
                type ="text"
                value = {id}
                required
                onChange ={(e) => setId(e.target.value)}
                ></input>
                <label>  </label>
                <label>PW</label>
                <input className="loginInput"
                type = "password"
                value = {pw}
                required
                onChange={(e) =>setPw(e.target.value)}></input>
                <label>  </label>
                <button>login</button>
            </form>
        </div>
    );
}
 
export default LoginForm;