create or replace package accdays_test is
  procedure insertData(insert_id_start number,insert_id_end number);
end accdays_test;  

create or replace package body accdays_test is
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
end accdays_test ;

-- 调用存储过程
call accdays_test.insertData(3,35);

select * from users;
