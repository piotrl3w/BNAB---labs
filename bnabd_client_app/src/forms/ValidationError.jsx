import React, { Component } from 'react';

export class ValidationError extends Component{
    render(){
        if (this.props.errors){
            return this.props.errors.map(x => 
                <h6 className="text-danger" key={x}>
                    {x}
                </h6>)
        }
        return null;
    }
}