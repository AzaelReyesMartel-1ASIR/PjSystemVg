## 💡 IDEA DE PROYECTO

# 🎮 RPG por Turnos - *Elden Pro*

Un sistema de juego por consola, basado en un RPG por turnos. No guarda datos entre ejecuciones, y se enfoca en demostrar herencia y polimorfismo en POO.

---

## 📁 Estructura del Proyecto

```

eldenpro/
├── controller/                       # Aquí están los controladores del juego
│   ├── BatallaController.java       # Controla lo que pasa en una batalla
│   └── GameController.java          # Controla el funcionamiento general del juego

├── model/                           # Todo lo que tiene que ver con los personajes y lógica del juego
│   ├── batalla/
│   │   └── Batalla.java             # Se encarga de simular una batalla entre personajes
│   ├── enemigos/
│   │   └── jefeFinal.java             # Clase para enemigos del juego
|   |   └── ladron.java
│   ├── Inventario/
│   │   └── Item.java                # Para manejar los objetos que puede tener un personaje
│   ├── personajes/
│   │   ├── Personaje.java           # Clase base para todos los personajes
│   │   ├── PersonajeFisico.java     # Subclase para personajes físicos
│   │   ├── PersonajeMagico.java     # Subclase para personajes mágicos
        ├── personajesFisicos/
│   │       └── Guerrero.java            # Personaje que lucha cuerpo a cuerpo               
│   │       └── Asesino.java             # Muy rápido y sigiloso
│   │       └── Arquero.java             # Ataca con flechas
|   |   ├── personajesMagicos/
|   |       └── Mago.java                # Usa magia simple
│   │       └── Hechicero.java           # Usa hechizos más avanzados

│   └── habilidades/                 # Aquí están las interfaces con habilidades especiales
│       └── Curable.java             # Para los personajes que se pueden curar
│       └── Defendible.java          # Para los que pueden defenderse
│       └── Magico.java              # Para los que usan magia
│       └── Movilizable.java         # Para los que se pueden mover más rápido o especial
│       └── Volador.java             # Para los que pueden volar
├── view/                            # Todo lo que ve el usuario en consola
│   ├── menuInicial.java
│   └── seleccionPersonaje.java
|   └── seleccionGeneral.java
|   └── seleccionCueva.java
|   └── seleccionCastillo.java
|   └── menuBatalla.java

├── Juego.java                        # Es el punto de entrada, donde empieza el programa

```

## 🧙 Introducción al Juego

Al iniciar el programa, se muestra una introducción breve al mundo de *Elden Pro*.  
El jugador podrá decidir si quiere comenzar la aventura o salir del juego.

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

