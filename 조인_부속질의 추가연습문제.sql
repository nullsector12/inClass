-- 2020.05.22
-- join & sub query 연습문제 풀이

-- 1 마당서점의 고객이 요구하는 다음 질문에 대해 SQL문을 작성하시오.
-- (5) 박지성이 구매한 도서의 출판사 수 
select name, custid from customer;


select count(distinct b.publisher)

from    book b, 
        (select custid from customer where name = '박지성') c, 
        orders o

where   b.bookid = o.bookid and c.custid = o.custid
;

--select distinct bookname ,b.bookid, b.price from book b;
--select bookid, saleprice from orders;

--(6) 박지성이 구매한 도서의 이름, 가격, 정가와 판매가격의 차이

select  b.bookname, 
        b.price, 
        (b.price - o.saleprice) as 가격차이
        
from    book b, 
        orders o, 
        (select custid from customer where name = '박지성') c
        
where   b.bookid = o.bookid and c.custid = o.custid
;



-- (7) 박지성이 구매 하지않은 도서의 이름

select  bookname

from    book 

where   bookname not in(select b.bookname 
                        from book b,orders o,customer c 
                        where o.custid = c.custid and b.bookid = o.bookid and c.name = '박지성')
;

-- 2 마당서점의 운영자와 경영자가 요구하는 다음 질문에 대해 SQL문을 작성하시오.
--(8) 주문하지 않은 고객의 이름 (부속질의사용)

select  name

from    customer

where   custid not in (select o.custid 
                        from customer c, orders o 
                        where c.custid = o.custid)
;


--(9) 주문 금액의 총액과 주문의 평균 금액

select sum(saleprice), avg(saleprice)
from orders
;


--(10) 고객의 이름과 고객별 구매액

select name, sum(o.saleprice)

from customer c, orders o

where c.custid = o.custid
group by name
;


--(11) 고객의 이름과 고객이 구매한 도서목록
select name, b.bookname

from    customer c, 
        book b, 
        orders o
        
where c.custid = o.custid and b.bookid = o.bookid
order by c.custid
;


--(12) 도서의 가격(Book 테이블)과 판매가격(Orders 테이블)의 차이가 가장 많은 주문
select bookname
from (select bookname, (b.price - o.saleprice) from book b, orders o)
where 





--(13) 도서의 판매액 평균보다 자신의 구매액 평균이 더 높은 고객의 이름

select  name

from    (select name, avg(saleprice) avg
            from customer c, orders o 
            where c.custid = o.custid 
            group by name)
            
where avg > (select avg(saleprice)
                from orders)
;



--3. 마당서점에서 다음의 심화된 질문에 대해 SQL 문을 작성하시오.
--(1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름




--(2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름