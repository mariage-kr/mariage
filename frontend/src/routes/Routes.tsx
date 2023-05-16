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
  Test /* TODO: 개발때만 사용 */,
} from '@/pages/Pages';

import { Route, Routes as BrowserRoutes } from 'react-router-dom';

import { BROWSER_PATH } from '@/constants/path';

function Routes() {
  return (
    <BrowserRoutes>
      <Route path={BROWSER_PATH.BASE} element={<Main />} />
      <Route path={BROWSER_PATH.ADMIN} element={<Admin />} />
      <Route path={BROWSER_PATH.DETAIL} element={<Detail />} />
      <Route path={BROWSER_PATH.MY} element={<MyInformation />} />
      <Route path={BROWSER_PATH.PRODUCT} element={<Product />} />
      <Route path={BROWSER_PATH.LOGIN} element={<Login />} />
      <Route path={BROWSER_PATH.SIGN_UP} element={<SignUp />} />
      <Route path={BROWSER_PATH.REVIEW} element={<Review />} />
      <Route path={BROWSER_PATH.TEST} element={<Test />} />
      {/* TODO: 개발때만 사용 */}
      <Route path={'*'} element={<NotFound />} />
    </BrowserRoutes>
  );
}

export default Routes;
