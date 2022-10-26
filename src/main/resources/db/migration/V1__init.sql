create table public.addresses (
                                  id bigint primary key not null default nextval('addresses_id_seq'::regclass),
                                  address_has_active boolean,
                                  city character varying(255),
                                  country character varying(255),
                                  house_number character varying(255),
                                  street character varying(255),
                                  employee_id integer,
                                  foreign key (employee_id) references public.users (id)
                                      match simple on update no action on delete no action
);

create table public.documents (
                                  id bigint primary key not null default nextval('documents_id_seq'::regclass),
                                  passport integer,
                                  driving_licence integer,
                                  e_document integer,
                                  international_passport integer,
                                  student_card integer,
                                  number bigint,
                                  passport_id integer,
                                  driving_licence_id integer,
                                  e_document_id integer,
                                  international_passport_id integer,
                                  student_card_id integer,
                                  foreign key (e_document) references public.e_document (id)
                                      match simple on update no action on delete no action,
                                  foreign key (driving_licence) references public.driving_licence (id)
                                      match simple on update no action on delete no action,
                                  foreign key (international_passport) references public.international_passport (id)
                                      match simple on update no action on delete no action,
                                  foreign key (e_document_id) references public.e_document (id)
                                      match simple on update no action on delete no action,
                                  foreign key (driving_licence_id) references public.driving_licence (id)
                                      match simple on update no action on delete no action,
                                  foreign key (student_card) references public.international_passport (id)
                                      match simple on update no action on delete no action,
                                  foreign key (international_passport_id) references public.international_passport (id)
                                      match simple on update no action on delete no action,
                                  foreign key (passport) references public.international_passport (id)
                                      match simple on update no action on delete no action,
                                  foreign key (passport_id) references public.international_passport (id)
                                      match simple on update no action on delete no action,
                                  foreign key (student_card_id) references public.international_passport (id)
                                      match simple on update no action on delete no action
);

create table public.driving_licence (
                                        id integer primary key not null default nextval('driving_licence_id_seq'::regclass),
                                        category character varying(255),
                                        category_issuing_date character varying(255),
                                        date_of_birth character varying(255),
                                        date_of_issue character varying(255),
                                        expiry_date character varying(255),
                                        is_active boolean,
                                        issuing_authority integer,
                                        number bigint,
                                        place_of_birth character varying(255),
                                        record_number character varying(255)
);

create table public.e_document (
                                   id integer primary key not null default nextval('e_document_id_seq'::regclass),
                                   nationality character varying(255),
                                   date_of_birth character varying(255),
                                   gender character varying(255),
                                   number bigint
);

create table public.international_passport (
                                               id integer primary key not null default nextval('international_passport_id_seq'::regclass),
                                               authority integer,
                                               country_code character varying(255),
                                               date_of_birth character varying(255),
                                               date_of_expiry character varying(255),
                                               date_of_issue character varying(255),
                                               gender character varying(255),
                                               is_active boolean,
                                               legal_address character varying(255),
                                               nationality character varying(255),
                                               number character varying(255),
                                               place_of_birth character varying(255),
                                               type character varying(255)
);

create table public.passport (
                                 id integer primary key not null default nextval('passport_id_seq'::regclass),
                                 date_of_expiry character varying(255),
                                 authority integer,
                                 date_of_birth character varying(255),
                                 date_of_issue character varying(255),
                                 gender character varying(255),
                                 nationality character varying(255),
                                 number bigint,
                                 place_of_birth character varying(255),
                                 place_of_residence character varying(255),
                                 tax_number bigint
);

create table public.student_card (
                                     id integer primary key not null default nextval('student_card_id_seq'::regclass),
                                     date_of_expiry character varying(255),
                                     date_of_issue character varying(255),
                                     faculty character varying(255),
                                     form_of_education character varying(255),
                                     is_active boolean,
                                     number bigint,
                                     university character varying(255)
);

create table public.users (
                              id integer primary key not null default nextval('users_id_seq'::regclass),
                              name character varying (255),
                              country character varying (255),
                              email character varying (255),
                              is_updated boolean,
                              is_deleted boolean,
                              passport_id integer,
                              employee_id integer,
                              foreign key (employee_id) references public.documents (id)
                                  match simple on update no action on delete no action,
                              foreign key (passport_id) references public.passport (id)
                                  match simple on update no action on delete no action
);

