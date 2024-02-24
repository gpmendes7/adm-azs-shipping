# Transporta Aí

<p align='center'>
    <img src="/img/logo.png" alt="Logo Transporta Aí" />
</p>

<p align='center'>
    <img src="https://img.shields.io/badge/status-concluído-green" />    
    <img src="https://img.shields.io/badge/java-17.0.6-blue" />
    <img src="https://img.shields.io/badge/maven-3.8.3-yellow" />
    <img src="https://img.shields.io/badge/lincença-mit-blue" />
</p>

## Índice

<ul>
  <li><a href="#descricao">Descrição</a></li>
  <li><a href="#instalacao">Instalação</a></li>
  <li><a href="#windows">Windows</a></li>
  <li><a href="#linux">Linux</a></li>
  <li><a href="#clonar-repositorio">Clonar Repositório</a></li>
  <li><a href="#executar-maven">Excecutar Maven</a></li>
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

#### Iniciar aplicação

Digitar o comando: 

```bash
 mvn spring-boot:run
```

Use the package manager [pip](https://pip.pypa.io/en/stable/) to install foobar.

```bash
pip install foobar
```

## Usage

```python
import foobar

# returns 'words'
foobar.pluralize('word')

# returns 'geese'
foobar.pluralize('goose')

# returns 'phenomenon'
foobar.singularize('phenomena')
```

## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License

[MIT](https://choosealicense.com/licenses/mit/)

# badges

# Liceca