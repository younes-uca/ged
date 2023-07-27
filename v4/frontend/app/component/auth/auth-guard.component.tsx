import {useRouter} from 'next/router';
import React, {useEffect, useState} from 'react';


const AuthGuard = ({children}) => {
    const [isTokenValid, setIsTokenValid] = useState(null);
    const router = useRouter();

    useEffect(() => {
        setIsTokenValid(false)
    }, []);

    if (isTokenValid == false) {
        router.push("/auth")
    }

    if (isTokenValid == true) {
        return {children}
    }

    return <></>
};
export default AuthGuard
