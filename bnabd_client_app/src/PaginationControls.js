import React, { Component } from "react";
import { PaginationButtons } from "./PaginationButtons";

export default class PaginationControls extends Component {
    constructor(props) {
        super(props);
        this.pageSizes = this.props.size || [5, 10, 15, 20];
        this.sortKeys = this.props.keys || ["Name", "Price"];
    }

    sortKey2Label = (key) => {
        return { Name: "nazwy", Price: "ceny" }[key];
    };

    handlePageSizeChange = (ev) => {
        this.props.setPageSize(ev.target.value);
    };

    handleSortKeyChange = (ev) => {
        this.props.setSortProperty(ev.target.value);
    };

    render() {
        return (
            <div className="m-2">
                <div className="text-center m-1">
                    <PaginationButtons currentPage={this.props.currentPage} pageCount={this.props.pageCount} navigate={this.props.navigateToPage} />
                </div>

                <div className="form-inline justify-content-center">
                    <select className="form-control" onChange={this.handlePageSizeChange} value={this.props.pageSize || this.pageSizes[0]}>
                        {this.pageSizes.map((s) => (
                            <option value={s} key={s}>
                                {s} na stronie
                            </option>
                        ))}
                    </select>
                    <select className="form-control" onChange={this.handleSortKeyChange} value={this.props.sortKey || this.sortKeys[0]}>
                        {this.sortKeys.map((k) => (
                            <option value={k.toLowerCase()} key={k}>
                                sortuj według {this.sortKey2Label(k)}
                            </option>
                        ))}
                    </select>
                </div>
            </div>
        );
    }
}
