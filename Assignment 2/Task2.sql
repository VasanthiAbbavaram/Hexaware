-- 1
USE SISDB;
INSERT INTO Students (student_id,first_name, last_name, date_of_birth, email, phone_number)
VALUES (31,'John', 'Doe', '1995-08-15', 'john.doe@example.com', '1234567890');

-- 2. Write an SQL query to enroll a student in a course. Choose an existing student and course and insert a record into the "Enrollments" table with the enrollment date.

INSERT INTO Enrollments (student_id, course_id, enrollment_date)
VALUES (101, 12, CURDATE());

-- 3. Update the email address of a specific teacher in the "Teacher" table. Choose any teacher and modify their email address.
UPDATE Teacher SET email = 'vikram@gmail.com'WHERE teacher_id = 114;

-- 4
DELETE FROM enrollments WHERE student_id=101 AND course_id=12;

-- 5
SELECT course_id FROM Courses WHERE course_name = 'Arts';UPDATE Courses SET teacher_id = 114 WHERE course_id ='Arts';

-- 6
DELETE FROM Enrollments
WHERE student_id IN (SELECT student_id FROM Students WHERE first_name = 'sudha' AND last_name = 'kalathuru')
AND enrollment_id =7;

-- 7
UPDATE Payments
SET amount = 8000
WHERE payment_id = 17;
