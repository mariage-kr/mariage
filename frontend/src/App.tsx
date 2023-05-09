import { Suspense } from 'react';
import { BrowserRouter as Router } from 'react-router-dom';
import { RecoilRoot } from 'recoil';
import { QueryClientProvider, QueryClient } from 'react-query';

import GlobalStyle from '@/styles/global';
import Routes from '@/routes/Routes';

import Mariage from './components/Mariage/Mariage';
import Loading from '@/components/Loading/Loading';
import ScrollToTop from '@/components/ScrollToTop/ScrollToTop';
import Layout from './layout/Layout';

const queryClient = new QueryClient({});

function App() {
  return (
    <Mariage>
      <GlobalStyle />
      <RecoilRoot>
        <QueryClientProvider client={queryClient}>
          <Router>
            <ScrollToTop />
            <Layout>
              <Suspense fallback={<Loading />}>
                <Routes />
              </Suspense>
            </Layout>
          </Router>
        </QueryClientProvider>
      </RecoilRoot>
    </Mariage>
  );
}

export default App;
