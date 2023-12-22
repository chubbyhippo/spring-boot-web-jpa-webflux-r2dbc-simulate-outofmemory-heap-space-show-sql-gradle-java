INSERT INTO student (id, name)
SELECT s.id, 'Student Name ' || md5(random()::text)
FROM generate_series(1, 1000000) AS s(id);