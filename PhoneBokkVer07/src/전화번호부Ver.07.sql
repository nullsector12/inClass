create table contact    (
                        pidx number(6) constraint p_idx_pk primary key,
                        cn_name varchar2(50) not null,
                        cn_phonenumber varchar2(50) 
                        default '등록정보없음' not null,
                        cn_address varchar2(50) 
                        default '등록정보없음' not null,
                        cn_email varchar2(50) not null,
                        kategorie varchar2(50) not null
                        constraint cn_kategorie_ck check 
                        ( kategorie in ('univ', 'com', 'cafe', 'family') ),
                        
                        cn_u_major varchar2(50),
                        cn_u_grade number(1)
                        constraint univ_grade_ck check (cn_u_grade between 0 and 4),
                        
                        cn_cm_cname varchar2(50),
                        cn_cm_dname varchar2(50),
                        cn_cm_job varchar2(50),
                        
                        cn_cf_cname varchar2(50),
                        cn_cf_nickname varchar2(50),
                        
                        cn_fm_relationship varchar2(50)
                        )
;                           

create sequence contact_pidx_seq
increment by 1
start with 0
minvalue 0
;

drop table contact;
drop SEQUENCE contact_pidx_seq;
select * from contact order by pidx;

