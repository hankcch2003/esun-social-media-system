import axios from "axios";


const api = axios.create({

    baseURL: "http://localhost:8080"

});



api.interceptors.request.use(

    config => {


        const token =
            localStorage.getItem("token");



        if(token){

            config.headers.Authorization =
                `Bearer ${token}`;

        }


        console.log(
            "Request:",
            config.method,
            config.url,
            config.data
        );


        return config;

    }

);



api.interceptors.response.use(

    response => {


        console.log(
            "Response:",
            response.status,
            response.data
        );


        return response;

    },


    error => {


        console.log(
            "API Error:",
            error.response
        );


        return Promise.reject(error);

    }

);



export default api;