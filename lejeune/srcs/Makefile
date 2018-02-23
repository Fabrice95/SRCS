#			Systemes Repartis Client Serveur
#				Makefile pour TP 2


# Documentation: http://www.gnu.org/software/make/manual/make.html
CC =javac

DIR=.
BIN=$(DIR)/bin/
SRC=$(DIR)/src/

.SUFFIXES:
.PHONY: all clean test test-Serveur test-Client test-ServeurV1 test-ClientV1 test-Serveur-Client
all: $(BIN)srcs/tme2/base/Serveur.class $(BIN)srcs/tme2/base/Client.class $(BIN)srcs/tme2/v1/Serveur.class $(BIN)srcs/tme2/v1/Client.class

test: test-Serveur test-Client test-ServeurV1 test-ClientV1

test-Serveur: $(BIN)srcs/tme2/base/Serveur.class
	-javac $(SRC)srcs/tme2/base/Serveur.java && cd $(BIN) && java srcs.tme2.base.Serveur

test-Client: $(BIN)srcs/tme2/base/Client.class
	-javac $(SRC)srcs/tme2/base/Serveur.java && cd $(BIN) && java srcs.tme2.base.Client


test-ServeurV1: $(BIN)srcs/tme2/v1/Serveur.class
	-javac $(SRC)srcs/tme2/v1/Serveur.java -d $(BIN) -classpath $(BIN)
	-cd $(BIN) && java srcs.tme2.v1.Serveur

test-ClientV1: $(BIN)srcs/tme2/v1/Client.class
	-javac $(SRC)srcs/tme2/v1/Client.java -d $(BIN) -classpath $(BIN)
	-cd $(BIN) && java srcs.tme2.v1.Client


test-Serveur-Client: $(BIN)srcs/tme2/base/Serveur.class $(BIN)srcs/tme2/base/Client.class
	-javac $(SRC)srcs/tme2/base/Serveur.java -d $(BIN) -classpath $(BIN)
	-javac $(SRC)srcs/tme2/base/Client.java
	-cd $(BIN) && java srcs.tme2.base.Serveur & java srcs.tme2.base.Client &

$(BIN)srcs/tme2/base/%.class: $(SRC)srcs/tme2/base/%.java
	@if [ -d $(BIN) ]; then : ; else mkdir $(BIN); fi
	$(CC) -d ./bin -classpath ./bin $^

clean: 
	rm -Rf $(BIN)srcs/tme2/base/*.class
