USE SISDB;
-- 1
SELECT AVG(num_students) AS avg_students_per_course FROM (SELECT course_id, COUNT(student_id) AS num_students FROM Enrollments
GROUP BY course_id) AS enrollment_counts;

-- 2
SELECT student_id,first_name,last_name FROM Students WHERE student_id IN (SELECT student_id FROM Payments 
WHERE amount = (SELECT MAX(amount) FROM Payments));

-- 3
SELECT course_id,course_name FROM Courses WHERE course_id IN (SELECT course_id FROM Enrollments GROUP BY course_id
HAVING COUNT(*) = (SELECT MAX(enrollment_count) FROM (SELECT course_id,COUNT(*) AS enrollment_count FROM 
Enrollments GROUP BY course_id) AS subquery));

-- 4
SELECT t.teacher_id,t.first_name,t.last_name,
    (
        SELECT SUM(p.amount) FROM Payments p
        INNER JOIN Courses c ON p.course_id = c.course_id
        WHERE c.teacher_id = t.teacher_id
    ) AS total_payments
FROM Teacher t;

-- 5
SELECT student_id,first_name,last_name FROM StudentS WHERE (SELECT COUNT(DISTINCT course_id)FROM Courses) 
= (SELECT COUNT(DISTINCT course_id)FROM Enrollments WHERE Enrollments.student_id = Students.student_id);

-- 6
SELECT t.first_name, t.last_name FROM Teacher t
WHERE t.teacher_id NOT IN (SELECT DISTINCT teacher_id FROM Courses);

-- 7
SELECT AVG(age) AS average_age
FROM (
    SELECT TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) AS age FROM Students)
    AS student_age;

-- 8
SELECT student_id,first_name,last_name FROM Students
WHERE student_id IN (SELECT student_id FROM Payments GROUP BY student_id );

-- 7
SELECT Students.student_id,Students.first_name,Students.last_name,SUM(Payments.amount) AS total_payments
FROM Students
LEFT JOIN Payments ON Students.student_id = Payments.student_id
GROUP BY Students.student_id,Students.first_name,Students.last_name;

-- 8
SELECT c.course_id, c.course_name FROM Courses c
WHERE c.course_id NOT IN (SELECT DISTINCT course_id FROM Enrollments);

-- 9
SELECT e.student_id, e.course_id, SUM(p.amount) AS total_payments
FROM Enrollments e
LEFT JOIN Payments p ON e.student_id = p.student_id
GROUP BY e.student_id, e.course_id;

-- 10
SELECT student_id FROM Payments
GROUP BY student_id
HAVING COUNT(*) > 1;

-- 11
SELECT p.student_id, SUM(p.amount) AS total_payments FROM Payments p
GROUP BY p.student_id;

-- 12
SELECT c.course_name, COUNT(e.student_id) AS enrollment_count FROM Courses c
LEFT JOIN Enrollments e ON c.course_id = e.course_id
GROUP BY c.course_name;

-- 13
SELECT p.student_id, AVG(p.amount) AS average_payment FROM Payments p
GROUP BY p.student_id;