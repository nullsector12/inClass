-- 1. 테이블 생성
create table MEMBER (
        ID number(6) constraint M_id_pk primary key,
        passward varchar2(20) not null,
        name varchar2(20) not null,
        Photoname varchar2(20),
        regidate date default sysdate,
        idx number(6) not null,
        constraint m_idx_fk foreign key(idx) references MEMBER(ID)
        )
        ;
        
select * from member;        
        
-- 2. 인덱스객체 생성 및 생성확인
create index m_idn_name on MEMBER(name);

select  table_name, index_name, column_name 
from    user_ind_columns 
where   table_name in ('MEMBER');

-- 3. view 생성 및 확인 
create view MEMBER_view 
as 
select  ID, name, photoname 
from    member;

select * from member_view;
    