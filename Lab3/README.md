Homework

Am adaugat clasa Designer cu atributul SoftwareTool si clasa Programmer cu atributele ExperienceLevel si Specialization. Toate atributele sunt implementate ca enums.
In clasa Network, importanta unui Node este data de numarul de vecini (adica de gradul nodului in graf). Pentru a calcula importanta Nodului am parcurs lista de noduri
din Network si am incrementat valoarea gradului daca am gasit un vecin.

Bonus

Am adaugat 2 clase pentru cei 2 algoritmi : un algoritm pentru a gasi puncte de articulatie si un algoritm pentru a gasi subgrafuri biconexe maximale. Ambii algoritmi 
se bazeaza pe algoritmul lui Tarjan. Pentru gasirea subgrafurilor biconexe maximale am gasit mai intai subgrafurile biconexe si am verificat daca gradul minim al sub-
grafului este mai mare sau egal cu 2. Am mai adaugat 2 clase pentru testare (JUnit test), in care am pus un exemplu de input pentru algoritm si solutiile pe care ar 
trebui sa le gaseasca, si apoi am verificat daca solutia data de fiecare algoritm este corecta. 

In imaginea de mai jos, nodurile 7 si 3 sunt punctele de articulatie si subgrafurile biconexe maximale vor fi cele 2 circuite (1-0-2-3 si 5-4-6-7). Cand rulam testele pentru cei 2 algoritmi, vedem ca algoritmul gaseste punctele de articulatie si cele 2 subgrafuri.


![alt text](https://github.com/IvanCristian112/JavaLab/blob/main/Lab3/graph(1).png?raw=true)


