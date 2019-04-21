 create or replace trigger t1
 before delete or update on Student
 for each row
  declare
  begin
  insert into Alumni values(:old.rollno,:old.name,:old.doa,:old.branch,:old.per,:old.status);
  end;
  /
