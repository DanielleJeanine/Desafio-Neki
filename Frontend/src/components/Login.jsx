import React, { useState, useContext } from 'react';
import { useNavigate } from 'react-router-dom';

import { AuthContext } from '../context/AuthContext';
import './Login.Style.css';

const Login = () => {
  const navigate = useNavigate();
  const [login, setLogin] = useState('');
  const [password, setPassword] = useState('');
  const [showPassword, setShowPassword] = useState(false);
  const [rememberPassword, setRememberPassword] = useState(false);
  const { loginSuccess } = useContext(AuthContext);

  const handleLoginChange = (e) => {
    setLogin(e.target.value);
  };

  const handleSenhaChange = (e) => {
    setPassword(e.target.value);
  };

  const handleShowPassword = () => {
    setShowPassword(!showPassword);
  };

  const handleRememberPasswordChange = () => {
    setRememberPassword(!rememberPassword);
  };

  const handleCadastrarClick = () => {
    navigate('/cadastrar');
  };


  const handleEntrarClick = () => {
    // Simulando a autenticação com um usuário fixo
    if (login === 'dani' && password === 'senha123') {
      if (rememberPassword) {
        localStorage.setItem('rememberedLogin', login);
        localStorage.setItem('rememberedPassword', password);
      } else {
        localStorage.removeItem('rememberedLogin');
        localStorage.removeItem('rememberedPassword');
      }
      loginSuccess(); 
      
      navigate('/home');
    } else {
      alert('Credenciais inválidas');
    }
  };

  
  React.useEffect(() => {
    const rememberedLogin = localStorage.getItem('rememberedLogin');
    const rememberedPassword = localStorage.getItem('rememberedPassword');
    if (rememberedLogin && rememberedPassword) {
      setLogin(rememberedLogin);
      setPassword(rememberedPassword);
      setRememberPassword(true);
    }
  }, []);

  return (
    <div>
      <form className="form">
      <span className="signup">Sign Up</span>
      <div className="input-div">
      <input className="form--input" type="text" value={login} onChange={handleLoginChange} placeholder="Login" />
      <input
      className="form--input"
        type={showPassword ? 'text' : 'password'}
        value={password}
        onChange={handleSenhaChange}
        placeholder="Senha"
      />
      </div>
      <div className="check-div">
      <label>
        <input className="checkbox" type="checkbox" checked={showPassword} onChange={handleShowPassword} />
        Mostrar Senha
      </label>
      <label>
        <input
        className="checkbox"
          type="checkbox"
          checked={rememberPassword}
          onChange={handleRememberPasswordChange}
        />
        Gravar Senha
      </label>
      </div>
      <div className="btn-div">
      <button className="form--submit" onClick={handleEntrarClick}>Entrar</button>
      <button className="form--submit" onClick={handleCadastrarClick}>Cadastrar-se</button>
      </div>
      </form>
    </div>
  );
};

export default Login;
