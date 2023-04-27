Compulsory


Am creat modelul problemei cu clasele Token, Cell, Robot, Exploration, ExplorationMap, SharedMemory, Timekeeper, ParseUserInput, MultiThreadedBFS.

Homework 


Am implementat comenzile cu ajutorul clasei ParseUserInput care ruleaza din clasa Main. Am implementat comenzile "stop all", "stop n", unde n este al n-lea robot, "start all" si "start n" (asemanator cu "stop n"). Comenzile de stop si start le-am implementat cu metodele wait si notify. Pentru parcurgerea matricei, am facut ca fiecare robot sa incerce sa parcurga un rand. Daca ajunge la sfarsitul randului, cauta urmatorul rand care nu este explorat de alt robot. 
Am implementat un thread daemon in clasa timekeeper care urmareste timpul de rulare al programului (si il afiseaza la un anumit interval de timp) si opreste executia daca intrece limita de timp. 
In clasa Exploration am creat metoda displayTokens pentru a arata cati tokeni a reusit sa puna fiecare robot. Acesti tokeni sunt salvati intr-o variabila a fiecarui obiect Robot.

Bonus

Am incercat sa implementez un algoritm BFS colaborativ folosind Graph4J. Am folosit RandomGnpGraphGenerator pentru a crea un graf aleator de 1000 de noduri cu edgeProbability de 0.2. In metoda traverse am folosit un ExecutorService pentru a imparti la un numar de threaduri sarcina de a explora graful. Am impartit graful intr-un numar de subgrafuri (conform numarului de threaduri folosite) si am folosit API-ul BFSTraverser din Graph4J pentru a vizita fiecare subgraf. 

Cand am rulat metoda traverse pe graful random aleator am primit eroarea de mai jos:


Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 1000 out of bounds for length 1000
	at org.graph4j.GraphImpl.degree(GraphImpl.java:833)
	...
	
	
	at org.example.MultiThreadedBFS.traverse(MultiThreadedBFS.java:41)
	at org.example.MultiThreadedBFS.main(MultiThreadedBFS.java:74)

