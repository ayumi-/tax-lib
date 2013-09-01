# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table tax_rate (
  id                        bigint not null,
  type                      varchar(255),
  started_date              timestamp,
  ended_date                timestamp,
  rate                      integer,
  unit                      varchar(255),
  constraint pk_tax_rate primary key (id))
;

create sequence tax_rate_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists tax_rate;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists tax_rate_seq;

