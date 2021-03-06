import BlogList from './BlogList';
import useFetch from './usefetch';


const Home = () => {
    const {data : blogs, isPending, error} = useFetch('http://localhost:8080/blogs');
    console.log(blogs)
    return ( 
        <div className="home">
            {error && <div> {error} </div>}
            {isPending && <div>Loading</div>}
            {blogs && <BlogList blogs={blogs} title="All blogs" />}
        </div>
     );
}
 
export default Home;