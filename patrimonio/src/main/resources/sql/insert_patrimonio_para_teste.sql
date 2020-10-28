INSERT INTO tb_patrimonios
(nome, marca_id, descricao, num_Tombo) 
VALUES 
( 'PatrimonioTeste', 1234, 'Teste para entidade patrimonio', 1)
ON CONFLICT (marca_id) DO NOTHING;