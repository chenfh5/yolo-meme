
mysqldump -pmysql406 samp_db > samp_db.sql

mysqladmin -pmysql406 create sample

mysql -pmysql406 sample < samp_db.sql

mysqladmin -pmysql406 -f drop samp_db

create table students_2(
		id int(4) unsigned not null primary key auto_increment,
		name char(20) not null,
		sex char(4) not null,
		age int(4) unsigned not null,
		tel char(13) null 
	);

mysql -D samp_db -u root -p < /home/Desktop/createtable.sql

插入一条记录
insert into students values(NULL, "王刚", "男", 20, "13811371377");

查询年龄在21岁以上的所有人信息: 
select * from students where age > 21;

查询名字中带有 "王" 字的所有人信息: 
select * from students where name like "%王%";

查询id小于5且年龄大于20的所有人信息: 
select * from students where id<5 and age>20;

将所有人的年龄增加1: 
update students set age=age+1;

将手机号为 13288097888 的姓名改为 "张伟鹏", 年龄改为 19: 
update students set name="张伟鹏", age=19 where tel="13288097888";

删除所有年龄小于21岁的数据: 
delete from students where age<20;

删除表中的所有数据: 
delete from students;

在表的最后追加列 address: 
alter table students add address char(60);

在名为 age 的列后插入列 birthday: 
alter table students add birthday date after age;



-- 记得分号
mysql -uroot -pmysql406;
show databases;
use samp_db;
show tables;
describe students;
select * from students;
quit;


ref:
http://www.cnblogs.com/mr-wid/archive/2013/05/09/3068229.html