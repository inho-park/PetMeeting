import logo from './logo.svg';
import './App.css';
import {useEffect, useState} from "react";
import axios from 'axios';

function App() {
    const [hello, setHello] = useState('')

    useEffect(() => {
        axios.get('/main/hello')
            .then(response => setHello(response.data))
            .catch(error => console.log(error))
    }, []);

    return (
        <div>
             {hello}
        </div>
    );
}

export default App;
