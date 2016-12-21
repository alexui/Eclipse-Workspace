Programare orientata obiect

Tema1

Clasa Index contine doua metode private:
	-metoda 'arrayToString' de conversie a unui vector cu valori intregi la sir de caracter;
	-metoda 'main' care primeste ca argumente doua fisiere, si afiseaza pe ecran 
		pe cate o linie, numarul de aparitii in text a fiecarui prefix din al doilea fisier 
		primit la intrare, urmat de pozitiile cuvintelor in cadrul textului in care prefixul respectiv poate fi gasit.
		-Primul fisier este transmis ca parametru constructorului din clasa CreateRT pentru a se crea un obiect 'tree'.
		-instanta 'tree' este un RADIX-TREE
		-Prefixele din al doilea fisier sunt citite pe rand cu ajutorul unei instante a lui FileParser si cautate in instanta 'tree'
			-pentru fiecare prefix se obtine un vector de pozitii ce va fi afisat pe ecran (cu metoda de conversie de mai
			sus) precedat de un contor de linie

Clasa RadixTree defineste structura unui nod din RADIX-TREE. Contine:
	-un vector de pozitii (pos)
	-un ArrayList de noduri de tip RadixTree . (Succesori) (urm}
	-un intreg ce retine numarul de succesori directi (sub)
	-un sir de caractere - prefixul sau cheia (key)

Clasa CreateRT creeaza efectiv un RADIX-TREE si permite cautarea in acesta.Contine:
	-constructor care primeste ca parametru un fisier si citeste ,pe rand, cate un cuvant din acesta cu ajutorul unei instante a lui 
	FileParser si il introduce in arbore prin metoda 'buildRadixTree'.
	-metoda 'checkForPrefix' verifica daca prefixele a doua numere coincid si returneaza dimensiunea prefixului comun 
		lui word1 si lui word2

	-metoda 'buildRadixTree' introduce un cuvant in arbore tratand diversele cazuri ce pot sa apara.
	Pentru fiecare cuvant(cheie) metoda urmareste inserarea lui sau a prefixului sau in randul succesorilor. (vectorul 'urm')
		-CAZUL IN CARE NODUL NU ARE SUCCESORI
			-se adauga cheie ca succesor
		-CAZUL IN CARE  PREFIXUL CHEII NU CORESPUNDE CU NICI UN PREFIX AL SUCCESORILOR
			-se adauga cheie ca succesor
		-CAZUL IN CARE PREFIXUL CHEII COINCIDE CU A UNUI SUCCESOR IN TOTALITATE
			-DACA SUCCESORUL  CURENT NU ARE SUCCESORI
				-se creaza un nou arbore pornind de la succesorul curent (apel recursiv)
				-argumentul apelului recursiv este sufixul cheii
				-seteaza prefix comun la succesor curent
			-DACA SUCCESORUL  CURENT ARE SUCCESORI
				-se incearca pozitionarea sufixului (apel recursiv)
				-argumentul apelului recursiv este sufixul cheii
		-CAZUL IN CARE PREFIXUL SUCCESORULUI COINCIDE CU AL CHEII IN TOTALITATE
			-se retin  succesorii succesorului curent
			-se creaza un nou arbore pornind de la succesorul curent (apel recursiv)
			-argumentul apelului recursiv este sufixul cuvantului din succesorul curent
			-seteaza cheie la succesor
		-CAZUL IN CARE PREFIXUL CHEII COINCIDE CU A UNUI SUCCESOR DAR NU IN TOTALITATE	
			-DACA SUCCESORUL NU ARE SUCCESORI
				-se creaza un nou arbore pornind de la succesorul curent (apel recursiv)
				-seteaza prefix comun la succesor
				-argumentul apelului recursiv este sufixul cheii
			-DACA SUCCESORUL  CURENT ARE SUCCESORI
				-creaza nod auxiliar
				-nodul auxiliar are cheia - sufixul din succesor curent
				-seteaza prefix cumun la succesorul curent
				-nodul auxiliar se adauga in lista de succesori a succesorului curent
				-se creaza un nou arbore pornind de la succesorul curent
				-sufixul cheii este adaugat la succesor curent prin apel recursiv
	-metoda de printare a arborelui 'printRadixTree'
	-metoda de cautare in arbore 'search'
		-se apeleaza recursiv atunci cand prefixul cheii (primita ca parametru) se gaseste in arbore
		-argumentul apeluilui recursiv este sufixul cheii
		-atunci cand cheia coincide cu un prefix din arbore se apeleaza metoda 'seek'
		-metoda returneaza rezultatul metodei 'seek' sau null 
	-metoda 'seek' 
		-verifica daca exista cuvinte in fisier care incep cu prefixul dat prin parametru
		-returneaza un vector de intregi ce reprezinta pozitiile cheilor in cadrul fisierului specificat ca argument 1

Clasa IntArray permite lucrul cu vector de intregi. Ea contine metode care permit:
	-adaugarea unui element
	-realocarea vectorului
	-