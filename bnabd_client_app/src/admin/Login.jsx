import React from "react";
import { useForm } from "react-hook-form";
import "./Login.css";
import { useHistory } from "react-router-dom";
import * as service from "../service/adminService";

export default function Login() {
    const { register, handleSubmit, errors } = useForm();

    const history = useHistory();

    const onSubmit = (data) => {
        service.Login({name : data.Name, password : data.Password}).then((res) => {
            if (res.data == true) {
                history.push("/adminCenter/management");
            } else {
                alert("Login lub hasło niepoprawne");
            }
        }).then(err => {
        });
    };

    return (
        <div className="center">
            <h1>Admin console SportStore</h1>
            <form onSubmit={handleSubmit(onSubmit)} style={{ width: "30vw", margin: "20px" }}>
                <input className="form-control form-control-lg input" type="text" placeholder="Login" name="Name" ref={register({ required: true })} />
                {errors.login?.type === "required" && <p style={{ color: "red" }}>Login is required</p>}
                <input className="form-control form-control-lg input" type="password" placeholder="Password" name="Password" ref={register({ required: true })} />
                {errors.password?.type === "required" && <p style={{ color: "red" }}>Password is required</p>}
                <input className="btn btn-primary" type="submit" value="Log in" />
            </form>
        </div>
    );
}
