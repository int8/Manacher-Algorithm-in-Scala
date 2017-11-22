## Manacher Algorithm implementation in Scala


You will find two different scala implementations of [Manacher Algorithm](https://en.wikipedia.org/wiki/Longest_palindromic_substring#Manacher.27s_algorithm) here. The algorithm is utilized for the problem of finding number of all palindrome substrings in given string.


The aformentioned solutions list:

- [imperative implementation](https://github.com/int8/Manacher-Algorithm-in-Scala/blob/master/src/main/scala/solvers/ImperativeLinear.scala) that does not differ much from those found online (with vars, Arrays while loops)

- [functional implementation](https://github.com/int8/Manacher-Algorithm-in-Scala/blob/master/src/main/scala/solvers/FunctionalLinearImmutable.scala)r with immutable data structures (using Vectors, values and tail recursion)


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


Any comments are welcome!
