--서브쿼리를 이용해서 여러 테아ㅣ블에서 한번에 데이터 삽입
--테스트 테이블 : emp_hir : empno, ename, hiredate
-- 테스트 테이블 : emp_mgr : empno, ename, hiredate

create table emp_hir
as
select empno, ename, hiredate from emp;

create table emp_mgr
as
select empno, ename, mgr from emp;

select * from emp_mgr;

select * from emp_hir;

drop table emp_hir02;

-- 두개 테이블에 emp 테이블 의 데이터를 기반으로 삽입
insert all
into emp_hir values (empno, ename,hiredate)
into emp_mgr values (empno, ename,mgr)
select empno, ename, hiredate, mgr
from emp
;

create table emp01
as
select * from emp;

create table emp_sal
as
select empno, ename, sal from emp;

insert all
when hiredate > '1982/01/01' then
into emp_hir02 values(empno, ename, hiredate)
when sal > 2000 then
into emp_sal values (empno, ename, sal)
select empno, ename, hiredate, sal from emp
;

select * from emp_hir02;
select * from emp_sal;

-- 컬럼의 데이터 변경(수정)
-- update 테이블이름 set 컬럼이름1 = 값, 컬럼이름2 = 값, ... where 행(row)을 찾는 조건식

select * from emp01;

update emp01
set deptno = 30, sal = 50, comm= 4000
where ename = 'SCOTT';

update emp01
set sal = sal * 1.1
where sal >= 3000;

update emp01
set hiredate  = sysdate
where substr(hiredate, 1, 2) = '87';

update emp01
set hiredate= sysdate;

rollback;