

--
-- Create user table
--
CREATE TABLE public.application_user
(
  user_id integer PRIMARY KEY,
  username character varying,
  password character varying,
  is_admin boolean
);

DROP SEQUENCE public.application_user_id_seq;
CREATE SEQUENCE public.application_user_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;


--
-- Create the book table
--
CREATE TABLE public.book
(
  book_id integer PRIMARY KEY ,
  date character varying,
  book_name character varying,
  price numeric,
  author character varying,
  ISBN numeric,
  genre character varying

);

DROP SEQUENCE public.book_id_seq;
CREATE SEQUENCE public.book_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

