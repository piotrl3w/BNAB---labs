import React, { Component } from "react";
import { Link } from "react-router-dom";

export class CartSummary extends Component {

    getSummary = () => {
        if (this.props.cartItems > 0) {
            return <span>
                { this.props.cartItems } item(s), 
                ${ this.props.cartPrice.toFixed(2)}
            </span>
        } else {
            return <span>Your cart: (empty) </span>
        }        
    }

    getLinkClasses = () => {
        return `btn btn-sm bg-dark text-white 
            ${ this.props.cartItems === 0 ? "disabled": ""}`;
    }

    render() {
        return <div className="float-right">
            <small>
                 { this.getSummary() }            
                <Link className={ this.getLinkClasses() } 
                        to="/shop/cart">
                    <i className="fa fa-shopping-cart"></i>
                </Link>        
                <Link className="btn btn-sm bg-dark text-white" to="/adminCenter">
                    <i className="fa fa-user-cog"></i></Link>        
            </small>
        </div>
    }
}
