import React from "react";

export default function ProductItem({ product }) {
    return (
        <div className="card m-1 p-1 bg-light">
            <h4>
                {product.name}
                <span className="badge badge-pill badge-primary float-right">{product.price.toFixed(2)} zl</span>
            </h4>
            <div className="card-text bg-white p-1">{product.description}</div>
        </div>
    );
}