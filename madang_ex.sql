--1 마당서점의 고객이 요구하는 다음 질문에 대해 SQL문을작성하시오.
--(1) 도서번호가 1 인 도서의 이름
--(2) 가격이 20,000원 이상인 도서의 이름
--(3) 박지성의 총 구매액 (박지성의 고객번호는 1번으로 놓고 작성)
--(4) 박지성이 구매한 도서의 수 (박지성의 고객번호는 1번으로 놓고 작성)

--(1)
select bookname
from book
where bookid = 1;

--(2)
select bookname
from book
where price > 19999;

select orderid, custid, saleprice
from  orders;

--(3) JOIN 사용으로 바꿈
select sum(o.saleprice) as TotalPayedPrice 
from orders o, customer c
where c.custid = o.custid and c.name = '박지성';

--(4) JOIN 사용으로 바꿈
select count(o.orderid) as TotalboughtBookcnt
from orders o, customer c
where c.custid = o.custid and c.name = '박지성';

--2 마당서점의 운영자와 경영자가 요구하는 다음 질문에 대해 SQL문을 작성하시오.
--(1) 마당서점 도서의 총 개수
--(2) 마당서점에 도서를 출고하는 출판사의 총 개수
--(3) 모든 고객의 이름, 주소
--(4) 2014년 7월 4일 ~ 7월 7일 사이에 주문받은 도서의 주문번호
--(5) 2014년 7월 4일 ~ 7월 7일 사이에 주문받은 도서를 제외한 도서의 주문번호
--(6) 성이 ‘김’씨인 고객의 이름과 주소
--(7) 성이 ‘김’씨이고 이름이 ‘아’로 끝나는 고객의 이름과 주소

--(1)
select count(bookid) as TotalNumOfBook from book;

--(2)
select count(distinct publisher) as TotalNumOfPublisher 
from book;



--(3)
select name, address
from customer;

--(4)
select orderid, orderdate
from orders
where orderdate between '2014-07-04' and '2014-07-07';

--(5)
select orderid, orderdate
from orders
where orderdate not between '2014-07-04' and '2014-07-07';

--(6)
select name, address
from customer
where name like '김%';

--(7)
select name, address
from customer
where name like '김%' and name like '%아';