package objsets

import TweetReader._

/**
 * A class to represent tweets.
 */
class Tweet(val user: String, val text: String, val retweets: Int) {
  override def toString: String =
    "User: " + user + "\n" +
    "Text: " + text + " [" + retweets + "]"
}

/**
 * This represents a set of objects of type `Tweet` in the form of a binary search
 * tree. Every branch in the tree has two children (two `TweetSet`s). There is an
 * invariant which always holds: for every branch `b`, all elements in the left
 * subtree are smaller than the tweet at `b`. The elements in the right subtree are
 * larger.
 *
 * Note that the above structure requires us to be able to compare two tweets (we
 * need to be able to say which of two tweets is larger, or if they are equal). In
 * this implementation, the equality / order of tweets is based on the tweet's text
 * (see `def incl`). Hence, a `TweetSet` could not contain two tweets with the same
 * text from different users.
 *
 *
 * The advantage of representing sets as binary search trees is that the elements
 * of the set can be found quickly. If you want to learn more you can take a look
 * at the Wikipedia page [1], but this is not necessary in order to solve this
 * assignment.
 *
 * [1] http://en.wikipedia.org/wiki/Binary_search_tree
 */
abstract class TweetSet {

    def filter(p: Tweet => Boolean): TweetSet = filterAcc(p, new Empty)

    def filterAcc(p: Tweet => Boolean, acc: TweetSet): TweetSet

    def union(that: TweetSet): TweetSet = filterAcc((tw) => !that.contains(tw), that)

    def mostRetweeted: Tweet
  
  /**
   * Returns a list containing all tweets of this set, sorted by retweet count
   * in descending order. In other words, the head of the resulting list should
   * have the highest retweet count.
   *
   * Hint: the method `remove` on TweetSet will be very useful.
   * Question: Should we implment this method here, or should it remain abstract
   * and be implemented in the subclasses?
   */
    def descendingByRetweet: TweetList
  
  /**
   * The following methods are already implemented
   */

  /**
   * Returns a new `TweetSet` which contains all elements of this set, and the
   * the new element `tweet` in case it does not already exist in this set.
   *
   * If `this.contains(tweet)`, the current set is returned.
   */
  def incl(tweet: Tweet): TweetSet

  /**
   * Returns a new `TweetSet` which excludes `tweet`.
   */
  def remove(tweet: Tweet): TweetSet

  /**
   * Tests if `tweet` exists in this `TweetSet`.
   */
  def contains(tweet: Tweet): Boolean

  /**
   * This method takes a function and applies it to every element in the set.
   */
  def foreach(f: Tweet => Unit): Unit

  val isEmpty: Boolean
}

class Empty extends TweetSet {

  def descendingByRetweet: TweetList = null

  def mostRetweeted: Tweet = throw new java.util.NoSuchElementException

  def filterAcc(p: Tweet => Boolean, acc: TweetSet): TweetSet = acc

  def contains(tweet: Tweet): Boolean = false

  def incl(tweet: Tweet): TweetSet = new NonEmpty(tweet, new Empty, new Empty)

  def remove(tweet: Tweet): TweetSet = this

  def foreach(f: Tweet => Unit): Unit = ()

  val isEmpty: Boolean = true
}

class NonEmpty(elem: Tweet, left: TweetSet, right: TweetSet) extends TweetSet {

  val isEmpty: Boolean = false

  def filterAcc(p: Tweet => Boolean, acc: TweetSet): TweetSet = {
    val newAcc = if (p(elem)) acc.incl(elem) else acc
    left.filterAcc(p, right.filterAcc(p, newAcc))
  }

  def descendingByRetweet: TweetList = {
    descendingByRetweetHelper(this)
  }

  def descendingByRetweetHelper(curr: TweetSet): TweetList = {
      val head = curr.mostRetweeted
      val tail = curr.remove(head)
      if(!tail.isEmpty) new Cons(head, descendingByRetweetHelper(tail))
      else new Cons(head, Nil)
  }

  def mostRetweeted: Tweet = {
    mostRetweetedHelper(this)
  }

  private def mostRetweetedHelper(curr: TweetSet): Tweet ={

    if(left.isEmpty && right.isEmpty) elem
    else if(!left.isEmpty && right.isEmpty) {
      val leftTw = left.mostRetweeted
      if(elem.retweets > leftTw.retweets) elem
      else leftTw
    }
    else if(left.isEmpty && !right.isEmpty){
      val rightTw = right.mostRetweeted
      if(elem.retweets > rightTw.retweets) elem
      else rightTw
    }
    else {
      val leftTw = left.mostRetweeted
      val rightTw = right.mostRetweeted

      if(elem.retweets > leftTw.retweets && elem.retweets > rightTw.retweets) elem
      else if(leftTw.retweets > rightTw.retweets) leftTw
      else rightTw
    }
  }

  def contains(x: Tweet): Boolean =
    if (x.text < elem.text) left.contains(x)
    else if (elem.text < x.text) right.contains(x)
    else true

  def incl(x: Tweet): TweetSet = {
    if (x.text < elem.text) new NonEmpty(elem, left.incl(x), right)
    else if (elem.text < x.text) new NonEmpty(elem, left, right.incl(x))
    else this
  }

  def remove(tw: Tweet): TweetSet =
    if (tw.text < elem.text) new NonEmpty(elem, left.remove(tw), right)
    else if (elem.text < tw.text) new NonEmpty(elem, left, right.remove(tw))
    else left.union(right)

  def foreach(f: Tweet => Unit): Unit = {
    f(elem)
    left.foreach(f)
    right.foreach(f)
  }
}

trait TweetList {
  def head: Tweet
  def tail: TweetList
  def isEmpty: Boolean
  def foreach(f: Tweet => Unit): Unit =
    if (!isEmpty) {
      f(head)
      tail.foreach(f)
    }
}

object Nil extends TweetList {
  def head = throw new java.util.NoSuchElementException("head of EmptyList")
  def tail = throw new java.util.NoSuchElementException("tail of EmptyList")
  def isEmpty = true
}

class Cons(val head: Tweet, val tail: TweetList) extends TweetList {
  def isEmpty = false
}


object GoogleVsApple {
    val google = List("android", "Android", "galaxy", "Galaxy", "nexus", "Nexus")
    val apple = List("ios", "iOS", "iphone", "iPhone", "ipad", "iPad")

    lazy val googleTweets: TweetSet = TweetReader.allTweets.filter((tweet) => google.exists(tweet.text.contains))
    lazy val appleTweets: TweetSet = TweetReader.allTweets.filter((tweet) => apple.exists(tweet.text.contains))

  /**
   * A list of all tweets mentioning a keyword from either apple or google,
   * sorted by the number of retweets.
   */
     lazy val trending: TweetList = googleTweets.union(appleTweets).descendingByRetweet
  }

object Main extends App {
  // Print the trending tweets
  GoogleVsApple.trending foreach println
}
