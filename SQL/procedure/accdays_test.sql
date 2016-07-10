create or replace package accdays_test is
  procedure insertData(insert_id_start number,insert_id_end number);
end accdays_test;  

create or replace package body accdays_test is
   procedure insertData(insert_id_start number,insert_id_end number) is
     -- �Զ��������Ѿ������쳣
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
          -- �ж������Ƿ��Ѿ�����
         select count(1) into num_by_i from users u where u.id=i;
         if num_by_i>0 then
           raise exception_violated_unique;
         end if;
     
         select case when mod(i,2)=1 then 'F' else 'M' end into sex from dual;
         -- trunc��ȡ����  ȡ��ǰʱ�����20-30��
         select trunc(sysdate-trunc(dbms_random.value(20*365,30*365),0)) into birthday from dual;
         insert into users(id,name,sex,birthday,address)
            values(i,'��'||i,sex,birthday,'��'||i||'�ĵ�ַ');
         i:=i+1;
         -- �˳�ѭ��
         exit when i>insert_id_end;
      end loop;    
      
      -- ע�� exception���ܷ���ѭ������,�Ҳ���Ҫend�ؼ��ֽ���
      exception
       when exception_violated_unique then
         dbms_output.put_line('�Ѿ�����������'||i); 
       when exception_id_st_end then
         dbms_output.put_line('id��ʼ�����ܴ��ڽ�����'); 
          
    end;
end accdays_test ;

-- ���ô洢����
call accdays_test.insertData(3,35);

select * from users;
