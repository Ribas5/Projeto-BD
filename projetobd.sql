--
-- PostgreSQL database dump
--

-- Dumped from database version 10.14
-- Dumped by pg_dump version 10.14

-- Started on 2020-10-19 10:24:02

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12924)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2871 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 197 (class 1259 OID 24785)
-- Name: estudio; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.estudio (
    id integer NOT NULL,
    nome character varying NOT NULL
);


ALTER TABLE public.estudio OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 24783)
-- Name: estudio_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.estudio_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.estudio_id_seq OWNER TO postgres;

--
-- TOC entry 2872 (class 0 OID 0)
-- Dependencies: 196
-- Name: estudio_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.estudio_id_seq OWNED BY public.estudio.id;


--
-- TOC entry 199 (class 1259 OID 24796)
-- Name: filme; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.filme (
    id integer NOT NULL,
    nome character varying NOT NULL,
    duracao integer NOT NULL,
    preco numeric NOT NULL,
    faixa_etaria character varying NOT NULL,
    id_estudio integer NOT NULL
);


ALTER TABLE public.filme OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 24794)
-- Name: filme_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.filme_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.filme_id_seq OWNER TO postgres;

--
-- TOC entry 2873 (class 0 OID 0)
-- Dependencies: 198
-- Name: filme_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.filme_id_seq OWNED BY public.filme.id;


--
-- TOC entry 201 (class 1259 OID 24813)
-- Name: genero; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.genero (
    id integer NOT NULL,
    descricao character varying NOT NULL
);


ALTER TABLE public.genero OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 24894)
-- Name: genero_filme; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.genero_filme (
    id_filme integer NOT NULL,
    id_genero integer NOT NULL
);


ALTER TABLE public.genero_filme OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 24811)
-- Name: genero_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.genero_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.genero_id_seq OWNER TO postgres;

--
-- TOC entry 2874 (class 0 OID 0)
-- Dependencies: 200
-- Name: genero_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.genero_id_seq OWNED BY public.genero.id;


--
-- TOC entry 205 (class 1259 OID 24868)
-- Name: pedido; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pedido (
    id integer NOT NULL,
    data date NOT NULL,
    expiracao date NOT NULL,
    id_usuario integer NOT NULL
);


ALTER TABLE public.pedido OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 24879)
-- Name: pedido_filme; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pedido_filme (
    id_filme integer NOT NULL,
    id_pedido integer NOT NULL
);


ALTER TABLE public.pedido_filme OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 24866)
-- Name: pedido_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pedido_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pedido_id_seq OWNER TO postgres;

--
-- TOC entry 2875 (class 0 OID 0)
-- Dependencies: 204
-- Name: pedido_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pedido_id_seq OWNED BY public.pedido.id;


--
-- TOC entry 203 (class 1259 OID 24824)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    nome character varying NOT NULL,
    id integer NOT NULL,
    idade integer NOT NULL,
    senha character varying NOT NULL,
    email character varying NOT NULL,
    saldo numeric NOT NULL
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 24822)
-- Name: usuario_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuario_id_seq OWNER TO postgres;

--
-- TOC entry 2876 (class 0 OID 0)
-- Dependencies: 202
-- Name: usuario_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.usuario_id_seq OWNED BY public.usuario.id;


--
-- TOC entry 2706 (class 2604 OID 24788)
-- Name: estudio id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estudio ALTER COLUMN id SET DEFAULT nextval('public.estudio_id_seq'::regclass);


--
-- TOC entry 2707 (class 2604 OID 24799)
-- Name: filme id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.filme ALTER COLUMN id SET DEFAULT nextval('public.filme_id_seq'::regclass);


--
-- TOC entry 2708 (class 2604 OID 24816)
-- Name: genero id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.genero ALTER COLUMN id SET DEFAULT nextval('public.genero_id_seq'::regclass);


--
-- TOC entry 2710 (class 2604 OID 24871)
-- Name: pedido id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido ALTER COLUMN id SET DEFAULT nextval('public.pedido_id_seq'::regclass);


--
-- TOC entry 2709 (class 2604 OID 24827)
-- Name: usuario id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario ALTER COLUMN id SET DEFAULT nextval('public.usuario_id_seq'::regclass);


--
-- TOC entry 2853 (class 0 OID 24785)
-- Dependencies: 197
-- Data for Name: estudio; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.estudio (id, nome) FROM stdin;
1	Lectus Nullam LLP
2	Tempor Bibendum PC
3	Suspendisse Ac Consulting
4	Posuere Inc.
5	Sodales Elit Erat Consulting
6	Nibh Dolor Incorporated
7	Sem Eget Massa Corp.
8	In Consulting
9	Nullam Inc.
10	Placerat Incorporated
11	Wanner
\.


--
-- TOC entry 2855 (class 0 OID 24796)
-- Dependencies: 199
-- Data for Name: filme; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.filme (id, nome, duracao, preco, faixa_etaria, id_estudio) FROM stdin;
1	 Shrek Terceiro	204	11	+16	1
3	Mad Max	171	18	+12	3
4	Doutor Estranho	169	38	+18	2
5	Avatar	198	40	Livre	1
6	 Homem-Aranha 2	126	33	+12	8
7	My Little Poney	213	2	+10	9
8	 Carros	159	31	+16	2
9	 Homem-Aranha 3	113	33	+10	8
10	Monstros S.A.	150	9	+10	6
11	Logan	103	37	+16	7
12	 Hercules	199	18	+18	6
13	 Shrek	112	34	+10	1
14	 Shrek 2	98	8	+10	9
15	 Carros 3	157	34	+14	3
16	 O Gigante de Ferro	95	40	+18	4
17	Avengers Guerra infinita	68	25	+10	10
18	Blade Runner	65	29	+18	2
19	Trolls	120	40.3	Livre	1
2	Barbie e as sereias	100	15.5	Livre	3
21	Speed Racer	120	50.2	+10	2
\.


--
-- TOC entry 2857 (class 0 OID 24813)
-- Dependencies: 201
-- Data for Name: genero; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.genero (id, descricao) FROM stdin;
1	Ação
2	Terror
3	Romance
4	Ficção
5	Aventura
6	Drama
7	Corrida
8	comedia
\.


--
-- TOC entry 2863 (class 0 OID 24894)
-- Dependencies: 207
-- Data for Name: genero_filme; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.genero_filme (id_filme, id_genero) FROM stdin;
18	6
14	5
17	3
13	2
10	5
1	1
1	6
13	4
5	6
6	2
4	5
9	3
18	5
4	6
9	2
15	4
13	6
7	1
18	4
17	2
6	4
7	2
14	4
12	2
16	2
16	6
2	8
2	3
\.


--
-- TOC entry 2861 (class 0 OID 24868)
-- Dependencies: 205
-- Data for Name: pedido; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pedido (id, data, expiracao, id_usuario) FROM stdin;
1	2019-11-26	2021-06-11	34
2	2020-01-16	2021-09-06	26
3	2020-01-03	2021-05-31	15
4	2019-12-04	2020-10-10	15
5	2019-12-27	2021-09-11	28
6	2019-11-22	2021-02-15	17
7	2020-02-11	2021-02-10	29
8	2019-11-18	2020-12-31	24
9	2020-01-07	2021-07-02	18
10	2020-01-15	2020-10-27	12
11	2019-12-23	2021-01-27	11
12	2019-11-18	2021-02-05	6
13	2020-01-08	2020-12-01	11
14	2019-11-28	2021-07-13	24
15	2020-01-04	2020-12-28	14
16	2019-11-27	2021-02-18	32
17	2019-11-10	2020-11-07	1
18	2020-01-10	2020-10-21	28
19	2019-12-21	2021-09-20	6
20	2019-10-04	2021-06-11	30
21	2020-02-02	2021-02-07	15
22	2019-12-13	2021-02-04	15
23	2019-10-09	2021-02-28	29
24	2019-12-02	2021-07-26	19
25	2020-02-06	2021-05-27	3
26	2019-12-23	2021-08-25	20
27	2019-10-20	2021-05-23	15
28	2020-02-09	2021-06-20	32
29	2019-11-09	2021-08-14	1
30	2020-02-07	2021-04-24	40
31	2020-01-09	2021-05-01	27
32	2019-10-12	2021-07-21	9
33	2019-10-15	2021-05-23	28
34	2019-10-15	2020-12-11	18
35	2019-10-31	2021-01-15	11
36	2019-11-15	2021-09-09	3
37	2019-10-26	2020-12-20	2
38	2019-10-03	2021-08-18	36
39	2020-01-03	2021-02-25	17
40	2019-12-02	2021-04-29	7
41	2020-05-12	2020-05-25	2
\.


--
-- TOC entry 2862 (class 0 OID 24879)
-- Dependencies: 206
-- Data for Name: pedido_filme; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pedido_filme (id_filme, id_pedido) FROM stdin;
16	12
5	29
10	10
17	22
5	8
17	17
7	18
9	23
12	22
14	21
12	31
17	23
2	9
13	35
1	31
17	36
9	27
13	25
5	11
18	35
4	22
18	39
1	13
12	8
1	19
3	7
3	2
12	39
14	13
11	13
17	7
7	34
8	40
18	14
12	7
8	36
17	31
5	19
3	11
11	36
3	6
5	23
3	5
8	17
2	21
13	12
6	24
4	2
4	21
15	6
3	10
11	31
7	32
4	39
14	14
17	16
17	27
5	16
10	6
15	39
5	34
15	29
12	24
14	5
18	31
13	39
3	9
2	17
17	40
10	25
9	3
18	38
\.


--
-- TOC entry 2859 (class 0 OID 24824)
-- Dependencies: 203
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario (nome, id, idade, senha, email, saldo) FROM stdin;
Malcolm Barry	1	65	BNV49OMB1JF	Cras@tincidunt.net	81
Xenos Mclaughlin	2	17	XMW23GQV4FC	ante.Vivamus.non@ac.ca	7
Barbara Mueller	3	62	HPJ81CZM2QB	ac.ipsum@risus.co.uk	195
Daphne Pugh	4	57	DNO14RNB9TZ	tempus.scelerisque.lorem@bibendumullamcorper.ca	29
Melanie Olsen	5	20	TLI52IHO3LP	odio@pedenecante.edu	153
Gabriel Obrien	6	44	MAO14KHX8MB	at.lacus@etmalesuadafames.org	72
Hashim Rasmussen	7	70	YAB96ASY9FD	arcu.ac@dictum.co.uk	7
Justin Livingston	8	27	MDM99EAP7DG	mauris@lacus.org	84
Shana Mcknight	9	16	IYD05HNT2YW	fames.ac@aodiosemper.org	140
Daniel Moran	10	28	VVC84ZAR4BK	Sed.id@nascetur.org	107
Sloane Craig	11	50	UBA02VRF8FP	cursus@estac.org	153
Taylor Bradford	12	11	IHJ22YCZ3PP	dis.parturient.montes@Nunc.co.uk	164
Jonas Colon	13	54	SLM24QOK0XY	Phasellus@erat.ca	180
Camille Harrington	14	37	EUW00UPP0IU	nisi.a@musAeneaneget.ca	4
Kaye Clarke	15	70	JTW18XOE4MA	nec@lobortis.co.uk	55
Lester Townsend	16	35	HVE76QUU2LO	Phasellus@Cumsociis.net	76
Burke Odom	17	40	DQG17YJT9LA	sed@vel.org	176
Conan Levine	18	17	PFT12OSR6ER	gravida.Aliquam.tincidunt@vitaeerat.co.uk	105
Nita Henry	19	64	OAG44BBD2CF	pellentesque@non.net	47
Caleb Webster	20	41	ABD19VRL3QI	interdum.Curabitur.dictum@loremeumetus.edu	125
Mason Espinoza	21	34	SVR56SMP0BG	ultrices@odio.co.uk	178
Josephine Briggs	22	49	CMN35RUV2DL	lacus.pede.sagittis@liberoDonecconsectetuer.com	85
Brielle Buchanan	23	67	CLY22NNO8UL	odio.semper@convallis.co.uk	154
Silas Soto	24	50	ZPI76BLW6NG	aliquam.enim.nec@velsapien.ca	46
Tallulah Bauer	25	13	HTH15SFP6ZD	sapien.gravida.non@eu.edu	128
Yen Beach	26	47	ZYQ11OMQ9WJ	vulputate@Mauris.co.uk	183
Sylvester Hill	27	47	UGH35KLR8BZ	pede@musAenean.edu	194
Jana Holt	28	51	IGT00CIR6RN	ac.feugiat@arcu.org	89
Phoebe Frye	29	18	UPJ53ICT0GR	suscipit@Duis.co.uk	1
Shelly Maynard	30	22	SJX72JNG4LY	non.lacinia@consequat.com	82
Molly Bradford	31	38	ZTI24QDG1WC	tempus.risus.Donec@sagittis.ca	45
Mercedes Cantrell	32	41	DCN37ZJO7JX	risus@NullamenimSed.co.uk	183
Troy Galloway	33	12	EFU10CUF4YR	ligula.Donec.luctus@tristiqueneque.net	48
Ishmael Cotton	34	18	LLM02LFQ8JR	fermentum.convallis@ametnulla.com	166
Teagan Roberson	35	39	ARL44RFX3QA	consectetuer.ipsum@Integeraliquamadipiscing.net	107
Carter Thornton	36	20	CZB95KFL1SR	ac@nibh.edu	127
Ashton Reid	37	34	UEQ44WCQ6MA	vulputate.lacus.Cras@augueSedmolestie.org	79
Willa Levy	38	23	KTZ86JQO0PW	eu@Nuncmauris.com	1
Renee Frost	39	40	ZEG68RXO2YV	ornare@volutpat.ca	103
Colette Le	40	53	SQC89PRF2WE	ac@elit.org	21
ivo	42	52	123	ivoBB@@BB	15
ivo	43	45	123	ivo@cc	12.5
\.


--
-- TOC entry 2877 (class 0 OID 0)
-- Dependencies: 196
-- Name: estudio_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.estudio_id_seq', 11, true);


--
-- TOC entry 2878 (class 0 OID 0)
-- Dependencies: 198
-- Name: filme_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.filme_id_seq', 21, true);


--
-- TOC entry 2879 (class 0 OID 0)
-- Dependencies: 200
-- Name: genero_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.genero_id_seq', 8, true);


--
-- TOC entry 2880 (class 0 OID 0)
-- Dependencies: 204
-- Name: pedido_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pedido_id_seq', 41, true);


--
-- TOC entry 2881 (class 0 OID 0)
-- Dependencies: 202
-- Name: usuario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuario_id_seq', 43, true);


--
-- TOC entry 2712 (class 2606 OID 24793)
-- Name: estudio estudio_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estudio
    ADD CONSTRAINT estudio_pkey PRIMARY KEY (id);


--
-- TOC entry 2714 (class 2606 OID 24804)
-- Name: filme filme_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.filme
    ADD CONSTRAINT filme_pkey PRIMARY KEY (id);


--
-- TOC entry 2724 (class 2606 OID 24898)
-- Name: genero_filme genero_filme_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.genero_filme
    ADD CONSTRAINT genero_filme_pkey PRIMARY KEY (id_filme, id_genero);


--
-- TOC entry 2716 (class 2606 OID 24821)
-- Name: genero genero_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.genero
    ADD CONSTRAINT genero_pkey PRIMARY KEY (id);


--
-- TOC entry 2722 (class 2606 OID 24883)
-- Name: pedido_filme pedido_filme_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_filme
    ADD CONSTRAINT pedido_filme_pkey PRIMARY KEY (id_filme, id_pedido);


--
-- TOC entry 2720 (class 2606 OID 24873)
-- Name: pedido pedido_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido
    ADD CONSTRAINT pedido_pkey PRIMARY KEY (id);


--
-- TOC entry 2718 (class 2606 OID 24832)
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);


--
-- TOC entry 2725 (class 2606 OID 24805)
-- Name: filme filme_estudio_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.filme
    ADD CONSTRAINT filme_estudio_id_fkey FOREIGN KEY (id_estudio) REFERENCES public.estudio(id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 2729 (class 2606 OID 24899)
-- Name: genero_filme gf_filme_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.genero_filme
    ADD CONSTRAINT gf_filme_id_fkey FOREIGN KEY (id_filme) REFERENCES public.filme(id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 2730 (class 2606 OID 24904)
-- Name: genero_filme gf_genero_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.genero_filme
    ADD CONSTRAINT gf_genero_id_fkey FOREIGN KEY (id_genero) REFERENCES public.genero(id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 2726 (class 2606 OID 24874)
-- Name: pedido pedido_usuario_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido
    ADD CONSTRAINT pedido_usuario_id_fkey FOREIGN KEY (id_usuario) REFERENCES public.usuario(id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 2727 (class 2606 OID 24884)
-- Name: pedido_filme pf_filme_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_filme
    ADD CONSTRAINT pf_filme_id_fkey FOREIGN KEY (id_filme) REFERENCES public.filme(id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 2728 (class 2606 OID 24889)
-- Name: pedido_filme pf_pedido_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_filme
    ADD CONSTRAINT pf_pedido_id_fkey FOREIGN KEY (id_pedido) REFERENCES public.pedido(id) ON UPDATE CASCADE ON DELETE RESTRICT;


-- Completed on 2020-10-19 10:24:03

--
-- PostgreSQL database dump complete
--

