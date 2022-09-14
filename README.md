# Varejonline - Projeto #
Projeto avaliativo para novos colaboradores.

## Iniciando ##
O projeto consiste no desenvolvimento de um pequeno sistema de Controle de Estoque com os seguintes requisitos:

### Requisitos não funcionais ###
* Utilizar o BD H2 do Spring Boot;
* Todos os dados necessários para a execução e utilização do projeto deverão ser enviados junto com o código feito;
* Deverá ser utilizado o Spring Security para controle de acesso;


### Requisitos funcionais ###
* **1-** Deverão existir 2 perfis de usuários para o acesso as funcionalidades: _OPERADOR_, _GERENTE_.
* **2-** O sistema deverá ter uma tela para permitir o cadastro e edição de produtos com os seguintes campos ( somente _GERENTE_ ):
  * _Id_: Deverá ser um sequencial único, mostrado somente em modo de edição sem permitir sua alteração;
  * _Código de barras_: Código de barras do produto, sendo um campo do tipo literal. Não poderá exisitr mais de um produto com o mesmo código de barras;
  * _Nome_: Nome do produto, sendo um campo do tipo literal;
  * _Quantidade mínima_: Quantidade mínima do produto em estoque, sendo um campo do tipo numérico;
  * _Saldo inicial_: Saldo inicial do produto no momento do cadastro, sendo um campo do tipo numérico;
    * Não será possível sua alteração após o cadastro; 
    * Ao cadastrar um valor superior a 0, uma movimentação de _SALDO_INICIAL_ deverá ser criada para o produto;
    * O _Saldo inicial_ não poderá ser inferior a _quantidade mínima_
* **3-** O sistema deverá ter uma tela para permitir o lançamento das movimentações de estoque com os seguintes campos (_GERENTE_ e _OPERADOR_):
  * _Produto_: Campo para permitir informar/selecionar um produto previamente cadastrado;
  * _Tipo de Movimento_: Os tipos de movimentação possíveis são: _ENTRADA_, _SAÍDA_, _SALDO_INICIAL_, _AJUSTE_ENTRADA_ e _AJUSTE_SAÍDA_; 
    * Somente o _GERENTE_ pode realizar lançamentos do tipo _SALDO_INICIAL_ e _AJUSTE_; 
    * Deverá existir no máximo 1 lançamento do tipo _SALDO_INICIAL_ por produto;
    * O lançamento de _SALDO_INICIAL_ somente poderá ser realizado se não existirem outros lançamentos para o produto;
    * O lançamento de _AJUSTE_ somente poderá ser realizado quando existirem outros lançamentos para o produto;
  * _Quantidade_: Quantidade a ser movimentada no estoque. 
    * O sistema não poderá permitir lançamentos em que o saldo do produto se torne negativo;
  * _Data_: Data da movimentação.
    * Não poderá ter movimentação para um determinado produto anterior a sua criação;
  * _Motivo_: Motivo da Movimentação
  * _Documento_: Documento vinculado a movimentação, mostrar somente quando a movimentação for do tipo _ENTRADA_ ou _SAÍDA_;
* **4-** O sistema deverá ter uma tela para listar as movimentações de estoque com os seguintes campos:
  * Filtros:
    * _Produto_: Permitir filtrar os lançamentos por produto;
    * _Período_: Permitir filtrar os lançamentos de um determinado período;
    * _Tipo de Movimento_: Permitir filtrar os lançamentos de um determinado Tipo de Movimento;
  * Ordenações:
    * _Produto_
    * _Data_
  * Campos da Listagem:
    * _Data do Movimento_
    * _Produto_
    * _Tipo do Movimento_
    * _Documento_
    * _Motivo_
    * _Saldo_: Calculado considerando (Saldo Inicial + Entradas + Ajustes de Entrada - Saídas - Ajustes de Saída);
    * _Situação_: Caso o produto tiver valor para o campo _Quantidade Mínima_, e o _Saldo_ for inferior a ele, mostrar _Inferior ao Mínimo_ do contrário, mostrar _Ok_;


## Estrutura do Projeto ##
Dentro desse repositório pode-se encontrar 2 projetos, o ```frontend``` e o ```server```, sendo eles:
* ```frontend```: Projeto em **Angular** que deve conter todas a camada de apresentação do projeto (telas, formatações...).
  * A inicialização do projeto é feito pelo comando ```npm install``` onde será feito o download das dependências. (**Obs.:** Necessário ter o _Angular CLI - 12.2.17^_).
  * A execução do projeto é feita pelo comando ```npm start``` que rodará o projeto na porta ```4200```.
  * Todas as chamadas serão feitas para o server através da porta ```8081``` já configurada no ```proxy-config.json```. Essa configuração faz com que toda a requisição para ```/server/...``` seja redirecionado para o server.     
* ```server```: Projeto em **Java - Spring Boot** que deve conter todas as regras de negócio da aplicação, incluindo as regras de segurança de acesso.

