
## for Expressions

Often refered to as generators. For expressions simply get compiled into the coorisponding data structure. 

- Map
- FlatMap
- withFilter

these 3 functions make up all of the for expressions. If you have a class that implemens these functions then they can be used with
for loops. 

## Monads (aka binders)

One of the most abstract things I've learned in CS. I can still hardly describe them. In my own words:

- They are loosley related to category theory in math. 
- Category theory is the concept of object and arrows to those objects. Arrows have a fairly abstract meaning and can be lots of different things.

A monad has a couple of specific properties in order for it to actually be a monad
- Implements `map, flatMap, and unit/bind`
- These 3 functions are associative (can be applied in any order)
- Map basically says I have type A convert it to type be `A -> B` by some function F

Each monad is unique and does something different with the implementation of map, flatMap, and unit

- collections are technically monads (I guess)

There is some strange concept of binding that I don't understand. A general use case for monads is handling state.
It also can be used to implement Try/Catch type mechanics. 

People who try and describe monads sometimes relate it to describing color (really difficult unless you already know what it is)

A Scala Future is a type of monad. 

## Streams

Scala streams are almost exactly like list except each value is only evaluated when called. If it is never called then the value will never be calculated.

- Lists and Streams are built using trees
- Streams use **Call by name** in a recurive manner so then next value is never run until called. Streams also use lazy evaluation to make
sure that if a stream is called on twice, the values are not generated twice. 

- `val` is evaluated instantly
- `lazy` val is evaluated after the first time it is called, but never after
- `def` is evaluated each time it is called
