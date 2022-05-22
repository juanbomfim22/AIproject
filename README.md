# Manual de funcionamento:

<!---Esses são exemplos. Veja https://shields.io para outras pessoas ou para personalizar este conjunto de escudos. Você pode querer incluir dependências, status do projeto e informações de licença aqui--->

![GitHub repo size](https://img.shields.io/github/repo-size/juanbomfim22/AIproject?style=for-the-badge)
![GitHub language count](https://img.shields.io/github/languages/count/juanbomfim22/AIproject?style=for-the-badge) 

![image](https://user-images.githubusercontent.com/55420785/169701131-6bed8fca-784d-4630-b977-21820c46f414.png)

> Implementação do Problema de Agendamento no Escritório de Trabalho que utiliza a biblioteca [aima-java](https://github.com/aimacode/aima-java) para resolver o Problema de Satisfação de Restrições (PSR)
## Ajustes e melhorias

O projeto ainda está em desenvolvimento e as próximas atualizações serão voltadas nas seguintes tarefas:

- [x] Tarefa 1
- [x] Tarefa 2
- [x] Tarefa 3
- [ ] Tarefa 4
- [ ] Tarefa 5

## 💻 Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:
* Você instalou a versão mais recente do Java SDK;
* Você tem baixou o Eclipse IDE;
* Você leu todo esse manual.

## 🚀 Instalando AIproject

Para instalar o <nome_do_projeto>, siga estas etapas:
Todos SOs:
Basta abrir o Eclipse IDE e fazer o clone desse repositório, outra opção é abrir o projeto já clonado.
OBS: todas dependencias já estão instaladas dentro do repositório (maven).

## ☕ Usando AIproject

Para usar AIproject, siga estas etapas:

Entre na pasta do projeto e abra o .txt
Como esse .txt será a entrada, deve seguir o seguinte padrão:

<hora de início do experiente> < hora de fim do expediente>
<nome do funcionário 1> | <horas requeridas do funcionário> | <horários que o funcionário está livre> | <está vacinado ou não>
.
.
.
<nome do funcionário n> | <horas requeridas do funcionário> | <horários que o funcionário está livre> | <está vacinado ou não>
*
<nome do funcionário que precisa que outro termine seu turno> <nome do funcionário a ser esperado que o turno acabe>

Exemplo:

 1 10
 Alice | 2 | 1 2 3 4 5 | true
 Bob | 2 | 1 2 3 4 5 | true
 Charlie | 2 | 1 2 3 4 5 | true
 *
 Alice Bob

//
Após isso basta alterar no arquivo <x> quais restrições você quer que sejam aplicadas no PSR 
E por fim clicar em Run, o resultado será apresentado no terminal.

## 🤝 Colaboradores

Agradecemos às seguintes pessoas que contribuíram para este projeto:

<table>
  <tr>
    <td align="center">
      <a href="#">
        <img src="https://avatars.githubusercontent.com/u/61395424" width="100px;" alt="Foto de atila-b"/><br>
        <sub>
          <b>atila-b</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="#">
        <img src="https://avatars.githubusercontent.com/u/55420785" width="100px;" alt="Foto de juanbomfim22"/><br>
        <sub>
          <b>juanbomfim22</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="#">
        <img src="https://avatars.githubusercontent.com/u/61337156" width="100px;" alt="Foto de xorj"/><br>
        <sub>
          <b>xorj</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="#">
        <img src="https://avatars.githubusercontent.com/u/62582790" width="100px;" alt="Foto de leld21"/><br>
        <sub>
          <b>leld21</b>
        </sub>
      </a>
    </td>
  </tr>
</table>

