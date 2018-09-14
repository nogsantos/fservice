--database
CREATE DATABASE fservice
  WITH ENCODING='UTF8'
       OWNER=fabricio
       CONNECTION LIMIT=-1;
-- schema       
create schema administration AUTHORIZATION fabricio;
create schema business AUTHORIZATION fabricio;
