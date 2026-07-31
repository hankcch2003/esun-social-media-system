import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";


import api from "../api/axios";



function Posts() {


    const [posts, setPosts] =
        useState([]);


    const navigate =
        useNavigate();



    useEffect(() => {


        getPosts();


    }, []);



    const getPosts = async () => {


        try {


            const response =
                await api.get(
                    "/posts"
                );


            console.log(
                "Posts Response:",
                response.data
            );


            setPosts(
                response.data.data
            );


        } catch(error) {


            console.log(
                "Get Posts Error:",
                error
            );


        }


    };



    const deletePost = async (postId) => {


        try {


            await api.delete(
                `/posts/${postId}`
            );


            alert(
                "Delete Success"
            );


            getPosts();


        } catch(error) {


            console.log(
                "Delete Error:",
                error
            );


            alert(
                error.response?.data?.message
                ||
                "Delete Failed"
            );


        }


    };



    return (

        <div className="app-container">


            <h2>
                Posts
            </h2>



            {
                posts.map(
                    post => (


                        <div
                            key={post.id}
                            className="post-card"
                        >



                            <h3>
                                {post.content}
                            </h3>



                            {
                                post.image &&
                                <p className="post-image">
                                    Image:
                                    {" "}
                                    {post.image}
                                </p>
                            }



                            <div
                                className="post-actions"
                            >



                                <button

                                    onClick={
                                        () =>
                                            navigate(
                                                `/posts/${post.id}`
                                            )
                                    }

                                >

                                    View Comments

                                </button>



                                {" "}



                                <button

                                    onClick={
                                        () =>
                                            navigate(
                                                `/posts/${post.id}/edit`
                                            )
                                    }

                                >

                                    Edit

                                </button>



                                {" "}



                                <button

                                    className="danger-button"

                                    onClick={
                                        () =>
                                            deletePost(
                                                post.id
                                            )
                                    }

                                >

                                    Delete

                                </button>



                            </div>



                        </div>


                    )
                )
            }



        </div>

    );

}


export default Posts;