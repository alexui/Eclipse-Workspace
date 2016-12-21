Problema1

se creeaza o clasa Pair ce are urmatoarele campuri:
	-no -numar pereche
	-Slave -numar victime sclav
	-Master -numar victime stapan
	-dif diferenta dintre victimele stapanului si cele ale sclavului

cele 2*N perechi de orci sunt citite din fisier cu ajutorul instantei Scanner si se retin intr-un vector cu elemnte de tip Pair

Algoritm 
	Fie n perechi
	{
	
	alegem pe rand cate doua perechi -> din prima selectam sclavul iar din a doua stapanul (pentru a respecta ordinea de grupare - indice stapan > indice sclav) iar numarul de victime corespunzatoare orcului ales se adauga la salariu 
	for i de la 1 la n cu pas 2

	dupa ce se fac aceste alegeri se vor retine indicii perechilor de unde au fost selectati stapanii respectiv sclavii in doua liste
	
	pas i (>3);

	cautam diferenta maxima dintre victimele stapanului si victimele sclavului numai in randul perechilor din care a fost selectat stapanul pana la pasul i
	
	daca diferenta maxima gasita e mai mare decat diferenta dintre victimele stapanului si cele ale sclavului din perechea din care am ales sclavul la o oarecare iteratie 'i' atunci constatam ca alegerea stapanului nu a fost una buna; vom modifica alegerile facute astfel:
		-din perechea curenta din care am ales sclavul se va alege stapanul
		-din perechea in care am gasit diferenta maxima amintita anterior se va selecta sclavul si nu stapanul
	dupa aceste alegeri se va modifica si salariul

	pentru reconstituirea solutiei se vor parcurge cele doua liste de indici in ordine crescatoare iar perechile (N) se formeaza astfel: stapanul extras a 'i' a oara din vectorul indicilor perechilor cu stapan selectat va fi in echipa cu sclavul extras a 'i' a oara din vectorul indicilor perechilor cu sclav ales
	}

Implementare si complexitate
citire din fisier -> O(n)
pentru retinerea indicilor se creaza doua liste sortate (Sorted List) (derivate din ArrayList) in care se vor retine indicii perechilor cu stapan respectiv sclav ales
-aceasta lista sortata este utila pentru reconstituirea solutiei deoarece indicii din fiecare lista trebuie sa fie ordonati crescator
-adaugarea si eliminarea din acest tip de lista dureaza O(log n)
-la fiecare inserare a unui element in lista, se realizeaza o cautare binara a elementului de inserat in SortedList pentru a determina locul sau potrivit

pentru calculul diferentei maxime (victime stapan - victime sclav) in randul perechilor cu stapan ales se va folosi un PriorityQueue
-in aceasta coada perechile cu stapan ales sunt ordonate descrescator in functie de diferenta victime stapan - victime sclav
-adaugarea in aceasta coada dureaza O(log n) iar extragerea unui element dureaza Theta(1)

Strategia folosita este greedy: la parcurgerea vectorului de perechi, o data ce am selectat un orc dintr-o pereche (sclav sau stapan) nu avem posibilitatea sa ne schimbam alegerea facuta decat daca gasim o diferenta dintre victimele stapanului si cele ale sclavului  care sa fie mai mica decat un acelasi tip de diferenta calculata pentru perechile cu stapan ales

Complexitate: O(n log(n))
-inserari in listele sortate O(n log(n))
-eliminari din listele sortate O(n log(n))
-inserari in PriorityQueue O(n log(n))
-eliminari din PriorityQueue O(n)
-Reconstituirea solutiei O(n)

Problema 2

se cer numarul matricelor cu N linii M coloane a.i. pe fiecare coloana sa nu avem mai mult de K valori consecutive de 1

Algoritn

consideram M = 1 => cautam multimea secventelor de lungime N care sa nu contina mai mult de K valori consecutive de 1
se construieste matricea M ce contine N linii si K coloane si se completeaza cu numarul de secvente gasite avand proprietatea ceruta.

T=

__1__2__3__4__5
1|2 |2 |2 |2 |2
2|3 |4 |4 |4 |4
3|5 |7 |8 |8 |8
4|8 |13|15|16|16
5|21|24|29|31|32

Se observa ca elementul T(n,k) = {2^n 				pentru n<=k
								  2^n -1 			pentru n=k+1
								  T(n-1-i,k)		pentru i de la 0 la k}

se observa pentru a gasi numarul de secvente de lungime N avand cel mult K valori consecutive de 1 trebuie in cel mai rau caz sa insumam 
numarul de secvente cu aceasi proprietate avand lungimi mai mici (Programare dinamica)

Problema se va rezolva utilizand o recurenta
Fie matricea A si vectorul v la dreapta ei.
				 	
T(n,k),				1 1 1 ... 1 	T(n-1,k)			1 1 1 ... 1 	1 1 1 ... 1 	T(n-2,k)
T(n-1,k)			1 0	0  ...0		T(n-2,k)			1 0	0  ...0		1 0	0  ...0		T(n-3,k)
...				=	0 1 0 ... 0		...				=	0 1 0 ... 0		0 1 0 ... 0	    ...	
T(n-k+1,k)			...........		...					...........		...........	    ...
T(n-k,k)			0 0 0 ..1 0		T(n-k+1,k)			0 0 0 ..1 0		0 0 0 ..1 0     T(n-k+2,k)


=> deoarece stim cum arata vectorul de la drapta matricei avand k+1 elemente  (2^n 	pentru n<=k  si 2^n -1 pentru n=k+1)
e suficient sa ridicam matricea la puterea N-K-1 si apoi sa o inmultim cu vectorul amintit anterior
Rezultatul se va afla in varful vectorului rezultant.
Se va ridica la puterea M pentru 

Complexitate O( K^3 * log (N-K-1) * log(M)
			-se creaza matricea A O(K)
			-se creaza vectorul v ce contine puteri ale lui 2 O(K*log k) -> se foloseste metoda de ridicare la putere a unui numar in timp logaritmic
			-se realizeaza ridicarea la puterea N-K-1 a matricei A in O( K^3 * log (N-K-1))		(K^3 de la inmultirea efectiva a doua matrici)	
			-se realizeaza inmultirea matricei rezultante cu vectorul v in O(K^2)	
			-se extrage rezultatul in O(1)
			-se ridica rezultatul la puterea M pentru aflarea rezultatului final in O(log(M))


