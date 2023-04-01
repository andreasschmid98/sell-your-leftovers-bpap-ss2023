import axios from "axios";
import {useAuthStore} from "@/stores/auth";

const PRODUCT_API_BASE_URL = 'http://localhost:8080/api/product';


class ProductService{

    getAllProducts(){
        return axios.get(PRODUCT_API_BASE_URL, {
            headers: { Authorization: 'Bearer ' + useAuthStore().token }
        });
    }

    getProductById(id){
        return axios.get(PRODUCT_API_BASE_URL + "/" + id, {
            headers: { Authorization: 'Bearer ' + useAuthStore().token }
        });
    }
}

export default new ProductService();