SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'project';

select * from goods;

select count(*) from goods where gds_delyn='y';

select * from goods;

		select * from goods
		where gds_delyn='y'
		order by gds_num desc
		limit 0, 10;