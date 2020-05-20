-- 2020.05.20 SQL 그룹함수 연습

---------------------
-- 그룹함수( 집합함수 )
---------------------
-- sum, avg, count, max, min
-- sum(컬럼이름) : 그룹의 누적 합계를 반환
-- 매월 지급되는 급여의 총 합
select sum(sal) as totalsal
from emp;
-- 문자열로 변환
select to_char (sum(sal)*1000, 'L999,999,999') as totalsal
from emp;

-- 그룹함수는 칼럼값이 null인 것을 제외하고 계산함
select sum(comm) as totalcomm
from emp;

-- avg(컬럼명) : 해당 컬럼의 데이터들의 평균값을 반환
select avg(sal)
from emp;

-- max, min(컬럼명) : 해당 컬럼의 최대값과 최소값을 구함
select max(sal), min(sal)
from emp;

-- count(칼럼명) : 해당 컬럼의 로우 개수를 구함
select count(comm)
from emp;

-- group  by : 컬럼의 값을 개별적으로 확인
select deptno
from emp
group by deptno;

select deptno, avg(sal)
from emp
group by deptno;

select deptno, max(sal), min(sal)
from emp
group by deptno;

-- 부서별로
-- 사원 수와 커미션을 받는 사원들의 수를 계산하자
select deptno, count(*), count(comm)
from emp
group by deptno;

-- having : 그룹의 결과를 제한할 때 사용
select deptno, avg(sal)
from emp
group by deptno
having avg(sal) >= 2000;


-- 직급별 지표 출력
select job, count(*) as "직급별 인원",
            sum(sal) as "직급별 총급여",
            trunc(avg(sal)) as "직급별월평균급여",
            sum(nvl(comm,0)) as "부서별수령커미션총합",
            max(sal) as "직급별최고급여"
from emp
group by job
having count(*) >= 2;

select deptno--, job
from emp
group by deptno--, job
order by deptno;