import { ActionTypes } from "./Types";

export const ShopReducers = (storeData, action) => {
    switch (action.type) {
        case ActionTypes.DATA_LOAD:
            return {
                ...storeData,
                [action.payload.dataType]: action.payload.data,
            };
        case ActionTypes.DATA_SET_PAGESIZE:
            return {...storeData,pageSize : action.payload};
        case ActionTypes.DATA_SET_SORT_PROPERTY:
            return {...storeData,sortKey : action.payload};
        default:
            return storeData || {};
    }
};