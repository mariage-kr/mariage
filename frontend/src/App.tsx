import { Suspense } from 'react';
import { BrowserRouter as Router } from 'react-router-dom';

import GlobalStyle from '@/styles/global';
import Routes from '@/routes/Routes';

import Loading from '@/components/Loading/Loading';

function App() {
  return (
    <>
      <GlobalStyle />
      <Router>
        <Suspense fallback={<Loading />}>
          <Routes />
        </Suspense>
      </Router>
    </>
  );
}

export default App;
