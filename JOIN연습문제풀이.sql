-- 2020.05.21
-- JOIN 연습문제 풀이

--32. EQUI 조인을 사용하여 SCOTT 사원의 부서번호와 부서 이름을 출력하시오.
select ename, e.deptno, dname
from emp e, dept d
where e.ename = 'SCOTT' and e.deptno = d.deptno;

--33. INNER JOIN과 ON 연산자를 사용하여 사원 이름과 함께 그 사원이 소속된 부서이름과 지역 명을 출력하시오.
select e.ename, dname, loc
from emp e inner join dept d
on e.deptno = d.deptno
order by d.loc;

--36. 조인과 WildCARD를 사용하여 이름에 ‘A’가 포함된 모든 사원의 이름과 부서명을 출력하시오.
select ename, dname
from emp e, dept d
where e.ename like '%A%' and e.deptno = d.deptno
order by d.dname;

--37. JOIN을 이용하여 NEW YORK에 근무하는 모든 사원의 이름, 업무, 부서번호 및 부서명을 출력하시오.
select e.ename, job, e.deptno, dname, loc
from emp e, dept d
where e.deptno = d.deptno and d.loc = 'NEW YORK'
order by e.sal;

--38. SELF JOIN을 사용하여 사원의 이름 및 사원번호, 관리자 이름을 출력하시오.
select employee.ename, employee.deptno, manager.ename 관리자명
from emp employee, emp manager
where manager.mgr = employee.mgr and employee.ename = manager.ename
order by manager.ename;

--39. OUTER JOIN, SELF JOIN을 사용하여 관리자가 없는 사원을 포함하여 사원번호를 기준으로 내림차순 정렬하여 출력하시오.
select employee.ename, employee.deptno, nvl(manager.ename,'관리자없음') 관리자명
from emp employee, emp manager
where employee.mgr = manager.empno(+)
order by manager.ename;

--40. SELF JOIN을 사용하여 지정한 사원의 이름, 부서번호, 지정한 사원과 동일한 부서에서 근무하는 사원을 출력하시오. ( SCOTT )
select employee.ename, employee.deptno
from emp employee, emp scott
where employee.deptno = scott.deptno and scott.ename = 'SCOTT'
order by employee.sal;


--41. SELF JOIN을 사용하여 WARD 사원보다 늦게 입사한 사원의 이름과 입사일을 출력하시오.
select employee.ename 사원명, employee.hiredate 사원입사일, ward.hiredate ward입사일
from emp employee, emp ward
where employee.hiredate > ward.hiredate and ward.ename = 'WARD'
order by employee.hiredate;

--42. SELF JOIN 을 사용하여 관리자보다 먼저 입사한 모든 사원의 이름 및 입사일을 관리자의 이름 및 입사일과 함께 출력하시오.
select employee.ename 사원명, employee.hiredate 사원입사일, manager.ename 관리자명, manager.hiredate 관리자입사일
from emp employee, emp manager
where employee.hiredate < manager.hiredate and employee.mgr = manager.empno
order by manager.ename;