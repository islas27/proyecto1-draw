INSERT INTO users (id, name, password, email, is_admin) VALUES 
(6, "Jesus Garcia Pardo", "12346", "jpardo@hwrace.com", true),
(7, "Jonathan Islas", "Clave superSecreta.,", "jislas@hwrace.com", true),
(8, "Luis Ramirez", "spoakefpqaOJDASEQ23", "luramirez@uach.mx", false),
(9, "Raul Martinez", "Soy super listo 12345AA!", "raulmartinez@dependencia.gob", false),
(10, "Maria Isabel Perez", "contraseña", "mip1974@tuempresa.com", false);
        
INSERT INTO products (id, name, description, category, number_of_stock, price) VALUES
(1, "Intel i7", "Cuarta generacion", "procesadores", 50, 1250.99),
(2, "Intel i5", "Cuarta generacion", "procesadores", 45, 1000.99),
(3, "Intel i3", "Cuarta generacion", "procesadores", 70, 750.99),
(4, "Intel Xenon", "Cuarta generacion", "procesadores", 20, 4250.99),
(5, "4GB DDR3", "Para laptop", "Ram", 50, 550.99),
(6, "1GB DDR2", "Para maquinas obsoletas", "ram", 80, 3250.99),
(7, "8GB DDR3", "Ideal para maquias de gaming", "Ram", 50, 1090.99),
(8, "16GB DDR3", "Trabajo rudo en servidores", "Ram", 41, 1250.99),
(9, "4GB DDR3", "Para Mac", "Ram", 67, 12250.99),
(10, "512MB DDR", "Para reliquias de museo", "Ram", 10, 10250.99),
(11, "2TB ", "Disco para Servidores", "Disco duro", 250, 3250.99),
(12, "1TB ", "Disco para pc de escritorio", "Disco duro", 150, 2765.99),
(13, "500GB", "Disco para laoptop", "Disco duros", 450, 950.99),
(14, "300GB", "fisco de estado solido", "Disco duro", 350, 750.99),
(15, "150GB", "Disco para maquinas viejas", "Disco duro", 10, 450.99),
(16, "Jaguar XT", "Luz roja y puerto USB 3.0 para el ultragamer dedicado", "Gabinetes", 450, 1050.99),
(17, "Blue purple night", "Para los gamers que les gustan mas de un color", "Gabinetes", 350, 550.99),
(18, "Silever brigh", "Para los gabinetes formales del profesionista", "Gabinetes", 350, 250.99),
(19, "Blacknight", "Para las oficinas modernas de empresas modernas", "Gabinetes", 550, 150.99),
(20, "beige retro", "para el viejo vegestorio que conservas", "Gabinetes", 10, 50.99);

INSERT INTO orders (id, customer_id, date_of_delivery, is_approved) VALUES
(1, 9,  '2015-9-30', true),
(2, 10, '2015-10-27', false);

INSERT INTO details(id, quantity, order_id, product_id) VALUES
(1, 6, 1, 1),
(2, 4, 1, 4),
(3, 12, 1, 7),
(4, 5, 1, 11),
(5, 10, 1, 16),
(6, 2, 2, 10),
(7, 2, 2, 15),
(8, 2, 2, 20);