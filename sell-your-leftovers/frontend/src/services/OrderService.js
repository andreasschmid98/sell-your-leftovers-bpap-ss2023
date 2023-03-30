import axios from "axios";
import {useAuthStore} from "@/stores/auth";

const ORDER_API_BASE_URL = 'http://localhost:8080/api/order';


class CartService {


    placeOrder(orderRequest){
        return axios.post(ORDER_API_BASE_URL, orderRequest, {
            headers: {
                Authorization: 'Bearer ' + useAuthStore().token
            }
        });
    }

}

export default new CartService();