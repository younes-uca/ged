// i18n.js
import i18n from 'i18next';
import { initReactI18next } from 'react-i18next';
import HttpBackend from 'i18next-http-backend';

i18n.use(HttpBackend).use(initReactI18next).init({
    lng: 'en', // Default language
    fallbackLng: 'fr', // Fallback language if the translation is missing in the current language
    supportedLngs: ['en', 'fr', 'es'], // List of supported languages
    backend: {
        // Backend options (e.g., load translations from the backend)
        loadPath: '/locales/{{lng}}/{{ns}}.json', // Adjust the path as per your server configuration
    },
});

export default i18n;
