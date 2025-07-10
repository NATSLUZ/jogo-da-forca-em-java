# 🎮 Jogo da Forca em Java

---

## 📚 Sobre o Projeto

Este projeto é um **Jogo da Forca** desenvolvido em **Java**, criado como parte da disciplina **Arquitetura de Software e Padrões de Projetos** na **UNEB** Campus II Alagoinhas.

Ele demonstra na prática o uso de **dois padrões de projeto obrigatórios**:
- ✅ **Adapter**
- ✅ **Template Method**

---

## 🎯 Objetivo

O objetivo do jogo é **não deixar o estudante da UNEB ser enforcado!**
Você deve adivinhar as palavras sorteadas antes de atingir o limite de tentativas.

---

## 👥 Modos de Jogo

- 🧑‍💻 **Solo**: 1 jogador tenta sobreviver por 5 rodadas.
- 👥 **Multiplayer**: 2 jogadores se revezam, disputando quem faz mais pontos em até 10 rodadas.
- 🏆 **Ranking**: O jogo salva e exibe o ranking de pontuação para Solo e Multiplayer.

---

## 🖥️ Interface

O jogo conta com uma **interface gráfica** feita com **Java Swing** (`JFrame`), garantindo uma experiência visual interativa para o usuário.

---

## 🔗 Padrões de Projeto Usados

### ✅ Adapter
Permite que o jogo carregue palavras **de arquivos `.txt` linha por linha** e também de um **arquivo `.json` com palavras e dicas**, adaptando o formato para o fluxo interno do jogo.

### ✅ Template Method
Define o **fluxo principal do jogo** na classe abstrata `JogoDaForca`.
As subclasses (`JogoSolo` e `JogoMultiplayer`) implementam as partes específicas — como preparar jogadores, controlar turnos e finalizar a sessão.

---

## ⚙️ Tecnologias Usadas

- Java
- Java Swing (JFrame)
- Padrões de Projeto (GoF)
- Git & GitHub
- IDE IntelliJ IDEA

---

## 🚀 Como Jogar

1. Clone o repositório:
   ```bash
   git clone https://github.com/NATSLUZ/jogo-da-forca-em-java.git
   ```

2. Abra o projeto no **IntelliJ IDEA**.

3. Compile e execute o projeto.

4. Escolha **Solo** ou **Multiplayer**, selecione um tema e divirta-se!

---

## 👨‍🏫 Autores

- **Professor Orientador:** Larissa Rocha
- **Programadores:** Natan Luz & Yude Lima
- **Artes:** Natan Luz & Diego Luz

---

## 📖 Licença

Projeto criado para fins **acadêmicos**, demonstrando boas práticas de **Arquitetura de Software** e **Padrões de Projeto**.

---

**Não deixe o estudante ser enforcado! 🎓**
