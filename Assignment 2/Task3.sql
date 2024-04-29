USE SISDB;
-- 1
SELECT st.student_id,st.first_name,st.last_name, SUM(pay.amount) AS total_payments
FROM Students st JOIN Payments pay ON st.student_id = pay.student_id WHERE st.student_id = 101
GROUP BY st.student_id,st.first_name,st.last_name;

-- 2
SELECT c.course_id,c.course_name, COUNT(e.student_id) AS enrolled_students_count FROM Courses c
LEFT JOIN Enrollments e ON c.course_id = e.course_id
GROUP BY c.course_id,c.course_name ORDER BY enrolled_students_count DESC;

-- 3
SELECT st.student_id,st.first_name,st.last_name FROM Students st LEFT JOIN Enrollments en ON st.student_id = en.student_id
WHERE en.student_id IS NULL ORDER BY st.first_name,st.last_name;

-- 4
SELECT st.first_name,st.last_name,co.course_name FROM Students st JOIN Enrollments en ON st.student_id = en.student_id
JOIN Courses co ON en.course_id = co.course_id ORDER BY st.first_name,st.last_name;

-- 5
SELECT te.teacher_id,te.first_name,te.last_name,co.course_name FROM Teacher te
JOIN Courses co ON te.teacher_id = co.teacher_id ORDER BY te.first_name,te.last_name;

-- 6
SELECT Students.first_name,Students.last_name,Enrollments.enrollment_date
FROM Students JOIN Enrollments ON Students.student_id = Enrollments.student_id
JOIN Courses ON Enrollments.course_id = Courses.course_id
WHERE Courses.course_name = 'Arts' ORDER BY  Students.first_name,Students.last_name;

-- 7
SELECT Students.first_name,Students.last_name,Enrollments.enrollment_date
FROM Students JOIN Enrollments ON Students.student_id = Enrollments.student_id JOIN 
Courses ON Enrollments.course_id = Courses.course_id WHERE Courses.course_name = 'Arts'
ORDER BY Students.last_name,Students.first_name;SELECT Students.first_name,Students.last_name
FROM students LEFT JOIN Payments ON Students.student_id = Payments.student_id WHERE Payments.student_id IS NULL
ORDER BY Students.last_name,Students.first_name;

-- 8
SELECT c.* FROM Courses c
LEFT JOIN Enrollments e ON c.course_id = e.course_id
WHERE e.course_id IS NULL;

-- 9
SELECT e.student_id, COUNT(e.course_id) AS course_count FROM Enrollments e
GROUP BY e.student_id
HAVING COUNT(e.course_id) > 1;

-- 10
SELECT t.* FROM Teacher t
LEFT JOIN Courses c ON t.teacher_id = c.teacher_id
WHERE c.teacher_id IS NULL;

   