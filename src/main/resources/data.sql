-- Insert rows into table 'roles'
INSERT INTO roles
( -- columns to insert data into
 description, name 
)
VALUES
( -- first row: values for the columns in the list above
 'Admin role', 'ADMIN'
),
( -- second row: values for the columns in the list above
 'User role', 'USER'
),
(
 'Operational role', 'OPERATIONAL'
);

-- Insert rows into table 'users        '
INSERT INTO users       
( -- columns to insert data into
 name, password
)
VALUES
( -- first row: values for the columns in the list above
 'user1@a.com', '$2a$04$GJ85Ihcglhbqac2zc3z3A.C3v55FMmN8.qGQ8FlNBCuyLtQ5/TyMO'
),
( -- second row: values for the columns in the list above
 'user2@a.com', '$2a$04$XWpgKkCQaVRuXjB5f1hzt.pDa2NAzntroH3bELICZy8R8Q0L0SShO'   
),
(
'user3@a.com', '$2a$04$bmmWXec6YkFIesIxv2gx7.NbxRcMJ4UoRKT9Qoqk09pKegfcr3Zla'
);

-- Insert rows into table 'user_role'
INSERT INTO user_roles
( -- columns to insert data into
 user_id, role_id
)
VALUES
( -- first row: values for the columns in the list above
 1, 1
),
( -- second row: values for the columns in the list above
 2, 2
),
(
 3, 3
);

-- Insert rows into table 'clients'
INSERT INTO clients
( -- columns to insert data into
 email, name, surname, birth_date
)
VALUES
( -- first row: values for the columns in the list above
 'user1@a.com','User','A', 970310849000
),
( -- second row: values for the columns in the list above
 'user2@a.com','User','B', 970310849000
),
( 
 'user3@a.com','User','c', 970310849000
),
( 
 'user4@a.com','User','D', 970310849000
);