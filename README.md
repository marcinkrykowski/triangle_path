# Minimal path in triangle

## How to run the code
There are a couple of ways doing that. This is pure `sbt` project so you can:
- import it to your IDE and run `Main.scala` using already existing file name or you can put your file in the project root
- run `sbt test` in project root, so you can watch all the tests passing

## Solution description
The solution happens in `Solution.scala` class. I use dynamic programming approach. I start with reversing the triangle, so it is bottom up positioned and later try to solve each row respectively.
In each row I start with looking for the best solutions so far and then I try to go add values from a passed row. At the end I choose the best solution which is the first element of the list.

## Design
The design is pretty simple. The most important part is `Solution.scala` where solving the actual problem happens.
I also used some type aliases and custom exceptions in `package` object. As well as parsing in the `Parser` class.

## Libraries used
I tried to stick to vanilla Scala, so the only libraries I used are `scalatest` and `scalactic`.

## TODO
- [ ] add possibility to pass the file as an argument
- [ ] make solution command line application
