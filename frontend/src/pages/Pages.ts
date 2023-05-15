import { lazy } from 'react';

const Admin = lazy(() => import('./Admin/Admin'));
const Detail = lazy(() => import('./Detail/Detail'));
const Login = lazy(() => import('./Login/Login'));
const Main = lazy(() => import('./Main/Main'));
const MyInformation = lazy(() => import('./MyInformation/MyInformation'));
const NotFound = lazy(() => import('./NotFound/NotFound'));
const Product = lazy(() => import('./Product/Product'));
const SignUp = lazy(() => import('./SignUp/SignUp'));
const Test = lazy(() => import('./Test/Test')); /* TODO: 개발때만 사용 */

export {
  Admin,
  Detail,
  Login,
  Main,
  MyInformation,
  NotFound,
  Product,
  SignUp,
  Test,
};
