import React from "react";
import { Link } from "react-router-dom";

export function Thanks({ order }) {
    return (
        <>
            <div className="col bg-dark text-white">
                <div className="navbat-brand">Sportstore shop</div>
            </div>
            <div className="m-2 text-center">
                <h2>Thanks!</h2>
                <p>Thank You for Your order</p>
                <p> Your order has number : {order ? order.id : 0}</p>
                <Link to="/shop" className="btn btn-primary">
                    Back to shop
                </Link>
            </div>
        </>
    );
}
