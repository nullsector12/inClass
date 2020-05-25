-- 2020. 05. 22 
-- 부속질의 연습문제풀이
-- 2020. 05. 23
-- 문제풀이방법 추가

--43. 사원 번호가 7788인 사원과 담당 업무가 같은 사원을 표시(사원 이름과 담당업무)하시오.
-- 중첩질의 in 연산자 사용
select ename, job, empno
from emp
where job in (select job from emp where empno = 7788) --and empno !=7788 --SCOTT 제외
;

-- 인라인 뷰 부속질의 사용
select e2.ename, e2.job, e2.empno
from (select * from emp where empno = 7788) e, emp e2
where e.job = e2.job --and e2.empno != 7788 --SCOTT 제외
;

--44. 사원번호가 7499인 사원보다 급여가 많은 사원을 표시하시오. 사원이름과 담당 업무
select empno, sal from emp where empno = 7499; -- = 1600
-- 1600보다 많은 sal 받는 사원 
-- 중첩질의 비교연산자 사용
select ename, job, sal
from emp
where sal > (select sal from emp where empno = 7499)
;


--45. 최소급여를 받는 사원의 이름, 담당업무 및 급여를 표시하시오. (그룹함수 사용)
select min(sal) from emp; -- =800

select ename, job, sal
from emp  
where sal = (select min(e.sal) from emp e)
group by ename, job, sal
;


--46. 평균급여가 가장 적은 직급의 직급 이름과 직급의 평균을 구하시오. ****
select min(avg(sal)) from emp group by job;  -- = 1037.5

select job, sal
from (select job, avg(sal) sal from emp group by job order by sal)
where rownum = 1
;

-- *** rownum 없이 값 출력 ***
select job, avg(sal)
from emp
group by job
having avg(sal) = any( select min(avg(sal)) from emp group by job)
;


--47. 각 부서의 최소 급여를 받는 사원의 이름, 급여, 부서번호를 표시하시오. ***
select ename, sal, deptno
from emp
where sal in (select min(sal) from emp group by deptno)
;


-- *** group by 와 having 절 사용
select ename, sal, deptno
from emp
group by deptno, ename, sal
having sal = any (select min(sal) from emp group by deptno)
;



--48. 담당업무가 ANALYST 인 사원보다 급여가 적으면서 업무가 ANALYST가 아닌 사원들을 표시(사원번호, 이름, 담당 업무, 급여)하시오.
select sal from emp where job = 'ANALYST'; -- = 3000

select  distinct e2.empno, e2.ename, e2.job, e2.sal
from    (
        select empno, ename, job, sal 
        from emp 
        where job = 'ANALYST'
        ) e1, 
        emp e2
        
where   e1.sal > e2.sal 
    and e2.job != 'ANALYST'
order by    sal
;

-- join 제외
select empno, ename, job, sal
from emp 
where   sal 
        < all (
                select sal 
                from emp 
                where job = 'ANALYST'
                ) 
                and job != 'ANALYST'
order by sal
;

--49. 부하직원이 없는 사원의 이름을 표시하시오.

select ename
from emp
where empno not in (select mgr from emp where mgr is not null)
;


--50. 부하직원이 있는 사원의 이름을 표시하시오.

select ename
from emp
where empno in (select mgr from emp where mgr is not null)
;


--51. BLAKE와 동일한 부서에 속한 사원의 이름과 입사일을 표시하는 질의를 작성하시오. ( 단 BLAKE는 제외 )
select ename, deptno, job from emp where deptno = 30;

select  ename, hiredate
from    emp
where   deptno = (
                select deptno 
                from emp 
                where ename = 'BLAKE'
                ) 
                and ename != 'BALKE'
;

--52. 급여가 평균 급여보다 많은 사원들의 사원 번호와 이름을 표시하되 결과를 급여에 대해서 오름차순으로 정렬하시오.
select avg(sal) from emp; --평균급여 = 2073.214....

select empno, sal
from emp e
where sal > (select avg(sal) from emp)
order by sal desc
;

--53. 이름에 K가 포함된 사원과 같은 부서에서 일하는 사원의 사원 번호와 이름을 표시하시오.
select deptno from emp where ename like '%K%'; -- 부서번호 = 10, 30

select e2.empno, e2.ename

from    (
        select distinct deptno 
        from emp 
        where ename like '%K%'
        ) e1, 
        emp e2
        
where   e1.deptno = e2.deptno 
    and e2.ename not like '%K%'
;

-- join 제외
select empno, ename
from emp
where deptno in (
                select deptno
                from emp
                where ename like '%K%'
                )
                and ename not like '%K%'
;

--54. 부서위치가 DALLAS인 사원의 이름과 부서번호 및 담당업무를 표시하시오.

select  distinct e.ename, d.deptno, e.job 

from    emp e, dept d

where   d.loc = 'DALLAS' 
    and e.deptno = d.deptno
    
order by    e.job
;

select  e.ename, e.deptno, e.job
from    (
        select deptno 
        from dept 
        where loc = 'DALLAS'
        ) loc, 
        emp e
        
where   loc.deptno = e.deptno
order by    e.job
;

-- join 제외
select ename, deptno, job
from emp
where   deptno in (
                    select deptno 
                    from dept 
                    where loc = 'DALLAS'
                    )
order by job
;


--55. KING에게 보고하는 사원의 이름과 급여를 표시하시오.
select ename, empno, mgr from emp where mgr = 7839;

select ename, sal
from emp
where mgr = (select empno from emp where ename = 'KING')
;


--56. RESEARCH 부서의 사원에 대한 부서번호, 사원이름 및 담당 업무를 표시하시오.
select  e.deptno, e.ename, e.job
from    (
        select deptno 
        from dept 
        where dname = 'RESEARCH'
        ) d, 
        emp e
        
where   d.deptno = e.deptno
;

-- 중첩질의 사용
select deptno, ename, job
from emp
where deptno in (
                select deptno 
                from dept 
                where dname = 'RESEARCH'
                )
;

--57. 평균 월급보다 많은 급여를 받고 이름에 M이 포함된 사원과 같은 부서에서 근무하는 사원의 사원 번호, 이름, 급여를 표시하시오.
select deptno, ename from emp where ename like '%M%';


select empno, ename, sal, e.deptno
from emp e, (
            select distinct deptno 
            from emp 
            where ename like '%M%'
            ) e2
            
where sal > (
            select avg(sal) 
            from emp
            ) 
            and e.deptno = e2.deptno
;

-- join 제외
select empno, ename, sal
from emp
where sal > (
            select avg(sal) 
            from emp
            )
            and deptno in
            (
            select deptno 
            from emp
            where ename like '%M%'
            )
;


--58. 평균급여가 가장 적은 업무를 찾으시오. **********

select job ,(
            select min(avg(sal)) 
            from emp 
            group by job
            )
from emp
where rownum = 1
group by job
order by avg(sal)
;

select  job

from    (
        select job, avg(sal) sal 
        from emp 
        group by job 
        order by sal
        )
        
where   rownum = 1
;

-- *** rownum 없이 값 출력 ***
select job
from emp
group by job
having avg(sal) =   any (
                        select min(avg(sal)) 
                        from emp 
                        group by job
                        )
;

--59. 담당업무가 MANAGER 인 사원이 소속된 부서와 동일한 부서의 사원을 표시하시오.
select deptno, ename from emp where job = 'MANAGER';

select  distinct e2.ename, e2.deptno

from    (
        select deptno 
        from emp 
        where job = 'MANAGER'
        ) e1, 
        emp e2

where   e2.deptno = e1.deptno 
    and job != 'MANAGER'

order by    e2.deptno
;

-- join 제외
select *
from emp
where   deptno in   (
                    select deptno 
                    from emp 
                    where job = 'MANAGER'
                    ) 
                    and job != 'MANAGER'
order by deptno
;