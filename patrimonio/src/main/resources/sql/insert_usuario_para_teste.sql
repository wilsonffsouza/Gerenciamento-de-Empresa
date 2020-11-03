INSERT INTO tb_usuarios 
(email, nome, senha, token) 
VALUES 
( 'teste@teste.com.br', 'teste', '1234', 'eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MDQ0MzI4OTksInN1YiI6IlRlc3RlIEp3dCBBUEkiLCJleHAiOjE2MDQ0MzQ2OTl9.haMXJ96NnWnsPYz8q970fdytjkBYiQHcjovq835Yn6I')
ON CONFLICT (email) DO NOTHING;