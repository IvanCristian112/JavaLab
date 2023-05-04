CREATE TABLE IF NOT EXISTS public."Albums"
    (
        "ID" integer NOT NULL DEFAULT nextval('"Albums_ID_seq"'::regclass),
        "ReleaseYear" integer NOT NULL,
        "Title" character varying(50) COLLATE pg_catalog."default" NOT NULL,
        "Artist" character varying(50) COLLATE pg_catalog."default" NOT NULL,
        "Genres" character varying(50)[] COLLATE pg_catalog."default" NOT NULL,
        CONSTRAINT "Albums_pkey" PRIMARY KEY ("ID")
    )

    TABLESPACE pg_default;

    ALTER TABLE IF EXISTS public."Albums"
        OWNER to postgres;
        -- Table: public.Artists

        -- DROP TABLE IF EXISTS public."Artists";

CREATE TABLE IF NOT EXISTS public."Artists"
        (
            "ID" integer NOT NULL DEFAULT nextval('"Artists_ID_seq"'::regclass),
            "Name" character varying(50) COLLATE pg_catalog."default" NOT NULL,
            CONSTRAINT "Artists_pkey" PRIMARY KEY ("ID")
        )

        TABLESPACE pg_default;

        ALTER TABLE IF EXISTS public."Artists"
            OWNER to postgres;

-- Table: public.Genres

-- DROP TABLE IF EXISTS public."Genres";

CREATE TABLE IF NOT EXISTS public."Genres"
(
    "ID" integer NOT NULL DEFAULT nextval('"Genres_ID_seq"'::regclass),
    "Name" character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Genres_pkey" PRIMARY KEY ("ID")
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Genres"
    OWNER to postgres;

-- Table: public.AlbumGenres

-- DROP TABLE IF EXISTS public."AlbumGenres";

CREATE TABLE IF NOT EXISTS public."AlbumGenres"
(
    "GenreID" integer NOT NULL DEFAULT nextval('"AlbumGenres_GenreID_seq"'::regclass),
    "AlbumID" integer NOT NULL DEFAULT nextval('"AlbumGenres_AlbumID_seq"'::regclass),
    CONSTRAINT album_fk FOREIGN KEY ("AlbumID")
        REFERENCES public."Albums" ("ID") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT genre_fk FOREIGN KEY ("GenreID")
        REFERENCES public."Genres" ("ID") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE RESTRICT
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."AlbumGenres"
    OWNER to postgres;

    -- Table: public.Albums

    -- DROP TABLE IF EXISTS public."Albums";