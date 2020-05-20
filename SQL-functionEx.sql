-- 2020.05.20 SQL 주요함수연습
-- desc dual = dummy 라는 한개의 컬럼과 x라는 아무 의미가 없는 단 하나의 로우로 구성
-- dual 테이블 = SQL 함수를 다룰때 일시적인 연산을 위해 사용되는 임시 테스트 테이블

-- ABS 함수 : 절대값 구하기
select -10, abs(-10)
from dual;

-- FLOOR 함수 : 소수점 아래 버리기
select 34.5678, floor(34.5678)
from dual;

-- ROUND 함수 : 특정 자릿수에서 반올림하기 round(대상, 자릿수)
select 34.5678, round(34.5678,3) -- 34.5678을 소수점 3자리로 반올림
from dual;
-- 자릿수에 음수가 들어올 경우 1의 자리를 반올림
select 35.5678, round(35.5678, -1)
from dual;

-- TRUNC 함수 : 특정 자릿수에서 잘라내기
select trunc(34.5678,2), trunc(34.5678, -1), trunc(34.5678)
from dual;

-- MOD 함수 : 나머지 구하기
select mod(27, 2), mod(27, 5), mod(27, 7)
from dual;
-- 사원번호가 홀수인 사원 찾기
select empno, ename
from emp
where mod (empno, 2) = 1;


-- TO_CHAR : 날짜형 혹은 숫자형을 문자형으로 변환
select sysdate, to_char(sysdate, 'yyyy.mm.dd')
from dual;
-- 입사일 형 변환
select ename,hiredate, to_char(hiredate, 'yyyy.mm.dd') as hiredate
from emp;

-- 시스템 현재 시간 출력 
select sysdate, to_char(sysdate, 'hh24:mi:ss')
from dual;
-- 시스템 현재 날짜 시스템 현재시각
select TO_CHAR(sysdate, 'yyyy.mm.dd hh24:mi')
from dual;

select to_char(12500, '999,000')
from dual;

select to_char(3.14, '999,990,090.009')
from dual;
-- NVL : null을 다른 값으로 변환
select ename, sal, to_char ( sal*1000*12+nvl(comm,0), 'l999,999,999') as yearincome
from emp
order by yearincome desc;
-- TO_DATE : 문자형을 날짜형으로 변환

select to_date('19810220', 'yyyymmdd')
from dual;

select ename, hiredate
from emp
where hiredate = to_date('1981/02/20', 'yyyy/mm/dd');

select sysdate, to_date('19920619', 'yyyymmdd'), trunc(sysdate - to_date('19920619', 'yyyymmdd'))
from dual;

-- TO_NUMBER : 문자형을 숫자형으로 변환

-- NVL : null을 다른 값으로 변환

-- DECODE : swich case문과 비슷
-- 조건이 일치되는 경우에 대해서만 적용됨
-- decode( 표현식, 조건1, 결과1, 조건2, 결과2, 조건n, 결과n, 기본결과n)

select ename, deptno, decode(deptno, 10, 'ACCOUNTING', 20, 'RESEARCH', 30, 'SALES', 40, 'OPERATIONS') as dname
from emp;

-- 직급에 따라 급여인상
select ename, sal, job ,decode(job, 'ANALYST', sal+sal*0.05, 'SALESMAN', sal+sal*0.1, 'MANAGER', sal+sal*0.15, 'CLERK', sal+sal*0.2, 'PRESIDENT', sal) as incsal
from emp;

-- CASE : 여러 경우에 대해 하나를 선택
-- DECODE와 차이점 : 다양한 비교연산자를 이용하여 조건 제시 가능, 범위 지정 가능
-- if else와 비슷한 구조
-- case 표현식 when 조건1 then 결과1 when 조건2 then 결과2 when 조건3 then 결과3 else 결과n end

-- 직급에 따른 급여인상 in case
select ename, sal, job, case when job = 'ANALYST' then sal+sal*0.05 when job = 'SALESMAN' then sal+sal*0.1 when job = 'MANAGER' then sal+sal*0.15 when job = 'CLERK' then sal+sal*0.2 else sal end as incSal
from emp;
