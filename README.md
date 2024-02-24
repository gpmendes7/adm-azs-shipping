# Transporta Aí

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

## Índice

<ul>
  <li><a href="#descricao">Descrição</a></li>
  <li><a href="#instalacao">Instalação</a></li>
  <li><a href="#windows">Windows</a></li>
  <li><a href="#linux">Linux</a></li>
  <li><a href="#clonar-repositorio">Clonar Repositório</a></li>
  <li><a href="#executar-maven">Excecutar Maven</a></li>
  <li><a href="#iniciar">Iniciar aplicação</a></li>
  <li><a href="#testar-listar">Testar endpoint de listar fretes</a></li>
  <li><a href="#testar-criar">Testar endpoint de criar frete</a></li>
  <li><a href="#tecnicas">Técnicas e tecnologias utilizadas</a></li>
  <li><a href="#licenca">Licença</a></li>
</ul>

<h2 id="descricao">Descrição</h2>

API REST desenvolvida em Java para gerenciamento de dados relacionados a transportes e fretes.


<h2 id="instalacao">Instalação</h2>

Instalar java e conferir versão instalada com o comando :

```bash
java -version
```

Precisa atualizar a variável JAVA_HOME antes de rodar o Maven.

<h3 id="windows">Windows</h3>

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

<h3 id="linux">Linux</h3>

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

Digitar o comando: 

```bash
 mvn clean install
```

<h3 id="executar-maven">Executar Maven</h3>

Digitar o comando: 

```bash
 mvn clean install
```

<h3 id="iniciar">Iniciar aplicação</h3>

Digitar o comando: 

```bash
 mvn spring-boot:run
```

<h3 id="testar-listar">Testar endpoint de listar fretes</h3>

É possível testar com a ferramenta postman ou digitar o comando no prompt de comandos :

```bash
  curl http://localhost:8080/api/v1/fretes
```

Também é possível modificar a quantidade de registros alterando-se os parâmmetros da paginação <br/>
que, por default, page=0 e size=5 :

```bash
  curl -G -d "page=0" -d "size=100" http://localhost:8080/api/v1/fretes
```

<h3 id="testar-criar">Testar endpoint de criar frete</h3>

É possível testar com a ferramenta postman ou digitar o comando no prompt de comandos :

```bash
  curl -X POST http://localhost:8080/api/v1/fretes -H "Content-type:application/json" -d "{\"cubagem\":20.55, \"peso\":1000.00, \"distancia\":90.5, \"tempo\":2}"
```

<h3 id="tecnicas">Técnicas e tecnologias utilizadas</h3>

* Java 17
* [JUnit](https://junit.org/junit5/)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [H2](https://www.h2database.com/html/main.html)
* [Maven](https://maven.apache.org/)
* [Model Mapper](https://modelmapper.org/) 
* [Lombok](https://projectlombok.org/)
* MVC
* IntelliJ IDEA
* PostMan

<h3 id="autores">Autores</h3>
[<img loading="lazy" src="https://avatars.githubusercontent.com/u/12829540?v=4" width=115><br><sub>Gabriel Mendes</sub>](https://github.com/gpmendes7)
<h3 id="licenca">Licença</h3>

[MIT](https://choosealicense.com/licenses/mit/)
