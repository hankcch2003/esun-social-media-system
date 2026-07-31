import { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/axios";


function CreatePost() {


    const [content, setContent] =
        useState("");


    const [image, setImage] =
        useState("");


    const navigate =
        useNavigate();



    const handleCreate = async () => {


        try {


            const response =
                await api.post(
                    "/posts",
                    {
                        content,
                        image
                    }
                );



            console.log(
                "Create Post Response:",
                response.data
            );



            alert(
                "Create Post Success"
            );



            navigate("/posts");



        } catch(error) {


            console.log(
                "Create Post Error:",
                error
            );


            alert(
                error.response?.data?.message
                ||
                "Create Post Failed"
            );


        }


    };



    return (

        <div
            className="form-container"
        >


            <h2>
                Create Post
            </h2>



            <input

                placeholder="Content"

                value={content}

                onChange={
                    e => setContent(
                        e.target.value
                    )
                }

            />



            <input

                placeholder="Image"

                value={image}

                onChange={
                    e => setImage(
                        e.target.value
                    )
                }

            />



            <button
                onClick={handleCreate}
            >

                Create

            </button>



        </div>

    );

}


export default CreatePost;