#			Systemes Repartis Client Serveur


# Documentation: http://www.gnu.org/software/make/manual/make.html
CC =javac

DIR=.
BIN=$(DIR)/bin/
SRC=$(DIR)/src/

.SUFFIXES:
.PHONY: all clean test test-Serveur test-Client test-ServeurV1 test-ClientV1 test-Serveur-Client test-Serveur_rmi test-Client_rmi
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


#####			TME 3

test-Serveur_http_get: $(BIN)srcs/tme3/ProcessRequestGet.class
	-javac $(SRC)srcs/tme3/ProcessRequestGet.java -d $(BIN) -classpath $(BIN)
	-java -classpath $(BIN) srcs.tme3.ProcessRequestGet

test-Serveur_http_get_put: $(BIN)srcs/tme3/ProcessRequestGetPut.class
	-javac $(SRC)srcs/tme3/ProcessRequestGetPut.java -d $(BIN) -classpath $(BIN)
	-java -classpath $(BIN) srcs.tme3.ProcessRequestGetPut

test-Client_http_put: $(BIN)srcs/tme3/ClientPut.class
	-javac $(SRC)srcs/tme3/ClientPut.java -d $(BIN) -classpath $(BIN)
	-java -classpath $(BIN) srcs.tme3.ClientPut


#####			TME 5

test-Serveur_rmi: $(BIN)srcs/tme5/ServerMain.class
	-javac $(SRC)srcs/tme5/ServerMain.java -d $(BIN) -classpath $(BIN)
	-java -classpath $(BIN) srcs.tme5.ServerMain

test-Client_rmi: $(BIN)srcs/tme5/ClientMain.class
	-javac $(SRC)srcs/tme5/ClientMain.java -d $(BIN) -classpath $(BIN)
	-java -classpath $(BIN) srcs.tme5.ClientMain



#############################################################################################


test-Serveur-Client: $(BIN)srcs/tme2/base/Serveur.class $(BIN)srcs/tme2/base/Client.class
	-javac $(SRC)srcs/tme2/base/Serveur.java -d $(BIN) -classpath $(BIN)
	-javac $(SRC)srcs/tme2/base/Client.java
	-cd $(BIN) && java srcs.tme2.base.Serveur & java srcs.tme2.base.Client &

$(BIN)srcs/tme2/base/%.class: $(SRC)srcs/tme2/base/%.java
	@if [ -d $(BIN) ]; then : ; else mkdir $(BIN); fi
	$(CC) -d ./bin -classpath ./bin $^

clean: 
	rm -Rf $(BIN)srcs/tme2/base/*.class
