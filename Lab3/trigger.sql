-- Using table "managers"

DROP VIEW IF EXISTS managers_view;
CREATE VIEW managers_view as
SELECT *
from managers;

DROP TABLE IF EXISTS insert_log_table;
DROP TABLE IF EXISTS after_update_log_table;
DROP TRIGGER IF EXISTS insert_trigger ON managers_view;
DROP TRIGGER IF EXISTS after_update_trigger ON managers;
DROP FUNCTION IF EXISTS insert_function;
DROP FUNCTION IF EXISTS after_update_function;

-- same_name_count - overall last_name's length of managers with same first_name (uses new value)
CREATE TABLE insert_log_table
(
    id          serial primary key,
    size        INTEGER,
    insert_date DATE default NOW()
);
-- (uses old value)
CREATE TABLE after_update_log_table
(
    id          serial primary key,
    size        INTEGER,
    update_date DATE default NOW()
);

CREATE OR REPLACE FUNCTION insert_function()
    RETURNS TRIGGER
    LANGUAGE plpgsql
AS
$$
declare
    len     INTEGER := 0;
    manager RECORD;
    cur_managers cursor
        for select *
            from managers;
begin
    open cur_managers;

    loop
        fetch cur_managers into manager;
        exit when not found;
        if manager.first_name = NEW.first_name then
            len = len + char_length(manager.last_name);
        end if;
    end loop;
    insert into insert_log_table (size) VALUES (len);

    return NEW;
end;
$$;

CREATE OR REPLACE FUNCTION after_update_function()
    RETURNS TRIGGER
    LANGUAGE plpgsql
AS
$$
declare
    len     INTEGER := 0;
    manager RECORD;
    cur_managers cursor
        for select *
            from managers;
begin
    open cur_managers;

    loop
        fetch cur_managers into manager;
        exit when not found;
        if manager.first_name = NEW.first_name then
            len = len + char_length(manager.last_name);
        end if;
    end loop;
    insert into insert_log_table (size) VALUES (len);

    return NEW;
end;
$$;


CREATE TRIGGER insert_trigger
    instead of insert
    on managers_view
    for each row
execute function insert_function();

CREATE TRIGGER after_update_trigger
    after update
    on managers
    for each row
execute function after_update_function();


SELECT * from insert_log_table;
SELECT * from after_update_log_table;
