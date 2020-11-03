# "Gerenciamento de Patrimônio de Empresas"

Api para gerenciamento de patrimônio de uma empresa.

## Descrição
Web API REST criado com SpringBoot, com uso de Maven para gerenciamento de dependêcias, JPA(hibernate) para a persistência de dados e criação das tabelas, Lombok para geração de contrutores, getters e setters, toString e hashCode, utilização de banco de dados PostgreSQL, JUnit para testes unitários e JWT para validação de usuários com geração de token.

### Requisitos
* **Patrimônio**

		Campos:
		 * Nome - obrigatório
		 * MarcaId – obrigatório
		 * Descrição
		 * Nº do tombo		
		obs. O nº do tombo é gerado automaticamente pelo sistema e não pode ser
		alterado pelos usuários.

*	**Marca**

		Campos:
		 * Nome – obrigatório
		 * MarcaId - obrigatório 
		Obs. Não é permitido duas marcas com o mesmo nome.

* **Usuário**

		Campos:
		 * Nome – obrigatório
		 * Email – obrigatório
		 * Senha - obrigatório
		Obs. Não é permitido e-mail repetido;
		Rotas de Atualizar, deletar e buscar acessado apenas por usuários cadastrados;
