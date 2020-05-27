--2020.05.18

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

-- 2020. 05. 19

-- 특정 데이터를 추출하기 : where 절을 이용
-- select 컬럼명 from 테이블 이름 where 조건(true/false)

-- 전체 사원중의 월 급여가 3000 이상인 사원의 이름 리스트
select ename, sal
from emp
where sal >= 3000;

-- = 같은 조건을 검색 (문자열 조회땐 작은따옴표 + 대소문자 구분)
select *
from emp
where job = 'MANAGER';

-- !=, <> 같지 않은 조건 검색
select *
from emp
where ename <> 'SCOTT';


-- AND 조건절 : 부서번호 10이고 직급이 관리자인 사람 검색
select *
from emp
where deptno = 10 AND job = 'MANAGER';

-- OR 조건절 : 10번 부서의 직원 혹은 직급이 매니저인 사람 검색
select *
from emp
where deptno = 10 OR job = 'MANAGER';

-- NOT 조건절 : 부서번호가 10이 아닌 사람들만 검색
select *
from emp
where NOT deptno = 10;

-- 범위 연산자 BETWEEN AND : column_name between a and b
select *
from emp
where sal between 2000 and 3000; -- 2000 이상 3000 이하

select *
from emp
where sal>2000 and sal <3000; -- 2000 초과 3000미만

select *
from emp
where sal between 2001 and 2999; -- 2000초과 3000미만

-- between and 연산자는 문자형이나 날짜형도 사용 가능

select *
from emp
where hiredate between '1981/01/01' and '1981/12/31';

-- or연산을 간소화하는 in 연산자 : 
-- column_name in(a,b,c) = a이거나 b이거나 c 중 어느 하나라도 만족하면 출력
select *
from emp
where comm in(300,500,1400);
-- or연산자 사용시
select *
from emp
where comm = 300 or comm = 400 or comm = 1400;

-- like 연산자/와일드카드 : column_name like pattern
-- 와일드카드 % : 문자가 없거나, 하나 이상의 문자가 어떤 값이 와도 상관없음
-- 와일드카드 _ : 하나의 문자가 어떤 값이 와도 상관없다.

-- F로 시작하는 이름 찾기

select *
from emp
where ename like 'F%';

-- 문자 A 앞뒤에 %를 기술하면 문자열 중간에 A 문자가 있으면 앞뒤에 몇개가 오든 상관없이 찾음
select *
from emp
where ename like '%A%';

-- 앞에 어떤 문자열이 오든 N으로 끝나는 데이터

select *
from emp
where ename like '%N';

-- _는 %와 마찬가지로 어떤 문자가 오든 상관없다는 의미 
-- 차이 : %는 몇개가 오든 상관 없음 / _는 단 한 문자만 상관없음

-- 두번째 글자가 A인 사원 찾기

select *
from emp
where ename like '_A%';

-- 세번째 글자가 A인 사원 찾기

select *
from emp
where ename like '__A%';

-- not like 연산자 : 입력한 값을 포함하지 않은 데이터 검색
-- 이름에 A가 들어가지 않는 사원 찾기

select *
from emp
where ename not like '%A%';

-- null을 위한 연산자 : is null / not null
-- culmn_name is (연산자) null (비교값)
-- 커미션을 받지 않은 사원 검색
select *
from emp
where comm is null;

-- 커미션을 받은 사원만 검색
select*
from emp
where comm is not null;

-- order by : 정렬
-- asc(오름차순) / desc(내림차순)

-- 급여를 오름차순으로 (작은값에서 큰값으로)
-- (아무것도 안쓴 디폴트는 자동 오름차순)

select *
from emp
-- order by sal asc; = order by sal;
order by sal;

-- 급여를 내림차순으로 (큰값부터 작은값으로)

select *
from emp
order by sal desc;

-- 문자순으로 출력 (디폴트 오름차순)

select *
from emp
order by ename;

-- 날짜순 출력 ( desc 내림차순)

select *
from emp
order by hiredate desc;

-- 정렬에 여러 조건 제시
-- 동일한 급여일 경우 알파벳 순서가 빠른 순으로 출력되도록

select *
from emp
order by sal desc, ename asc;


-- 1번
select ename, sal, sal+300 
from emp;

-- 2번
select ename, sal, sal*12+100
from emp
order by sal*12+100 desc;

-- 3번
select ename, sal
from emp
where sal >2000 order by sal desc;

--4번 
select ename, deptno
from emp
where empno = 7788;

--5번
select ename, sal
from emp
where sal < 2000 or  sal > 3000;

--6번
select ename, job, hiredate
from emp
where hiredate between '1981/02/20' and '1981/05/01';

-- 7번
select ename, deptno
from emp
where deptno = 20 or deptno =30 order by ename desc;

-- 7번 between and 사용
select ename, deptno
from emp
where deptno between 20 and 30 order by ename desc;


-- 8번
select ename, sal, deptno
from emp
where (sal > 2000 and sal < 3000) and (deptno = 20 or deptno = 30) order by ename;

-- 9번
select ename, hiredate
from emp
where hiredate like '81%';

-- 10번
select ename, job
from emp
where mgr is null;

-- 11번
select ename, sal, comm
from emp
where comm is not null order by sal, comm;

-- 12번
select ename
from emp
where ename like '__R%';

-- 13번
select ename
from emp
where ename like '%A%' and ename like '%E%';

-- 13번 - 2번째방법 (현재 데이터베이스에선 동일한 결과값이 나오지만 실제론 A가 먼저 있고 그다음 E가 포함됨 이름만 나옴)
-- E가 먼저인 사람은 나오지 않을 것으로 예상됨
select ename
from emp
where ename like '%A%E%';


-- 14번
select ename, job, sal
from emp
where (job = 'CLERK' or job = 'SALESMAN') and not sal in(1600, 950, 1300);

-- 15번
select ename, sal, comm
from emp
where comm > 499;

drop table orders;