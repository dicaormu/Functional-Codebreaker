# Functional-Codebreaker

Codebreaker game solved in java 8 using TDD

## The game

Code breaking is all about finding the secret code.

When the game starts the player should be able to guess the secret code by providing a 4 digits number. 
The game finishes when the player have found the exact match for the secret code.

- The game will return a + sign for an exact match
- The game will return a - sign for a digit match
- An exact match is a digit that matches a digit of the secret code both in value and in position
- A digit match is a digit that matches a digit of the secret code in value but does not have the correct position
- Exact matches have priority over digit matches
- Once a digit has been used for an exact match in the secret code, it can no longer be used for any digit match

If you give-up, you can end the game by entering an empty line

## Prerequisites
JDK 1.8, Maven

## Installation

From your command line, clone the project using

```sh
$ git clone https://github.com/dicaormu/Functional-Codebreaker.git
```

This projet uses maven and you have to compile it

From your command line, in the directory of your project, build it using:

```sh
$ mvn clean compile
```
You can execute the tests by using

```sh
$ mvn test
```

## How it works?
The project contains a class 'fr.com.cb.Match'. This class contains a public method called 'play',which is in charge of receiving:

- A String containing the number to find
- A CustomProcessor which is in charge of provide the 'guess'

This method returns a String with the result (of + and -) of the last guessed number supplied by the CustomProcessor.

### Make it run
1. Create a CustomProcessor, there is one that provides a list in the 'MatchTest' class, and one for the keyBoard in 'fr.com.strategy.KeyBoardProcessor'
2. Create an instance of the class 'fr.com.cb.Match', example:

 ```
   Match match = new Match();
 ```
3. Play to guess a number, p.e '1234':

 ```
match.play("1234", compute)
 ```
   
Unit tests provide example data.
