INSERT INTO users (username, password, role) VALUES ('john', '$2a$12$/vzP9aVRfRLTtOXJ.FzXretj9nQq6aJ0XIw.MUYQg69vZgqVUEBve', 'ROLE_MANAGER');
INSERT INTO users (username, password, role) VALUES ('cleo', '$2a$12$P/X0gRVNCQmxvOT/EntPEONzdoIYof/DPVw4GE2kBsxQqEO75IT2e', 'ROLE_STAFF');
INSERT INTO users (username, password, role) VALUES ('dave', '$2a$12$A0L03y3aDaA7WvJBYBlDneozM0/xlvoROhypWYx4DFBp0xIAmIAGC', 'ROLE_STAFF');
INSERT INTO users (username, password, role) VALUES ('bob', '$2a$12$WxYN8G1pArhGeuoXyoQqouIWUOR7DRKtg1p1lT9W8UrTImLv7pOMO', 'ROLE_STAFF');

INSERT INTO clients(name, email, phonenumber, address, cancel) VALUES ('Paul Doe', 'pauldoe@gmail.com', '6942345521', '12 Tavros Athens', 'false');
INSERT INTO clients(name, email, phonenumber, address, cancel) VALUES ('Jacob Steve', 'jacobsteveo@gmail.com', '6949932542', '18 Ermou Athens', 'false');
INSERT INTO clients(name, email, phonenumber, address, enroll, cancel) VALUES ('Dave Stone', 'dave03stone@gmail.com', '6948642134', '23 Kypseli Athens',  'true');
INSERT INTO clients(name, email, phonenumber, address, cancel) VALUES ('Mary James', 'maryjames@gmail.com', '6940342434', '10 Zografou Athens','true');
INSERT INTO clients(name, email, phonenumber, address, cancel) VALUES ('Paul Doe', 'pauldoe@gmail.com', '6949946781', '22 Attiki Athens',  'false');

INSERT INTO contacts(contacted, client_id, contact_date, contact_reason, contact_description) VALUES(true, 1, now(), 'Renewal of contract', 'He decided to continue as our customer');
INSERT INTO contacts(contacted, client_id, contact_date, contact_reason, contact_description) VALUES(true, 2, now(), 'Membership memo', 'Every week members would be sent newsletters');
INSERT INTO contacts(contacted, client_id, contact_date, contact_reason, contact_description) VALUES(false, 3, now(), 'null', 'null');
INSERT INTO contacts(contacted, client_id, contact_date, contact_reason, contact_description) VALUES(false, 5, now(), 'Newsletter', 'There are new offers for our services');
INSERT INTO contacts(contacted, client_id, contact_date, contact_reason, contact_description) VALUES(false, 4, now(), 'null', 'null');