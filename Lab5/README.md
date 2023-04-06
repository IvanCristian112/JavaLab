Compulsory

Am rezolvat partea Compulsory.

Homework


  Am creat clase pentru toate comenzile mentionate.In clasa Main am exemplificat o utilizare pentru fiecare din comenzile implementate. Fisierle care se deschid prin
comanda ViewCommand se afla pe masina locala, dar vor fi incluse in fisierele din repository. Pentru comanda ReportCommand am folosit template engine-ul Velocity pentru a genera raportul. In raport am inclus 
titlul, ID, tagurile, si locatia fiecarui document. Pentru a crea un fisier jar executabil, am folosit pluginul Maven Assembly (am utilizat comanda *mvn clean compile
assembly:single* si apoi am rulat fisierul cu comanda *java -jar fisierNume.jar* din terminal).

Bonus


  Pentru comanda InfoCommand, am folosit ApacheTika pentru a extrage metadata despre fiecare document (am exemplificat comanda in clasa Main). Pentru partea de algoritm,am implementat un algoritm din libaria JGraphT si un algoritm greedy (in doua clase separate, JGraphTAlgorithm si GreedyColoringAlgorithm). Algoritmul din libraria JGraphT se bazeaza pe clasa BrownBacktrackColoring. Pentru a rezolva problema, am construit un graf Graph<Integer, DefaultEdge> ce corespunde fiecarui catalog. 
Pentru testare, am implementat o clasa TestAlgorithm, in care am scris doua teste : unul simplu, pentru a verifica daca algoritmii au acelasi rezultat si unul random,
in care am creat instante mari random. Pentru testul am rulat ii pe graful din poza de mai jos: 

![alt text](https://github.com/IvanCristian112/JavaLab/blob/main/Lab5/graph(2).png?raw=true)


  Pentru al doilea test, am creat instante mai mare ale problemei astfel: pentru un numar de documente dat ca input, am creat sqrt de taguri si am adaugat fiecarui docu-
ment 3 taguri alese aleator. Apoi am masurat timpul de rulare pentru cei 2 algoritmi. Pentru 5000 de obiecte Document, algoritmul Greedy are un timp de rulare mediu 
de 5 milisecunde. Aici am intalnit o problema la algoritmul JGraphT : pentru un numar mare de input, ruleaza la infinit. (pentru 100+ obiecte Document) - nu sunt sigur
daca este un bug.

