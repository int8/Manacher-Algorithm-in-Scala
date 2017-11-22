## Manacher Algorithm implementation in Scala


You will find two different scala implementations of Manacher Algorithm here. The algorithm is utilized for the problem of finding number of all palindrome substrings in given string.

Please be gentle, this is my first scala code ever and it may not be optimal, any comments are welcome!


The aformentioned solutions list:

- [imperative implementation](https://github.com/int8/Manacher-Algorithm-in-Scala/blob/master/src/main/scala/solvers/ImperativeLinear.scala) that does not differ much from those found online (with vars, Arrays while loops)

- [functional implementation](https://github.com/int8/Manacher-Algorithm-in-Scala/blob/master/src/main/scala/solvers/FunctionalLinearImmutable.scala) with immutable data structures (using Vectors, values and tail recursion)


There is also [quadratic solution](https://github.com/int8/Manacher-Algorithm-in-Scala/blob/master/src/main/scala/solvers/Quadratic.scala) added as a sanity check  



Interestingly, functional implementation suffers from Vectors' operators overheads. As a result for some very random sequences quadratic may outperform linear solution (especially when there is very small number of palindromes in a string)


To run main app
```
sbt run
```

To run tests
```
sbt test
```
