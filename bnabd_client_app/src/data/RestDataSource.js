import { RestUrl } from "./Urls";
import Axios from "axios";

export class RestDataSource {
    GetData = (dataType, params) => this.SendRequest("get", RestUrl[dataType], params);

    StoreData = (dataType, data) => this.SendRequest("post", RestUrl[dataType], {}, data);

    SendRequest = (method, url, params, data) => Axios.request({ method, url, params, data });
}
