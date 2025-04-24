## 💡 IDEA DE PROYECTO

# 🎮 RPG por Turnos - *Elden Pro*

Un sistema de juego por consola, basado en un RPG por turnos. No guarda datos entre ejecuciones, y se enfoca en demostrar herencia y polimorfismo en POO.

---

## 📁 Estructura del Proyecto

```

eldenpro/
├── controller/                   # Controladores del flujo del juego
│   ├── BatallaController.java   # Controla la lógica de las batallas
│   └── GameController.java      # Control general del flujo del juego
|
├── model/                       # Lógica del juego
│   ├── batalla/
│   │   └── Batalla.java         # Simulación de combates
│   ├── enemigos/
│   │   └── Enemigo.java         # Posible clase futura para enemigos no jugables
│   ├── Inventario/
│   │   └── Item.java            # Gestión de ítems del juego
│   └── personajes/
│       ├── Personaje.java       # Clase base abstracta para personajes
│       ├── Guerrero.java        # Personaje físico
│       ├── Mago.java            # Personaje mágico
│       ├── Arquero.java         # Personaje físico con agilidad
│       ├── Hechicero.java       # Personaje mágico avanzado
│       └── Asesino.java         # Personaje ágil y sigiloso
|
├── view/                        # Representación visual en consola
│   ├── ConsolaView.java         # Muestra mensajes y opciones al usuario
│   └── Menus.java               # Menús interactivos por consola
|
├── Main.java                    # Clase principal para ejecutar la aplicación

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
  - Equipamiento: Armadura de hierro de caballería, espada gastada, escudo de hierro

- **Mago**
  - HP: 1000
  - Nivel: 27
  - Magia: 20
  - Maná: 40
  - Sabiduría: 15
  - Equipamiento: Túnica, bastón largo

- **Arquero**
  - HP: 950
  - Nivel: 30
  - Agilidad: 30
  - Equipamiento: Armadura de arquero, arco

- **Hechicero**
  - HP: 950
  - Nivel: 30
  - Maná: 60
  - Habilidad especial: **Concentración** (puede usarse una vez cada 2 turnos, se puede acumular)
  - Equipamiento: Túnica, bastón de magia corto

- **Asesino**
  - HP: 1250
  - Nivel: 20
  - Agilidad: 40
  - Habilidad pasiva: **Sigilo**
  - Crítico: 25% de probabilidad de golpe crítico
  - Equipamiento: Armadura de cuero, daga

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

- **Torreón:** Encuentra un cofre y una nota sobre el mundo. Luego puede volver a elegir.
- **Entrada:** Combate contra un **Caballero Oscuro (HP: 1000)**.  
  Recompensa: 100 de oro y una espada larga.
- **Jefe Final:** Enfrenta al **Jefe (HP: 2500)**.  
  Recompensa: 500 de oro y una daga sombría.

### 2. 🕳️ Explorar la Cueva

- **Tesoro:** Combate sorpresa contra un ladrón al intentar tomar el tesoro.
- **Ladrón:** Opción de enfrentar al ladrón antes de ir por el tesoro. Si lo derrota, el tesoro queda libre.
- **Tienda:** Se muestra un ejemplo de tienda con objetos disponibles.

### 3. 🧓 Hablar con un NPC

- El NPC cuenta una historia breve del mundo.
- Al finalizar, el jugador recibe un **tesoro aleatorio**.

---

## 💡 Sugerencias Técnicas

- Crear una clase base abstracta `Personaje` con atributos comunes y métodos virtuales.
- Cada clase (`Guerrero`, `Mago`, `Asesino`, etc.) que accederá a subclases `Física` o `Mágica`, 
  pudiendo sobreescribir sus habilidades o ataques.
- Incluir una clase `Combate` para gestionar peleas.
- Usar un sistema de turnos con acciones como atacar, usar habilidad o esquivar.
- Las decisiones se pueden manejar con `switch-case` o `if-else`, dependiendo del lenguaje.

