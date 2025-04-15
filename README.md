# TicTacToe
A Java implementation of the classic Tic-Tac-Toe game featuring an AI opponent powered by the Minimax algorithm. This project allows a human player to compete against an unbeatable computer opponent that makes optimal moves.​

# ✨ **Features**
💻 Single-player mode: Play against an AI that utilizes the Minimax algorithm to determine optimal moves. <br>
🧩 User-friendly interface: Simple interface for easy interaction. <br>

# 🚀 **Getting Started**

## Prerequisites
Java Development Kit (JDK) 8 or higher​

## 📦 Installation
Clone the repository:​ <br>

git clone https://github.com/asparts/TicTacToe.git <br>
cd TicTacToe <br>

Compile the source code:​ <br>
javac -d bin src/tictactoe/*.java <br>

Run the application:​ <br>
java -cp bin tictactoe.Main <br>

# 📁 **Project Structure**

TicTacToe/ <br>
├── src/ <br>
│   └── tictactoe/ <br>
│       ├── Main.java <br>
│       ├── Game.java <br>
│       ├── Board.java <br>
│       └── AI.java <br>
├── bin/ <br>
├── .classpath <br>
├── .project <br>
└── .settings/ <br>

Main.java: Entry point of the application. <br>
Game.java: Handles game flow and user interactions. <br>
Board.java: Represents the game board and related operations. <br>
AI.java: Implements the Minimax algorithm for the AI opponent.​ <br>

# 🧩How to Play
Upon running the application, the game board will be displayed in the console. <br>
Players take turns by entering the number corresponding to the desired cell (1-9). <br>
The AI will respond with its move immediately after the player's turn. <br>
The game continues until there is a winner or a draw.​ <br>

## 📄License
This project is licensed under the MIT License.  <br>
See the LICENSE file for more details.  <br>
