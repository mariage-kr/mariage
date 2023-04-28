import Loading from './components/Loading/Loading';
import GlobalStyle from './styles/global';
import { BrowserRouter as Router } from "react-router-dom";
import Routes from "./routes/Routes";


function App() {
  
  return (
    <>
      <GlobalStyle />
      <Router>
            <Routes />
      </Router>
    </>
  );
}

export default App;
