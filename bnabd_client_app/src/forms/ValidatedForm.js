import React, { Component } from "react";
import { ValidationError } from "./ValidationError";
import { GetMessages } from "./ValidationMessage";

export class ValidatedForm extends Component {
    constructor(props) {
        super(props);
        this.state = {
            validationErrors: {},
        };
        this.formElements = {};
    }

    handleSubmit = () => {
        this.setState(
            (state) => {
                const newState = { ...state, validationErrors: {} };
                Object.values(this.formElements).forEach((elem) => {
                    if (!elem.checkValidity()) {
                        newState.validationErrors[elem.name] = GetMessages(elem);
                    }
                });
                return newState;
            },
            () => {
                if (Object.keys(this.state.validationErrors).length === 0) {
                    const data = Object.assign(...Object.entries(this.formElements).map((e) => ({ [e[0]]: e[1].value })));
                    this.props.submitCallback(data);
                }
            }
        );
    };

    registryRefs = (element) => {
        if (element != null) {
            this.formElements[element.name] = element;
        }
    };

    renderElement = (modelItem) => {
        const name = modelItem.name || modelItem.label.toLowerCase();
        return (
            <div className="form-group" key={modelItem.label}>
                <label>{modelItem.labelText ? modelItem.labelText : modelItem.label}</label>
                <ValidationError errors={this.state.validationErrors[name]} />
                <input className="form-control" name={name} ref={this.registryRefs} {...this.props.defaultAttrs} {...modelItem.attrs} />
            </div>
        );
    };

    render() {
        return (
            <>
                {this.props.formModel.map((m) => this.renderElement(m))}
                {this.props.options && this.props.selectName && (
                    <select name={this.props.selectName} className="form-control" ref={this.registryRefs}>
                        {this.props.options.map((x) => (
                            <option value={x.id}>{x.name}</option>
                        ))}
                    </select>
                )}
                <div className="text-center">
                    <button className="btn btn-secondary m-1" onClick={this.props.cancelCallback}>
                        {this.props.cancelText || "Cancel"}
                    </button>
                    <button className="btn btn-secondary m-1" onClick={this.handleSubmit}>
                        {this.props.submitText || "Send"}
                    </button>
                </div>
            </>
        );
    }
}
