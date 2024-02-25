<p align='center'>
    <img src="/img/logo.png" alt="Logo Transporta Aí" />
</p>

<p align='center'>
    <img src="https://img.shields.io/badge/status-concluído-green" />    
    <img src="https://img.shields.io/badge/java-17.0.6-blue" />
    <img src="https://img.shields.io/badge/junit-5.9.2-lightgray" />
    <img src="https://img.shields.io/badge/springboot-3.2.2-red" />
    <img src="https://img.shields.io/badge/maven-3.8.3-yellow" />
    <img src="https://img.shields.io/badge/modelmapper-3.2.0-pink" />
    <img src="https://img.shields.io/badge/springdoc-3.2.0-purple" />
    <img src="https://img.shields.io/badge/lincença-mit-lightblue" />
</p>

<h1>Sobre</h1>

<strong>TrasportaAi</strong> é uma API REST desenvolvida em Java para gerenciamento de dados relacionados a fretes
de cargas ou mercadorias.
Dentre os dados armazenados podem ser citados:

* cubagem da carga do frete (relação entre o peso e o volume da carga em m<sup>3</sup>)
* peso da carga do frete (em kg)
* distância do frete (em km<sup>2</sup>)
* tempo do frete (em horas)

<h2 id="tecnicas">Técnicas e tecnologias utilizadas</h2>

* Java 17
* [JUnit](https://junit.org/junit5/)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [H2](https://www.h2database.com/html/main.html)
* [Maven](https://maven.apache.org/)
* [Model Mapper](https://modelmapper.org/)
* [Lombok](https://projectlombok.org/)
* [OpenAPI](https://springdoc.org/)
* [Postman](https://www.postman.com/)
* MVC
* IntelliJ IDEA
* PostMan

<h2 id="ambiente">Ambiente de desenvolvimento</h2>

Para montar e rodar o ambiente de desenvolvimento pode-se 
utilizar uma IDE como o IntelliJ IDEA ou o próprio terminal do
sistema operacional.

<ul>
  <li><a href="#java">Instalar java</a></li>
  <li><a href="#maven">Instalar maven</a></li>
  <li><a href="#javahome">Atualizar variável JAVA_HOME</a></li>
  <li><a href="#clonar-repositorio">Clonar Repositório</a></li>
  <li><a href="#executar">Executar a aplicação</a></li>
  <li><a href="#endpoints">Testando os endpoints</a></li>
  <li><a href="#openapi">Documentação da API no OpenAPI</a></li>
  <li><a href="#h2">Acessar banco de dados H2</a></li>
  <li><a href="#licenca">Licença</a></li>
</ul>

A seguir seguem-se algumas instruções para executar o ambiente
diretamente pelo terminal do sistema operacional.

<h3 id="java">Instalar java</h3>

Instalar java (versão 17 ou superior) e conferir versão instalada com o comando :

```bash
java -version
```

<h3 id="maven">Instalar maven</h3>

Instalar maven e conferir versão instalada com o comando :

```bash
mvn -version
```

<h3 id="javahome">Atualizar JAVA_HOME</h3>

Precisa atualizar a variável JAVA_HOME antes de rodar o Maven.

<h4 id="windows">Windows</h4>

Abrir o prompt de comandos ou o Windows PowerShell como adim e digitar o seguinte comando :

```bash
setx /m JAVA_HOME <diretorio>
```

Se por exemplo, o jdk está instalado no diretório "C:\Program Files\Eclipse Adoptium\jdk-17.0.6.10-hotspot", <br/>
sustituir &lt;diretorio&gt; por "C:\Program Files\Eclipse Adoptium\jdk-17.0.6.10-hotspot" :

```bash
setx /m JAVA_HOME "C:\Program Files\Eclipse Adoptium\jdk-17.0.6.10-hotspot"
```

Conferir se o valor foi alterado com o comando:

```bash
echo %JAVA_HOME%
```

<h4 id="linux">Linux</h4>

Abrir terminal de comandos e digitar os comandos: 


```bash
export JAVA_HOME= <path to JDK>
export PATH=$PATH:$JAVA_HOME/bin
```

Se por exemplo, o jdk está instalado no diretório /usr/java/jdk1.7.0_05/,
sustituir <path to JDK> por /usr/java/jdk1.7.0_05/:

```bash
export JAVA_HOME= /usr/java/jdk1.7.0_05/
export PATH=$PATH:$JAVA_HOME/bin
```

<h3 id="clonar-repositorio">Clonar Repositório</h3>

```bash
 git clone https://github.com/gpmendes7/adm-azs-shipping.git
```

<h3 id="executar">Executar a aplicação</h3>

Para fazer o build da aplicação (baixar as dependências do projeto), digitar o comando: 

```bash
 mvn clean install
```

Para rodar os testes da aplicação, digitar o comando: :

```bash
 mvn test
```

Para iniciar a aplicação, digitar o comando: 

```bash
 mvn spring-boot:run
```

<h3 id="endpoints">Testando os endpoints</h3>

É possível testar os endpoints com a ferramenta [postman](https://www.postman.com/) ou digitar comandos
diretamente pelo terminal do sistema operacional.
Em essência utiliza-se o [curl](https://shorturl.at/eknN1),
uma ferramenta para transferência de dados entre cliente/servidor que usa vários protocolos como o HTTP e o FTP.


<h4>Testando endpoint de listar fretes</h4>

```bash
  curl http://localhost:8080/api/v1/fretes
```

Também é possível modificar a quantidade de registros alterando-se os parâmmetros da paginação <br/>
que, por default, page=0 e size=5 :

```bash
  curl -G -d "page=0" -d "size=100" http://localhost:8080/api/v1/fretes
```

<h4>Testando endpoint de criar frete</h4>

```bash
  curl -X POST http://localhost:8080/api/v1/fretes -H "Content-type:application/json" -d "{\"cubagem\":20.55, \"peso\":1000.00, \"distancia\":90.5, \"tempo\":2}"
```

Ou passando os parâmetros diretamente na requisição :

```bash
  curl "http://localhost:8080/api/v1/fretes?page=0&size=100"
```

<h3 id="openapi">Documentação da API no OpenAPI</h3>

Rodar no navegador o comando :

```bash
  http://localhost:8080/swagger-ui/index.html
```

<h3 id="h2">Acessar banco de dados H2</h3>

Digitar no navegador a url :

```bash
 http://localhost:8080/h2-console
```

<h3 id="autores">Autores</h3>

| [<img loading="lazy" src="https://avatars.githubusercontent.com/u/12829540?v=4" width=115><br><sub>Gabriel Mendes</sub>](https://github.com/gpmendes7) | 
| :---: | 

<h3 id="licenca">Licença</h3>

[MIT](https://choosealicense.com/licenses/mit/)
