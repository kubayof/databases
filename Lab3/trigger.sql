
DROP TABLE IF EXISTS insert_log_table;
DROP TRIGGER IF EXISTS after_update_trigger ON managers;
DROP FUNCTION IF EXISTS trigger_function;


CREATE TABLE insert_log_table
(
    id          serial primary key,
    size        INTEGER,
    insert_date DATE default NOW()
);

create or replace function trigger_function()
              returns trigger
              language plpgsql
              as $$
              declare
              len integer := 0;
manager record;
begin
    for manager in select * from managers
    loop
            if manager.first_name = NEW.first_name then
                len = len + char_length(manager.last_name);
end if;
end loop;
insert into insert_log_table (size) VALUES (len);
return NEW;
end;
$$;

CREATE TRIGGER after_update_trigger
    after update
    on managers
    for each row
    execute function trigger_function();