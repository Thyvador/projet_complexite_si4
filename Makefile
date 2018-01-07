
JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
        $(JC) $(JFLAGS) $*.java

CLASSES = \
        ./fr/polytech/unice/exception/OverLoadedException.java \
        ./fr/polytech/unice/fitting/AbstractFitting.java \
        ./fr/polytech/unice/fitting/AlmostWorstFit.java \
        ./fr/polytech/unice/fitting/WorstFit.java \
        ./fr/polytech/unice/fitting/BestFit.java \
        ./fr/polytech/unice/fitting/FirstFit.java \
        ./fr/polytech/unice/fitting/NextFit.java \
        ./fr/polytech/unice/fitting/WorstFit.java \
        ./fr/polytech/unice/utils/Bin.java \
        ./fr/polytech/unice/utils/DataParser.java \
        ./fr/polytech/unice/utils/Item.java \
        ./fr/polytech/unice/Main.java \
        ./fr/polytech/unice/MainStat.java \


default: classes

classes: $(CLASSES:.java=.class)


clean:
        $(RM) *.class