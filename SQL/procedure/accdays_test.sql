create or replace package accdays_test is
  -- 插入数据存储过程     
  procedure insertData(insert_id_start number,insert_id_end number);
  
  type cur_user_page is ref cursor;
  -- 分页查询存储过程
  procedure query_userinfo_page(
    name varchar2,
    sex char,
    birthday_start date,
    birthday_end date,
    address varchar2,
    page_size number,
    page_num number,
    page_recods out accdays_test.cur_user_page,
    total_num out number
    );
end accdays_test;  

create or replace package body accdays_test is
   -- 插入数据存储过程  
   procedure insertData(insert_id_start number,insert_id_end number) is
     -- 自定义主键已经存在异常
     exception_id_st_end exception;
     exception_violated_unique exception;
     num_by_i number;
     i number:=insert_id_start;
     sex char;
     birthday date;
    begin
    
       if insert_id_start>insert_id_end then
         raise exception_id_st_end;
       end if;  
    
      loop
          -- 判断主键是否已经存在
         select count(1) into num_by_i from users u where u.id=i;
         if num_by_i>0 then
           raise exception_violated_unique;
         end if;
     
         select case when mod(i,2)=1 then 'F' else 'M' end into sex from dual;
         -- trunc截取日期  取当前时间回退20-30年
         select trunc(sysdate-trunc(dbms_random.value(20*365,30*365),0)) into birthday from dual;
         insert into users(id,name,sex,birthday,address)
            values(i,'张'||i,sex,birthday,'张'||i||'的地址');
         i:=i+1;
         -- 退出循环
         exit when i>insert_id_end;
      end loop;    
      
      -- 注意 exception不能放在循环当中,且不需要end关键字结束
      exception
       when exception_violated_unique then
         dbms_output.put_line('已经存在主键：'||i); 
       when exception_id_st_end then
         dbms_output.put_line('id开始数不能大于结束数'); 
          
    end;
    -- 分页查询存储过程
    procedure query_userinfo_page(
    name varchar2,
    sex char,
    birthday_start date,
    birthday_end date,
    address varchar2,
    page_size number,
    page_num number,
    page_recods out accdays_test.cur_user_page,
    total_num out number
    ) is
     v_sql varchar2(2000);
     v_sql_count_prefix varchar2(2000):='select count(1) from ( ';
     v_sql_count_suffix varchar2(2000):=' ) t_count';
     
     v_sql_recods_prefix varchar2(2000):='select * from (select rownum rn, t_page_recods.* from ( ';
     -- rownum 从1开始的
     v_sql_recods_suffix varchar2(2000):=') t_page_recods where rownum < '||page_size*page_num||') t2_page_recods  where t2_page_recods.rn >= '||(page_size*(page_num-1)+1);
     
    begin
      v_sql:='select * from users u where 1=1 ';
      if name is not null then
        v_sql:=v_sql||' and u.name like '''||name||'%''';
      end if;
      if sex is not null then
        v_sql:=v_sql||' and u.sex='''||sex||'''';
      end if;
      
      if birthday_start is not null then
        v_sql:=v_sql||' and u.birthday >= '||birthday_start;
      end if;
      
      if birthday_end is not null then
        v_sql:=v_sql||' and u.birthday <= '||birthday_end;
      end if;
      
      if address is not null then
        v_sql:=v_sql||' and u.address like '''||address||'%''';
      end if; 
      
      v_sql:=v_sql||' order by u.id';
      
      -- 得到记录总数SQL
      v_sql_count_prefix:=v_sql_count_prefix||v_sql||v_sql_count_suffix;
      dbms_output.put_line(v_sql_count_prefix); 
      -- 查询记录总数
      execute immediate v_sql_count_prefix into total_num ;
        
       v_sql_recods_prefix:=v_sql_recods_prefix||v_sql||v_sql_recods_suffix;
        dbms_output.put_line(v_sql_recods_prefix); 
       open page_recods for v_sql_recods_prefix;
      
      
    end;
    
end accdays_test ;

