import axios from "axios";

const PRODUCT_API_BASE_URL = 'http://localhost:8080/api/product';

class ProductService{

    getAllProducts(){
        return axios.get(PRODUCT_API_BASE_URL);
    }

    getProductById(id){
        return axios.get(PRODUCT_API_BASE_URL + "/" + id);
    }
}

export default new ProductService();