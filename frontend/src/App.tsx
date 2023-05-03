import { Suspense } from 'react';
import { BrowserRouter as Router } from 'react-router-dom';

import GlobalStyle from '@/styles/global';
import Routes from '@/routes/Routes';

import Loading from '@/components/Loading/Loading';
import ScrollToTop from '@/components/ScrollToTop/ScrollToTop';
import { RecoilRoot } from 'recoil';

function App() {
  return (
    <>
      <GlobalStyle />
      <RecoilRoot>
        <Router>
          <ScrollToTop />
          <Suspense fallback={<Loading />}>
            <Routes />
          </Suspense>
        </Router>
      </RecoilRoot>
    </>
  );
}

export default App;
