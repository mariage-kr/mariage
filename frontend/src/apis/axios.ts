import Axios from 'axios';

import { accessTokenProvider } from '@/utils/token';

const baseURL = process.env.BASE_URL;

const axios = Axios.create({
  baseURL,
});

const axiosWithAccessToken = Axios.create({
  baseURL,
});

axiosWithAccessToken.interceptors.request.use(
  /* https://yamoo9.github.io/axios/guide/interceptors.html */
  config => {
    console.log('RUN AXIOS INTERCEPTORS');

    const accessToken = accessTokenProvider.get();

    if (config.headers && accessToken) {
      config.headers.Authorization = `Bearer ${accessToken}`;
    }

    return config;
  },
  error => {
    return Promise.reject(error);
  },
);

export { baseURL, axios, axiosWithAccessToken };
