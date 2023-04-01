import axios from "axios";
import {useAuthStore} from "@/stores/auth";

const CART_API_URL = 'http://localhost:8080/api/cart';

class CartService {

    getAllCartItems(){
        return axios.get(CART_API_URL, {
            headers: {
                Authorization: 'Bearer ' + useAuthStore().token
            }
        })
    }

    addCartItem(cartRequest){
        return axios.post(CART_API_URL + "/add", cartRequest, {
            headers: {
                Authorization: 'Bearer ' + useAuthStore().token
            }
        })
    }

    removeCartItem(cartRequest){
        return axios.post(CART_API_URL + "/remove", cartRequest, {
            headers: {
                Authorization: 'Bearer ' + useAuthStore().token
            }
        })
    }

}

export default new CartService();