# Adventure Game

## Description

**English:**
The Adventure Game is a text-based adventure game where players navigate through rooms, solve puzzles, and collect items. The game is developed in Java, and players interact through a console-based interface. The game mechanics include room transitions, object inspection, and puzzle solving. Player progress is saved and loaded using Java File I/O.

## Features

**English:**
- **Room Navigation**: Move between different rooms.
- **Puzzle Solving**: Solve puzzles to progress.
- **Item Collection**: Collect items and manage inventory.
- **Save and Load**: Save and load game progress.

## Requirements

**English:**
- Java JDK 17 or later
- Git

## How to Use

**English:**
1. Download or clone the project to your computer.
2. Ensure Java JDK is installed on your computer. If not, download and install it from [Oracle's official website](https://www.oracle.com/java/technologies/javase-downloads.html).
3. Open the project in a Java IDE (Integrated Development Environment).
4. Open the `AdventureGame.java` file.
5. Run the `main` method in the `AdventureGame` class to start the game.
6. Follow the on-screen instructions to navigate through rooms and solve puzzles.

## Additional Features

**English:**
1. **Special Rewards**: After clearing all enemies in a combat area, the player receives a special reward. The player wins the game if they collect all rewards and return to the "Safe Home". Once a reward is collected, the area cannot be re-entered.
   - **Rewards**:
     - Cave => Food
     - Forest => Firewood
     - River => Water
2. **Combat Mechanics**: When encountering a monster, the first attack is determined by a 50% chance.
3. **New Combat Area**: A new area called "Mine" is added where defeated enemies drop random money, weapons, or armor.
   - **Area**: Mine
   - **Monster**: Snake (1-5)
   - **Features**: Combat and Loot
   - **Items**: Money, Weapons, or Armor

