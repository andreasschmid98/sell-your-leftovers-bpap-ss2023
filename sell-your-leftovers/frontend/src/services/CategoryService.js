import axios from "axios"
import {useAuthStore} from "@/stores/auth"

/**
 * This defines the service class calling the category-API-endpoint.
 */

const CATEGORY_API_URL = 'http://localhost:8080/api/category'

class CategoryService {

    getAllCategories() {
        return axios.get(CATEGORY_API_URL, {
            headers: {Authorization: 'Bearer ' + useAuthStore().token}
        })
    }
}

export default new CategoryService();