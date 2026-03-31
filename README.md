# Arkanoid - 2D Arcade Game 🧱🕹️

An Object-Oriented implementation of the classic Arkanoid (Breakout) game, developed entirely in **Java**. 
This project showcases strong software engineering principles, including design patterns, interface-driven development, and a custom modular game architecture.

## ✨ Key Features

* **Dynamic Gameplay Loop:** A smooth 60 FPS animation loop handling real-time physics, collision detection, and rendering.
* **Progressive Levels:** Features 4 unique levels (`Direct Hit`, `Wide Easy`, `Green 3`, `Final Four`) with increasing difficulty, varying ball counts, custom ball velocities, and complex block formations.
* **Robust Collision System:** A custom 2D physics engine that calculates intersection points between mathematical lines and rectangles to determine precise hit velocities and angles.
* **Event-Driven Architecture:** Implements the **Observer Design Pattern** (`HitListener` / `HitNotifier`) to efficiently manage game events such as score tracking, block destruction, and ball removal without tight coupling.
* **Interactive UI:** Includes interactive Pause screens, dynamic Score & Level tracking, and End-Game screens (Victory/Game Over).

## 🏗️ Technical Architecture & OOP Concepts

* **Polymorphism & Interfaces:** Heavy utilization of the `Sprite` interface (for visual elements) and the `Collidable` interface (for physical objects), allowing the `GameLevel` manager to treat diverse game objects uniformly.
* **Separation of Concerns:** Clear architectural division between mathematical logic (`Point`, `Line`, `Rectangle`), game entities (`Ball`, `Block`, `Paddle`), and game flow management (`GameLevel`, `AnimationRunner`, `GameFlow`).
* **Memory Management:** Proper dynamic allocation and deallocation of listeners and sprites upon destruction to prevent memory leaks during extended gameplay.

## 🛠️ Tech Stack

* **Language:** Java
* **Graphics & Input:** `biuoop` library (a university-provided wrapper over Java AWT/Swing for simplified rendering and keyboard sensor inputs).

## 🚀 How to Run

1. Clone this repository to your local machine:
   ```bash
   git clone [https://github.com/](https://github.com/)[Your-GitHub-Username]/[Your-Repository-Name].git
