all: copy_executable
	javac source/fr/polytech/unice/exception/OverLoadedBinException.java \
	source/fr/polytech/unice/utils/Bin.java \
	source/fr/polytech/unice/utils/DataParser.java \
	source/fr/polytech/unice/utils/Item.java \
	source/fr/polytech/unice/utils/BST.java \
	source/fr/polytech/unice/utils/Node.java \
	source/fr/polytech/unice/fitting/AbstractFitting.java \
	source/fr/polytech/unice/fitting/AlmostWorstFit.java \
	source/fr/polytech/unice/fitting/BestFit.java \
	source/fr/polytech/unice/fitting/FirstFit.java \
	source/fr/polytech/unice/fitting/NextFit.java \
	source/fr/polytech/unice/fitting/WorstFit.java \
	source/fr/polytech/unice/MainStat.java \
	source/fr/polytech/unice/Main.java \

copy_executable:
ifeq ($(OS),Windows_NT)
	copy executable/algo.BAT .
	copy executable/stat.BAT .
else
	cp executable/algo.ex .
	cp executable/stat.ex .
endif

clean:
	rm source/fr/polytech/unice/exception/OverLoadedBinException.class \
	source/fr/polytech/unice/utils/Bin.class \
	source/fr/polytech/unice/utils/DataParser.class \
	source/fr/polytech/unice/utils/Item.class \
	source/fr/polytech/unice/fitting/AbstractFitting.class \
	source/fr/polytech/unice/fitting/AlmostWorstFit.class \
	source/fr/polytech/unice/fitting/BestFit.class \
	source/fr/polytech/unice/fitting/FirstFit.class \
	source/fr/polytech/unice/fitting/NextFit.class \
	source/fr/polytech/unice/fitting/WorstFit.class \
	source/fr/polytech/unice/MainStat.class \
	source/fr/polytech/unice/Main.class \
	source/fr/polytech/unice/utils/BST.class \
	source/fr/polytech/unice/utils/Node.class \

