Compulsory

Am rezolvat partea Compulsory - am implementat varianta 1 a jocului, in care un jucator castiga daca a reusit sa formeze un triunghi. 


Homework

Am implementat logica jocului astfel: am adaugat o clasa Line, care contine coordonatele celor doua puncte care definesc linia si culoarea liniei. In clasa DrawingPanel avem un Set de linii, in care memoram toate liniile care exista in joc. Fiecare jucator poate colora o linie, jucatorul 0 cu rosu si jucatorul 1 cu verde. 
Un jucator castiga daca a reusit sa formeze un triunghi de culoarea sa. O linie poate fi colorata doar daca are culoarea default, adica negru. Dupa ce o linie a fost colorata, verificam daca jucatorul respectiv a format un triunghi. Verificarea se face astfel : luam din Set-ul de linii acele linii care au culoarea jucatorului si apoi rulam un algoritm brute-force (de complexitate O(n^3) pentru a verifica daca exista un triunghi).

Am implementat functionalitatile pentru butoanele Create New Game (care sterge desenul si redeseneaza in functii de parametrii dati), Export(salveaza imaginea intr-un fisier png), Load si Save. Pentru butoanele Load si Save am procedat in felul urmator: am serializat clasa DrawingPanel, si am setat campurile BufferedImage si Graphics2D ca transient, pentru ca nu pot fi serializate. Clasa Line implementeaza si ea interfata Serializable pentru a putea serializa Set-ul de linii. 
Apoi, pentru butonul "Save" am scris un obiect DrawingPanel, folosing un ObjectOutputStream, intr-un fisier numit "gamestate.ser". Pentru butonul "Load" am citit din acelasi fisier un obiect de tip DrawingPanel si am reconstruit imaginea. (am setat frame.canvas cu aceeasi parametri ca obiectul citit).

Bonus

Am realizat un AI simplu, cu  urmatoarele metode: generateMoves, care genereaza toate mutarile posibile (in acest caz, o mutare este o linie), Evaluate, care evalueaza 
o anumita stare a jocului (daca jucatorul curent are un triunghi, returnam un numar mare si invers) si minimax (algoritmul propriu-zis) si findBestMove. Metoda findBestMove gaseste cea mai buna mutare conform algoritmului. Algoritmul functioneaza astfel : mai intai verficam daca jocul a fost castigat sau daca am ajuns la nivelul 0. Metoda se apeleaza recursiv pentru a gasi cea mai buna mutare. Conditia beta <= alpha inseamna ca o mutare optima a fost gasita deja si nu mai are rost sa evaluam mutarile urmatoare. Ca orice algoritm minimax, daca suntem in pozitia jucatorului MAX, algoritmul cauta o valoare cat mai mare, iar daca suntem in pozitia jucatorului MIN, algoritmul cauta o valoare cat mai mica. 
