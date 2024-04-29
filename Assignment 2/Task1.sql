DROP DATABASE IF EXISTS SISDB;
CREATE DATABASE SISDB;
USE SISDB;
drop table if exists payments;
CREATE TABLE Students (
    student_id INT PRIMARY KEY,
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    date_of_birth DATE,
    email VARCHAR(50),
    phone_number VARCHAR(30)
);

CREATE TABLE Courses (
    course_id INT PRIMARY KEY,
    course_name VARCHAR(50),
    credits INT,
    teacher_id INT
);
CREATE TABLE Enrollments (
    enrollment_id INT PRIMARY KEY,
    student_id INT,
    course_id INT,
    enrollment_date DATE,
    FOREIGN KEY (student_id) REFERENCES Students(student_id),
    FOREIGN KEY (course_id) REFERENCES Courses(course_id)
);

CREATE TABLE Teacher (
    teacher_id INT PRIMARY KEY,
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    email VARCHAR(50)
);
CREATE TABLE Payments (
    payment_id INT PRIMARY KEY,
    student_id INT,
    amount NUMERIC(10, 2),
    payment_date DATE,
    FOREIGN KEY (student_id) REFERENCES Students(student_id)
);
desc payments;

INSERT INTO Students (student_id, first_name, last_name, date_of_birth, email, phone_number) 
VALUES 
 (101, 'harika', 'narayan', '2001-06-24' , 'yash@gmail.com', 9998864566),
(102, 'bhav', 'patil', '2002-10-12' , 'bhav@gmail.com', 8888877777),
(103, 'charan', 'kumar','2001-07-16', 'charan@gmail.com', 22356565555),
(104, 'sai', 'joseph','2004-09-14' , 'sai@gmail.com', 111111111111),
(105, 'triveni', 'anji','1999-11-08', 'triveni@gmail.com', 9087656666),
(106, 'chandana', 'thondamaneti', '2002-10-12' ,'chandana@gmail.com', 1234567820),
(107, 'sudha', 'kalathuru', '1999-03-22' ,'sudha@gmail.com', 98756783210),
(108, 'balu', 'kadipakam', '2001-10-05' ,'balu@gamil.com', 52345674567),
(109, 'parthu', 'kadipaka', '2000-08-08','parthu@gmail.com', 1167547993),
(110, 'asha', 'kalaturu', '1999-09-24' , 'asha@gmail.com', 3456789021);

INSERT INTO Courses (course_id, course_name, credits, teacher_id) 
VALUES 
(11, 'Chemistry', 3, 120),
(12, 'Arts', 5 , 119),
(13, 'Mathematics', 4, 118),
(14, 'Biology', 5, 117),
(15, 'Hindi', 5, 116),
(16, 'Social', 5, 115),
(17, 'Physics', 3, 114),
(18, 'Telugu', 4, 113),
(19, 'English', 3, 112),
(20, 'Computer Science', 2, 111);


INSERT INTO Enrollments (enrollment_id, student_id, course_id, enrollment_date)
VALUES
(211, 101, 12,'2024-03-17'),
(212, 109, 11,'2024-01-20'),
(213, 108, 20,'2024-04-13'),
(214, 107, 20,'2024-01-24'),
(215, 106, 18,'2024-01-22'),
(216, 105, 19,'2024-01-21'),
(217, 104,13, '2024-02-25'),
(218, 103, 14,'2024-04-25'),
(219, 102, 15,'2024-02-18'),
(220, 101,17, '2024-04-24');


INSERT INTO Teacher (teacher_id, first_name, last_name, email)
VALUES 
(111 , 'Amit' , 'Shah' , 'amit.shah@example.com'),
(112,'Rahul' , 'Gupta' ,'rahul.gupta@example.com'),
(113,'Sneha' ,'Singh','sneha.singh@example.com'),
(114,'Vikram','Patel','vikram.patel@example.com'),
(115,'Priya','Yadav','priya.yadav@example.com'),
(116,'Ananya','Sharma','ananya.sharma@example.com'),
(117,'Rajesh','Kumar','rajesh.kumar@example.com'),
(118,'Neha','Verma','neha.verma@example.com'),
(119,'Kunal','Mehra','kunal.mehra@example.com'),
(120,'Tanvi','Joshi','tanvi.joshi@example.com');

INSERT INTO Payments (payment_id, student_id, amount, payment_date)
VALUES
(11, 101, 6000.00, '2024-05-26'),
(12, 102, 6500.00, '2024-05-26'),
(13, 103, 8550.00, '2024-06-26'),
(14, 104, 9000.00, '2024-06-26'),
(15, 105, 5050.00, '2024-07-26'),
(16, 110, 8000.00, '2024-07-26'),
(17, 107, 5500.00, '2024-08-26'),
(18, 108, 8000.00, '2024-08-26'),
(19, 109, 9550.00, '2024-09-26'),
(20, 110, 5500.00, '2024-09-26');
