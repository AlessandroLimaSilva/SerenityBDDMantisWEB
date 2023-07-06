# Framework de Teste de API com RestAssured com Ambiente CI/CD de Testes automatizados

Neste tutorial, vamos explorar como configurar um ambiente Jenkins CI/CD, utilizando o Docker para montar um ambiente com os contêineres do MantisBT, MySQL e Jenkins, juntamente com o uso do framework de teste de API RestAssured. O ambiente de testes Docker fornecerá uma infraestrutura completa e escalável para executar testes de API do MantisBT API de forma automatizada e controlada.
Ao Final deste tutorial teremos implementado um Pipepline com CI/CD completo de testes automatizados.

## Ambiente de Testes Docker

O ambiente de testes Docker contém os seguintes contêineres:

- **MantisBT 2.22.1**: um sistema de gerenciamento de problemas e rastreamento de defeitos, usado para acompanhar e resolver problemas em um projeto de software.
- **MySQL 5.7**: um sistema de gerenciamento de banco de dados relacional, utilizado para armazenar e recuperar dados necessários para os testes.
- **Jenkins 2.401.1**: uma plataforma de automação de CI/CD (Integração Contínua/Entrega Contínua), que permite criar e executar pipelines de testes automatizados.

A combinação do RestAssured com o ambiente de testes Docker nos permite realizar testes completos de ponta a ponta em APIs RESTful.

Vamos começar a aproveitar os benefícios deste ambiente de teste poderoso para automatizar e validar suas APIs RESTful usando o framework RestAssured!


# Framework de Teste de API com RestAssured

Este é um projeto de framework de teste de API altamente eficiente, desenvolvido para simplificar e agilizar o processo de validação de APIs RESTful. Com base nas bibliotecas mais poderosas e populares do ecossistema Java, este framework oferece uma estrutura robusta e flexível para a automação de testes de API.

## Recursos Destacados

- **Java**: Linguagem de programação versátil, orientada a objetos e altamente portátil, com um vasto ecossistema de bibliotecas e ferramentas. É amplamente utilizado para o desenvolvimento de aplicativos empresariais, web e móveis devido à sua segurança, desempenho e facilidade de uso.

- **Cucumber**: Aproveite o poder do BDD (Behavior-Driven Development) com o Cucumber, uma biblioteca que permite escrever testes em uma linguagem de domínio específica (Gherkin) e executá-los em um formato legível para não desenvolvedores. Isso facilita a colaboração entre equipes técnicas e não técnicas.

- **RestAssured**: Simplifique a validação de APIs RESTful com o RestAssured, uma biblioteca Java poderosa e intuitiva que oferece uma sintaxe amigável para a criação de testes de integração de API. Através do RestAssured, você pode facilmente enviar requisições HTTP, validar respostas, extrair dados e muito mais.

- **JUnit 4**: Aproveite os recursos do JUnit 4, um framework de teste unitário amplamente utilizado para Java. Ele permite que você defina casos de teste individuais, organize-os em suítes de testes e execute-os com eficiência. O JUnit 4 também oferece recursos avançados, como anotações de configuração e assertivas poderosas.

- **Extent Reporter**: Desfrute de relatórios de testes detalhados e atraentes com o Extent Reporter, uma biblioteca que oferece recursos avançados de geração de relatórios. Com o Extent Reporter, você terá uma visão clara sobre o status dos testes executados, métricas de desempenho e resultados.

- **Jackson Databind**: O Jackson Databind é uma biblioteca de serialização e desserialização JSON muito popular no ecossistema Java. Com ele, você pode converter facilmente objetos Java em formato JSON e vice-versa. Ele fornece uma maneira simples e eficiente de trabalhar com dados JSON em seus testes de API.

- **MySQL**: Aproveite a integração com o MySQL para armazenar e gerenciar dados em seus testes. O MySQL é um sistema de gerenciamento de banco de dados relacional amplamente utilizado, conhecido por sua confiabilidade e desempenho. Com o MySQL, você pode criar tabelas, inserir dados, realizar consultas e muito mais, tornando-o uma escolha poderosa para o armazenamento e recuperação de dados em seus testes.


## Configuração e Execução
    
### Pré-requisitos
### Hardware:
- Processador: Intel Core i7-7700HQ ou AMD Ryzen 5600G
- Memória RAM: 16 GB
- Armazenamento: 20GB de espaço livre
- Conectividade: Acesso à Internet estável

### Software:

#### S.O Ubuntu 22.04 : 
<details>
  <summary>Como instalar o Ubuntu 22.04</summary>

## Passo a passo para instalar o Ubuntu 22.04:

1. Faça o download da imagem ISO do Ubuntu 22.04 no [site oficial do Ubuntu](https://releases.ubuntu.com/22.04/).

2. Grave a imagem ISO em um disco ou crie um pendrive inicializável. Você pode usar ferramentas como o [Etcher](https://etcher.io/) ou o [Rufus](https://rufus.ie/) para criar um pendrive inicializável.

3. Insira o disco ou o pendrive inicializável no computador onde deseja instalar o Ubuntu 22.04.

4. Reinicie o computador e acesse a configuração de inicialização (geralmente pressionando "F2" ou "Del" durante a inicialização, mas pode variar dependendo do fabricante do seu computador).

5. Na configuração de inicialização, defina a opção de inicialização para o disco ou o pendrive inicializável.

6. Salve as configurações e saia da configuração de inicialização. O computador reiniciará e será inicializado a partir do disco ou do pendrive.

7. Siga as instruções na tela para instalar o Ubuntu 22.04. Você poderá escolher o idioma, definir as configurações regionais e particionar o disco, se necessário.

8. Durante a instalação, você também precisará fornecer informações como nome de usuário, senha e outros detalhes específicos.

9. Após a conclusão da instalação, reinicie o computador e inicialize no Ubuntu 22.04 a partir do disco rígido.

10. Parabéns! Agora você tem o Ubuntu 22.04 instalado no seu computador. Você pode começar a explorar e usar o sistema operacional.

</details>

#### OpenJDK 1.8 :
<details>
  <summary>Como instalar o OpenJDK 1.8 e configurar as variáveis de ambiente</summary>

## Passo a passo para instalar o OpenJDK 1.8 e configurar as variáveis de ambiente:

1. Abra o terminal pressionando "Ctrl + Alt + T" no teclado.

2. Execute o seguinte comando para instalar o OpenJDK 1.8:

   ```
   sudo apt update
   sudo apt install openjdk-8-jdk
   ```

3. Após a instalação, verifique se o Java foi instalado corretamente executando o seguinte comando:

   ```
   java -version
   ```

   Isso exibirá a versão do Java instalada no seu sistema. Deve mostrar algo semelhante a:

    ```
    openjdk version "1.8.x_xxx"
    OpenJDK Runtime Environment (build 1.8.x_xxx-ubuntu0.xx.xx.xx)
    OpenJDK 64-Bit Server VM (build 25.x_xxx-ubuntu0.xx.xx.xx, mixed mode)
    ```

4. Agora, vamos configurar as variáveis de ambiente para o OpenJDK 1.8. Abra o arquivo `/etc/environment` com um editor de texto usando o seguinte comando:

   ```
   sudo nano /etc/environment
   ```

5. Adicione a seguinte linha ao arquivo, substituindo `/usr/lib/jvm/java-8-openjdk-amd64` pelo caminho correto da instalação do OpenJDK 1.8 em seu sistema:

   ```
   JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
   ```

6. Pressione "Ctrl + X" para sair do editor de texto, pressione "Y" para confirmar as alterações e pressione Enter para salvar o arquivo com o mesmo nome.

7. Execute o seguinte comando para recarregar as variáveis de ambiente:

   ```
   source /etc/environment
   ```

8. Agora, vamos adicionar o diretório do Java ao PATH do sistema. Abra o arquivo `~/.bashrc` com um editor de texto usando o seguinte comando:

   ```
   nano ~/.bashrc
   ```

9. Adicione a seguinte linha ao final do arquivo:

   ```
   export PATH="$PATH:$JAVA_HOME/bin"
   ```

10. Pressione "Ctrl + X" para sair do editor de texto, pressione "Y" para confirmar as alterações e pressione Enter para salvar o arquivo com o mesmo nome.

11. Execute o seguinte comando para recarregar o arquivo `~/.bashrc`:

    ```
    source ~/.bashrc
    ```

12. Agora você tem o OpenJDK 1.8 instalado e as variáveis de ambiente configuradas corretamente. Você pode começar a usar o Java 8 em seu sistema.

</details>


#### Docker 20.10.24
<details>
  <summary>Como instalar o Docker no Ubuntu 22.04</summary>

## Passo a passo para instalar o Docker no Ubuntu 22.04:

1. Abra o terminal pressionando "Ctrl + Alt + T" no teclado.

2. Remova versões antigas do Docker, se existirem, executando o seguinte comando:

   ```
   sudo apt remove docker docker-engine docker.io containerd runc
   ```

3. Atualize a lista de pacotes com o seguinte comando:

   ```
   sudo apt update
   ```

4. Instale os pacotes necessários para permitir que o apt utilize repositórios via HTTPS, executando o seguinte comando:

   ```
   sudo apt install apt-transport-https ca-certificates curl gnupg-agent software-properties-common
   ```

5. Adicione a chave GPG oficial do Docker executando o seguinte comando:

   ```
   curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg
   ```

6. Adicione o repositório do Docker às fontes do APT, executando o seguinte comando:

   ```
   echo "deb [arch=amd64 signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
   ```

7. Atualize a lista de pacotes novamente, agora incluindo o repositório do Docker, com o seguinte comando:

   ```
   sudo apt update
   ```

8. Agora, você pode instalar o Docker executando o seguinte comando:

   ```
   sudo apt install docker-ce docker-ce-cli containerd.io
   ```

9. Após a conclusão da instalação, verifique se o Docker foi instalado corretamente executando o comando:

   ```
   docker --version
   ```

   Isso exibirá a versão do Docker instalada no seu sistema.

10. Parabéns! Agora você tem o Docker instalado no Ubuntu 22.04. Você pode começar a usar o Docker para criar e gerenciar contêineres.

</details>

#### Intellij Idea Community version 2023.1.2
<details>
  <summary>Como instalar o IntelliJ IDEA Community</summary>

## Passo a passo para instalar o IntelliJ IDEA Community:

1. Abra o terminal pressionando "Ctrl + Alt + T" no teclado.

2. Faça o download do arquivo de instalação do IntelliJ IDEA Community Edition no [site oficial da JetBrains](https://www.jetbrains.com/idea/download).

3. Navegue até o local onde o arquivo de instalação foi baixado.

4. Extraia o arquivo de instalação usando o seguinte comando:

   ```
   tar -xzf nome_do_arquivo.tar.gz
   ```

5. Acesse o diretório extraído usando o seguinte comando:

   ```
   cd nome_do_diretorio
   ```

6. Execute o script de instalação usando o seguinte comando:

   ```
   ./bin/idea.sh
   ```

7. O IntelliJ IDEA Community será iniciado e você será guiado pelo assistente de configuração inicial.

8. Siga as instruções na tela para configurar suas preferências, como temas, plugins, esquemas de teclado, etc.

9. Após a configuração inicial, o IntelliJ IDEA Community Edition estará pronto para uso.

10. Parabéns! Agora você tem o IntelliJ IDEA Community Edition instalado no seu sistema. Você pode começar a desenvolver aplicativos usando o IntelliJ IDEA.

</details>

#### Firefox ou qualquer navegador de sua preferencia

#### Instalação do Firefox no Ubuntu 22.04
 <details>
        <summary>Clique aqui para ver o passo a passo de instalação</summary>

- #### Passo 1: Abrir o Terminal

    #### Abra o terminal no Ubuntu. Você pode fazer isso pressionando `Ctrl + Alt + T` no teclado ou pesquisando por "Terminal" no menu de aplicativos.

- #### Passo 2: Verificar a disponibilidade do Snap

    #### O Ubuntu 22.04 inclui o Snap por padrão. Para verificar se o Snap está instalado, execute o seguinte comando no terminal:
    ```bash
    snap version
    ```
    #### Se o Snap estiver instalado, você verá a versão do Snap instalada no seu sistema. Caso contrário, você pode instalar o Snap executando o seguinte comando :
    ```bash
    sudo apt update
    sudo apt install snapd
    ```
- #### Passo 3: Instalar o Firefox via Snap
  
    #### Para instalar o Firefox usando o Snap, execute o seguinte comando no terminal:
    ```bash
    sudo snap install firefox
    ```
    #### Digite Y ou S quando solicitado para confirmar a instalação. O sistema irá baixar e instalar o Firefox via Snap.  

- #### Passo 4: Verificar a Instalação

  #### Após a instalação, você pode verificar se o Firefox foi instalado corretamente executando o seguinte comando no terminal:    
  ```bash
    sudo snap install firefox
    ```
    
</details>

#### Portas de rede : 80, 8989, 3606, 8080, 8081, 50000

#### Usuario root no Ubuntu

## Documentação utilizada nos testes 
####  [MantisBt API DOCS](https://documenter.getpostman.com/view/29959/mantis-bug-tracker-rest-api/7Lt6zkP#73397753-1560-a5cb-45f0-e0ce0194ceca)

## Configuração do ambiente de teste
Neste passo iremos configurar a estrutura de pastas do nosso ambiente, junto a isso iremos subir o nosso ambiente de teste.

Para começar a utilizar este framework de teste de API, siga estas etapas:
- ### Configurando a estrutura de arquivos e clonando o repositorio Git 
  1. Abra o terminal pressionando "Ctrl + Alt + T" no teclado.

     - #### crie uma pasta com o nome git em Documentos
        ```bash
        mkdir ~/Documentos/git/
        ```
     - #### crie uma pasta com o nome docker em Documentos
        ```bash
        mkdir ~/Documentos/docker/
        ``` 
     - #### Navegue até o diretório, no terminal
        ```bash
        cd ~/Documentos/git/
        ```
     - #### No terminal realize o clone do repositorio 
        ```bash
        git clone https://github.com/AlessandroLimaSilva/restassuredDemo.git
       ```
     - #### No terminal acesse a pasta
        ```bash
        cd ~/Documentos/git/restassuredDemo
        ```
     - #### Copie os arquivo docker-compose.yml, jenkinsFile, plugins.txt para a pasta Documentos/docker  
        ```bash
        cp ~/Documentos/git/restassuredDemo/docker-compose.yml ~/Documentos/docker/
        ```
     - #### Copie os arquivo docker-compose.yml, jenkinsFile, plugins.txt para a pasta Documentos/docker
        ```bash 
        cp ~/Documentos/git/restassuredDemo/jenkinsFile ~/Documentos/docker/
        ```
     - #### Copie os arquivo docker-compose.yml, jenkinsFile, plugins.txt para a pasta Documentos/docker
        ```bash
        cp ~/Documentos/git/restassuredDemo/plugins.txt ~/Documentos/docker/
        ```
- ### Iniciando o ambiente de teste  
  #### Agora que ja temos nossa estrutura de arquivos esta configurada podemos subir o ambiente
  1. Abra o terminal pressionando "Ctrl + Alt + T" no teclado.

      - #### Acesse a pasta Documentos/docker
         ```bash
         cd ~/Documentos/git/
         ```
      - #### Iniciando o Docker
         ```bash
         sudo docker-compose -f docker-compose.yml up -d
         ```
      - #### Aguarde o docker realizar o download dos container e suas dependencias, ao finalizar voce ira ver no terminal.
         ```bash
         [+] Running 8/8
         ✔ Network docker_my-networks   Created                                         0.1s
         ✔ Container selenium-hub       Started                                         1.1s
         ✔ Container jenkins            Started                                         1.1s
         ✔ Container docker-mysql-1     Started                                         1.1s
         ✔ Container docker-opera-1     Started                                         1.3s
         ✔ Container docker-chrome-1    Started                                         1.3s
         ✔ Container docker-firefox-1   Started                                         1.3s
         ✔ Container docker-mantisbt-1  Started                                         1.7s
         ```
        
      - #### conferindo se o ambiente de teste foi iniciado corretamente
         ```bash
        code@Nitro:~$ sudo docker ps -a
        CONTAINER ID   IMAGE                                  COMMAND                  CREATED         STATUS         PORTS                                                                                      NAMES
        01b3c1210e66   vimagick/mantisbt:latest               "docker-php-entrypoi…"   3 minutes ago   Up 3 minutes   0.0.0.0:8989->80/tcp, :::8989->80/tcp                                                      docker-mantisbt-1
        8a447fd4233b   selenium/node-firefox-debug:3.141.59   "/opt/bin/entry_poin…"   3 minutes ago   Up 3 minutes                                                                                              docker-firefox-1
        dcb1f17cee55   selenium/node-opera-debug:3.141.59     "/opt/bin/entry_poin…"   3 minutes ago   Up 3 minutes                                                                                              docker-opera-1
        33ef17b0a240   selenium/node-chrome-debug:3.141.59    "/opt/bin/entry_poin…"   3 minutes ago   Up 3 minutes                                                                                              docker-chrome-1
        20ff1ec9e42c   docker-jenkins                         "/usr/bin/tini -- /u…"   3 minutes ago   Up 3 minutes   0.0.0.0:50000->50000/tcp, :::50000->50000/tcp, 0.0.0.0:8081->8080/tcp, :::8081->8080/tcp   jenkins
        37381d5a55d2   mysql:5.7                              "docker-entrypoint.s…"   3 minutes ago   Up 3 minutes   0.0.0.0:3306->3306/tcp, :::3306->3306/tcp, 33060/tcp                                       docker-mysql-1
        546a538d29da   selenium/hub:3.141.59                  "/opt/bin/entry_poin…"   3 minutes ago   Up 3 minutes   0.0.0.0:4444->4444/tcp, :::4444->4444/tcp                                                  selenium-hub
        ```
      - #### Ao final desse passo nosso ambiente ja esta online.

- ### Configurando as aplicações
    Agora que terminamos de configurar nossa estrutura de arquivos podemos configurar as aplicações em nosso ambiente de teste.
- ### Configurando o MantisBT
  #### 1. Abra um navegador e digite na barra de endereço
  #### [http://0.0.0.0:8989/admin/install.php](http://0.0.0.0:8989/admin/install.php)

  #### ou

  #### [http://localhost:8989/admin/install.php](http://localhost:8989/admin/install.php)

  #### 2. Configurando o banco de dados do MantisBT
  A tela de configuração da aplicação MantisBT sera apresentada  
  ![Texto alternativo](src/test/resources/readmeImg/mantisBT01.png)
  - Preencha os seguintes campos
  - #### Em type of database Selecione
    ```bash
    MySQL Improved
    ```
  - #### Em Hostname (for Database Server) informe
    ```bash
    mysql
    ```
  - #### Em Username (for Database) informe
    ```bash
    root
    ``` 
  - #### Em Password (for Database) informe
    ```bash
    root
    ```
  - #### Em Database name (for Database) informe
    ```bash
    bugtracker
    ``` 
  - #### Em Admin Username (to create Database if required) informe
    ```bash
    root
    ```
  - #### Em Admin Password (to create Database if required) informe
    ```bash
    root
    ```     
  - #### Em Default Time Zone selecione
    ```bash
    Sao Paulo
    ```   
  - #### Realize um click em Install/Upgrade Database
    ![Texto alternativo](src/test/resources/readmeImg/mantisBT02.png)
  
  - #### A seguinte tela sera apresentada
    ![Texto alternativo](src/test/resources/readmeImg/mantisBT03.png)
  - #### Agora clique em Back to administration
    A tela de configuração da aplicação MantisBT sera apresentada
    ![Texto alternativo](src/test/resources/readmeImg/mantisBT04.png)
  
  #### 3. Obtendo o token de acesso a API do MantisBT
  Agora iremos obter o token de acesso que ira garantir que nossos testes tenha acesso a API do MantisBT.
  
  - #### Informe o seu nome de usuario 
    ```bash
    Administrator
    ``` 
  - #### Clique em entrar
    ![Texto alternativo](src/test/resources/readmeImg/mantisBT05.png)  

  - #### Informe a sua senha 
    ```bash
    root
    ``` 
  - #### Clique em entrar
    ![Texto alternativo](src/test/resources/readmeImg/mantisBT06.png)

  - #### Clique em Minha Conta
    ![Texto alternativo](src/test/resources/readmeImg/mantisBT07.png) 

  - #### Clique em Tokens API
    ![Texto alternativo](src/test/resources/readmeImg/mantisBT08.png)

  - #### Preencha o nome do token com Token, clique em criar token
    ![Texto alternativo](src/test/resources/readmeImg/mantisBT09.png)

  - #### Copie e guarde o token, este token so é exibido uma vez se voce perder o token é necessario criar outro.
  - vYpgsCjNSf2AE-dVR2Xtqs9asBvXp2Qd
    ![Texto alternativo](src/test/resources/readmeImg/mantisBT10.png)
  - - #### Lembre-se iremos precisar do token nos passos seguintes

  - ### Configurando o Jenkins
      #### 1. Abra o terminal pressionando "Ctrl + Alt + T" no teclado e digite.
      ```bash
      sudo docker ps -a
      ```
      #### Sera retornado as informações dos container
      ```bash
        code@Nitro:~$ sudo docker ps -a
        CONTAINER ID   IMAGE                                  COMMAND                  CREATED         STATUS         PORTS                                                                                      NAMES
        01b3c1210e66   vimagick/mantisbt:latest               "docker-php-entrypoi…"   3 minutes ago   Up 3 minutes   0.0.0.0:8989->80/tcp, :::8989->80/tcp                                                      docker-mantisbt-1
        8a447fd4233b   selenium/node-firefox-debug:3.141.59   "/opt/bin/entry_poin…"   3 minutes ago   Up 3 minutes                                                                                              docker-firefox-1
        dcb1f17cee55   selenium/node-opera-debug:3.141.59     "/opt/bin/entry_poin…"   3 minutes ago   Up 3 minutes                                                                                              docker-opera-1
        33ef17b0a240   selenium/node-chrome-debug:3.141.59    "/opt/bin/entry_poin…"   3 minutes ago   Up 3 minutes                                                                                              docker-chrome-1
        20ff1ec9e42c   docker-jenkins                         "/usr/bin/tini -- /u…"   3 minutes ago   Up 3 minutes   0.0.0.0:50000->50000/tcp, :::50000->50000/tcp, 0.0.0.0:8081->8080/tcp, :::8081->8080/tcp   jenkins
        37381d5a55d2   mysql:5.7                              "docker-entrypoint.s…"   3 minutes ago   Up 3 minutes   0.0.0.0:3306->3306/tcp, :::3306->3306/tcp, 33060/tcp                                       docker-mysql-1
        546a538d29da   selenium/hub:3.141.59                  "/opt/bin/entry_poin…"   3 minutes ago   Up 3 minutes   0.0.0.0:4444->4444/tcp, :::4444->4444/tcp                                                  selenium-hub
      ```    
      #### Iremos copiar o CONTAINER ID do nosso container do Jenkins e no terminal e iremos digitar.
      #### sudo docker exec -it CONTAINER ID bash
      ```bash
      sudo docker exec -it 20ff1ec9e42c bash 
      ```
      #### Agora estamos acessando o container do jenkins pelo terminal, com isso iremos copiar o password para acessar o jenkins no terminal e digitamos.
      ```bash
      cat /var/jenkins_home/secrets/initialAdminPassword 
      ```
      ![Texto alternativo](src/test/resources/readmeImg/jenkins01.png)
      #### Copie o password, precisaremos dele para acessar o jenkins

      #### 2. Abra um navegador e digite na barra de endereço
      #### [http://0.0.0.0:8081/login?from=%2F](http://0.0.0.0:8081/login?from=%2F)

      #### ou

      #### [http://localhost:8081/login?from=%2F](http://localhost:8081/login?from=%2F)
      #### Vamos informar a senha de administrador que copiamos no terminal [76ffc585c41b4dcaa0844b2ebc896e85](76ffc585c41b4dcaa0844b2ebc896e85)
      ![Texto alternativo](src/test/resources/readmeImg/jenkins02.png)
    
      #### Clique em Instalar as extensões sugeridas, as extensões necessarias ja foram adicionadas no container.
      ![Texto alternativo](src/test/resources/readmeImg/jenkins03.png)
      ![Texto alternativo](src/test/resources/readmeImg/jenkins04.png)
      #### Agora iremos preencher os campos para criar um usuario administrativo
      - #### Em Nome de usuario informe
      ```bash
      root
      ```
      - #### Em Senha informe
      ```bash
      root
      ```
      - #### Em Confirmar Senha informe
      ```bash
      root
      ```
      - #### Em Nome Completo informe
      ```bash
      root root
      ```
      - #### Em Endereço de Email informe
      ```bash
      root@root.com
      ```
      - #### Clique em Salvar e continuar
      ![Texto alternativo](src/test/resources/readmeImg/jenkins05.png)
      - #### Clique em Gravar e Concluir
      ![Texto alternativo](src/test/resources/readmeImg/jenkins06.png)
      - #### Clique em Reiniciar
      ![Texto alternativo](src/test/resources/readmeImg/jenkins07.png)
      - #### Aguarde o jenkins realizar as configurações, se dentro de 5 minutos a pagina não recarregar sozinha aperte F5 para recarregar a pagina.
      ![Texto alternativo](src/test/resources/readmeImg/jenkins08.png)

    #### 3. Agora iremos configurar o job no jenkins para executar os nossos testes de modo continuo CI com o nosso codigo que esta no github.
    #### Agora iremos preencher os campos para realizar o login
      - #### Em Nome de usuario informe
      ```bash
      root
      ```
      - #### Em Senha informe
      ```bash
      root
      ```
      #### Agora clique em entrar
      ![Texto alternativo](src/test/resources/readmeImg/jenkins09.png)
    
    #### Clique em nova tarefa
    ![Texto alternativo](src/test/resources/readmeImg/jenkins10.png)
    
    #### Informe o nome do teste 
    ```bash
    QA-MantisBT-WEB
    ```
    ![Texto alternativo](src/test/resources/readmeImg/jenkins11.png)
    
    #### Clique em Construir um projeto de software de estilo livre
    ![Texto alternativo](src/test/resources/readmeImg/jenkins12.png)

    #### Clique em Tudo certo
    ![Texto alternativo](src/test/resources/readmeImg/jenkins13.png)
    
    #### Informe a descrição do projeto 
    ```bash
    Testes automatizados WEB MantisBT
    ```
    ![Texto alternativo](src/test/resources/readmeImg/jenkins14.png)
    
    #### Selecione Esta construção é parametrizada. 
    ![Texto alternativo](src/test/resources/readmeImg/jenkins15.png)

    #### Clique em Adicionar parametro
    ![Texto alternativo](src/test/resources/readmeImg/jenkins16.png)

    #### Clique em Parametro de texto
    ![Texto alternativo](src/test/resources/readmeImg/jenkins217.png)

    #### Preencha Nome 
    ```bash
    NAVEGADOR
    ```
    ![Texto alternativo](src/test/resources/readmeImg/jenkins18.png)
  
    #### Agora iremos preencher valor com o navegador em que queremos executar nossos teste neste caso chrome
    #### Temos configurado no projeto 3 navegadores chrome, firefox e opera.
    #### Para executar qualquer um dos 3 e so mudar o valor passado neste campo.
    ```bash
    chrome
    ```
    ![Texto alternativo](src/test/resources/readmeImg/jenkins19.png)

    #### Clique em novamente Adicionar parametro
    ![Texto alternativo](src/test/resources/readmeImg/jenkins16.png)

    #### Clique em Parametro de texto
    ![Texto alternativo](src/test/resources/readmeImg/jenkins217.png)

    #### Preencha Nome
    ```bash
    AMBIENTE
    ```
    ![Texto alternativo](src/test/resources/readmeImg/jenkins218.png)

    #### Agora iremos preencher valor padrão com o ambiente no qual iremos executar os testes
    ```bash
    hml
    ```
    ![Texto alternativo](src/test/resources/readmeImg/jenkins219.png)

    #### Clique em Aplicar
    ![Texto alternativo](src/test/resources/readmeImg/jenkins20.png)

    #### Clique em Gerenciamento do codigo
    ![Texto alternativo](src/test/resources/readmeImg/jenkins21.png)

    #### Clique em Git
    ![Texto alternativo](src/test/resources/readmeImg/jenkins21.png)

    #### Preencha Repository URL
    ```bash
    https://github.com/AlessandroLimaSilva/restassuredDemo
    ```
    ![Texto alternativo](src/test/resources/readmeImg/jenkins22.png)

    #### Preencha Branch Specifier (blank for 'any')
    ```bash
    */main
    ```
    ![Texto alternativo](src/test/resources/readmeImg/jenkins23.png)

    #### Clique em Aplicar
    ![Texto alternativo](src/test/resources/readmeImg/jenkins20.png)

    #### Clique em Ambiente de construção
    ![Texto alternativo](src/test/resources/readmeImg/jenkins24.png)

    #### Clique em Delete workspace before build starts
    ![Texto alternativo](src/test/resources/readmeImg/jenkins25.png)

    #### Clique em Ambiente de construção
    ![Texto alternativo](src/test/resources/readmeImg/jenkins26.png)

    #### Clique em Adicionar passo na construção
    ![Texto alternativo](src/test/resources/readmeImg/jenkins27.png)

    #### Clique em Executar shell
    ![Texto alternativo](src/test/resources/readmeImg/jenkins28.png)

    #### Preencha Command, estamos passando as variaveis que criamos no inicio da configuração.
    ```bash
    sed -i "s|enviroment=.*|enviroment=$AMBIENTE|" src/globalParameters.propeties
    sed -i "s|$AMBIENTE.token=.*|$AMBIENTE.token=$TOKEN|" src/globalParameters.propeties
    ```
    ![Texto alternativo](src/test/resources/readmeImg/jenkins29.png)

    #### Clique em Aplicar
    ![Texto alternativo](src/test/resources/readmeImg/jenkins20.png)

    #### Clique em Adicionar passo na construção
    ![Texto alternativo](src/test/resources/readmeImg/jenkins27.png)

    #### Clique em Chamar alvos Maven de alto nivel
    ![Texto alternativo](src/test/resources/readmeImg/jenkins30.png)

    #### Preencha Goals, utilizaremos este passo para montar nosso banco de dados que os utilizaram
    ```bash
    clean verify "-Dcucumber.filters.tags=@MontaOBancoDeDados"
    ```
    ![Texto alternativo](src/test/resources/readmeImg/jenkins231.png)

    #### Clique em Adicionar passo na construção
    ![Texto alternativo](src/test/resources/readmeImg/jenkins27.png)

    #### Clique em Chamar alvos Maven de alto nivel
    ![Texto alternativo](src/test/resources/readmeImg/jenkins30.png)

    #### Preencha Goals
    ```bash
    clean verify "-Dcucumber.filters.tags= @automatizado"
    ```
    ![Texto alternativo](src/test/resources/readmeImg/jenkins31.png)

    #### Clique em Ações de pós-construção
    ![Texto alternativo](src/test/resources/readmeImg/jenkins32.png)

    #### Clique em Adicionar ação de pós-construção
    ![Texto alternativo](src/test/resources/readmeImg/jenkins33.png)

    #### Clique em Publicar relatorio de testes do junit
    ![Texto alternativo](src/test/resources/readmeImg/jenkins34.png)

    #### Preencha Relatorio XML de teste
    ```bash
    target/surefire-reports/*.xml
    ```
    ![Texto alternativo](src/test/resources/readmeImg/jenkins35.png)

    #### Clique novamente em Adicionar ação de pós-construção
    ![Texto alternativo](src/test/resources/readmeImg/jenkins33.png)

    #### Clique Publish HTML reports
    ![Texto alternativo](src/test/resources/readmeImg/jenkins36.png)

    #### Clique Adicionar
    ![Texto alternativo](src/test/resources/readmeImg/jenkins37.png)

    #### Preencha HTML directory to archive, tenha cuidado para preencher é necessario o espaço antes de 2023, hello bug jenkins. 
    ```bash
    ./target/relatorio/ 2023/
    ```
    ![Texto alternativo](src/test/resources/readmeImg/jenkins38.png)

    #### Preencha HTML directory to archive
    ```bash
    index.html
    ```
    ![Texto alternativo](src/test/resources/readmeImg/jenkins39.png)

    #### Preencha Report title
    ```bash
    HTML Report
    ```
    ![Texto alternativo](src/test/resources/readmeImg/jenkins40.png)

    #### Clique em Aplicar
    ![Texto alternativo](src/test/resources/readmeImg/jenkins20.png)

    #### Clique em Salvar
    ![Texto alternativo](src/test/resources/readmeImg/jenkins20.png)
    
    #### Agora ja temos nosso job CI/CD configurado no jenkins e pronto para execução dos testes.

## Executando os testes no jenkins
Neste passo iremos executar os testes no job que criamos no passo anterior.
Tambem iremos visualizar os relatorios gerados apos a execução dos testes.

#### Agora iremos preencher os campos para realizar o login
   #### Em Nome de usuario informe
   ```bash
   root
   ```
   #### Em Senha informe
   ```bash
   root
   ```
   #### Agora clique em entrar
   ![Texto alternativo](src/test/resources/readmeImg/jenkins09.png)

   #### Agora clique QA-API-MantisBT
   ![Texto alternativo](src/test/resources/readmeImg/jenkins41.png)

   #### Agora clique me Construir com parâmetros 
   ![Texto alternativo](src/test/resources/readmeImg/jenkins42.png) 

   #### O modo como foi configurado o job nos permite construir o teste em ambientes diferentes, so precisamos passar o token e o ambiente.
   - #### Clique em construir, como ja passamos as informações de token e ambiente não precisamos modificar nenhuma informação.
   ![Texto alternativo](src/test/resources/readmeImg/jenkins43.png)

   #### Para acompanhar a execução dos testes clique na barra azul
   ![Texto alternativo](src/test/resources/readmeImg/jenkins44.png)

   #### Nesta tela podemos acompanhar o log dos nossos testes sendo executados
   ![Texto alternativo](src/test/resources/readmeImg/jenkins45.png)
    
   #### Nesta tela podemos visualizar o termino dos testes neste caso tivemos testes que falharam \\^^/, e isso é bom.
   ![Texto alternativo](src/test/resources/readmeImg/jenkins46.png)
    
   #### Clique em QA-API-MantisBT.
   ![Texto alternativo](src/test/resources/readmeImg/jenkins47.png)

   #### Agora iremos visualizar o resultado do teste atraves do junit.
   - #### Clique no job em que executamos os testes, neste caso o job 11.
   ![Texto alternativo](src/test/resources/readmeImg/jenkins48.png)

   #### Clique em resultado de testes.
   ![Texto alternativo](src/test/resources/readmeImg/jenkins49.png)

   #### Os resultados dos testes são apresentados.
   ![Texto alternativo](src/test/resources/readmeImg/jenkins50.png)

   #### Agora iremos visualizar o resultado do teste atraves do ExtentReport.
   - #### Clique em QA-API-MantisBT.
   ![Texto alternativo](src/test/resources/readmeImg/jenkins50.png)

   #### Clique em HTML report.
   ![Texto alternativo](src/test/resources/readmeImg/jenkins51.png)

   #### O Nosso relatorio ExtentReport sera apresentado dessa forma pelo jenkins por medida de segurança.
   #### Por isso vamos realizar o download do relatorio do ExtentReporter
   - #### Clique em Back to QA-API-MantisBT
   ![Texto alternativo](src/test/resources/readmeImg/jenkins52.png)

   #### Clique em Workspace
   ![Texto alternativo](src/test/resources/readmeImg/jenkins53.png)

   #### Clique em target
   ![Texto alternativo](src/test/resources/readmeImg/jenkins54.png) 

   #### Clique em 2023
   ![Texto alternativo](src/test/resources/readmeImg/jenkins55.png)

   #### Clique em (Todos os arquivos em .zip), aguarde o fim do download do relatorio
   ![Texto alternativo](src/test/resources/readmeImg/jenkins56.png)

   #### descompacte o arquivo e abra o arquivo index.html, pronto ja podemos visualizar o Relatorio do ExtentReport
   ![Texto alternativo](src/test/resources/readmeImg/jenkins57.png) 


## Desafios Base 2

### Teste automatizado de API da aplicação MantisBT

##### - [✔] Tarefa concluída

##### - [x] Tarefas pendentes

### 1. [✔] Implementar 50 algoritmos de testes que manipulem uma aplicação cuja interface é uma API REST. 

   ##### Mais de 50 algoritmos de testes unicos de api implementados.
   ##### Software utilizado para os testes MantisBT.

### 2. [✔] Alguns algoritmos de testes devem ler dados de uma planilha Excel para implementar Data-Driven. 

   ##### Implementação de Data-Driven pelo Cucumber.
   ![Texto alternativo](src/test/resources/readmeImg/dataDriven01.png)
   ![Texto alternativo](src/test/resources/readmeImg/dataDriven02.png)
   ![Texto alternativo](src/test/resources/readmeImg/dataDriven03.png)
   ![Texto alternativo](src/test/resources/readmeImg/dataDriven04.png)

### 3. [✔] Notem que 50 algoritmos de testes podem cobrir mais de 50 casos de testes se usarmos Data-Driven. Em outras palavras, implementar 50 CTs usando data-driven não é a mesma coisa que implementar 50 algoritmos de testes. </summary>

   ##### Mais de 50 casos de testes unicos implementados.

### 4. [✔] O projeto deve tratar autenticação. Exemplo: OAuth2. 

   #### Autenticação via token da API, passada atraves do headers.

### 5. [X] Pelo menos um teste deve fazer a validação usando REGEX (Expressões Regulares). </summary>

   #### Não implementado.

### 6. [✔] Pelo menos um algoritmo de teste deve usar código Groovy / Node.js ou outra linguagem para fazer scripts.. 

#### Implementado uma classe em Groovy [ValidacaoGroovy.groovy](https://github.com/AlessandroLimaSilva/restassuredDemo/blob/main/src/test/java/br/com/ale/restassuredDemo/utils/ValidacaoGroovy.groovy) para realizar um assert
![Texto alternativo](src/test/resources/readmeImg/groovy01.png)

![Texto alternativo](src/test/resources/readmeImg/groovy02.png)
![Texto alternativo](src/test/resources/readmeImg/groovy03.png)


### 7. [✔] O projeto deverá gerar um relatório de testes automaticamente. 

#### O projeto gera automaticamente um relatorio do ExtentReport .
![Texto alternativo](src/test/resources/readmeImg/relatorio01.png)

#### O projeto gera automaticamente um relatorio do junit que pode ser visualizado no jenkins .
![Texto alternativo](src/test/resources/readmeImg/jenkins50.png)

### 8. [✔] Implementar pelo menos dois ambientes (desenvolvimento / homologação) 

#### O Projeto foi desenvolvido para implementar quantos ambientes forem necessarios.
#### Neste caso foram implementados 3 ambientes hml, dev e local.
#### basta apenas adicionar o ambiente desejado atraves do arquivo [globalParameters.propeties](https://github.com/AlessandroLimaSilva/restassuredDemo/blob/main/src/globalParameters.propeties) e implementar na classe [GlobalParameters.java](https://github.com/AlessandroLimaSilva/restassuredDemo/blob/main/src/test/java/br/com/ale/restassuredDemo/utils/GlobalParameters.java)
#### Na configuração realizada no job do jenkins é passado em qual ambiente o teste sera executado.
![Texto alternativo](src/test/resources/readmeImg/jenkins43.png)
![Texto alternativo](src/test/resources/readmeImg/jenkins29.png)
#### No jenkins é possivel utilizar 2 ambientes hml e dev.

### 9. [✔] A massa de dados dos testes deve ser preparada neste projeto, seja com scripts carregando massa nova no BD ou com restore de banco de dados. 

#### A construção do banco de dados e a massa de dados é realizada atraves da execução de um algortimo de teste e configurada em um passo anterior a execução dos testes no jenkins.
![Texto alternativo](src/test/resources/readmeImg/jenkins231.png)
#### Isso tambem poderia ser feito atraves de um shell script que executaria o caso de teste responsavel por criar e popular o banco de dados utilizado pela automação.
#### Sendo que este workaround so foi implementado, dados que as bibliotecas utilizadas no framework não dispoem de uma solução para executar um metodo antes da execução.


### 10. [✔] Executar testes em paralelo. Pelo menos duas threads (25 testes cada).

#### Dado que nosso testes são executados pelo maven-surefire-plugin.
![Texto alternativo](src/test/resources/readmeImg/thread05.png)
#### Configurei o paralelismo no maven-surefire-plugin para 4 threads.
![Texto alternativo](src/test/resources/readmeImg/thread06.png)
#### O cucumber trabalha com paralelismo dividindo cada caso de teste em duas thread uma fica responsavel pela feature e a outra pela execução do teste.
#### Assim temos 2 threads para cada caso de teste, totalizando 8 threads para executar nossos testes.
#### podemos visualizar as threads no log de execução dos testes no jenkins, e local tambem.
![Texto alternativo](src/test/resources/readmeImg/thread01.png)
![Texto alternativo](src/test/resources/readmeImg/thread02.png)
![Texto alternativo](src/test/resources/readmeImg/thread03.png)
![Texto alternativo](src/test/resources/readmeImg/thread04.png)

### - 11. [✔] Execução ambiente CI/CD Jenkins montado em docker
#### As instruções e arquivos necessarios para construir um ambiente de teste CI/CD estão documentadas nesse repositorio.
#### Assim não é necessario utilizar o servidor de terceiros.

## Personalização e Expansão

Este framework de teste de API é altamente personalizável e pode ser facilmente expandido para atender às necessidades exclusivas do seu projeto. Você pode adicionar novos casos de teste, criar classes utilitárias adicionais e integrar bibliotecas adicionais conforme necessário.

