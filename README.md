# GalakZ

A Java-based 2D space shooter inspired by classic arcade games.\
This project focuses on real-time rendering, entity systems, collision
handling, and a custom game loop.

## Screenshot

![](https://i.imgur.com/6OjLTmB.png)

------------------------------------------------------------------------

## Overview

**GalakZ** is a small game engine + game implementation written in
Java.\
It demonstrates:

-   A real-time update/render loop
-   Basic 2D rendering
-   Player and enemy entity systems
-   Projectile and collision handling
-   Input-driven movement and combat
-   Simple game state management

This is a technical / learning-focused project rather than a production
game.

------------------------------------------------------------------------

## Features

-    Player ship movement, rotation, and shooting
-    Enemy entities with basic behavior
-    Projectile system and collision detection
-    Entity update system
-    2D rendering pipeline
-    Fixed or semi-fixed timestep game loop
-    Keyboard input handling

------------------------------------------------------------------------

## Tech Stack

-   **Language:** Java\
-   **Rendering:** Java2D / AWT / Swing\
-   **Architecture:**
    -   Custom game loop\
    -   Entity-based design\
    -   Separation of update and render steps\
-   **Assets:** Loaded via standard Java image utilities

------------------------------------------------------------------------

## Building & Running

### Requirements

-   Java JDK 8 or newer
-   An IDE like IntelliJ IDEA / Eclipse **or** command line

### Clone

``` bash
git clone https://github.com/AaronCreor/GalakZ.git
cd GalakZ
```

### Compile (example)

``` bash
javac -d out $(find src -name "*.java")
```

### Run (example)

``` bash
java -cp out game.Main
```

> Update the main class path if your package name differs.

------------------------------------------------------------------------

## Controls

(Adjust to match your actual bindings)

-   **Arrow Keys / WASD** --- Move / rotate ship\
-   **Space** --- Fire\
-   **Esc** --- Exit

------------------------------------------------------------------------

## Possible Improvements

-   Sprite animations and effects
-   Sound effects and music
-   More advanced enemy AI patterns
-   Particle effects
-   Level system / wave progression
-   Better physics and collision resolution
-   Configurable controls


------------------------------------------------------------------------

## Notes

This project is intended as a technical demonstration of:

-   Real-time game loops
-   2D rendering in Java
-   Entity-based game architecture
-   Basic game engine structure

It's a solid base for experimenting with engine features, performance
improvements, or migrating to a more advanced framework later.
