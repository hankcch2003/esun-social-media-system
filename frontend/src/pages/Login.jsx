import { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/axios";


function Login() {


    const [phone, setPhone] =
        useState("");


    const [password, setPassword] =
        useState("");


    const navigate =
        useNavigate();



    const handleLogin = async () => {


        try {


            const response =
                await api.post(
                    "/users/login",
                    {
                        phone,
                        password
                    }
                );



            console.log(
                "Login Response:",
                response
            );



            console.log(
                "Response Data:",
                response.data
            );



            const token =
                response.data.data.token;



            if (!token) {

                throw new Error(
                    "Token not found"
                );

            }



            localStorage.setItem(
                "token",
                token
            );



            alert("Login Success");



            navigate("/posts");



        } catch(error) {


            console.log(
                "Login Error:",
                error
            );



            if(error.response) {


                console.log(
                    "Status:",
                    error.response.status
                );


                console.log(
                    "Error Data:",
                    error.response.data
                );


            }
            else {


                console.log(
                    "Error Message:",
                    error.message
                );


            }



            alert(
                "Login Failed"
            );


        }


    };



    return (

        <div
            className="form-container"
        >


            <h2>
                Login
            </h2>



            <input

                placeholder="Phone"

                value={phone}

                onChange={
                    e => setPhone(e.target.value)
                }

            />



            <input

                placeholder="Password"

                type="password"

                value={password}

                onChange={
                    e => setPassword(e.target.value)
                }

            />



            <button
                onClick={handleLogin}
            >

                Login

            </button>



        </div>

    );

}


export default Login;