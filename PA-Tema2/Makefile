JFLAGS = -g
JC = javac
JVM= java

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	P1.java \
	Problema2.java\
	SortedList.java\

MAIN1 = P1

MAIN2 = Problema2

build: classes

classes: $(CLASSES:.java=.class)

run-p1: $(MAIN1).class
	$(JVM) $(MAIN1)

run-p2: $(MAIN2).class
	$(JVM) $(MAIN2)

clean:
	rm -f *.class

.PHONY: build clean