import { DataTypes } from "./Types";

const protocol = "http";
const hostname = "localhost";
const port = 43412;

export const RestUrl = {
    [DataTypes.PRODUCTS]: `${protocol}://${hostname}:${port}/api/v1/products/get`,
    [DataTypes.CATEGORIES]: `${protocol}://${hostname}:${port}/api/v1/category/get`,
    [DataTypes.ORDERS] : `${protocol}://${hostname}:${port}/api/orders`
};
