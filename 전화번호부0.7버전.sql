/* #1
==== 전화번호부 ( 테이블 이름 contact )
기본정보 (NOT NULL)
대리키 : 일련번호 -> pidx 기본키로 설정
이름, 전화번호, 주소, 이메일
주소값과 이메일은 입력이 없을 때 기본값 입력
친구의 타입 (카테고리) : univ, com, cafe 세가지 값만 저장 가능
------ 선택정보 -------
전공/학년
회사이름/부서이름/직급
모임이름/닉네임
*/

create table contact_basic  (
                            pidx number(6) constraint p_idx_pk primary key,
                            name varchar2(50) not null,
                            pnum varchar2(50) default '등록정보없음' not null,
                            address varchar2(50) default '등록정보없음' not null,
                            email varchar2(50) not null,
                            kategorie varchar2(50) not null
                            constraint cn_kategorie_ck check 
                            ( kategorie in ('univ', 'com', 'cafe', 'family') )
                            )
;                           

create table contact_univ   (
                            pidx number(6) constraint univ_idx_pk primary key,
                            major varchar2(50),
                            grade number(1)
                            constraint univ_grade_ck check (grade between 1 and 4),
                            uref number(6) not null, 
                            constraint univ_idx_FK foreign key(uref) 
                            references contact(pidx)
                            )
;                      


create table contact_company    (
                                pidx number(6) constraint cm_idx_pk primary key,
                                cname varchar2(50),
                                dname varchar2(50),
                                job varchar2(50),
                                cmref number(6) not null, 
                                constraint company_idx_FK foreign key(cmref) 
                                references contact(pidx)
                                )
;                      

create table contact_cafe   (
                            pidx number(6) constraint cf_idx_pk primary key,
                            cfname varchar2(50),
                            nickname varchar2(50),
                            cfref number(6) not null, 
                            constraint cafe_idx_FK foreign key(cfref) 
                            references contact(pidx)
                            )
;                      

create table contact_family (
                            pidx number(6) constraint fm_idx_pk primary key,
                            relationship varchar2(50),
                            fmref number(6) not null, 
                            constraint family_idx_FK foreign key(fmref) 
                            references contact(pidx)
                            )
;                      
create sequence contact_pidx_seq
increment by 1
start with 0
minvalue 0
;

drop table contact_basic;
drop table contact_univ;
drop table contact_company;
drop table contact_cafe;
drop table contact_family;

drop SEQUENCE contact_pidx_seq;
select * from contact_basic order by pidx;

--2. DEPT 테이블에 데이터를 삽입하는 SQL을 작성하시오. 입력 데이터는 임의로 작성하시오.
insert into dept values (60, 'PROGRAMER', 'SEOUL');

select * from dept;

--3. DEPT 테이블에 위에서 삽입한 데이터의 dname, loc 데이터를 변경하는 SQL을 작성하시오.
update dept 
set dname = 'GAMEDESIGNER', loc = 'INCHEON'
where deptno = 60;

--4. DEPT 테이블에 위에서 삽입한 데이터를 deptno 컬럼의 값을 기반으로 삭제하는 SQL을 작성하시오.
delete from dept where deptno = 30;

--5. 사용자가 보유한 테이블 목록을 확인하는 SQL문을 작성하시오.
select * from all_tables;

--6. EMP 테이블의 구조를 확인하는 SQL을 작성하시오.
desc emp;

--7. 사용자가 정의한 제약조건들을 확인하는 SQL문을 작성하시오.
select * from all_constraints where table_name = 'EMP';


--#2
--1. EMP 테이블의 ename 컬럼에 인덱스를 생성하는 SQL을 작성하시오. 인덱스의 이름은 emp_index
create index emp_index on emp(ename);

--2. EMP 테이블과 DEPT 테이블을 조인하는 SQL을 기반으로 view 객체를 생성하는 SQL을 작성하시오. 
--view 의 이름은 emp_view 로 하시오.

create view emp_view
as
select  e.empno,
        e.ename,
        e.job,
        e.mgr,
        e.hiredate,
        e.sal,
        e.comm,
        e.deptno,
        d.dname,
        d.loc
from emp e, dept d
where e.deptno = d.deptno
order by e.deptno
;

select * from emp_view;

--3. EMP 테이블에서 모든 사원의 부서번호를 이름이 'SCOTT'인 사원의 부서번호로 변경하는 SQL을 작성하시오.
update emp
set deptno = (select deptno from emp where ename = 'SCOTT')
;

select * from emp;