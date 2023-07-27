import axios, {AxiosResponse} from "axios";
import {AUTH_URL} from 'layout/AppConfig';


import jwt from 'jsonwebtoken';

export class AuthService {

    signIn(username: string, password: string): Promise<AxiosResponse<any>> {
        return axios.post(AUTH_URL, {username, password});
    }


    getRoleConnectedUser(): string {
        var decodedJwt = this.decodeJWT();
        var roles = decodedJwt['roles'];
        return roles[0];
    }

    saveToken(token: string) {
        localStorage.setItem('token', token);
    }


    removeToken() {
        localStorage.removeItem('token');
    }

    getToken() {
        return localStorage.getItem('token')
    }

    decodeJWT() {
        const token = this.getToken();
        try {
            const decodedToken = jwt.decode(token.replace('Bearer ', ''));
            return decodedToken;
        } catch (error) {
            console.error('Error decoding JWT:', error);
            return null;
        }
    }

    getUsername(): string {
        const tokenDecoded = this.decodeJWT();
        return tokenDecoded.sub;
    }

    getExpirationFromToken(): boolean {
        const tokenDecoded = this.decodeJWT();
        console.log(tokenDecoded);
        return tokenDecoded.exp;
    }

    isTokenValid(): boolean {
        const exp = this.getExpirationFromToken();
        const now = new Date();
        //return isAfter(exp, now)
        return true;
    }
};

