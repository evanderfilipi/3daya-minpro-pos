// tabel pos_t_pr_history

CREATE TABLE public.pos_t_pr_history
(
    id serial NOT NULL,
    pr_id bigint NOT NULL,
    status character varying(20) NOT NULL,
    created_by bigint,
    created_on timestamp(8) without time zone,
    CONSTRAINT pk_id PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.pos_t_pr_history
    OWNER to postgres;



// tabel pos_t_adjusment_history

CREATE TABLE public.pos_t_adjusment_history
(
    id serial NOT NULL,
    adjusment_id bigint NOT NULL,
    status character varying(20) NOT NULL,
    created_by bigint,
    created_on timestamp(8) without time zone,
    CONSTRAINT pk_pos_t_po_history PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.pos_t_adjusment_history
    OWNER to postgres;



// tabel pos_t_po_history

CREATE TABLE public.pos_t_po_history
(
    id serial NOT NULL,
    po_id bigint NOT NULL,
    status character varying(20) NOT NULL,
    created_by bigint,
    created_on timestamp(8) without time zone,
    CONSTRAINT pk_id_ptph PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.pos_t_po_history
    OWNER to postgres;



// pos_t_transfer_stock_history

CREATE TABLE public.pos_t_transfer_stock_history
(
    id serial NOT NULL,
    transfer_id bigint NOT NULL,
    status character varying(20) NOT NULL,
    created_by bigint,
    created_on timestamp(8) without time zone,
    CONSTRAINT pk_pos_t_transfer_stock_history PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.pos_t_transfer_stock_history
    OWNER to postgres;
