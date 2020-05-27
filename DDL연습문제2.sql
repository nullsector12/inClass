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
(1, '대학친구1', '01065953887', 'rlatmd017@naver.com', '인천', default);
insert into PhoneInfo_basic values 
(2, '회사동료1', '5435482185', '', '', '150306');
insert into PhoneInfo_basic values 
(3, '대학친구2', '01000000002', '@naver.com', '서울', '190909');
insert into PhoneInfo_basic values
(4, '직장동료2', '01000000003', '@google.com','경기', '170529');
insert into PhoneInfo_basic values 
(5, '대학친구3', '01000000004', '@yahoo.com', '부산', '201205');


-- 학교친구 입력
insert into PhoneInfo_univ values (1, '사회학과', 2, 1);
insert into PhoneInfo_univ values (3, '행정학과', 4, 3);
insert into PhoneInfo_univ values (5, '호텔조리학과', 1, 5);

-- 회사동료입력
insert into PhoneInfo_com values (2, '비트캠프', 2);
insert into PhoneInfo_com values (4, 'AIA', 4);


desc PhoneInfo_basic;

select * 
from PhoneInfo_basic b, PhoneInfo_univ u 
where b.idx = u.fr_ref;

select * 
from PhoneInfo_basic b, PhoneInfo_com c 
where b.idx = c.fr_ref;

-- 다중테이블에서 정보 전체출력 = inner join 은 x : 서로 일치하는 결과만 출력, left outer join으로 왼쪽 테이블에서 교집합을 찾음 
select * 
from    PhoneInfo_basic b left outer join 
        phoneinfo_univ u on b.idx = u.fr_ref left outer join 
        phoneinfo_com c on b.idx = c.fr_ref
order by b.idx
;

-- outer join 추가
select * 
from    PhoneInfo_basic b, 
        phoneinfo_univ u, 
        phoneinfo_com c
where   b.idx = u.fr_ref(+) and b.idx = c.fr_ref(+)
order by b.idx
;


drop table PhoneInfo_basic;
