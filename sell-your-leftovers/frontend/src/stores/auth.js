import {defineStore} from 'pinia';
import router from '@/router';
import AuthService from "@/services/AuthService";

export const useAuthStore = defineStore({
    id: 'auth',
    state: () => {
        return {
            user: localStorage.getItem('user') ? localStorage.getItem('user') : null,
            token: localStorage.getItem('token') ? localStorage.getItem('token') : null,
            returnUrl: '/'
        }
    },
    actions: {
        login(email, password) {
            AuthService.login(JSON.parse(JSON.stringify({email: email, password: password}))).then((response) => {

                if (response.status === 200) {
                    const token = response.data
                    localStorage.setItem('user', JSON.stringify(email))
                    localStorage.setItem('token', JSON.stringify(token))
                    this.user = email
                    this.token = token
                    router.push('/')
                } else {
                    throw new Error('Invalid credentials')
                }
            });
        },
        logout() {
            this.user = ''
            this.token = ''
            localStorage.removeItem('user')
            localStorage.removeItem('token')
            router.push('/login')
        }
    },
    persist: true
})
