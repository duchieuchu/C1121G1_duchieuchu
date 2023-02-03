import React from "react";
import './App.css';
// import './style.css'
import 'bootstrap/dist/css/bootstrap.css'

class App extends React.Component {
    render() {
        var i = 1;
        var myStyle = {
            fontsize: 100,
            color: 'red'
        }
        return (
            <div>
                <p>Hello World</p>
                <button className="btn btn-danger">Danger</button>
            </div>
        )
    }
}

export default App;
