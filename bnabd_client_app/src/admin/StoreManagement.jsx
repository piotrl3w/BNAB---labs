import React, { useState,useEffect } from "react";
import { useHistory } from "react-router-dom";
import { ValidatedForm } from "../forms/ValidatedForm";
import * as service from "../service/adminService";

export default function StoreManagement() {
    const [categoryList, setCategoryList] = useState([]);
    const history = useHistory();
    const defaultAttrs = { type: "text", required: true };

    const formCategory = [
        {
            label: "Name",
        },
    ];

    const formProduct = [{ label: "Name" }, { label: "Price", attrs: { type: "number" } }, { label: "Description" }];

    const createProduct = (data) => {
        let category = categoryList.find(x => x.id == data.Category);
        let dataToSend = {...data , category : category};
        service
            .CreateProduct(dataToSend)
            .then((res) => {
                if (res) {
                    alert("Produkt utworzono pomyślnie");
                }
            })
            .catch((err) => alert("Problem z utworzeniem"));
    };

    const createCategory = (data) => {
        service
            .CreateCategory(data)
            .then((res) => {
                if (res) {
                    alert("Kategorie utworzono pomyślnie");
                    loadCategory();
                }
            })
            .catch((err) => alert("Problem z utworzeniem"));
    };

    const loadCategory = () => {
        service.LoadCategory().then((res) => {
            setCategoryList(res.data);
        });
    };

    useEffect(() => {
        loadCategory()
    }, [])

    return (
        <div className="containter-fluid">
            <div className="row">
                    <div className="col bg-dark text-white">
                        <div className="navbar-brand mx-3" onClick={() => {history.push("/shop")}}>Sportstore shop</div>
                    </div>
                </div>
            <div className="row mx-3">
                <div className="col-sm">
                    <h2>Zarzadzanie kategoriami</h2>
                    <ValidatedForm formModel={formCategory} defaultAttrs={defaultAttrs} submitCallback={createCategory} submitText="Create Category" />
                </div>
                <div className="col-sm">
                    <h2>Zarzadzanie produktami</h2>
                    <ValidatedForm
                        formModel={formProduct}
                        defaultAttrs={defaultAttrs}
                        submitCallback={createProduct}
                        submitText="Create Product"
                        selectName="Category"
                        options={categoryList}
                    />
                </div>
            </div>
        </div>
    );
}
