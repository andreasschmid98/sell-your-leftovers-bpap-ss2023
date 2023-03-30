import axios from "axios";
import {useAuthStore} from "@/stores/auth";

const CART_API_BASE_URL = 'http://localhost:8080/api/cart';


class CartService {


    addCartItem(cartRequest){
        return axios.post(CART_API_BASE_URL + "/add", cartRequest, {
            headers: {
                Authorization: 'Bearer ' + useAuthStore().token
            }
        });
    }

    removeCartItem(cartRequest){
        return axios.post(CART_API_BASE_URL + "/remove", cartRequest, {
            headers: {
                Authorization: 'Bearer ' + useAuthStore().token
            }
        });
    }


    getAllCartItems(){
        return axios.get(CART_API_BASE_URL, {
            headers: {
                Authorization: 'Bearer ' + useAuthStore().token
            }
        });
    }

}

export default new CartService();