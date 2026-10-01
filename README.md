# Turdle 🐢

Turdle is a small Java Swing word game with a turtle theme and two ways to play: find the hidden word (wordle), or try your best to avoid it (absurdle).

## Features

- **Wordle:** Guess the five-letter word in six tries.
- **Absurdle:** Make it through six valid guesses without finding the word. Guess it, and you lose!
- **Color feedback:** Green in Wordle (red in Absurdle) means the right letter in the right spot. Yellow means the letter belongs elsewhere, and gray means no matching letter remains.
- **Hints that carry over:** Keep confirmed letters in place and reuse revealed yellow letters. Absurdle also adds a restriction on reusing gray letters.

## Class diagram

This is Turdle’s class diagram, showing the classes and how they connect.

![Turdle class diagram](Turdle%20Class%20Diagram.png)

## Run it

With a JDK installed, run these commands from the repository folder:
```
    javac *.java
    java Turdle
```
Keep `WordList.txt` and the PNG assets in that folder so the game can load them. 🐢
