import { useState } from "react";
//import { useHistory } from "react-router";
import UseAxios from './UseAxios';

const LoginForm = (props) => {
    const [id,setId] = useState('');
    const [pw,setPw] = useState('');
    //const history = useHistory();

    const submit = (e)=>{
        e.preventDefault();
        // setData()
        props.setIsLoggedIn(true);
        //const {data:isLoggedIn,error} = UseAxios('login',{id:id,pw:pw},'post');
        // axios.post('http://localhost:8080/login',{id,pw})
        // .then(res =>{
        //     console.log(res.data)
        //     localStorage.setItem("Atoken",res.data.AToken);
        //     localStorage.setItem("Rtoken",res.data.RToken);
        //     localStorage.setItem("username",id);
        //     history.push('/');
        // }).catch(err =>{
        //     console.log(err.response.data.message)
        //     var message =""
        //     switch(err.response.data.message){
        //         case "PASSWORD_NOT_FOUND":
        //             message = "패스워드를 찾을 수 없습니다.";
        //             break;
        //         case "ID_NOT_FOUND":
        //             message = "아이디를 찾을 수 없습니다."
        //             break;
        //         default:

        //     }
        //     alert(message)
        // })
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