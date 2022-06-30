import { Route, Routes } from 'react-router-dom';
import './App.css';
import Home from './routes/home';
import Allphones from './routes/allphones';
import Viewuser from './routes/viewuser';
import Createcontact from './routes/createContac';
import Createphone from './routes/createPhone';
import ModifyPhone from './routes/modyPhone';
import ModifyContact from './routes/modyContact';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<Home />}></Route>
        <Route path="/allphones" element={<Allphones />}></Route>
        <Route path="/viewphones" element={<Viewuser></Viewuser>}></Route>
        <Route path="/createcontact" element={<Createcontact></Createcontact>}></Route>
        <Route path="/createphone" element={<Createphone></Createphone>}></Route>
        <Route path="/updatephone" element={<ModifyPhone></ModifyPhone>}></Route>
        <Route path="/updatecontact" element={<ModifyContact></ModifyContact>}></Route>
      </Routes>
    </div>
  );
}

export default App;
