INSERT INTO tb_usuarios 
(email, nome, senha) 
VALUES 
( 'teste@teste.com.br', 'teste', '1234')
ON CONFLICT (email) DO NOTHING;