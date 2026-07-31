import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import api from "../api/axios";


function PostDetail() {


    const { postId } =
        useParams();


    const [comments, setComments] =
        useState([]);


    const [content, setContent] =
        useState("");



    useEffect(() => {


        getComments();


    }, []);



    const getComments = async () => {


        try {


            const response =
                await api.get(
                    `/comments/post/${postId}`
                );


            console.log(
                "Comments:",
                response.data
            );


            setComments(
                response.data.data
            );


        } catch(error) {


            console.log(
                "Get Comments Error:",
                error
            );


        }


    };



    const createComment = async () => {


        try {


            await api.post(
                "/comments",
                {
                    postId,
                    content
                }
            );



            alert(
                "Comment Success"
            );


            setContent("");


            getComments();



        } catch(error) {


            console.log(
                "Create Comment Error:",
                error
            );


        }


    };



    return (

        <div
            className="app-container"
        >


            <div
                className="form-container"
            >


                <h2>
                    Comments
                </h2>



                <input

                    placeholder="Write comment"

                    value={content}

                    onChange={
                        e =>
                            setContent(
                                e.target.value
                            )
                    }

                />



                <button
                    onClick={createComment}
                >

                    Send

                </button>


            </div>



            <hr />



            {
                comments.map(
                    comment => (

                        <div
                            key={comment.id}
                            className="comment"
                        >

                            <p>
                                {comment.content}
                            </p>

                        </div>

                    )
                )
            }



        </div>

    );


}


export default PostDetail;