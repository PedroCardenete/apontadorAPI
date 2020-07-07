TYPE=VIEW
query=select `e`.`id` AS `Id`,(select `apontadordb`.`empresatype`.`TypeEmpresaName` from `apontadordb`.`empresatype` where (`apontadordb`.`empresatype`.`id` = `e`.`TypeEmpresaId`)) AS `Tipo`,`e`.`Nome` AS `Nome`,`e`.`Logradouro` AS `Logradouro`,`e`.`Telefone` AS `Telefone` from `apontadordb`.`empresa` `e`
md5=bcc4a4bfeea34cfccb1c13653aea330e
updatable=0
algorithm=0
definer_user=root
definer_host=%
suid=2
with_check_option=0
timestamp=2020-07-07 02:38:55
create-version=1
source=SELECT\n Id,\n (SELECT TypeEmpresaName FROM empresatype WHERE id= e.TypeEmpresaId) AS `Tipo`,\n `Nome`,\n `Logradouro`,\n `Telefone`\n FROM empresa e
client_cs_name=utf8mb4
connection_cl_name=utf8mb4_general_ci
view_body_utf8=select `e`.`id` AS `Id`,(select `apontadordb`.`empresatype`.`TypeEmpresaName` from `apontadordb`.`empresatype` where (`apontadordb`.`empresatype`.`id` = `e`.`TypeEmpresaId`)) AS `Tipo`,`e`.`Nome` AS `Nome`,`e`.`Logradouro` AS `Logradouro`,`e`.`Telefone` AS `Telefone` from `apontadordb`.`empresa` `e`
