import React, { useEffect, useState } from 'react'
import axios from 'axios';

export default function HomeAdmin() {
    const [categories, setCategories] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8181/api/categories', {
            headers: {
                "Authorization": "Bearer " + sessionStorage.getItem('token')
            }
        })
        .then(res => {
            console.log(res);
            setCategories(res.data);
        })
        .catch(error => console.log(error));
        return () => {
        }
    }, [])
    return (
        <div>
            <h1>Home Admin pages</h1>
            <table border={1} cellPadding={5} cellSpacing={0} width={'100%'}>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Status</th>
                </tr>
                {categories.map(x => {
                    return (
                        <tr>
                            <td>{x.id}</td>
                            <td>{x.name}</td>
                            <td>{x.status?'Active' : 'Inactive'}</td>
                        </tr>
                    )
                })}
            </table>
        </div>
    )
}
