/*
2020. 05. 28
INDEX
검색을 빠르게 하기 위해 사용
DML 작업에선 성능 저하가 일어날 수 있음



*/

drop table emp01;

create table emp01
as
select * from emp;

select index_name, table_name, column_name
from user_ind_columns
where table_name in ('emp', 'emp01')
;
insert into emp01 (empno, ename) values (2222, 'PARK');

select * from emp01 where ename = 'PARK';

create index emp01_name_index on emp01 (ename);
create index emp01_empno_index on emp01 (empno);

drop index emp01_name_index;