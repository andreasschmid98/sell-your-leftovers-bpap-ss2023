import axios from "axios";
import {useAuthStore} from "@/stores/auth";

const CATEGORY_API_BASE_URL = 'http://localhost:8080/api/category';

class CategoryService{

    getAllCategories(){
        return axios.get(CATEGORY_API_BASE_URL, {
            headers: { Authorization: 'Bearer ' + useAuthStore().token }
        })
    }
}

export default new CategoryService();