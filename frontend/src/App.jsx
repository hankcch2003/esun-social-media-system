import {
  BrowserRouter,
  Routes,
  Route,
  Navigate
} from "react-router-dom";


import Login from "./pages/Login";
import Posts from "./pages/Posts";
import CreatePost from "./pages/CreatePost";
import PostDetail from "./pages/PostDetail";
import EditPost from "./pages/EditPost";



function App() {


  return (


      <BrowserRouter>


        <Routes>



          <Route
              path="/"
              element={
                <Navigate to="/login" />
              }
          />



          <Route
              path="/login"
              element={<Login />}
          />



          <Route
              path="/posts"
              element={<Posts />}
          />



          <Route
              path="/posts/:postId"
              element={<PostDetail />}
          />



          <Route
              path="/posts/:postId/edit"
              element={<EditPost />}
          />



          <Route
              path="/create-post"
              element={<CreatePost />}
          />



        </Routes>


      </BrowserRouter>


  );

}


export default App;