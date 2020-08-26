--DROP TABLE IF EXISTS tasks;
 
--CREATE TABLE tasks (
--  id INT AUTO_INCREMENT  PRIMARY KEY,
--  desc VARCHAR(200) DEFAULT NULL,
--  status VARCHAR(20) DEFAULT NULL,
--  planned_date TIMESTAMP(9) DEFAULT NULL,
--  completed_date TIMESTAMP(9) DEFAULT NULL
--);
 
  
INSERT INTO TASK_DETAIL(id, desc, status, planned_date, completed_date)
    VALUES(1, 'Buy Grocery', 'Not Completed', null, null);
INSERT INTO TASK_DETAIL(id, desc, status, planned_date, completed_date)
    VALUES(2, 'Go To Gym', 'Completed', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO TASK_DETAIL(id, desc, status, planned_date, completed_date)
    VALUES(3, 'Learn New Things', 'Not Completed', CURRENT_TIMESTAMP(), null);
INSERT INTO TASK_DETAIL(id, desc, status, planned_date, completed_date)
    VALUES(4, 'Explore Cloud Technology', 'Not Completed', CURRENT_TIMESTAMP(), null);

