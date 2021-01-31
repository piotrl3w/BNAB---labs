import React from "react";
import Adapter from "enzyme-adapter-react-16";
import Enzyme, { mount, render, shallow } from "enzyme";
import { ProductList } from "./ProductList";
import shortid from "shortid";

Enzyme.configure({ adapter: new Adapter() });

const fakeProducts = [
    { key: shortid.generate(), id: 1, name: "P1", category: 1, description: "P1 (Watersports)", price: 3 },
    { key: shortid.generate(), id: 2, name: "P2", category: 1, description: "P2 (Watersports)", price: 4 },
    { key: shortid.generate(), id: 3, name: "P3", category: 2, description: "P3 (Running)", price: 5 },
];

it("showProductListWhenDataExists", () => {
    const wrapper = mount(<ProductList products={fakeProducts} />);
    const prodLen = wrapper.find("ProductItem").length;
    expect(prodLen).toEqual(3);
});

it("showProductListWithoutData", () => {
    const wrapper = mount(<ProductList products={null} />);
    const empty = wrapper.find("h5").text();
    expect(empty).toBe("Empty list...");
});
