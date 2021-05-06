import 'bootstrap/dist/css/bootstrap.min.css';
import { Container } from 'react-bootstrap';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Navigation from "./layouts/Navigation";
import SingIn from "./pages/SingIn"
import Posts from "./pages/Posts"
import store from './store';
import {Provider} from 'react-redux' ;

function App() {
  return (
    <Provider store={store}>
    <Router>
       <div >
   <Navigation></Navigation>
    </div>
    <Container>
    <Switch>
      <Route exact path='/' component={Posts}></Route>
      <Route exact path='/singin' component={SingIn}></Route>
    </Switch>
    </Container>
    </Router>
    </Provider>
  
  );
}

export default App;
