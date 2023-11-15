import React from 'react'
import {BrowserRouter, Routes, Route} from 'react-router-dom';
import Login from './components/admin/Login.component';
import Home from './components/client/Home.component';
import AuthRoute from './components/config/AuthRoute';
import HomeAdmin from './components/admin/HomeAdmin.component';

export default function AppIndex() {
    return (
        <>
            <div>
                <h1>AppIndex</h1>
                <BrowserRouter>
                    <Routes>
                        <Route path="/login" element={<Login />}></Route>
                        <Route path="/admin" element={<AuthRoute element={<HomeAdmin />} />}></Route>
                        <Route index path="/" element={<Home />}></Route>
                    </Routes>
                </BrowserRouter>
            </div>
        </>
    )
}
