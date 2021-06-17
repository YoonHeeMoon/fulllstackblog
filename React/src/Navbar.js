import { useState } from 'react';
import {Link} from 'react-router-dom';
import LoginForm from './LoginForm';
import LogoutForm from './LogoutForm';

const Navbar = () => {
    
    const isLoggedIn = useState(true);
    let form;
    if(isLoggedIn){
        form = <LoginForm />
    }else{
        form = <LogoutForm/>
    }
    return (
        <nav className="navbar">
            <h1> the blog</h1>
            <div className="links">
                <Link className="left" to="/">home</Link>
                <Link className="left" to="/create">new blog</Link>
                <div className="loginDiv">
                    {form}
                </div>
            </div>
        </nav>
    );
}
 
export default Navbar;