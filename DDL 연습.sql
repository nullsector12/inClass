--2020. 05. 25
---------------------
-- DDL
---------------------

--테이블 생성 : create table 테이블명 (...) <- 컬럼 정의 : (컬럼명1 데이터타입(사이즈) , 컬럼명2 타입(사이즈), ... )

-- ddl_test 라는 이름의 테이블 생성
-- 컬럼 : no 숫자타입(3), name  가변문자열(10), birth 날짜타입 기본값은 현재날짜/시간

CREATE TABLE ddl_test (no NUMBER(3), name VARCHAR2(10), birth DATE DEFAULT SYSDATE ) TABLESPACE users;

desc ddl_test;

select * from tab;

select * from ddl_test;

insert into ddl_test(no, name, birth) values (2, '김승연', '1992/06/19');

-- emp 테이블 참조
-- 사원번호, 사원이름, 급여 3개의 칼럼으로 구성된 emp01 테이블을 생성
-- ename varchar2(10), empno NUMBER(4) DEFAULT NOT NULL, sal NUMBER(7,2)

desc emp;

CREATE TABLE emp01 (
empno NUMBER(4),
ename varchar2(10) not null,
sal number(7,2)
)
;

desc emp01;
select * from emp01;

-- 테이블 복사 : 서브쿼리 이용

create table emp02
as
select * from emp;

select * from emp02;

-- 원하는 컬럼 복사 : 서브쿼리의 select 문에 원하는 컬럼명 입력

create table emp03
as
select empno, ename from emp;

select * from emp03;

-- where절을 추가하여 원하는 범위의 테이블만 복사
create table emp04
as
select * from emp where deptno = 10;

select * from emp04;

--emp 테이블의 스키마 구조만 복사하여 새로운 테이블 생성

create table emp05
as
select * from emp where 1 <0
;

select * from emp05;

-- 테이블에 컬럼 추가
-- alter table 테이블 이름 add (컬럼정의)
-- emp01 테이블에 직급(job) 컬럽 추가

desc emp01;

alter table emp01 add (job varchar2(10));

-- 기존 컬럼 변경
-- alter table modify (컬럼정의)
-- 직급 컬럼을 최대 30글자까지로 변경
alter table emp01 modify (job varchar2(30) not null);

-- 기존 컬럼 삭제
-- alter table (테이블이름) drop column (컬럼이름)
-- 직급 컬럼 삭제하기
alter table emp01 drop column job;

-- 테이블 구조 삭제
-- drop table (테이블명)
drop table emp05;

-- 기존 테이블의 모든 로우 제거
-- trucnate table (테이블명)
truncate table emp05;

-- 테이블 명 변경
-- rename (현재 테이블명) to (변경할 테이블명)
rename emp02 to test;
select * from test;

desc dept;

-- 사원 테이블(EMP02)을 사원번호, 사원명, 직급, 부서번호 4개의 칼럼으로 구성, 
-- 사원번호와 사원명에 NOT NULL 조건을 지정하도록
-- 제약 조건은 칼럼명과 자료형을 기술한 후에 연이어서 NOT NULL 기술 

create table emp02 ( empno number(4) not null, ename varchar2(10) not null, job varchar2(10), deptno number(2) )
;

insert into emp02 values (0001, '김승연', '관리자', 25);

select * from emp02;

--사원번호, 사원명, 직급, 부서번호 4개의 칼럼으로 구성된 EMP03 테이블 생성
--사원번호를 유일키 지정, create table (테이블명) (컬럼... UNIQUE, ...)
create table emp03 ( empno number(4) unique, ename varchar2(10) not null, job varchar2(10), deptno number(2) )
;

insert into emp03 values (0001, '김승연', '관리자', 25);
insert into emp03 values (0002, '김승헌', '정사원', 25);

select * from emp03;

--사원번호, 사원명, 직급, 부서번호 EMP04 테이블 생성
--사원번호에는 유일키, 사원명은 NOT NULL 제약조건 설정
-- constraint 테이블명_칼럼명_제약조건유형 

create table emp04( empno number(4) constraint emp04_empno_uk unique, ename varchar2(10) constraint emp04_ename_nn not null, job varchar2(10), deptno number(2) )
;

insert into emp04 values (0001, '김승연', '관리자', 25);
insert into emp04 values (0002, '김승헌', '정사원', 25);

select * from emp04;
desc emp04;

--사원번호, 사원명, 직급, 부서번호 4개의 칼럼으로 구성된 테이블을 생성
--기본 키 제약조건 설정 primary key

create table emp05 ( empno number(4) constraint emp05_empno_pk primary key, ename varchar2(10) constraint emp05_ename_nn not null, job varchar2(10), deptno number(2) )
;

create table emp06 (
                    empno number(4) constraint emp06_empno_pk primary key, 
                    ename varchar2(10) constraint emp06_ename_nn not null, 
                    job varchar2(10), 
                    deptno number(2) constraint demp06_deptno_FK references dept(deptno)
                    )
;
insert into emp06 values (0002, '김승헌', '정사원', 40);


--사원번호, 사원명, 직급, 부서번호, 직급, 성별 칼럼 구성
--기본 키 제약 조건, 외래키 제약 조건, CHECK 제약 조건 설정
CREATE TABLE EMP07  ( 
                    EMPNO NUMBER(4) CONSTRAINT EMP07_EMPNO_PK PRIMARY KEY , 
                    ENAME VARCHAR2(10) CONSTRAINT EMP07_ENAME_NN NOT NULL, 
                    SAL NUMBER(7, 2) CONSTRAINT EMP07_SAL_CK CHECK(SAL BETWEEN 500 AND 5000), 
                    GENDER VARCHAR2(1) CONSTRAINT EMP07_GENDER_CK CHECK (GENDER IN('M', 'F'))
                    )
;

insert into emp07 values (0001, '김승연', 5000, 'M');
insert into emp07 values (0002, '김승헌', 3500, 'M');
insert into emp07 values (0003, '최성환', 500, 'F');
insert into emp07 values (0004, '이영훈', 1500, 'F');

select * from emp07;