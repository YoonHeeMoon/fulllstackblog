import {Link} from 'react-router-dom';
import LoginForm from './LoginForm';

const Navbar = () => {
    return (
        <nav className="navbar">
            <h1> the blog</h1>
            <div className="links">
                <Link className="left" to="/">home</Link>
                <Link className="left" to="/create">new blog</Link>
                <div className="loginDiv">
                    <LoginForm/>
                </div>
            </div>
        </nav>
    );
}
 
export default Navbar;