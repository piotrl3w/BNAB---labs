import { DataTypes } from "./Types";

const protocol = "http";
const hostname = "localhost";
const port = 3501;

export const RestUrl = {
    [DataTypes.PRODUCTS]: `${protocol}://${hostname}:${port}/api/products`,
    [DataTypes.CATEGORIES]: `${protocol}://${hostname}:${port}/api/categories`,
    [DataTypes.ORDERS] : `${protocol}://${hostname}:${port}/api/orders`
};
