import ReactDOM from 'react-dom/client';

import App from './App';

import worker from './mocks/browsers';

if (process.env.NODE_ENV === "development") {
  worker.start();
}

const root = ReactDOM.createRoot(document.getElementById('root')!);

root.render(<App />);
