# Manual de funcionamento:

<!---Esses são exemplos. Veja https://shields.io para outras pessoas ou para personalizar este conjunto de escudos. Você pode querer incluir dependências, status do projeto e informações de licença aqui--->

![GitHub repo size](https://img.shields.io/github/repo-size/juanbomfim22/AIproject?style=for-the-badge)
![GitHub language count](https://img.shields.io/github/languages/count/juanbomfim22/AIproject?style=for-the-badge) 

![image](https://user-images.githubusercontent.com/55420785/169721670-1605a36f-4ca2-4e5b-8adc-b074f6680659.png)
> Implementação do Problema de Agendamento no Escritório de Trabalho que utiliza a biblioteca [aima-java](https://github.com/aimacode/aima-java) para resolver o Problema de Satisfação de Restrições (PSR)
> 
## 💻 Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:  
* Você instalou a versão mais recente do Java SDK;  
* Você baixou o Eclipse IDE;  
* Você leu todo esse manual.  

## 🚀 Instalando AIproject

Para instalar o AIproject, siga estas etapas (todos SOs):  
1. Fazer o clone do repositório na pasta desejada  
2. Siga as etapas do guia [Rodando no Eclipse IDE](https://github.com/juanbomfim22/AIproject/wiki/Rodando-com-Eclipse-IDE)

## ☕ Usando AIproject

Para usar AIproject, siga estas etapas:  
  
1. Entre na pasta do projeto e abra o arquivo `input.txt`.  
2. Edite os dados de entrada nesse arquivo, respeitando o seguinte padrão:  

 ```
<nome do membro 1> | <horas requeridas de 1> | <horários livres de 1> | <se 1 está vacinado `true`, senão `false`>  
<nome do membro 2> | <horas requeridas de 2> | <horários livres de 2> | <se 2 está vacinado `true`, senão `false`>  
...
<nome do membro n> | <horas requeridas de n> | <horários livres de n> | <se n está vacinado `true`, senão `false`>  
*  
<nome do funcionário que precisa que outro termine seu turno> <nome do funcionário a ser esperado que o turno acabe>  
```  

Exemplo da página 4 da publicação [The Office Scheduling Problem](https://easychair.org/publications/preprint_open/7krz) com restrições adicionais:  
```  
4 21
Alice | 2 | 4 13 19 21 22 | true
Bob | 3 | 6 9 10 14 15 21 | true
Charlie| 1 | 5 8 10 13 14 21 22 23 | false
David | 2 | 1 3 4 5 6 7 19 23 | false
Eve |4 | 2 4 7 10 11 13 14 15 18 21 | false
*
Alice Bob
```
 
Por padrão, as seguintes cinco restrições foram implementadas e ativadas:
1. `AllowVaccinatedConstraint`: Os membros vacionados podem trabalhar no mesmo horário que outros.
2. `DependentMembersConstraint`: O membro A só pode trabalhar após que B concluir todas as suas horas.
3. `FreeWorkHoursConstraint`: Os membros devem trabalhar nas horas que estão livres.
4. `OfficeHourConstraint`: Os membros devem trabalhar dentre o horário de funcionamento do escritório.
5. `WorkLoadConstraint`: Os membros devem trabalhar exatamente a quantidade de horas informada.

Caso deseje alterar, basta comentar e descomentar as restrições de interesse na classe `ScheduleCSP`

Para executar, após configurado o projeto no Eclipse, clique em Run (botão verde na barra superior) e o resultado será apresentado no console.

## 🤝 Colaboradores

As seguintes pessoas contribuíram para este projeto:

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

