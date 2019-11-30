insert into Discipline (id, title) values ('1', 'Mathematik'),
                                          ('2', 'Deutsch'),
                                          ('3', 'Englisch');

insert into Question (id, question, answer, discipline_fk) values ('1', 'Was ergibt 5 + 7?', '12', '1'),
                                                                 ('2', 'Was ergibt 22 - 13?', '9', '1'),
                                                                 ('3', 'Was ergibt 7 * 7?', '49', '1'),

                                                                 ('4', 'Mehrzahl: "Gurke"', 'Gurken', '2'),
                                                                 ('5', 'Verb: "Tanz"', 'tanzen', '2'),
                                                                 ('6', 'Mehrzahl: "Banane"', 'Bananen', '2'),

                                                                 ('7', 'A cat goes?', 'Meow', '3'),
                                                                 ('8', 'Was heisst Apfel auf englisch?', 'Apple', '3'),
                                                                 ('9', 'What is the plural of table?', 'Tables', '3');