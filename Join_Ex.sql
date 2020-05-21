-- 2020.05.21
-------------------
-- JOIN : 스키마의 결합
-------------------

--cross join
select * from emp,dept;

-- equl join과 모호성 해결을 위한 컬럼명 모호성 해결을 위한 테이블 별칭부여
select *
from orders o, book b , customer c;

-- equl join의 and 연산
select * 
from orders o, book b, customer c
where o.bookid = b.bookid and o.custid = c.custid and name = '박지성'
;


select sal, grade from emp,salgrade;
-- non equl join
select ename, sal, grade
from emp e, salgrade s
where sal between losal and hisal;

-- 위와 같은 결과
select ename, sal, grade
from emp, salgrade
where sal >= losal and sal <= hisal;

-- self join : 동일한 테이블 내에서 조인
select employee.ename || '의 관리자는 ' || manager.ename || '입니다.' as 담당관리자
from emp employee, emp manager
where employee.mgr = manager.empno
order by manager.ename;
-- self join의 경우 조인 조건을 만족하지 못한 null값을 제외함

-- outer join : (+)를 조인 조건을 만족하는 정보가 부족한 칼럼 뒤에 붙임
-- 사원번호 empno에 null인 사원은 없고, 관리자가 없는 사원을 출력해야 하므로 manager.empno 뒤에 붙여줌
select employee.ename || '의 관리자는 ' || nvl(manager.ename, '관리자 없음') as 담당관리자
from emp employee, emp manager
where employee.mgr = manager.empno(+)
order by manager.ename;

-- ansi cross/inner/outer join
select ename, dname
from emp e inner join dept d
on e.deptno = d.deptno;

-- using (공통컬럼) 사용
select ename, dname
from emp e inner join dept d
using (deptno)
order by dname;

select bookname, custid
from book b inner join orders c
using (bookid)
order by custid;

-- natural join : using을 생략하고 사용 가능
select ename, dname
from emp e natural join dept d
order by dname;

-- outer join left/right/full