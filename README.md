## 💡 IDEA DE PROYECTO

# 🎮 RPG por Turnos - *Elden PRO - Expedition: DAW*

Un sistema de juego por consola, basado en un RPG por turnos. No guarda datos entre ejecuciones, y se enfoca en demostrar herencia y polimorfismo en POO.

---

## 📁 Estructura del Proyecto

```
eldenpro/
├── controller/                       # Controladores del juego
│   ├── battleController.java         # Controla las batallas
│   ├── castleController.java         # Controla la exploración del castillo
│   ├── caveController.java           # Controla la exploración de la cueva
│   └── gameController.java           # Controla el flujo general del juego
│
├── model/                            # Lógica del juego y personajes
│   ├── abilities/                    # Interfaces con habilidades especiales
│   │   ├── defendible.java           # Para personajes que pueden defenderse
│   │   ├── flying.java               # Para personajes que pueden volar
│   │   ├── healable.java             # Para personajes que pueden curarse
│   │   ├── magical.java              # Para personajes que usan magia
│   │   └── mobilizable.java          # Para personajes con habilidades de movimiento
│   │
│   ├── characters/                   # Clases relacionadas con los personajes
│   │   ├── character.java            # Clase base para todos los personajes
│   │   ├── magicalCharacters/        # Personajes mágicos
│   │   │   ├── mage.java             # Clase para el Mago
│   │   │   ├── magicalCharacter.java # Clase base para personajes mágicos
│   │   │   └── wizard.java           # Clase para el Hechicero
│   │   └── physicalCharacters/       # Personajes físicos
│   │       ├── archer.java           # Clase para el Arquero
│   │       ├── assassin.java         # Clase para el Asesino
│   │       ├── physicalCaracter.java # Clase base para personajes físicos
│   │       └── warrior.java          # Clase para el Guerrero
│   │
│   ├── enemies/                      # Clases relacionadas con los enemigos
│   │   ├── enemy.java                # Clase base para todos los enemigos
│   │   ├── finalBoss.java            # Clase para el Jefe Final
│   │   └── thief.java                # Clase para el Ladrón
│   │
│   └── enums/                        # Enumeraciones del juego
│       ├── classes.java              # Enumeración de clases de personajes
│       └── damageTypes.java          # Enumeración de tipos de daño
│
├── view/                             # Interfaz de usuario en consola
│   ├── castleSelector.java           # Menú de opciones del castillo
│   ├── caveSelector.java             # Menú de opciones de la cueva
│   ├── characterSelection.java       # Menú para seleccionar personaje
│   └── startMenu.java                # Menú inicial del juego
│
├── game.java                         # Punto de entrada del programa
└── LICENSE                           # Licencia del proyecto
```

## 🧙 Introducción al Juego
  Al iniciar el programa, se muestra una introducción breve al mundo de *Elden PRO: Expedition DAW*.  
  El jugador podrá decidir si quiere comenzar la aventura o salir del juego.

  ## Contexto
  Nos hemos basado en las mcánicas del juego llamado Clair Obscur: Expedition 33, le hemos añadido personalización y más dificultad para hacer una mezcla de Souls-like (Sekiro y Elden Ring) por turnos, así como añadiendo contexto en el mundo, por qué nuestro personaje está aquí y qué tenemos que hacer para terminar nuestra travesía.

  Por favor, revisar el video de ejemplo de la jugabilidad de Clair Obscur: Expedtion 33:
  [video de demostración](https://youtu.be/db2jQHWUaFo?si=wNJEoErFpaqcqGaB&t=170).

---

## 🧑‍🤝‍🧑 Selección de Personaje

Si el jugador decide jugar, se le presentan las siguientes clases jugables:

### Clases Disponibles:

- **Guerrero**
  - HP: 2000
  - Nivel: 10
  - Fuerza: 15
  - Equipamiento: Armadura de hierro de caballería (15 de armadura), espada gastada(150 daño), escudo de hierro(5 de armadura)

- **Mago**
  - HP: 1000
  - Nivel: 27
  - Magia: 20
  - Maná: 40
  - Sabiduría: 15
  - Equipamiento: Túnica(10 de armadura), bastón largo(200 de daño mágico)

- **Arquero**
  - HP: 950
  - Nivel: 30
  - Agilidad: 30
  - Equipamiento: Armadura de arquero(10 de armadura), arco(175 de daño en cuerpo, 250 de daño en la cabeza)

- **Hechicero**
  - HP: 950
  - Nivel: 30
  - Maná: 60
  - Habilidad especial: **Concentración** (puede usarse una vez cada 2 turnos, se puede acumular, aumenta el daño un 3% 3 turnos)
  - Equipamiento: Túnica(10 de armadura), bastón de magia corto(200 de daño mágico)

- **Asesino**
  - HP: 1250
  - Nivel: 20
  - Agilidad: 40
  - Habilidad pasiva: **Sigilo** (atacar siempre primero y probabilidad del 10% de matar al enemigo) 
  - Crítico: 25% de probabilidad de golpe crítico (2*daño base)
  - Equipamiento: Armadura de cuero(5 de armadura), daga(100 de daño)

### 📌 Nota Técnica

Cada clase derivará de una clase base `Personaje`, y podrá sobrescribir métodos como `atacar()` o `usarHabilidad()`, demostrando **polimorfismo**. Las estadísticas y habilidades propias de cada clase muestran el uso de la **herencia**.

---

## 🧾 Creación del Personaje

Una vez elegida la clase, el jugador introduce su nombre.  
Se muestra un resumen final con los datos del personaje.

---

## 🎲 Comienzo del Juego

El jugador podrá tomar una de tres decisiones principales:

### 1. 🏰 Explorar el Castillo

- **Torreón:** Encuentra un cofre (daga mágica que añade 3% de daño mágico y 200 de oro) y una nota sobre el mundo. Luego puede volver a elegir.
- **Entrada:** Combate contra un **Caballero Oscuro (HP: 500)**.  
  Recompensa: 100 de oro y una espada larga(+100 de daño).
- **Jefe Final:** Enfrenta al **Jefe (HP: 2500, 10 de armadura, 15 de armadura mágica, daño físico y mágico)**.  
  Recompensa: 500 de oro y una daga sombría(200+ de daño).

### 2. 🕳️ Explorar la Cueva

- **Tesoro:** Combate sorpresa contra un ladrón al intentar tomar el tesoro, cuando se toma el tesoro, el jugador podrá elegir entre armadura(5+ de armadura) o daño(30+ de daño).
- **Ladrón:** Opción de enfrentar al ladrón(HP: 1000, 5 de armadura física, débil a daño mágico) antes de ir por el tesoro. Si lo derrota, el tesoro queda libre.
- **Tienda:** Se muestra un ejemplo de tienda con objetos disponibles: 1. medallón ámbar(7% mas de vida, 50 de oro, 2. Icono de mago(Concentración puede usarse siempre, pero no se puede acumular), 75 de oro y 3. Daga del asesino(los golpes criticos restauran un 10% de vida).

### 3. 🧓 Hablar con un NPC

- El NPC cuenta una historia breve del mundo.
- Al finalizar, el jugador recibe un **tesoro aleatorio**(tomo mágico, puedes embuir tu espada con daño mágico, unico para el caballero y el asesino).

---

## 💡 Sugerencias Técnicas

- Crear una clase base abstracta `Personaje` con atributos comunes y métodos virtuales.
- Cada clase (`Guerrero`, `Mago`, `Asesino`, etc.) que accederá a subclases `Física` o `Mágica`, 
  pudiendo sobreescribir sus habilidades o ataques.
- Incluir una clase `Combate` para gestionar peleas.
- Usar un sistema de turnos con acciones como atacar, usar habilidad o esquivar.
- Las decisiones se pueden manejar con `switch-case` o `if-else`, dependiendo del lenguaje.
- La armadura resta un porcentaje del daño base (1-2%), si el personaje se defiende no recibe daño

