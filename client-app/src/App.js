import logo from './logo.svg';
import './App.css';
import { useEffect, useState } from 'react';
import axios from 'axios';

function App() {
  const [categories, setCategories] = useState([]);
  const [token, setToken] = useState();
  useEffect(() => {
    console.log("Component Mount");
    axios.post('http://localhost:8181/token', {
      username: "customer",
      password: "123456"
    }).then(res => setToken(res.data.token));

    
  }, [])

  const handleLoadData = () => {
    axios.get('http://localhost:8181/api/categories', {
      headers: {
        "Authorization": "Bearer " + token
      }
    })
    .then(res => {
      console.log(res);
      setCategories(res.data);
    })
    .catch(error => console.log(error));
  }

  return (
    <>
      <img src='http://localhost:8181/api/files/load/gv_nguyen_duy_quang.jpg' />
      <button onClick={handleLoadData}>Load data</button>
      <table border={1} cellPadding={5} cellSpacing={0} width={'100%'}>
        <thead>
          <tr>
            <th>Tên danh mục</th>
            <th>Danh mục cha</th>
            <th>Trạng thái</th>
          </tr>
          {categories.map(x => {
            return (<tr key={x.id}>
              <td>{x.name}</td>
              <td>{x.parentId}</td>
              <td>{x.status ? 'Active' : 'Inactive'}</td>
            </tr>)
          })}
        </thead>
      </table>
    </>
  );
}

export default App;
