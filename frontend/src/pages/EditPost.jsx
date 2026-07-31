import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import api from "../api/axios";


function EditPost() {


    const { postId } =
        useParams();


    const navigate =
        useNavigate();


    const [content, setContent] =
        useState("");


    const [image, setImage] =
        useState("");



    useEffect(() => {


        getPost();


    }, []);



    const getPost = async () => {


        try {


            const response =
                await api.get(
                    `/posts/${postId}`
                );


            console.log(
                "Post Response:",
                response.data
            );


            const post =
                response.data.data;


            setContent(
                post.content
            );


            setImage(
                post.image || ""
            );


        } catch(error) {


            console.log(
                "Get Post Error:",
                error
            );


            alert(
                error.response?.data?.message
                ||
                "Get Post Failed"
            );


        }


    };



    const handleUpdate = async () => {


        try {


            await api.put(
                `/posts/${postId}`,
                {
                    content,
                    image
                }
            );


            alert(
                "Update Success"
            );


            navigate("/posts");


        } catch(error) {


            console.log(
                "Update Error:",
                error
            );


            alert(
                error.response?.data?.message
                ||
                "Update Failed"
            );


        }


    };



    return (

        <div
            className="form-container"
        >


            <h2>
                Edit Post
            </h2>



            <div>


                <label>
                    Content
                </label>



                <br />



                <input

                    placeholder="Content"

                    value={content}

                    onChange={
                        e =>
                            setContent(
                                e.target.value
                            )
                    }

                />


            </div>



            <br />



            <div>


                <label>
                    Image
                </label>



                <br />



                <input

                    placeholder="Image"

                    value={image}

                    onChange={
                        e =>
                            setImage(
                                e.target.value
                            )
                    }

                />


            </div>



            <br />



            <button

                className="success-button"

                onClick={handleUpdate}

            >

                Save

            </button>



            {" "}



            <button

                className="secondary-button"

                onClick={
                    () =>
                        navigate("/posts")
                }

            >

                Cancel

            </button>


        </div>

    );

}


export default EditPost;