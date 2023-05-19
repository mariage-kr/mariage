import { lazy } from 'react';

const Admin = lazy(() => import('./Admin/Admin'));
const Detail = lazy(() => import('./Detail/Detail'));
const Login = lazy(() => import('./Login/Login'));
const Main = lazy(() => import('./Main/Main'));
const MyInformation = lazy(() => import('./MyInformation/MyInformation'));
const NotFound = lazy(() => import('./NotFound/NotFound'));
const Product = lazy(() => import('./Product/Product'));
const SignUp = lazy(() => import('./SignUp/SignUp'));
const Review = lazy(() => import('./Review/Review'));

export {
  Admin,
  Detail,
  Login,
  Main,
  MyInformation,
  NotFound,
  Product,
  SignUp,
  Review,
};
