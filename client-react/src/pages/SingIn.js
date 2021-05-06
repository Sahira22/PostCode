import React, {useEffect, useState} from 'react';
import { Container,Row, Col, Card } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import SingInForm from '../components/forms/SingInForm';
import { useDispatch} from 'react-redux';


export default function SingIn() {
    const[errors,setErrors]=useState({});
    const dispatch =useDispatch();

    useEffect(()=>{


    });

    const login=({ email, password}) =>{
        const errors={};
        setErrors(errors);
    }


    return (
        <Container className="mt-5">
            <Row>
                <Col sm="12" md={{span:8, offset:2}} md={{span:6, offset:3}}>
                    <Card body>
                        <h3>Inciar Sesion</h3>
                        <SingInForm errors={{}} onSubmitCallback={null}></SingInForm>
                        <div className="mt-4">
                            <Link to="">No tienes una cuenta? Registrateaqui</Link>
                        </div>
                    </Card>

                </Col>
            </Row>
        </Container>
    )
}
