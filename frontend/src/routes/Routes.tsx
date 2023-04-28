import {
  Detail,
  Login,
  Main,
  MyInformation,
  NotFound,
  Product,
  SignUp,
  Test /* prod 때는 삭제 */,
} from '../pages/Pages';

import { Route, Routes as BrowserRoutes } from 'react-router-dom';

import { BROWSER_PATH } from '../constants/path';

function Routes() {
  return (
    <BrowserRoutes>
      <Route path={BROWSER_PATH.BASE} element={<Main />} />
      <Route path={BROWSER_PATH.DETAIL} element={<Detail />} />
      <Route path={BROWSER_PATH.MY} element={<MyInformation />} />
      <Route path={BROWSER_PATH.PRODUCT} element={<Product />} />
      <Route path={BROWSER_PATH.LOGIN} element={<Login />} />
      <Route path={BROWSER_PATH.SIGN_UP} element={<SignUp />} />
      <Route path={BROWSER_PATH.TEST} element={<Test />} />
      {/* prod 때는 삭제 */}
      <Route path={'*'} element={<NotFound />} />
    </BrowserRoutes>
  );
}

export default Routes;
