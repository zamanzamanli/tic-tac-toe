# Tic-Tac-Toe Unique Completed States
## Problem Statement
Write a program that plays every possible tic-tac-toe game, starting with an empty board, X always moves first, and players alternate turns.
Count the number of unique, valid, and completed board states:

**Valid:** Can be reached by following the rules of tic-tac-toe (X goes first, alternating turns, no overwriting moves).

**Completed:** Either X wins, O wins, or the board is full (tie).

If two different sequences of moves result in the same final board, count it only once.

## Solution
We simulate all possible games using recursive backtracking:
Use a 3×3 char[][] board (_ means empty).
Place moves recursively for the current player.

After each move:
If the game is over (win or tie), store the board in a Set<String> to avoid duplicates.
Otherwise, switch players and continue recursion.
Backtrack after exploring each move.

We use helper functions to:
Check for a winner (hasWinner).
Check if the board is full (isFull).
Convert boards to/from strings for storage and printing.

## Example Output
```
Number of unique completed states: 958
```

## How to Run
Save the Java file (e.g., TicTacToe.java).
Compile:
```
javac TicTacToe.java
```
Run:
```
java TicTacToe
```

## Limitations
### No early stop for inevitable ties:
While the algorithm stops immediately when a player wins, it does not stop early in situations where the remaining empty spaces cannot possibly produce a win.
In these cases, it will continue to explore all remaining moves until the board is full.

This does not affect correctness as all generated boards are valid final states according to the move sequences explored.
