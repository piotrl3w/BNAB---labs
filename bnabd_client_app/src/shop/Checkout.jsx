import React, { Component } from "react";
import { ValidatedForm } from "../forms/ValidatedForm";
import * as service from "../service/orderService";

export default class Checkout extends Component {
    constructor(props) {
        super(props);
        this.defaultAttrs = { type: "text", required: true };
        this.formModel = [
            { label: "Purchaser" },
            { label: "Email", attrs: { type: "email" } },
            { label: "Address" },
            { label: "City" },
            { label: "Postal Code", name: "zip" },
            { label: "Country" },
        ];
    }

    handleSubmit = (formData) => {
        const order = { ...formData, products: this.props.cart.map((item) => ({ quantity: item.quantity, product: item.product })) };
        service.placeOrder(order).then((res) => {
            debugger;
            this.props.placeOrder(order);

            this.props.clearCart();
            this.props.history.push("/shop/thanks/:order",res.data.id);
        });
    };

    handleCancel = () => {
        this.props.history.push("/shop/cart");
    };

    render() {
        return (
            <div className="container-fluid">
                <div className="row">
                    <div className="col bg-dark text-white">
                        <div className="navbar-brand">Sportstore shop</div>
                    </div>
                </div>
                <div className="row">
                    <div className="col m-2">
                        <ValidatedForm
                            formModel={this.formModel}
                            defaultAttrs={this.defaultAttrs}
                            submitCallback={this.handleSubmit}
                            cancelCallback={this.handleCancel}
                            cancelText="Cancel order"
                            submitText="Order"
                        />
                    </div>
                </div>
            </div>
        );
    }
}
