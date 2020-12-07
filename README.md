# loginproject

Tecnologias escolhidas:
<ul>Linguagem Java</ul>
<ul>Framework de testes automatizados: Selenium WebDriver</ul>
<ul>Framework de testes automatizados: Junit</ul>
<ul>Framework de testes automatizados orientados a dados: EasyTest</ul>
<ul>Padrão de escrita de código de testes: PageObjects</ul>

Passo a passo do projeto
1. Classe CreatedWebDriver:

<ul>
<li>Método createdChrome: Método que encontra o driver (arquivo) dentro do projeto e instancia o navegador.</li>
<li>Método screenShot: Realiza o screenshot da tela e salva o arquivo na pasta "imagens" dentro do projeto com o nome recebido por parâmetro.</li>
</ul>

2. Classe BasePage: Utilizada para instanciar o navegador nas classes Pages.

3. Classes PageObject: Classes que possuem as características de cada página da aplicação.

4. Classe LoginTest: Classe que representa a suíte de testes que será executada.
Para execução dos testes é utilizado o arquivo "InfTestData.csv" que contém a massa de dados.

5. Execução

<ul>
Para execução dos testes é possível:
<li>Executar pelo Junit na IDE (executar a classe LoginTest não os métodos. Caso contrário não será possível acessar o arquivo "InfTestData.csv")</li>
<li>Executar pelo Maven (pelo CMD acesse o caminho do projeto e após execute o comando: mvn test)</li>
</ul>
