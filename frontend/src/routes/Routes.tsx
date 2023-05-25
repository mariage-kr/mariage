import {
  Admin,
  Detail,
  Login,
  Main,
  MyInformation,
  NotFound,
  Product,
  SignUp,
  Review,
} from '@/pages/Pages';

import { Route, Routes as BrowserRoutes } from 'react-router-dom';

import { BROWSER_PATH } from '@/constants/path';
import PrivateWrapper from './PrivateWrapper';

function Routes() {
  return (
    <BrowserRoutes>
      <Route path={BROWSER_PATH.BASE} element={<Main />} />
      <Route path={BROWSER_PATH.LOGIN} element={<Login />} />
      <Route path={BROWSER_PATH.SIGN_UP} element={<SignUp />} />
      <Route path={BROWSER_PATH.PRODUCT} element={<Product />} />
      <Route path={BROWSER_PATH.DETAIL}>
        <Route path={':id'} element={<Detail />} />
      </Route>
      <Route path={BROWSER_PATH.REVIEW}>
        <Route path={':id'} element={<Review />} />
      </Route>
      <Route element={<PrivateWrapper />}>
        <Route path={BROWSER_PATH.ADMIN} element={<Admin />} />
        <Route path={BROWSER_PATH.MY} element={<MyInformation />} />
      </Route>
      <Route path={'*'} element={<NotFound />} />
    </BrowserRoutes>
  );
}

export default Routes;
