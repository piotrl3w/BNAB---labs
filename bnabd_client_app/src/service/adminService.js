import Axios from "axios";

export function CreateCategory(data) {
    return SendRequest("POST", "http://localhost:43412/api/v1/category/save", {}, data);
}

export function CreateProduct(data) {
    return SendRequest("POST", "http://localhost:43412/api/v1/products/save", {}, data);
}

export function LoadCategory() {
    return SendRequest("GET", "http://localhost:43412/api/v1/category/get", {}, {});
}

export function Login(data) {
    return SendRequest("POST", "http://localhost:43412/api/v1/users/login", {}, data);
}

const SendRequest = (method, url, params, data) => Axios.request({ method, url, params, data });
