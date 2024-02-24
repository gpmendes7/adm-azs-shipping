# Transporta Aí

API REST desenvolvida em Java para gerenciamento de dados relacionados a transportes e fretes.


## Instalação

Instalar java e conferir versão instalada com o comando:

```bash
java -version
```

Precisa atualizar a variável JAVA_HOME antes de rodar o Maven.

### Windows

Abrir o prompt de comandos ou o Windows PowerShell como adim e digitar o seguinte comando:

```bash
setx /m JAVA_HOME <diretorio>
```

Se por exemplo, o jdk está instalado no diretório "C:\Program Files\Eclipse Adoptium\jdk-17.0.6.10-hotspot",
sustituir <diretorio> por "C:\Program Files\Eclipse Adoptium\jdk-17.0.6.10-hotspot":

```bash
setx /m JAVA_HOME "C:\Program Files\Eclipse Adoptium\jdk-17.0.6.10-hotspot"
```

Conferir se o valor foi alterado com o comando:

```bash
echo %JAVA_HOME%
```

### Linux

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

### Clonar Repositório

Digitar o comando: 

```bash
 mvn clean install
```

### Executar Maven

Digitar o comando: 

```bash
 mvn clean install
```

### Iniciar aplicação

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