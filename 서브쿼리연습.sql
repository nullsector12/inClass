-- 2020.05.22
----------------
-- sub query / ROWNUM /부속질의
----------------

-- 평균 급여를 구하는 쿼리문을 서브 쿼리로 사용하여
-- 평균 급여보다 더 많은 급여를 받는 사원을 검색하는 문장

select avg(sal) from emp;

-- 단일 행 서브쿼리
select * 
from emp
where sal > (select avg(sal) from emp)
;

select *
from emp
where deptno = (select deptno from emp where ename = 'KING')
;

-- 다중 행 서브쿼리 : in/any,some/all/exist
-- in : 메인 쿼리의 비교조건( = )이 서브 쿼리의 결과 중 하나라도 일치하면 참 ( = or)
-- 전체 사원 중 2000 이상의 급여를 받는 사원이 소속된 부서의 사원 이름/급여/부서번호
select ename, sal, deptno
from emp
where deptno in( select distinct deptno from emp where sal >= 2000)
;

-- all : 메인 쿼리의 비교조건이 서브 쿼리의 검색결과와 모든값이 일치하면 참( = and)
-- 전체 사원 중에서 30번 부서 사원 중 가장 많은 급여를 받는 사원보다 더 많은 급여를 받는 사원
select ename, sal
from emp
where sal > all(select sal from emp where deptno = 30)
;

-- any : 메인 쿼리의 비교 조건이 서브쿼리의 검색결과와 하나 이상이 일치하면 참
-- 전체 사원중에서 30번 부서의 사원들 급여 중 가장 작은 값보다 많은 급여를 받는 사원의 이름, 급여

select ename, sal, deptno
from emp
where sal > any(select sal from emp where deptno = 30)
order by deptno
;
-- 단일 행 서브쿼리로도 동일한 결과 출력가능
select ename, sal, deptno
from emp
where sal > (select min(sal) from emp where deptno = 30)
order by deptno
;

-- ROWNUM : 입력순서의 번호
-- 내장함수는 아니지만 자주 사용됨
-- 오라클에서 내부적으로 생성되는 가상 컬럼 : SQL 조회결과의 순번을 나타냄
-- 자료를 일부분만 확인하여 처리할 때 유용

select rownum, ename
from emp
where rownum <= 2
;

-- 부속질의 : 하나의 SQL 문 안에 다른 SQL 문이 중첩된것 ( 스칼라 / 인라인뷰 / 중첩질의)
-- 다른 테이블에서 가져온 데이터로 현재 테이블에 있는 정보를 찾거나 가공할 때 사용
-- 데이터 량이 방대할 때 JOIN보다 더 성능이 좋음
-- 주질의( 외부질의 )와 부속질의( 내부질의 ) 로 구성

-- 스칼라 부속질의 (select절/ 단일값을 반환), update / set : where절 조심!!
select ( select name from customer cs where cs.custid = od.custid ) "name", sum(saleprice) "total"
from orders od
group by od.custid
;

-- 같은 결과 ( join을 사용한 결과 )
select o.custid, name, sum(saleprice)
from orders o, customer c
where o.custid = c.custid
group by o.custid, name
order by custid
;

-- 인라인뷰 (from절/ 다중 행, 다중 열도 반환가능), 가상 테이블인 뷰 형태로 제공되어 상관부속질의로 사용 불가

select c.name, sum(o.saleprice) "total"
from (select custid, name 
        from customer 
        where custid <= 2) c, 
        orders o
where c.custid = o.custid
group by c.name
;

select rownum, ename, empno, sal
from (select ename, empno, job, deptno, sal from emp order by sal desc)
where rownum <= 3
;


-- 중첩질의 (where절/ 비교, 집합, 한정, 존재 연산자),

-- 평균 주문금액 이하의 주문에 대해서 주문번호와 금액 출력
select orderid, saleprice
from orders
where saleprice <= (select avg(saleprice)from orders)
;

-- 각 고객의 평균 주문금액보다 큰 금액의 주문 내역에 대해서 주문번호, 고객번호, 금액 출력
select round(avg(saleprice)), o.custid from orders o where o.custid = o.custid group by o.custid order by o.custid;
-- = 1번고객 13000 2번고객 7500 3번고객 10333 4번고객 16500

select orderid, custid, saleprice
from orders o
where saleprice > (select avg(saleprice) from orders od where o.custid = od.custid)
order by o.custid
;

-- 대한민국 거주하는 고객에게 판매한 도서의 총판매액 ( in / not in )
select sum(saleprice)
from orders
where custid in (select custid from customer where address like '%대한민국%')
;

-- 3번 고객이 주문한 도서의 최고 금액보다 더 비싼 도서를 구입한 주문의 주문번호와 금액 ( all / some / any )
select max(saleprice) from orders where custid = 3; -- = 13000

select orderid, saleprice
from ordersㅠ
where saleprice > all(select max(saleprice) from orders where custid = 3)
;

-- 대한민국에 거주하는 고객에게 판매한 도서의 총 판매액 ( exists )
select sum(o.saleprice) 
from customer c, orders o 
where address like '%대한민국%' and c.custid = o.custid
;

select sum(saleprice)
from orders o
where exists (select address from customer c where address like '%대한민국%' and c.custid = o.custid)
;