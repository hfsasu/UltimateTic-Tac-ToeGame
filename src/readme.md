* Hafsa Alaparmak
* CS2336.001
* 11/28/2022


Analysis
* In this program I am creating an ULTIMATE TIC TAC TOE Game.
* I am using some of the code that has been previously used 
in the Tic Tac Toe class activities
* In ultimate Tic Tac Toe I create Tic Tac Toe boards inside the 
Tic Tac Toe board. In order to have a winner in the game,
the winner needs to win 3 of the smaller boards, and then 
they also have to win the game from the bigger Tic Tac Toe board
  (One big board that has small tic tac to board every box)

Design
- Ask user to select a game modality using if else statements
(AI vs AI, AI vs Human, Human vs Human
- Start game message
- Computer vs Computer game plays itself, if Human plays, it will ask for 
the first player to pick a board to play and then pick a row and col to 
place their respective marks. 
- The Board checks if box is available, and if so, place mark, 
otherwise repeats the steps and asks for another input for row and col
- After one player's turn, Print all the board(9 of them)
- Repeat the steps for other player until one player wins or the board is full


Why Object-Oriented Programming
- provides a clear structure for the programs
- Code Don't Repeat
- Reuses codes


My Assumptions for the program
- Whenever there is a wrongly entered value for row and col like out of bound number,
the program asks the prompt again until there is a valid data
- If there is a char mistakenly entered, program should give the
prompt again to reenter values
- If the entered row and col is already full, program should give the
- prompt again to reenter values
- If a player send a player to a board that is already full,
the next player gets to choose any board that they want to play in
since the board they got send is full
- Whenever the board has a winner, rest of the empty spots are being replaced by *


To Test My code
- I played with all the game modalities and made sure I can
get an X winner, O winner, and a Tie for all different types of game
- I made sure x and o are switching in correct order
- I played with Human vs Human and I entered my own values
to test what happens if a board becomes full
- I chose board 0 and for x entered for row and col
00
- In O'S turn, entered 00 again
- Then everytime x's turn I entered 00(to send O back to 0th board)
- In O's turn 01, 02, 10, 11, 12, 20, 21, 22
- This way the board 0 looked liked
XOO
000
000

This board got full, X sent O back to 0th board once more,
then my game asked O to pick a new board to play. 


One thing I would add to my code would be when there is a winner on a board,
I would give more details about which board the winner is from. I would print a summary
at the end of the game too
Lastly I would add a print statement which rows and cols the computer player 
choose to play in just to make it easier to see.







