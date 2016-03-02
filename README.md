# Difference lists

List-like data structures for Clojure with O(1) concatenation.
[![Clojars Project](https://img.shields.io/clojars/v/dlist.svg)](https://clojars.org/dlist)

## Usage

```clojure
(require '[dlist.core :as d])
(def xs (d/list [1 2 3]))
(def ys (d/list [4 5 6]))
(= [1 2 3 4 5 6]
   (seq (d/concat xs ys)))
```

Note that `seq` on dlists is O(n).
`seq` on long dlists is very likely to blow up the stack.

## See also

 - Hughes, John. _A novel representation of lists and its application to the
   function “reverse”_. 1986.
   [PDF](http://www.cs.tufts.edu/~nr/cs257/archive/john-hughes/lists.pdf)
 - [Difference lists in Haskell](https://github.com/spl/dlist)

## License

Copyright © 2015 Jan Stępień

Permission is hereby granted, free of charge, to any person
obtaining a copy of this software and associated documentation
files (the "Software"), to deal in the Software without
restriction, including without limitation the rights to use,
copy, modify, merge, publish, distribute, sublicense, and/or
sell copies of the Software, and to permit persons to whom the
Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included
in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
DEALINGS IN THE SOFTWARE.
