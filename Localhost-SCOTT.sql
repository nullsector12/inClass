


---2020.05.18

select *FROM tap;

-- emp : 사원정보
-- dept : 부서정보
-- bonus : 임시테이블
-- salgrade : 급여테이블

-- 테이블의 구조 확인 : desc 테이블이름

desc emp;
desc dept;
desc salgrade;

select *from emp;
select *from dept;

-- 데이터 검색
select ename, sal, deptno, empno -- 컬럼 이름
from emp -- 테이블 이름
;

select * from dept;

select deptno, dname from dept;

-- select 의 결과는 새로운 테이블이다.
-- 컬럼(열)의 산술연산 가능 +, -, *, /, mod함수(나머지 연산)

select * from emp;

select ename, sal, comm, sal + comm
from emp;

select ename, sal, sal+500
from emp;

select ename, sal, sal*12
from emp;

select ename, sal, sal/2
from emp;


-- nvl(컬럼명, 기본값) : null값 치환 함수
-- 기본값은 컬럼의 도메인의 자료형과 같아야함
-- as (설정할 별명) : 컬럼 이름 대신 별칭 설정 = as total
select ename, sal, comm, sal*12+comm, nvl(comm,0), sal*12+nvl(comm,0) as total
from emp;

-- 데이터베이스의 문자열 표현 -> '' 작은따옴표 = '문자열'
-- 문자열을 붙여서 출력하는 연산 -> ||
select ename || ' is a ' || job
from emp;

-- distinct : 출력 컬럼의 중복을 제거하고 하나씩만 출력 
select distinct deptno, job
from emp;