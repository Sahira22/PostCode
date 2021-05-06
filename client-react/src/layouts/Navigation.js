import React from 'react'
import { Navbar, Nav, NavDropdown } from 'react-bootstrap';
import {NavLink} from 'react-router-dom'




export default function Navigation() {
    return (
        <Navbar bg="dark" variant="dark" expand="lg">
        <Navbar.Brand as={NavLink} to="/">PostCode</Navbar.Brand>
        <Navbar.Toggle aria-controls="main-menu"></Navbar.Toggle>
        <Navbar.Collapse id="main-menu">
            <Nav className="mr-auto">
            <Nav.Link>Create Post</Nav.Link>
         </Nav>
         <Nav>
            <Nav.Link>Create Account</Nav.Link>
            <Nav.Link as={NavLink} to="/singin">Iniciar Secion</Nav.Link>
            <NavDropdown title="Usuario" id="menu-dropdown">
            <NavDropdown.Item >My Posts</NavDropdown.Item>
            <NavDropdown.Item>Log out</NavDropdown.Item>
            </NavDropdown>
         </Nav>
        </Navbar.Collapse>
    </Navbar>

    )
}
