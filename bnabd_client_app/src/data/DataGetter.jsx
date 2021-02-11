import React, { Component } from "react";
import { DataTypes } from "./Types";

export class DataGetter extends Component {
    render() {
        return <>{this.props.children}</>;
    }

    componentDidMount = () => this.getData();

    componentDidUpdate = () => this.getData();

    getData = () => {
        const dsData = this.props.products_params || {};
        const rtData = {
            _sort: this.props.sortKey || "name",
            category_like: this.props.match.params.category === "All" ? "" : this.props.match.params.category,
        };
        
        if (Object.keys(rtData).find((key) => dsData[key] !== rtData[key])) {
            this.props.loadData(DataTypes.PRODUCTS,rtData);
        }
    };
}
