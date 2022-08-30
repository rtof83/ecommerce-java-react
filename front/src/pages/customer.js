import React, { useEffect, useState } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import api from '../api';

import Grid from '@mui/material/Grid';
import Button from '@mui/material/Button';
import IconButton from '@mui/material/IconButton';
import OutlinedInput from '@mui/material/OutlinedInput';
import InputLabel from '@mui/material/InputLabel';
import InputAdornment from '@mui/material/InputAdornment';
import FormControl from '@mui/material/FormControl';
import TextField from '@mui/material/TextField';
import Visibility from '@mui/icons-material/Visibility';
import VisibilityOff from '@mui/icons-material/VisibilityOff';

const Customer = () => {
    const [ values, setValues ] = useState({ name: '',
                                             address: '',
                                             email: '',
                                             cpf: '',
                                             phone: '',
                                             birth: '' });

    const navigate = useNavigate();
    const { id } = useParams();

    // const [ showDate, setShowDate ] = useState('');
    const datateste = new Date('1996-01-01T00:00:00.000+00:00');

    const insertCustomer = async () => {
      if (!values.name || !values.address || !values.cpf) {
        alert('Atenção! Os campos obrigatórios devem ser preenchidos.')
      } else {
        const customer = { name: values.name,
                           address: values.address,
                           email: values.email,
                           cpf: values.cpf,
                           phone: values.phone,
                           birth: values.birth,
                           password: values.password };
                           
        if (id) {
          await api.put(`customers/${id}`, customer)
            .then(navigate('/listCust'))
            .catch(e => console.log(e));
        } else {
          await api.post('customers', customer)
            .then(navigate('/listCust'))
            .catch(e => console.log(e));
        }
      }
    }
    
      const handleClickShowPassword = () => {
        setValues({
          ...values,
          showPassword: !values.showPassword,
        });
      };
    
      const handleMouseDownPassword = (event) => {
        event.preventDefault();
      };

      const getCustomer = async () => {
        if (id) {
          await api.get(`customers/${id}`)
            .then(({ data }) => {
              setValues({ name: data.name,
                          address: data.address,
                          email: data.email,
                          cpf: data.cpf,
                          phone: data.phone,
                          birth: data.birth,
                          password: data.password });
            })
            .catch(e => console.log(e));
        }
      }

      useEffect(() => {
        // setShowDate(values.birth);
        console.log(values.birth);
      }, [values]);

      useEffect(() => {
        getCustomer();
      }, []);
    
      return (
        <>
        <h3>Cadastro de Clientes</h3>

        {/* -------------------------------- */}
        <br /> variavel birth <span />
        {values.birth}
        <br /> pt-br <span />
        {new Date(datateste.getFullYear(), datateste.getMonth(), datateste.getDate()).toLocaleDateString('pt-BR')}
        <br /> us <span />
        {/* {new Date('31-12-1983'.split('-').reverse().join('-'))} */}
        {'31-12-1983'.split('-').reverse().join('-')}
        {/* -------------------------------- */}

        <div className="gridCustomer">

        <Grid gap={3}
              container
              direction="column"
              justifyContent="space-evenly"
              alignItems="stretch"
              className="gridCustomer">

            { id && <TextField id="outlined-basic" label="Id" variant="outlined" value={id} disabled /> }
            <TextField required id="outlined-basic" label="Nome" variant="outlined" value={values.name} onChange={e => setValues({...values, name: e.target.value})} />
            <TextField id="outlined-basic" label="Endereço" variant="outlined" value={values.address} onChange={e => setValues({...values, address: e.target.value})} />
            <TextField required id="outlined-basic" label="E-mail" variant="outlined" value={values.email} onChange={e => setValues({...values, email: e.target.value})} />
            <TextField required id="outlined-basic" label="CPF" variant="outlined" value={values.cpf} onChange={e => setValues({...values, cpf: e.target.value})} />
            <TextField required id="outlined-basic" label="Telefone" variant="outlined" value={values.phone} onChange={e => setValues({...values, phone: e.target.value})} />
            <TextField type="date" required id="outlined-basic" label="Nascimento" variant="outlined" value={values.birth} onChange={e => setValues({...values, birth: e.target.value})} />

            <FormControl required variant="outlined">
              <InputLabel htmlFor="outlined-adornment-password">Senha</InputLabel>
              <OutlinedInput
                id="outlined-adornment-password"
                type={values.showPassword ? 'text' : 'password'}
                value={values.password}
                onChange={e => setValues({...values, pass: e.target.value})}
                endAdornment={
                  <InputAdornment position="end">
                    <IconButton
                      aria-label="toggle password visibility"
                      onClick={handleClickShowPassword}
                      onMouseDown={handleMouseDownPassword}
                      edge="end"
                    >
                      {values.showPassword ? <VisibilityOff /> : <Visibility />}
                    </IconButton>
                  </InputAdornment>
                }
                label="Password"
              />
        </FormControl>
        
        </Grid>

        <Grid gap={3}
              container
              direction="row"
              justifyContent="center"
              alignItems="center"
              className="gridButton">

          <Button onClick={() => insertCustomer()} variant="contained">Salvar</Button>

          <Link to={'/'}>
            <Button variant="contained">Cancelar</Button>
          </Link>
        </Grid>
        </div>
        </>
      );
};

export default Customer;
