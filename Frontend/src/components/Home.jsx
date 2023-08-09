import React, { useState, useEffect } from "react";
import "./Home.css";

const Home = () => {
  const [skills, setSkills] = useState([]);
  const [showModal, setShowModal] = useState(false);
  const [selectedSkill, setSelectedSkill] = useState("");
  const [selectedLevel, setSelectedLevel] = useState("");

  // Simulação de dados das skills
  const mockSkills = [
    { id: 1, nome: "HTML", level: "Intermedário", descricao: "Descrição da Skill HTML" },
    { id: 2, nome: "CSS", level: "Intermediário", descricao: "Descrição da Skill CSS" },
    { id: 3, nome: "JavaScript", level: "Avançado", descricao: "Descrição da Skill JavaScript" },
    { id: 4, nome: "React", level: "Avançado", descricao: "Descrição da Skill React" },
    { id: 5, nome: "Node.js", level: "Intermediário", descricao: "Descrição da Skill Node.js" },
    { id: 6, nome: "Python", level: "Intermediário", descricao: "Descrição da Skill Python" },
    { id: 7, nome: "Java", level: "Intermediário", descricao: "Descrição da Skill Java" },
    { id: 8, nome: "C#", level: "Iniciante", descricao: "Descrição da Skill C#" },
    { id: 9, nome: "SQL", level: "Intermediário", descricao: "Descrição da Skill SQL" },
    { id: 10, nome: "Git", level: "Intermediário", descricao: "Descrição da Skill Git" },
    { id: 11, nome: "Docker", level: "Intermediário", descricao: "Descrição da Skill Docker" },
    { id: 12, nome: "AWS", level: "Iniciante", descricao: "Descrição da Skill AWS" },
    { id: 13, nome: "Machine Learning", level: "Avançado", descricao: "Descrição da Skill Machine Learning" },
    { id: 14, nome: "Data Analysis", level: "Intermediário", descricao: "Descrição da Skill Data Analysis" },
    { id: 15, nome: "UI/UX Design", level: "Iniciante", descricao: "Descrição da Skill UI/UX Design" },
    { id: 16, nome: "Ruby on Rails", level: "Intermediário", descricao: "Descrição da Skill Ruby on Rails" },
    { id: 17, nome: "PHP", level: "Iniciante", descricao: "Descrição da Skill PHP" },
    { id: 18, nome: "Swift", level: "Iniciante", descricao: "Descrição da Skill Swift" },
    { id: 19, nome: "Kotlin", level: "Intermediário", descricao: "Descrição da Skill Kotlin" },
    { id: 20, nome: "Flutter", level: "Intermediário", descricao: "Descrição da Skill Flutter" },
  ];
  

  useEffect(() => {
    setSkills(mockSkills);
  }, []);

  const handleLevelChange = (index, newLevel) => {
    const updatedSkills = [...skills];
    updatedSkills[index].level = newLevel;
    setSkills(updatedSkills);
  };

  const handleExcluirSkill = (index) => {
    const updatedSkills = skills.filter((_, i) => i !== index);
    setSkills(updatedSkills);
  };

  const handleAdicionarSkill = () => {
    setShowModal(true);
  };

  const handleSaveSkill = () => {
    // Lógica para salvar a nova skill
    setShowModal(false);
  };

  const handleCancelSkill = () => {
    setShowModal(false);
    setSelectedSkill("");
    setSelectedLevel("");
  };

  const handleLogout = () => {
    // Lógica para logout
  };

  return (
    <div>
      <header>
        {"Home"}
      </header>
      <div className="main-content">
        <button onClick={handleAdicionarSkill}>Adicionar Skill</button>
        <button onClick={handleLogout}>Logout</button>
        <ul>
          {skills.map((skill, index) => (
            <li key={skill.id}>
              {/* Conteúdo da skill */}
            </li>
          ))}
        </ul>
      </div>
      {showModal && (
        <div className="modal-boleto">
          <div className="modal-boleto-container">
            <div className="modal-boleto-header">
              <h1>Adicionar Skill</h1>
              <button onClick={handleCancelSkill}>X</button>
            </div>
            <div className="modal-boleto-content">
              <select
                value={selectedSkill}
                onChange={(e) => setSelectedSkill(e.target.value)}
              >
                {/* Opções da combo */}
              </select>
              <input
                type="text"
                value={selectedLevel}
                onChange={(e) => setSelectedLevel(e.target.value)}
                placeholder="Nível da Skill"
              />
              <button onClick={handleSaveSkill}>Salvar</button>
            </div>
          </div>
        </div>
      )}
    </div>
  );
};

export default Home;
