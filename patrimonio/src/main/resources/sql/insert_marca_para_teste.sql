INSERT INTO tb_marcas
(nome, marca_id) 
VALUES 
( 'MarcaTeste', 1234)
ON CONFLICT (nome) DO NOTHING;