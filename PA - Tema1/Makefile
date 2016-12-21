JFLAGS = -g
JC = javac
JVM= java

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Problema1.java \
	Problema2.java \
	SortedList.java \

MAIN1 = Problema1

MAIN2 = Problema2

MAIN3 = Bonus

build: classes

classes: $(CLASSES:.java=.class)

run-p1: $(MAIN1).class
	$(JVM) $(MAIN1)

run-p2: $(MAIN2).class
	$(JVM) $(MAIN2)

run-p3: $(MAIN3).class
	$(JVM) $(MAIN3)

clean:
	rm -f *.class

.PHONY: build clean