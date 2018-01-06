import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import AutorBox from './Autor';
//import LivroAdmin from './Livro';
import Home from './Home';
import './index.css';
import {BrowserRouter as Router, Route,Switch,Link} from 'react-router-dom';

ReactDOM.render((
        <Router>
            <App>
                    <Switch>            
                        <Route exact path="/" component={Home}/>
                        <Route path="/autor" component={AutorBox}/>
                        <Route path="/livro" />                
                    </Switch>            
            </App>
        </Router>

), document.getElementById('root'));