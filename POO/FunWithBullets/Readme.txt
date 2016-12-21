Programare orientata obiect

Tema2 : Fun with bullets

Pachetul default:

Clasa FileParser
	-Permite preluarea datelor necesare programului dintr-un fisier. Calea fisierului este spcificata prin constructor.
	Contine urmatorele metode:
		-open() - deschide fisierul, initializeaza buffer
		-close() - inchide fisierul, inchide buffer
		-getNextWord()	- preia un cuvant din fisier: se creeaza o coada de cuvinte (String) provenite din linia citita cu metoda parseNextLine
		-getNextInt() - preia un Integer din fisier:  se creeaza o coada de cuvinte (String) provenite din linia citita cu metoda parseNextLine
													  cuvantul preluat este convertit la Integer		
		-private parseNextLine() - citeste linie din fisiser cu ajutorul bufferului
		
Clasa Main
	-Permite lansarea in executie a programului daca primeste ca parametru in linia de comanda un nume de fisier
	-Fisierul primit ca parametru trebuie sa contina urmatoarele date:
	 		-pe prima linie dimensiunile ecranului: 2 numere ex si ey
			-pe a doua linie se va afla un numar N ce va reprezenta numarul de proiectile ce vor fi lansate spre tinta
			-urmeaza N linii unde se gasesc pe fiecare linie:
				-tipul_de_proiectil ref hh:mm:ss dist posx posy
	-Exista un numar de variabile ce retine fiecare tip de data primita ca input de la fisier,
		un obiect 'Screen' ce permite realizarea desenului pe ecran, si un obiect 'FileParser' ce permite citirea din fisier
	-Contine un ciclu 'for' ce permite crearea un obiect 'Projectile' si aruncarea lui spre tinta de N ori.
	-Contine o secventa de afisare a ecranului. Aceasta consta in parcurgerea si afisarea unei matrici de elemente de tip 'Char'.
	 	Aceasta operatie necesita un obiect 'FileWriter' ce permite scrierea matricei in fisier.

Pachetul Constants:

Clasa ProjectileNames
	-Clasa de tip Final
	-Contine constante String : Numele proiectilelor
	-Contine constante Char : Simbolurile figurilor geometrice ce se vor proiecta pe ecran pentru desenarea acestora.
	
Clasa DrawManager
	Contine metoda:
	-draw(char[][] matrix, Point start, Point end, char symbol) 
		-deseneaza o linie care incepe la punctul 'Start' si se termina la punctul 'End'
		-aceasta operatie se realizeaza prin 'umplerea' spatiilor corespunzatoare 
			din matricea 'matrix' cu simbolul 'symbol'

Clasa TimeManager
	-contine variabile ce descriu un moment de timp h (ora), m (min) , s(secunda)
	Contine metode de tip Getter si Setter pentru aceste variabile
	
Pachetul Projectiles:
	
Clasa abstracta Projectile
	-Contine variabilele:
		screen; - retine ecranul pe care se va face proiectarea proiectilui
		shape;	- retine forma proiectilului
		shapeChangingDist;	- retine distanta dupa care proiectilul curent se transforma intr-un alt proiectil din cauza coroziunii atmosferice
		ref;	- retine o marime de referinta pentru dimensiunea proiectilului
		currentTime; - retine momentul de timp la care a fost lansat proiectilul
		
	Contine metode abstracte
		-metoda shoot(int dist, Point shooterPosition) ce primeste 'dist'-distanta de la care a fost lansat proiectilul,
			si 'shooterPosition'-punctul tinta de pe ecran la care se urmareste lansarea proiectilului  
		-metoda hitScreenAction(Point shooterPosition, int ref) ce primeste pe langa 'shooterPosition', is marimea 'ref'
		
Clasele derivate din clasa Projectile:
	-Clasa CanniterShot derivata din HeatedShot
	-Clasa Carcass derivata din HeatedShot
	-Clasa ChainShoot derivata din Shrpanel
	-Clasa HeatedShoot derivata din SpiderShot
	-Clasa Shrapnel derivata din SpiderShot
	-Clasa SimpleShot derivata direct din Projectile
	-Clasa SpiderShot derivata din SimpleShot
	-Clasa TriGrapeShot derivata din Shrpanel
	
	Clasa SimpleShell
		-metoda shoot(int dist, Point shooterPosition) apeleaza metoda hitScreenAction din aceeasi clasa
		-hitScreenAction(Point shooterPosition, int ref) - foloseste metoda 'draw' a obiectului 'shape' pentru a desena 
			o figura centrata in 'shooterPosition' cu dimensiunea dictata de 'ref' 
	Clasa SpiderShot
		Urmatoarele doua metode vor fi mostenite si de restul claselor de tip 'Projectil' intrucat sunt derivate din 'SpiderShot'
		Parametrul 'id' ce apare in ambele metode este specific fiecarui tip de proiectil
		-metoda computeDistance(int id,TimeManager currentTime) - calculeaza distanta dupa care proiectilul curent se transforma intr-un 
																	alt proiectil din cauza coroziunii atmosferice 
		-metoda newRef(int id,int dist,int ref) - calculeaza marimea de referinta pentru dimensiunea proiectilului
		
		-metoda shoot(int dist, Point shooterPosition)
			 - aceasta metoda se ocupa de actiunea proiectilului pana la lovirea ecranului si de afisarea lui pe ecran
			 - este asemanatoare celorlalte clase derivate din clasa 'Projectile'
			 - ESTE SINGURA METODA CARE DIFERENTIAZA CLASELE DERIVATE DIN CLASA 'PROJECTILE'
			 - LOGICA DE IMPLEMENTARE ESTE ACEEASI PENTRU TOATE CLASELE DE ACEEA NU SE VOR MAI EXPUNE IN ACEST README
		Mod de implementare:
			-calculeaza distanta dupa care proiectilul curent se transforma intr-un alt proiectil din cauza coroziunii atmosferice
			-daca distanta de la care s-a aruncat obiectul o depaseste pe cea necesara transformarii 
				-se apeleaza metoda 'shoot' din clasa parinte
				-se transmit clasei parinte urmatoarele variabile:
					-ref; modificat dupa regula proiectilului curent- se utilizeaza 'id'-ul proiectilului curent si distanta necesara transformarii
					-shape; modificat la forma dictata de parinte
					-shooterPosition; modificat dupa regula proiectilului curent - se utilizeaza distanta necesara transformarii
				OBS: proiectilui ii mai ramane de parcurs o distanta mai mica: 
					distanta de la care s-a aruncat obiectul -  distanta necesara transformarii
			
			-daca distanta de la care s-a aruncat obiectul nu o depaseste pe cea necesara transformarii 
				-se calculeaza:
					-ref; modificat dupa regula proiectilului curent- se utilizeaza 'id'-ul proiectilului curent si distanta introdusa prin parametru - cea de la care s-a aruncat proiectilul
					-shooterPosition; modificat dupa regula proiectilului curent - se utilizeaza distanta introdusa ca parametru
					-se apeleaza metoda 'hitScreenAction' din clasa 'SimpleShell'
					
Pachetul Screen:

Clasa Screen
	-metoda drawLineOnScreen(Point startPoint, Point endPoint, char symbol)
		-utilizeaza clasa 'DrawManager' pentru a desena o linie 'umpluta' cu simbolul 'symbol' de la punctul 'startPoint' la 'endPoint'
	-drawMultipleLinesOnScreen(Point[] startPoints,Point[] endPoints, char symbol)		
		-utilizeaza metoda 'drawLineOnScreen' pentru a desena linii umplute cu simbolul 'symbol' 	
		
Pachetul Shapes		

Clasa Point
	-contine descrierea unui punct de pe un ecran 2D: x,y
	-contine metode de tip Getter si Setter pentru coordonatele x,y
	-metoda translate(int x, int y) - translateaza un punct existent cu x si y
	
Clasa abstracta BasicShape
	Contine metoda:
		-draw(Screen screen, int ref, Point centerGrav) 
			-in clasele derivate aceasta metoda deseneaza pe ecranul continut de obiectul 'Screen' o figura centrata in 'centerGrav' 
				a carui dimensiune este dictata de 'ref'

Clasele derivate contin variabile(varfurile) ce dicteaza modul de desenare a figurii.
	-PointedShape
	-Rectangle
	-Rhombus
	-Square
	-Triangle 				 	 