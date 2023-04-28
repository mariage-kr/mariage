import Main from "../pages/Main/Main";
import NotFound from "../pages/NotFound/NotFound";
import { BROWSER_PATH } from "../constants/path";
import { Route, Routes as BrowserRoutes } from "react-router-dom";

function Routes() {
  return (
    <BrowserRoutes>
    
      <Route path={BROWSER_PATH.BASE} element={<Main />} />
      {/* <Route path={BROWSER_PATH.NOT_FOUND} element={<NotFound />} /> */}
      <Route path='*' element={<NotFound/>} />
      
    </BrowserRoutes>
  );
}

export default Routes;
