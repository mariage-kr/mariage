import { Suspense } from 'react';
import { BrowserRouter as Router } from 'react-router-dom';

import GlobalStyle from '@/styles/global';
import Routes from '@/routes/Routes';

import Loading from '@/components/Loading/Loading';
import ScrollToTop from '@/components/ScrollToTop/ScrollToTop';
import { RecoilRoot } from 'recoil';
import Layout from './layout/Layout';

import Mariage from './components/Mariage/Mariage';

function App() {
  return (
    <Mariage>
      <GlobalStyle />
      <RecoilRoot>
        <Router>
          <ScrollToTop />
          <Layout>
            <Suspense fallback={<Loading />}>
              <Routes />
            </Suspense>
          </Layout>
        </Router>
      </RecoilRoot>
    </Mariage>
  );
}

export default App;