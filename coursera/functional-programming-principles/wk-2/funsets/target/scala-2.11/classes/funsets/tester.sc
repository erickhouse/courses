

type Set = Int => Boolean

/**
  * Indicates whether a set contains a given element.
  */
def contains(s: Set, elem: Int): Boolean = s(elem)

/**
  * Returns the set of the one given element.
  */
def singletonSet(elem: Int): Set = (check) => elem == check

/**
  * Returns the union of the two given sets,
  * the sets of all elements that are in either `s` or `t`.
  */
def union(s: Set, t: Set): Set = (elem) => s(elem) || t(elem)

/**
  * Returns the intersection of the two given sets,
  * the set of all elements that are both in `s` and `t`.
  */
def intersect(s: Set, t: Set): Set = (elem) => s(elem) && t(elem)

/**
  * Returns the difference of the two given sets,
  * the set of all elements of `s` that are not in `t`.
  */
def diff(s: Set, t: Set): Set = (elem) => s(elem) && !t(elem)

/**
  * Returns the subset of `s` for which `p` holds.
  */
def filter(s: Set, p: Int => Boolean): Set = (elem) => intersect(s,p)(elem)


val bound = 1000

/**
  * Returns whether all bounded integers within `s` satisfy `p`.
  */
def forall(s: Set, p: Int => Boolean): Boolean = {
  def iter(a: Int): Boolean = {
    if (a > bound) true
    //else if (diff(s,p)(a)) false
    else if (singletonSet(2)(a)) false
    else iter(bound + 1)
  }
  iter(-bound)
}

singletonSet(3)(3)
singletonSet(3)(3)

val lessthan3: Set = (elem) => elem < 3 && elem > 0
val morethan5: Set = (elem) => elem > 5
val over0: Set = (elem) => elem > 0

intersect(lessthan3, over0)(2)

forall(lessthan3, singletonSet(2))