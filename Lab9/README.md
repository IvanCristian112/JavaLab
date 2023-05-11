Compulsory


Am folosit plugin-ul Jakarta Persistence pentru a genera persistence.XML si Persistence Unit. Am creat clasele @Entity care corespund tabelelor din baza de date. Am creat o clasa singleton PersistenceManager care contine un obiect EntityManagerFactory. Apoi am creat o clasa repository pentru fiecare clasa entity cu cele 3 metode (findByName, findByID, Create).

Homework


Am creat o clasa generica AbstractRepository din care mostenesc cele trei clase Repository. In clasa GenerateRandomData, am creat un numar de albume si artisti si le-am introdus in baza de date. De exemplu, introducerea in baza de date a 500 de artisti si 500 de albume a durat aproximativ 3 secunde. 

Bonus

Am creat urmatorul model: o interfata AbstractFactory, care este implementata de 2 clase abstrace AbstractJPARepository si AbstractJDBCRepository - pentru a folosi ambele metode de a ne conecta la baza de date (aceste clase ar trebui sa aiba rolul de ConcreteFactory). Fiecare repository va extinde una dintre cele doua API-uri. In clasa AbstractJDBC am implementat metoda findById, care functioneaza indiferent de tipul obiectului cautat.

Pentru a rezolva problema cu cel putin k albume, am folosit Choco-solver. Am folosit metoda descrisa la laborator: am creat o variabila binara pentru fiecare album si am pus doua constrangeri: selectam cel putin k albume si, daca doua albume nu pot face parte simultan din solutie, suma variabilelor binare trebuie sa fie <= 1. Am creat o metoda care verifica daca doua albume pot apartine solutiei (diferenta dintre ani este cel mult 10 si prima litera din titlu este aceeasi). Am testat cu 500 de albume in baza de date, pentru k=15 choco-solver gaseste solutia.



