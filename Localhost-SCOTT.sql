


---2020.05.18

select *FROM tap;

-- emp : �������
-- dept : �μ�����
-- bonus : �ӽ����̺�
-- salgrade : �޿����̺�

-- ���̺��� ���� Ȯ�� : desc ���̺��̸�

desc emp;
desc dept;
desc salgrade;

select *from emp;
select *from dept;

-- ������ �˻�
select ename, sal, deptno, empno -- �÷� �̸�
from emp -- ���̺� �̸�
;

select * from dept;

select deptno, dname from dept;

-- select �� ����� ���ο� ���̺��̴�.
-- �÷�(��)�� ������� ���� +, -, *, /, mod�Լ�(������ ����)

select * from emp;

select ename, sal, comm, sal + comm
from emp;

select ename, sal, sal+500
from emp;

select ename, sal, sal*12
from emp;

select ename, sal, sal/2
from emp;


-- nvl(�÷���, �⺻��) : null�� ġȯ �Լ�
-- �⺻���� �÷��� �������� �ڷ����� ���ƾ���
-- as (������ ����) : �÷� �̸� ��� ��Ī ���� = as total
select ename, sal, comm, sal*12+comm, nvl(comm,0), sal*12+nvl(comm,0) as total
from emp;

-- �����ͺ��̽��� ���ڿ� ǥ�� -> '' ��������ǥ = '���ڿ�'
-- ���ڿ��� �ٿ��� ����ϴ� ���� -> ||
select ename || ' is a ' || job
from emp;

-- distinct : ��� �÷��� �ߺ��� �����ϰ� �ϳ����� ��� 
select distinct deptno, job
from emp;