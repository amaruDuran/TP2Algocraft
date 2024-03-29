# TP2Algocraft

[![Build Status](https://travis-ci.org/amaruDuran/TP2Algocraft.svg?branch=master)](https://travis-ci.org/amaruDuran/TP2Algocraft)
[![codecov](https://codecov.io/gh/amaruDuran/TP2Algocraft/branch/master/graph/badge.svg)](https://codecov.io/gh/amaruDuran/TP2Algocraft)

### Instalación previa
Las únicas herramientas necesarias para trabajar en el proyecto son el entorno de desarrollo de Java ([OpenJDK](https://openjdk.java.net/install/)), [Apache Ant](https://ant.apache.org/) para la construcción automatizada y Git para el control de versiones.
```console
$ sudo apt update
$ sudo apt install openjdk-8-jdk ant git
```
Verificamos que se hayan instalado correctamente:

```console
$ javac -version
javac 1.8.0_191
$ ant -version
Apache Ant(TM) version 1.9.6 compiled on July 20 2018
$ git --version
git version 2.7.4
```

Obs: Para el jdk se recomienda una versión 8 o superior.

## Casos de prueba para cada entrega

### Entrega 1

Tests de Herramienta:
Se crea hacha de madera con con su durabilidad y fuerza correspondiente
Se crea pico de madera con con su durabilidad y fuerza correspondiente
Se crea hacha de metal con con su durabilidad y fuerza correspondiente
Se crea Pico de metal con con su durabilidad y fuerza correspondiente
Se crea Pico Fino con con su durabilidad y fuerza correspondiente
Hacha se usa contra cada uno de los materiales y se reduce su durabilidad correspondiente al material del Hacha
Pico se usa contra cada uno de los materiales y se reduce su durabilidad correspondiente al material del Pico
Pico Fino se usa contra Diamante y se reduce su durabilidad correspondiente
Pico Fino se usa contra los demás materiales y no se reduce su durabilidad
Tests de Jugador: 
Correcta creación e inicialización del jugador

Test de Material:
Madera se golpea con un Hacha de Madera y se verifica que se reduce la durabilidad del material.
Piedra se golpea con un Hacha y se verifica que no se reduce la durabilidad del material.
Metal se golpea con un Pico de madera y se verifica que no se reduce la durabilidad del material.

### Entrega 2

Construcción de herramienta:
Se verifica la correcta construcción de cada herramienta con su correspondiente forma de creación y materiales.
Jugador:
Se verifica la correcta inicialización del jugador en el mapa.
Se verifica que puede moverse para todas las direcciones vacías.
Mapa:
Se verifica que se puede ocupar un casillero vacío del terreno.
Se verifica que no se puede ocupar un casillero ocupado.
Se verifica que un casillero puede ser ocupado por un material o personaje.
Juego:
Se verifica que se inicia el juego con el terreno inicializado (materiales distribuidos en el mapa), el jugador inicializado

### Entrega 3

Interfaz gráfica inicial básica: comienzo del juego, disposición de materiales en el tablero y menú inicial.

### Entrega 4

Trabajo Práctico completo funcionando, con interfaz gráfica final, sonidos e informe completo.


