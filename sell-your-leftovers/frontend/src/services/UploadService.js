import axios from "axios";
import {useAuthStore} from "@/stores/auth";

const UPLOAD_API_URL = 'http://localhost:8080/api/upload';

class UploadService {

    getAllUploads(){
        return axios.get(UPLOAD_API_URL, {
            headers: { Authorization: 'Bearer ' + useAuthStore().token }
        });
    }

    uploadProduct(productRequest){
        return axios.post(UPLOAD_API_URL, productRequest, {
            headers: { Authorization: 'Bearer ' + useAuthStore().token }
        })
    }
}

export default new UploadService();