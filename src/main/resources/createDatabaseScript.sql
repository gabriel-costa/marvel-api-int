-------------------------------------- CREATE TABLES --------------------------------------
create table character(
   id serial PRIMARY KEY,
   name VARCHAR (50) NOT NULL,
   description VARCHAR (50) NOT null,
   modified date NOT null,
   resourceURI VARCHAR (50) NOT null
);

create table comic(
   id serial PRIMARY KEY,
   title VARCHAR (50) NOT NULL,
   description VARCHAR (50) NOT null,
   modified date NOT null,
   resourceURI VARCHAR (50) NOT null,
   pageCount integer not null,
   series integer,
   CONSTRAINT comic_series_fk FOREIGN KEY (series)
      REFERENCES Series(id)
);

create table event(
   id serial PRIMARY KEY,
   title VARCHAR (50) NOT NULL,
   description VARCHAR (50) NOT null,
   modified date NOT null,
   resourceURI VARCHAR (50) NOT null,
   next_event integer,
   previous_event integer,
   CONSTRAINT next_event_fk FOREIGN KEY (next_event)
      REFERENCES "event"(id),
   CONSTRAINT previous_event_fk FOREIGN KEY (previous_event)
      REFERENCES "event"(id)
);

create table story(
   id serial PRIMARY KEY,
   title VARCHAR (50) NOT NULL,
   description VARCHAR (50) NOT null,
   modified date NOT null,
   resourceURI VARCHAR (50) NOT null
);

create table series(
   id serial PRIMARY KEY,
   title VARCHAR (50) NOT NULL,
   description VARCHAR (50) NOT null,
   modified date NOT null,
   resourceURI VARCHAR (50) NOT null
);

create table character_comic(
	character_id integer not null,
	comic_id integer not null,
   CONSTRAINT character_comic_fk FOREIGN KEY (character_id)
      REFERENCES "character"(id),
   CONSTRAINT comic_character_fk FOREIGN KEY (comic_id)
      REFERENCES comic(id)
);

create table character_story(
	character_id integer not null,
	story_id integer not null,
   CONSTRAINT character_story_fk FOREIGN KEY (character_id)
      REFERENCES "character"(id),
   CONSTRAINT story_character_fk FOREIGN KEY (story_id)
      REFERENCES story(id)
);

create table character_event(
	character_id integer not null,
	event_id integer not null,
   CONSTRAINT character_event_fk FOREIGN KEY (character_id)
      REFERENCES "character"(id),
   CONSTRAINT event_character_fk FOREIGN KEY (event_id)
      REFERENCES "event"(id)
);

create table character_series(
	character_id integer not null,
	series_id integer not null,
   CONSTRAINT character_series_fk FOREIGN KEY (character_id)
      REFERENCES "character"(id),
   CONSTRAINT series_character_fk FOREIGN KEY (series_id)
      REFERENCES series(id)
);

create table comic_story(
	comic_id integer not null,
	story_id integer not null,
   CONSTRAINT comic_story_fk FOREIGN KEY (comic_id)
      REFERENCES comic(id),
   CONSTRAINT story_comic_fk FOREIGN KEY (story_id)
      REFERENCES story(id)
);

create table comic_event(
	comic_id integer not null,
	event_id integer not null,
   CONSTRAINT comic_event_fk FOREIGN KEY (comic_id)
      REFERENCES comic(id),
   CONSTRAINT event_comic_fk FOREIGN KEY (event_id)
      REFERENCES event(id)
);

create table event_story(
	event_id integer not null,
	story_id integer not null,
   CONSTRAINT event_story_fk FOREIGN KEY (event_id)
      REFERENCES event(id),
   CONSTRAINT story_event_fk FOREIGN KEY (story_id)
      REFERENCES story(id)
);

create table event_series(
	event_id integer not null,
	series_id integer not null,
   CONSTRAINT event_series_fk FOREIGN KEY (event_id)
      REFERENCES event(id),
   CONSTRAINT series_event_fk FOREIGN KEY (series_id)
      REFERENCES series(id)
);

create table series_story(
	series_id integer not null,
	story_id integer not null,
	CONSTRAINT series_story_fk FOREIGN KEY (series_id)
      REFERENCES series(id),
   CONSTRAINT story_series_fk FOREIGN KEY (story_id)
      REFERENCES story(id)
);

create table series_comic(
	series_id integer not null,
	comic_id integer not null,
	CONSTRAINT series_comic_fk FOREIGN KEY (series_id)
      REFERENCES series(id),
   CONSTRAINT comic_series_fk FOREIGN KEY (comic_id)
      REFERENCES comic(id)
);

-------------------------------------- INSERTS --------------------------------------------
insert into "character" values(1,'Hulk','É bem verde','1962-05-01', 'https://en.wikipedia.org/wiki/Hulk');

insert into series values(1, 'The Incredible Hulk', 'The Hulk and his alter ego Dr. Bruce Banner', '1962-05-01', 'en.wikipedia.org/wiki/The_Incredible_Hulk');

insert into comic values(1, 'The Incredible Hulk #1', 'First of the series', '1962-05-01', 'en.wikipedia.org/wiki/The_Incredible_Hulk', 25, 1);

insert into character_comic values(1, 1);

insert into series_comic values(1, 1);

insert into character_series values(1, 1);

insert into "event" values(1, 'Invasão da terra', 'Terra invadida por aliens', '2012-03-10', 'https://www.google.com.br/');
insert into "event" values(2, 'Vitória dos Avengers', 'Aliens foram derrotados pelos Avengers', '2012-03-11', 'https://www.google.com.br/');
insert into "event" values(3, 'Reunião dos Avengers', 'Se conhecem e viram amigos', '2012-03-09', 'https://www.google.com.br/');
update "event" set previous_event=3 where id=1;
update "event" set next_event=2 where id=1;

insert into character_event values(1, 1);
insert into character_event values(1, 2);
insert into character_event values(1, 3);

insert into story values(1, 'Acabou a criatividade', 'Acabou mesmo, não sou nerd da marvel', '2020-02-22', 'https://developer.marvel.com/docs#!/public/');

insert into character_story values(1, 1);

