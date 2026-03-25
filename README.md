# BancoVirtual


# Objetivo do Sistema:
Desenvolver um sistema báncario simples em java, com o objetivo de simular operações básicas de um banco digital, permitindo o gerenciamento de contas e a realização de transações financeiras básicas.
## Tipos de Clientes.
* Pessoa Física (PF)
* Pessoa Jurídica
## Tipos de conta.
* Conta Correte
* Conta poupança
# Funcionalidades do Sistema.
* Criar conta bancária.
* Buscar Conta pelo número ou CPF/CNPJ.
* Realizar Depósito.
* Realizar Saque.
* Realizar transferencia entre contas.
* Consultar saldo.
* Visualizar extratos de transações.
# Entidades dados do sistemas.
## Cliente.
- Nome
- CPF ou CNPJ.
- Tipo (PF ou PJ)
## Conta.
- Numero da conta
- Tipo da conta
- Saldo
## Transação.
- Tipo ( depósito, saque, transferência)
- Valor
- Data

# Fora do Escopo.
O Sistema não irá incluir.
* Empréstimos.
* Cartões bancários
* PIX automáticos
* Funcionalidades de Pix

# REGRAS DE NEGÓCIO.
* Cliente.
• O cliente deve possuir um nome válido
• O cliente deve ser do tipo Pessoa Física ou Pessoa Jurídica
• O cliente deve possuir um documento (CPF ou CNPJ) obrigatório
• CPF é usado para PF e deve conter 11 dígitos
• CNPJ é usado para PJ e deve conter 14 dígitos

# Tecnologia usadas.
* Java

