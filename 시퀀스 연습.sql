/* 2020. 05. 27

sequence : 번호 자동 생성기

create sequence 시퀀스이름
start with 시작값 입력 = default 0부터 시작
increment by 증가값 입력 = default  1
maxvalue 최대값
minvalue 최소값

*/

create SEQUENCE dept_deptno_seq01;

-- basic 테이블 seq
create SEQUENCE Pb_basic_idx_seq
start with 0
MINVALUE 0
;

-- com 테이블 seq
create SEQUENCE Pb_com_idx_seq
start with 0
MINVALUE 0
;


-- univ 테이블 seq
create SEQUENCE Pb_univ_idx_seq
start with 0
MINVALUE 0
;

drop SEQUENCE pb_basic_idx_seq;