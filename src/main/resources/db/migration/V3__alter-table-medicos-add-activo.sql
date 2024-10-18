-- 1 = activo, 0 = inactivo
-- Para que la columna de los anteriores registros no este nula
alter table medicos add activo tinyint;
update medicos set activo = 1;
