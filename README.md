## Manacher Algorithm implementation in Scala


You will find two different scala implementations of [Manacher Algorithm](https://en.wikipedia.org/wiki/Longest_palindromic_substring#Manacher.27s_algorithm) here. The algorithm is utilized for the problem of finding number of all palindrome substrings in given string.


The aformentioned solutions list:

- [imperative implementation](https://github.com/int8/Manacher-Algorithm-in-Scala/blob/master/src/main/scala/solvers/ImperativeLinear.scala) that does not differ much from those found online (with vars, Arrays while loops)

- [functional implementation](https://github.com/int8/Manacher-Algorithm-in-Scala/blob/master/src/main/scala/solvers/FunctionalLinearImmutable.scala) with immutable data structures (using Vectors, values and tail recursion)


There is also [quadratic solution](https://github.com/int8/Manacher-Algorithm-in-Scala/blob/master/src/main/scala/solvers/Quadratic.scala) added as a sanity check  



Interestingly, functional implementation suffers from Vectors' operators overheads. As a result for some very random sequences quadratic may outperform linear solution (especially when there is very small number of short palindromes in a string).

Let's try to explain why:

[Functional implementation](https://github.com/int8/Manacher-Algorithm-in-Scala/blob/master/src/main/scala/solvers/FunctionalLinearImmutable.scala) uses Vector to store centers and palindromes radiuses at these centers. Assuming ```K``` being maximum length of a palindrome and ```N``` being size of the input sentence and ```k << N```, interesting thing happens:

At the very end of palindrome search when we reach index close to ```N```, if palindromes are short - we are going to request very recent indices (non siginificantly lower than ```N```), therefore each lookup for a mirror palindrome length (```minLength```) within main palindrome has complexity ```~ log32(N)```. Moreover each palindrome search involves several lookups. Anyways, we get quite a few lookups at each center of complexity ```~log32(N)```. For some pairs ```(N,K)``` it may result in complexity worse than naive quadratic. For a pair: ```N = 10^6``` (```log32(10^6) =~ 4```), ```K = 4``` (such ```K``` happens sometimes when you randomly choose input sentence from 24 chars), at each iteration (center) everytime we request mirror value (+values while expanding palindrome) we in fact perform ```~4``` operations instead of one. This overhead is critical and leads to quadratic solution being better. I think, it's therefore safe net to claim that functional linear solution wins whenever there is lots of palindromes + they are much longer than ```log32(N```).



To run main app
```
sbt run
```

To run tests
```
sbt test
```


To generate (still poor) documentation with scaladocs
```
sbt doc
```



Any comments are welcome!
