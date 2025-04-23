
# Torneio de Startups – Simulador Java  
Simulação de um torneio entre startups, com batalhas, pontuação e classificação por performance. Desenvolvido por **Luis Felipe Flores Acosta** como exercício prático do programa DELL IT Academy.

---

## Tecnologias Utilizadas

- **Java JDK**: 21.0.2 (2024-01-16 LTS)  
- **IDE**: IntelliJ IDEA 2024.2.3 (Ultimate Edition)  
- **Modo de execução**: Terminal (console)  
- **Banco de dados e interface gráfica**: Não utilizados

---

## Como Executar o Projeto no IntelliJ

### Pré-requisitos

- Java JDK 21 instalado ([Baixe aqui](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html))
- IntelliJ IDEA 2024.2.3 Ultimate (ou Community)

---

### Passo a Passo

#### 1. Extraia o arquivo .zip
- Baixe o arquivo .zip
- Extraia o conteúdo dela

#### 2. Abra o projeto no IntelliJ
- Abra o IntelliJ IDEA
- Vá em **File > Open**
- Selecione a pasta do projeto baixado

#### 3. Configure o JDK 21
- Vá em: `File > Project Structure > Project`
- Em **Project SDK**, selecione **Java 21**
- Se não estiver instalado, clique em **Add SDK > Download JDK**, selecione a versão 21 e aguarde a instalação

#### 4. Compile e execute
- No painel lateral, abra o arquivo `App.java` (geralmente dentro de `src`)
- Clique com o botão direito e selecione **Run 'App.main()'**
- O terminal será aberto com as opções do torneio

---

## Como Usar

O programa roda via terminal e possui um menu interativo para:

- Definir o número de participantes (4, 6 ou 8)
- Cadastrar startups com nome, slogan e data de fundação
- Iniciar batalhas entre startups com pontuação dinâmica
- Aplicar critérios de desempate por sorteio ou performance
- Visualizar resultados do terneio

---

## Estrutura das Classes

```bash
├── src/
│   ├── App.java         # Classe principal e menu do programa
│   ├── Startup.java     # Representação de uma startup (nome, slogan, pontos, etc.)
│   └── Torneio.java     # Lógica do torneio, batalhas e desempates
```

---

## Autor

**Luis Felipe Flores Acosta**  
LinkedIn: https://www.linkedin.com/in/luis-felipe-acosta/
GitHub: https://github.com/Fitshow
