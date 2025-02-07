-- Paso 0: Conéctate a la base de datos con permisos de root.
-- Paso 1: Crear la base de datos 'instituto'.
CREATE DATABASE instituto;
-- Paso 2: Crear el usuario 'instituto' con una contraseña segura.
CREATE USER instituto WITH PASSWORD 'institutoSimarro';
-- Paso 3: Otorgar todos los privilegios al usuario 'instituto' sobre la base de datos 'instituto'.
-- Dar todos los permisos al usuario 'instituto' sobre la base de datos 'instituto'
GRANT ALL PRIVILEGES ON DATABASE instituto TO instituto;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO instituto;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO instituto;
GRANT ALL PRIVILEGES ON ALL FUNCTIONS IN SCHEMA public TO instituto;
-- Establecer la base de datos por defecto para el usuario 'instituto'
ALTER USER instituto
SET search_path TO public;
ALTER DATABASE instituto OWNER TO instituto;