# Natural-Language-decoder-

Made a natural language decoder using a binary tree in Java. Program will build a binary tree with nodes containing words, based upon strings of (+) and (-) symbols associated with each word.

Suppose we wanted a tree that would allow us to encode and decode words. It might look like this: coming soon... 



word tree
 
With such a tree, the sentence "hello world how are you" would be encoded:


+  -  ++  +-  -+


Requirements for this assignment:
Your project must read two files:

words.txt: contains words and the strings of + and - characters for each word
encoded.txt: a file containing sequences of (+), (-), and (<space>) characters encoding a sentence
## For instance, for the above tree, words.txt would contain:
```
hello +
world -
how ++
are --
you +-
I --
am +++
fine ++-
```

```
encoded.txt might contain:
--  +++  ++-  ++ -- +-
```
which reads: I am fine how are you
