--2020. 05. 26
-- 전화번호부 ( contact )

-- 기본 : 이름, 전화번호, 주소, 이메일

-- 대학 : 전공, 학년

-- 회사 : 부서명

-- 카페 : 카페이름

-- 가족 : 가족관계

-- 대리키 : 일련번호 -> p_idx

create table phoneInfo_basic  (
                            idx number(6) constraint p_idx_pk primary key, 
                            fr_name varchar2(20) not null, 
                            fr_phonenumber varchar2(20) not null, 
                            fr_email varchar2(20), 
                            fr_address varchar2(20),
                            fr_regdate date default sysdate
                            )
;

create table phoneInfo_univ   (
                            idx number(6) constraint univ_idx_PK primary key,
                            fr_u_major varchar2(20) default 'N' not null,
                            fr_u_year number(1) default 1 not null 
                            constraint univ_year_CK check (fr_u_year between 1 and 4),
                            fr_ref number(6) not null, 
                            constraint univ_idx_FK foreign key(fr_ref) 
                            references phoneInfo_basic(idx)
                            )
;

create table phoneInfo_com   (
                            idx number(6) constraint com_idx_PK primary key,
                            fr_c_company varchar2(20) default 'N' not null,
                            fr_ref number(6) not null,
                            constraint com_idx_FK foreign key(fr_ref) 
                            references phoneInfo_basic(idx)
                            )
;
/*
create table contact_cafe   (
                            idx number(6) constraint cafe_idx_pk primary key,
                            cafename varchar2(50) default 'n' not null,
                            nickname varchar2(50) default 'n' not null, 
                            constraint cafe_idx_FK foreign key(idx) 
                            references contact_basic(idx)
                            )
;


create table contact_family (
                            idx number(6) constraint family_idx_pk primary key,
                            relationship varchar2(20) default 'n' not null, 
                            constraint family_idx_FK foreign key(idx) 
                            references contact_basic(idx)
                            )
;
*/

-- 테스트
-- 기본정보
insert into PhoneInfo_basic values 
(pb_basic_idx_seq.nextval, '대학친구1', '01065953887', 'rlatmd017@naver.com', '인천', default);
insert into PhoneInfo_univ values (pb_univ_idx_seq.nextval, '사회학과', 2, pb_univ_idx_seq.currval);



insert into PhoneInfo_basic values 
(pb_basic_idx_seq.nextval, '회사동료1', '5435482185', '', '', '150306');
insert into PhoneInfo_com values (pb_com_idx_seq.nextval, '비트캠프', pb_com_idx_seq.currval);


insert into PhoneInfo_basic values 
(pb_basic_idx_seq.nextval, '대학친구2', '01000000002', '@naver.com', '서울', '190909');
insert into PhoneInfo_univ values (pb_univ_idx_seq.nextval, '행정학과', 4, pb_univ_idx_seq.currval);


insert into PhoneInfo_basic values
(pb_basic_idx_seq.nextval, '직장동료2', '01000000003', '@google.com','경기', '170529');
insert into PhoneInfo_com values (pb_com_idx_seq.nextval, 'AIA', pb_com_idx_seq.currval);

insert into PhoneInfo_basic values
(pb_basic_idx_seq.nextval, '대학친구3', '01000000004', '@yahoo.com', '부산', '201205');
insert into PhoneInfo_univ values (pb_univ_idx_seq.nextval, '호텔조리학과', 1, pb_univ_idx_seq.currval);



select * from phoneinfo_basic;

drop SEQUENCE pb_basic_idx_seq;



desc PhoneInfo_basic;


-- 대학친구 정보 출력
select * 
from PhoneInfo_basic b, PhoneInfo_univ u 
where b.idx = u.fr_ref;

-- 대학친구 정보 출력하는 view 정의 ( 2020. 05. 27 )
create view univ_Info_view 
as 
select  b.fr_name, 
        b.fr_phonenumber, 
        b.fr_address, 
        b.fr_email, 
        b.fr_regdate, 
        u.fr_u_major, 
        u.fr_u_year
from PhoneInfo_basic b, PhoneInfo_univ u 
where b.idx = u.fr_ref;

select * from univ_Info_view;

-- 직장동료 정보 출력
select * 
from PhoneInfo_basic b, PhoneInfo_com c 
where b.idx = c.fr_ref;

-- 직장동료 정보 출력하는 view 정의 ( 2020. 05. 27 )
create view com_Info_view 
as 
select  b.fr_name, 
        b.fr_phonenumber, 
        b.fr_address, 
        b.fr_email, 
        b.fr_regdate,
        c.fr_c_company 
from PhoneInfo_basic b, PhoneInfo_com c 
where b.idx = c.fr_ref;

select * from com_Info_view;


-- 다중테이블에서 정보 전체출력 = inner join 은 x : 서로 일치하는 결과만 출력, left outer join으로 왼쪽 테이블에서 교집합을 찾음 
select * 
from    PhoneInfo_basic b left outer join 
        phoneinfo_univ u on b.idx = u.fr_ref left outer join 
        phoneinfo_com c on b.idx = c.fr_ref
order by b.idx
;

-- 모든 정보 출력하는 view 정의 ( 2020. 05. 27 )
create view All_Info_view 
as
select  b.fr_name, 
        b.fr_phonenumber, 
        b.fr_address, 
        b.fr_email, 
        b.fr_regdate, 
        u.fr_u_major, 
        u.fr_u_year, 
        c.fr_c_company
from    PhoneInfo_basic b, 
        phoneinfo_univ u, 
        phoneinfo_com c
where b.idx = u.fr_ref(+) and b.idx = c.fr_ref(+)
;

select * from all_Info_view;

drop view all_Info_view;

-- outer join 추가
select * 
from    PhoneInfo_basic b, 
        phoneinfo_univ u, 
        phoneinfo_com c
where   b.idx = u.fr_ref(+) and b.idx = c.fr_ref(+)
order by b.idx
;

-- 2020. 05. 27
-- 테이블 정보 수정
-- idx번호가 1인 대학 친구의 전공을 경제학과로 변경
update PhoneInfo_univ
set fr_u_major = '경제학과'
where idx = 1;

--17년도에 등록한 직장동료의 직장 네이버로 변경
update PhoneInfo_com
set fr_c_company = '네이버'
where idx in    (
                select idx 
                from PhoneInfo_basic 
                where fr_regdate 
                between '2017/01/01' 
                and '2017/12/31'
                )
;


-- 테이블 정보 삭제
-- 경기지역에 사는 직장동료 정보 삭제
-- 상위의 정보를 삭제하려면 하위부터 삭제해야함
delete from PhoneInfo_com 
where idx in    (
                select idx 
                from PhoneInfo_basic 
                where fr_address = '경기');

delete from PhoneInfo_basic
where fr_address = '경기';

/*
on delete 설정 옵션 
    no action : 모두 삭제 불가
    cascade : 참조 하고있는 자식 테이블 포함한 모든 행 삭제
    set null : 참조 하고있는 자식 테이블의 모든 행 외래키 컬럼 값 null로 변경
    set default : 참조 하고있는 자식 테이블의 모든 행 외래키 컬럼 값 기본값으로 변경
-- 상위테이블에서 삭제하면 하위테이블에서 한번에 삭제하도록 하기위한
-- alter table을 이용한 on delete cascade 처리
-- 또는 create table 시 on delete cascade 문 추가
*/
-- 방법(1) 하위 create table에 on delete cascade 문 삽입시
create table phoneInfo_com   (
                            idx number(6) constraint com_idx_PK primary key,
                            fr_c_company varchar2(20) default 'N' not null,
                            fr_ref number(6) not null,
                            constraint com_idx_FK foreign key(fr_ref) 
                            references phoneInfo_basic(idx) on delete cascade
                            -- on delete cascade문 추가
                            )
;
create table phoneInfo_univ   (
                            idx number(6) constraint univ_idx_PK primary key,
                            fr_u_major varchar2(20) default 'N' not null,
                            fr_u_year number(1) default 1 not null 
                            constraint univ_year_CK check (fr_u_year between 1 and 4),
                            fr_ref number(6) not null, 
                            constraint univ_idx_FK foreign key(fr_ref) 
                            references phoneInfo_basic(idx) on delete cascade
                            -- on delete cascade문 추가
                            )
;

-- 직장동료 정보 제거
delete from PhoneInfo_basic 
where idx in    (
                select idx 
                from PhoneInfo_com 
                where Fr_c_company 
                is not null
                )
;

-- 학교친구 정보 제거
delete from PhoneInfo_basic 
where idx in    (
                select idx 
                from PhoneInfo_univ 
                where Fr_u_major 
                is not null
                )
;

-- 방법(2) alter table을 이용한 on delete cascade문 추가 후 처리
-- 먼저 미리 설정되어있는 foreign key를 해제하고,
alter table PhoneInfo_com drop constraint com_idx_fk;
alter table PhoneInfo_univ drop constraint univ_idx_fk;

-- cascade 문을 추가한 on delete로 다시 roreign key를 설정해준다.
alter table PhoneInfo_com add   constraint com_idx_fk 
                                foreign key (fr_ref) 
                                references PhoneInfo_basic (idx) 
                                on delete cascade; 
                                
alter table PhoneInfo_univ add  constraint univ_idx_fk 
                                foreign key (fr_ref) 
                                references PhoneInfo_basic (idx) 
                                on delete cascade; 

-- 직장동료 정보 제거확인
delete from PhoneInfo_basic 
where idx in    (
                select idx 
                from PhoneInfo_com 
                where Fr_c_company 
                is not null
                )
;

-- 학교친구 정보 제거확인
delete from PhoneInfo_basic 
where idx in    (
                select idx 
                from PhoneInfo_univ 
                where Fr_u_major 
                is not null
                )
;

drop table PhoneInfo_basic;

