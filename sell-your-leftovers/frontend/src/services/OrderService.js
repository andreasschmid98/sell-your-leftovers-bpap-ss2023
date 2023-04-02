import axios from "axios";
import {useAuthStore} from "@/stores/auth";

const ORDER_API_URL = 'http://localhost:8080/api/order';


class CartService {


    order(orderRequest){
        return axios.post(ORDER_API_URL, orderRequest, {
            headers: {
                Authorization: 'Bearer ' + useAuthStore().token
            }
        });
    }

}

export default new CartService();