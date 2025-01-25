# Projeto Final de Boas Práticas de Programaçã

Se trata de uma aplicação com interface gráfica para gestão de itens de biblioteca. Foram usados aplicados de maneira prática os conceitos de Clean Code, Design Patterns(Singleton) e Testes. O projeto foi contruído do zero.

[Demonstração](https://youtu.be/-grvFDZme8g)

## Pré-requisitos
- Java 17.0.13
- JavaFX 17.0.13
- JUnit 5.11

## Como rodar

Para compilar
```
javac --module-path lib -d bin src/module-info.java src/br/ufrn/imd/biblioteca/**/*.java
```
Para os testes
```
java -jar lib/junit-platform-console-standalone-1.11.4.jar --class-path bin --scan-classpath
```

Para rodar a aplicação
```
java --module-path "lib" --add-modules javafx.controls,javafx.fxml bin/br/ufrn/imd/biblioteca/Main
```
