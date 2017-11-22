## Manacher Algorithm implementation in Scala


In this repository, you can find two different scala implementations of Manacher Algorithm. The algorithm is utilized for the problem of finding number of all palindrome substrings in given string. 

Please be gentle, this is my first scala code ever and it may not be optimal, any comments are welcome!


The aformentioned solutions list:

- imperative implementation that does not differ much from those found online (with vars, Arrays while loops)

- functional implementation with immutable data structures (using Vectors, values and tail recursion)


There is also quadratic solution added as a sanity check.   



Interestingly, functional implementation suffers from Vectors' operators overheads. As a result for some very random sequences quadratic may outperform linear solution (especially when there is very small number of palindromes in a string)


To run main app
```
sbt run
```

To run tests
```
sbt test
```
