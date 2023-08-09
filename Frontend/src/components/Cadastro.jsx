import React, { useState } from "react";
import { FaEye, FaEyeSlash } from "react-icons/fa";
import './Cadastro.Style.css';
import { useNavigate } from 'react-router-dom';


const Cadastro = () => {
  const navigate = useNavigate();

  const [login, setLogin] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [showPassword, setShowPassword] = useState(false);
  const [showConfirmPassword, setShowConfirmPassword] = useState(false);
  const [successMessage, setSuccessMessage] = useState("");
  const [errorMessage, setErrorMessage] = useState("");



  const handleSignUp = () => {
    if (password !== confirmPassword) {
      setErrorMessage("As senhas digitadas não são iguais.");
      return;
    }

    // Substituir callSignupEndpoint com endpoint do back
    // Simulando mensaagem de cadastro bem sucedido
    setSuccessMessage("Cadastro realizado com sucesso!");
    navigate('/');
  };

  const handleTogglePasswordVisibility = () => {
    setShowPassword(!showPassword);
  };

  const handleToggleConfirmPasswordVisibility = () => {
    setShowConfirmPassword(!showConfirmPassword);
  };

  return (
    <div className="container">
    <form className="form">
      <h1>Cadastrar</h1>
      <div className="input-div">
        <label>Login:</label>
        <input
          className="form--input"
          type="text"
          value={login}
          onChange={(e) => setLogin(e.target.value)}
        />
      </div>
  
      <div className="input-div">
        <label>Senha:</label>
        <div className="input-with-icon">
          <input
            className="form--input"
            type={showPassword ? "text" : "password"}
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
          {showPassword ? (
            <FaEyeSlash
              className="password-icon"
              onClick={handleTogglePasswordVisibility}
            />
          ) : (
            <FaEye
              className="password-icon"
              onClick={handleTogglePasswordVisibility}
            />
          )}
        </div>
      </div>
  
      <div className="input-div">
        <label>Confirmar Senha:</label>
        <div className="input-with-icon">
          <input
            className="form--input"
            type={showConfirmPassword ? "text" : "password"}
            value={confirmPassword}
            onChange={(e) => setConfirmPassword(e.target.value)}
          />
          {showConfirmPassword ? (
            <FaEyeSlash
              className="password-icon"
              onClick={handleToggleConfirmPasswordVisibility}
            />
          ) : (
            <FaEye
              className="password-icon"
              onClick={handleToggleConfirmPasswordVisibility}
            />
          )}
        </div>
      </div>
  
      <div className="btn-div">
        <button
          className="form--button"
          type="button"
          onClick={handleTogglePasswordVisibility}
        >
          {showPassword ? "Ocultar Senha" : "Mostrar Senha"}
        </button>
      </div>
      {errorMessage && <p className="error-message">{errorMessage}</p>}
      {successMessage && <p className="success-message">{successMessage}</p>}
      <button className="form--submit" onClick={handleSignUp}>
        Salvar
      </button>
    </form>
  </div>
  
  );
};

export default Cadastro;
