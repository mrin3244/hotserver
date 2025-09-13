--
-- PostgreSQL database dump
--

-- Dumped from database version 11.10
-- Dumped by pg_dump version 11.10

-- Started on 2025-09-13 16:45:01

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
-- TOC entry 2939 (class 1262 OID 24585)
-- Name: hotserver; Type: DATABASE; Schema: -; Owner: -
--

CREATE DATABASE hotserver WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_India.1252' LC_CTYPE = 'English_India.1252';


\connect hotserver

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

SET default_with_oids = false;

--
-- TOC entry 198 (class 1259 OID 24599)
-- Name: category; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.category (
    id smallint NOT NULL,
    description character varying(100),
    balance integer,
    customer character varying(255),
    delivery_fee integer,
    discount integer,
    grand_total integer,
    inclusive_tax boolean,
    notes character varying(255),
    payment_status character varying(255),
    profit integer,
    revenue integer,
    sales_price integer,
    service_fee integer,
    tax integer,
    total_paid integer,
    transaction_date timestamp(6) without time zone
);


--
-- TOC entry 214 (class 1259 OID 32911)
-- Name: closing_stock; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.closing_stock (
    date date NOT NULL,
    r_id character varying(50) NOT NULL,
    amount numeric(14,2) NOT NULL,
    CONSTRAINT closing_stock_amount_check CHECK ((amount >= (0)::numeric))
);


--
-- TOC entry 199 (class 1259 OID 24604)
-- Name: daily_sale; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.daily_sale (
    category integer NOT NULL,
    sale_date timestamp(6) without time zone NOT NULL,
    log_dt timestamp(6) without time zone,
    sale_amount integer,
    user_id character varying(255)
);


--
-- TOC entry 202 (class 1259 OID 32777)
-- Name: excel_discount; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.excel_discount (
    invoice_number character varying(255) NOT NULL,
    log_date timestamp(6) without time zone NOT NULL,
    item_name character varying(255),
    promo_code character varying(255),
    qty character varying(255),
    sku character varying(255),
    total character varying(255),
    value character varying(255)
);


--
-- TOC entry 203 (class 1259 OID 32785)
-- Name: excel_options; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.excel_options (
    invoice_number character varying(255) NOT NULL,
    log_date timestamp(6) without time zone NOT NULL,
    item_name character varying(255),
    options character varying(255),
    product_cost character varying(255),
    qty character varying(255),
    sale_price character varying(255),
    sku character varying(255),
    title character varying(255),
    total character varying(255)
);


--
-- TOC entry 204 (class 1259 OID 32793)
-- Name: excel_product; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.excel_product (
    invoice_number character varying(255) NOT NULL,
    item_name character varying(255) NOT NULL,
    barcode character varying(255),
    category character varying(255),
    note character varying(255),
    product_cost integer,
    qty integer,
    sales_price integer,
    sku character varying(255),
    total_price integer,
    unit character varying(255)
);


--
-- TOC entry 205 (class 1259 OID 32801)
-- Name: excel_transaction; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.excel_transaction (
    invoice_number character varying(255) NOT NULL,
    balance integer,
    customer character varying(255),
    delivery_fee integer,
    discount integer,
    grand_total integer,
    inclusive_tax boolean,
    notes character varying(255),
    payment_status character varying(255),
    profit integer,
    revenue integer,
    sales_price integer,
    service_fee integer,
    tax integer,
    total_paid integer,
    transaction_date timestamp(6) without time zone,
    product_cost integer
);


--
-- TOC entry 197 (class 1259 OID 24594)
-- Name: items; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.items (
    id smallint NOT NULL,
    category smallint,
    description character varying(100),
    price smallint,
    weightage smallint
);


--
-- TOC entry 213 (class 1259 OID 32893)
-- Name: material_consumption; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.material_consumption (
    sale_id integer NOT NULL,
    date timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    r_id character varying(50) NOT NULL,
    quantity numeric(12,2) NOT NULL,
    amount numeric(14,2) NOT NULL,
    CONSTRAINT material_consumption_amount_check CHECK ((amount >= (0)::numeric)),
    CONSTRAINT material_consumption_quantity_check CHECK ((quantity > (0)::numeric))
);


--
-- TOC entry 207 (class 1259 OID 32847)
-- Name: product_material_recipe_master; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.product_material_recipe_master (
    p_id character varying(50) NOT NULL,
    r_id character varying(50) NOT NULL,
    quantity numeric(12,2) NOT NULL,
    CONSTRAINT product_material_recipe_master_quantity_check CHECK ((quantity > (0)::numeric))
);


--
-- TOC entry 210 (class 1259 OID 32874)
-- Name: product_price; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.product_price (
    p_id character varying(50) NOT NULL,
    unit_price numeric(12,2) NOT NULL,
    start_date date NOT NULL,
    end_date date,
    CONSTRAINT chk_price_validity CHECK (((end_date IS NULL) OR (end_date >= start_date))),
    CONSTRAINT product_price_unit_price_check CHECK ((unit_price >= (0)::numeric))
);


--
-- TOC entry 209 (class 1259 OID 32860)
-- Name: raw_material_buy; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.raw_material_buy (
    id integer NOT NULL,
    r_id character varying(50) NOT NULL,
    quantity numeric(12,2) NOT NULL,
    unit_price numeric(12,2) NOT NULL,
    total_price numeric(14,2),
    buy_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT raw_material_buy_quantity_check CHECK ((quantity > (0)::numeric)),
    CONSTRAINT raw_material_buy_unit_price_check CHECK ((unit_price >= (0)::numeric))
);


--
-- TOC entry 208 (class 1259 OID 32858)
-- Name: raw_material_buy_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.raw_material_buy_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2940 (class 0 OID 0)
-- Dependencies: 208
-- Name: raw_material_buy_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.raw_material_buy_id_seq OWNED BY public.raw_material_buy.id;


--
-- TOC entry 206 (class 1259 OID 32842)
-- Name: raw_material_master; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.raw_material_master (
    id character varying(50) NOT NULL,
    name character varying(255) NOT NULL,
    unit character varying(50) NOT NULL
);


--
-- TOC entry 212 (class 1259 OID 32883)
-- Name: sale; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.sale (
    sale_id integer NOT NULL,
    date timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    p_id character varying(50) NOT NULL,
    quantity numeric(12,2) NOT NULL,
    unit_price numeric(12,2) NOT NULL,
    amount numeric(14,2),
    invoice_amount numeric(14,2) NOT NULL,
    CONSTRAINT sale_invoice_amount_check CHECK ((invoice_amount >= (0)::numeric)),
    CONSTRAINT sale_quantity_check CHECK ((quantity > (0)::numeric)),
    CONSTRAINT sale_unit_price_check CHECK ((unit_price >= (0)::numeric))
);


--
-- TOC entry 211 (class 1259 OID 32881)
-- Name: sale_sale_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.sale_sale_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2941 (class 0 OID 0)
-- Dependencies: 211
-- Name: sale_sale_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.sale_sale_id_seq OWNED BY public.sale.sale_id;


--
-- TOC entry 200 (class 1259 OID 24609)
-- Name: todays_sale; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.todays_sale (
    log_dt timestamp(6) without time zone NOT NULL,
    amount integer,
    menu integer,
    quantity integer,
    user_id character varying(255)
);


--
-- TOC entry 201 (class 1259 OID 24614)
-- Name: todays_sale_history; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.todays_sale_history (
    log_dt timestamp(6) without time zone NOT NULL,
    amount integer,
    compiled_by character varying(255),
    compiled_on timestamp(6) without time zone,
    menu integer,
    quantity integer,
    user_id character varying(255)
);


--
-- TOC entry 196 (class 1259 OID 24586)
-- Name: user_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.user_info (
    user_id character varying(10) NOT NULL,
    user_name character varying(50),
    user_password character varying(500),
    user_type character varying(30),
    user_status character varying(1)
);


--
-- TOC entry 2759 (class 2604 OID 32863)
-- Name: raw_material_buy id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.raw_material_buy ALTER COLUMN id SET DEFAULT nextval('public.raw_material_buy_id_seq'::regclass);


--
-- TOC entry 2765 (class 2604 OID 32886)
-- Name: sale sale_id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.sale ALTER COLUMN sale_id SET DEFAULT nextval('public.sale_sale_id_seq'::regclass);


--
-- TOC entry 2779 (class 2606 OID 24603)
-- Name: category category_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pkey PRIMARY KEY (id);


--
-- TOC entry 2807 (class 2606 OID 32916)
-- Name: closing_stock closing_stock_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.closing_stock
    ADD CONSTRAINT closing_stock_pkey PRIMARY KEY (date, r_id);


--
-- TOC entry 2781 (class 2606 OID 24608)
-- Name: daily_sale daily_sale_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.daily_sale
    ADD CONSTRAINT daily_sale_pkey PRIMARY KEY (category, sale_date);


--
-- TOC entry 2787 (class 2606 OID 32784)
-- Name: excel_discount excel_discount_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.excel_discount
    ADD CONSTRAINT excel_discount_pkey PRIMARY KEY (invoice_number, log_date);


--
-- TOC entry 2789 (class 2606 OID 32792)
-- Name: excel_options excel_options_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.excel_options
    ADD CONSTRAINT excel_options_pkey PRIMARY KEY (invoice_number, log_date);


--
-- TOC entry 2791 (class 2606 OID 32800)
-- Name: excel_product excel_product_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.excel_product
    ADD CONSTRAINT excel_product_pkey PRIMARY KEY (invoice_number, item_name);


--
-- TOC entry 2793 (class 2606 OID 32808)
-- Name: excel_transaction excel_transaction_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.excel_transaction
    ADD CONSTRAINT excel_transaction_pkey PRIMARY KEY (invoice_number);


--
-- TOC entry 2777 (class 2606 OID 24598)
-- Name: items items_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.items
    ADD CONSTRAINT items_pkey PRIMARY KEY (id);


--
-- TOC entry 2805 (class 2606 OID 32900)
-- Name: material_consumption material_consumption_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.material_consumption
    ADD CONSTRAINT material_consumption_pkey PRIMARY KEY (sale_id, r_id);


--
-- TOC entry 2797 (class 2606 OID 32852)
-- Name: product_material_recipe_master product_material_recipe_master_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.product_material_recipe_master
    ADD CONSTRAINT product_material_recipe_master_pkey PRIMARY KEY (p_id, r_id);


--
-- TOC entry 2801 (class 2606 OID 32880)
-- Name: product_price product_price_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.product_price
    ADD CONSTRAINT product_price_pkey PRIMARY KEY (p_id, start_date);


--
-- TOC entry 2799 (class 2606 OID 32868)
-- Name: raw_material_buy raw_material_buy_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.raw_material_buy
    ADD CONSTRAINT raw_material_buy_pkey PRIMARY KEY (id);


--
-- TOC entry 2795 (class 2606 OID 32846)
-- Name: raw_material_master raw_material_master_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.raw_material_master
    ADD CONSTRAINT raw_material_master_pkey PRIMARY KEY (id);


--
-- TOC entry 2803 (class 2606 OID 32892)
-- Name: sale sale_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.sale
    ADD CONSTRAINT sale_pkey PRIMARY KEY (sale_id);


--
-- TOC entry 2785 (class 2606 OID 24621)
-- Name: todays_sale_history todays_sale_history_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.todays_sale_history
    ADD CONSTRAINT todays_sale_history_pkey PRIMARY KEY (log_dt);


--
-- TOC entry 2783 (class 2606 OID 24613)
-- Name: todays_sale todays_sale_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.todays_sale
    ADD CONSTRAINT todays_sale_pkey PRIMARY KEY (log_dt);


--
-- TOC entry 2775 (class 2606 OID 24590)
-- Name: user_info user_info_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.user_info
    ADD CONSTRAINT user_info_pkey PRIMARY KEY (user_id);


--
-- TOC entry 2809 (class 2606 OID 32869)
-- Name: raw_material_buy fk_buy_raw_material; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.raw_material_buy
    ADD CONSTRAINT fk_buy_raw_material FOREIGN KEY (r_id) REFERENCES public.raw_material_master(id);


--
-- TOC entry 2811 (class 2606 OID 32906)
-- Name: material_consumption fk_consumption_material; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.material_consumption
    ADD CONSTRAINT fk_consumption_material FOREIGN KEY (r_id) REFERENCES public.raw_material_master(id);


--
-- TOC entry 2810 (class 2606 OID 32901)
-- Name: material_consumption fk_consumption_sale; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.material_consumption
    ADD CONSTRAINT fk_consumption_sale FOREIGN KEY (sale_id) REFERENCES public.sale(sale_id) ON DELETE CASCADE;


--
-- TOC entry 2808 (class 2606 OID 32853)
-- Name: product_material_recipe_master fk_raw_material; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.product_material_recipe_master
    ADD CONSTRAINT fk_raw_material FOREIGN KEY (r_id) REFERENCES public.raw_material_master(id) ON DELETE CASCADE;


--
-- TOC entry 2812 (class 2606 OID 32917)
-- Name: closing_stock fk_stock_material; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.closing_stock
    ADD CONSTRAINT fk_stock_material FOREIGN KEY (r_id) REFERENCES public.raw_material_master(id);


-- Completed on 2025-09-13 16:45:02

--
-- PostgreSQL database dump complete
--

