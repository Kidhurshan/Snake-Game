
<p align="center">

# 🐍 Snake Game

A classic Snake Game implementation in Java using Swing GUI framework. Control the snake to eat apples and grow longer while avoiding collisions with walls and your own body.

![Snake Game](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Swing](https://img.shields.io/badge/Swing-000000?style=for-the-badge&logo=java&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-green.svg)

   <img width="1600" alt="image" src="https://github.com/user-attachments/assets/110cc5c3-1d38-4927-9bf5-38a824115198" />
</p>
## 🎮 Features

- **Classic Gameplay**: Traditional snake game mechanics with smooth controls
- **Visual Grid System**: Clear grid lines for better gameplay visibility
- **Dynamic Scoring**: Real-time score display that increases with each apple eaten
- **Gradient Snake Design**: Beautiful gradient effect on the snake body (head to tail)
- **Collision Detection**: Comprehensive collision detection for walls and self
- **Responsive Controls**: WASD key controls for intuitive movement
- **Game Over Screen**: Clear game over display with final score

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Any Java IDE (Eclipse, IntelliJ IDEA, NetBeans) or command line

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/snake-game.git
   cd snake-game
   ```

2. **Compile the project**
   ```bash
   javac src/*.java
   ```

3. **Run the game**
   ```bash
   java -cp src SnakeGame
   ```

### Alternative: Using an IDE

1. Open your preferred Java IDE
2. Import the project folder
3. Run the `SnakeGame.java` file as the main class

## 🎯 How to Play

- **Movement**: Use WASD keys to control the snake
  - `W` - Move Up
  - `S` - Move Down
  - `A` - Move Left
  - `D` - Move Right
- **Objective**: Eat the red apples to grow longer and increase your score
- **Avoid**: Hitting the walls or your own body
- **Goal**: Achieve the highest score possible!

## 🏗️ Project Structure

```
Snake Game/
├── src/
│   ├── SnakeGame.java      # Main entry point
│   ├── GameFrame.java      # JFrame window setup
│   └── GamePanel.java      # Game logic and rendering
└── README.md
```

## 🔧 Technical Details

### Architecture
- **MVC Pattern**: Clean separation of game logic and UI
- **Event-Driven**: Uses Swing's ActionListener and KeyListener
- **Game Loop**: Timer-based game loop for smooth gameplay

### Key Components

#### `SnakeGame.java`
- Main class that initializes the game
- Creates the GameFrame instance

#### `GameFrame.java`
- Extends JFrame for the game window
- Handles window properties and positioning
- Sets up the game panel

#### `GamePanel.java`
- Core game logic implementation
- Handles rendering, collision detection, and user input
- Manages snake movement and apple spawning
- Implements the game loop using Timer

### Game Mechanics

- **Grid System**: 600x600 pixel grid with 25x25 unit cells
- **Snake Growth**: Body parts increase with each apple eaten
- **Apple Spawning**: Random positioning within grid boundaries
- **Collision Detection**: Checks for wall and self-collision
- **Movement Logic**: Prevents reverse direction movement

## 🎨 Visual Features

- **Grid Lines**: Visual grid for better gameplay orientation
- **Gradient Snake**: Beautiful color gradient from head to tail
- **Apple Design**: Bright red circular apples
- **Score Display**: Real-time score counter
- **Game Over Screen**: Large, clear game over message with final score

## 🛠️ Development

### Built With
- **Java**: Core programming language
- **Swing**: GUI framework for the game interface
- **AWT**: Graphics and event handling

### Dependencies
- No external dependencies required
- Uses only Java standard library

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🤝 Contributing

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📞 Contact

Your Name - [your.email@example.com](mailto:your.email@example.com)

Project Link: [https://github.com/yourusername/snake-game](https://github.com/yourusername/snake-game)

## 🙏 Acknowledgments

- Classic Snake Game concept
- Java Swing framework
- Gaming community for inspiration

---

⭐ If you found this project helpful, please give it a star! 
