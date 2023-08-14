# UltimateTic-Tac-ToeGame
Hafsa Alaparmak| 11/28/2022

## Introduction

Welcome to the Ultimate Tic Tac Toe Game! This project is an implementation of the classic Tic Tac Toe game with an exciting twist. Players compete in smaller Tic Tac Toe boards, aiming to win three of these smaller boards and secure victory in the overall game.

## Analysis

In this program, I have created an Ultimate Tic Tac Toe game by utilizing and building upon the code from previous Tic Tac Toe class activities. The game is designed with nested Tic Tac Toe boards, where players aim to win smaller boards and subsequently win the larger Tic Tac Toe game.

## Design

### Game Modalities

Players can choose from various game modes, including:
- AI vs AI
- AI vs Human
- Human vs Human

### Gameplay Flow

The game follows these steps:
1. Start game message is displayed.
2. If AI is playing, the game simulates AI vs AI.
3. If a Human is playing, the first player picks a board and then a row and column to place their mark.
4. The program validates the move's availability and prompts for a different input if necessary.
5. The board state is displayed after each move.
6. Gameplay continues until a player wins or the board is full.

## Object-Oriented Programming

Object-Oriented Programming principles were used to structure the program effectively, promoting code reusability and maintainability.

## Assumptions

I made several assumptions for the program's behavior to enhance the user experience:
- Handling of wrongly entered values for rows and columns.
- Handling of non-numeric inputs for rows and columns.
- Handling of attempts to play in an already filled box.
- Handling of sending a player to a full board.
- Replacement of empty spots with "*" after a board has a winner.

## Testing

I thoroughly tested my code by:
- Playing all game modalities to ensure X wins, O wins, and ties are correctly identified.
- Ensuring the alternating order of X and O turns.
- Testing Human vs Human interactions with various inputs.
- Validating player movements in edge cases.

## Future Improvements

One improvement I would add is providing additional details about which board the winner is from when there is a winner. Additionally, I would include a game summary at the end of each match. Lastly, I would enhance the program by displaying the rows and columns chosen by the computer player to make tracking easier.
