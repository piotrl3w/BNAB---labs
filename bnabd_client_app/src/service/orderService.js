import Axios from 'axios';

export function placeOrder(data) {
    return SendRequest("POST", "http://localhost:43412/api/v1/orders/place", {}, data);
}

const SendRequest = (method, url, params, data) => Axios.request({ method, url, params, data });
