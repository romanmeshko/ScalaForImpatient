import scala.collection.mutable.ArrayBuffer
import scala.util.Random

// ex.3.1
val nums = new Array[Int](10)
for (i <- nums.indices) nums(i) = Random.nextInt()
nums.foreach(System.out.print)

// ex.3.2
def swapAdj(arr: Array[Int]) = {
  var temp = 0
  for (i <- 0 until arr.length - 1 by 2) {
    temp = arr(i)
    arr(i) = arr(i+1)
    arr(i+1) = temp
  }
  arr
}
println(swapAdj(Array(1,2,3,4,5)).toList)

// ex.3.3
def swapAdjYeild(arr: Array[Int]) = {
  for (i <- arr.indices) yield
    if (i == arr.length - 1 && i % 2 == 0) arr(i)
    else if (i % 2 == 0) arr(i + 1)
    else arr(i - 1)
}
val b = Array(1,2,3,4,5)
println(swapAdjYeild(b))

// ex.3.4
def ex4(arr: Array[Int]) = {
  val result = new ArrayBuffer[Int]()
  for (i <- arr if i > 0) result += i
  for (i <- arr if i <= 0) result += i
  result
}
println(ex4(Array(2,1,-5,4,-8,0,0,5)))

// ex.3.5
def avg(array: Array[Double]) = {
  array.sum / array.length
}
avg(Array(2,1,5,4,8,2,1,76))

// ex.3.6
Array(1,2,3).toBuffer.reverse

// ex.3.7
val testArr = Array(2,1,5,4,8,2,1,76)
println(testArr.distinct.toList)

// ex.3.8
def removeAllButFirstNeg(a: ArrayBuffer[Int]) = {
  var first = true
  var n = a.length
  var i = 0
  while (i < n) {
    if (a(i) >= 0) i += 1
    else {
      if (first) {
        first = false; i += 1
      }
      else {
        a.remove(i); n -= 1
      }
    }
  }
  a
}
println(removeAllButFirstNeg(ArrayBuffer(2,1,-5,4,-8,0,0,5)))

def removeAllButFirstNeg2(a: ArrayBuffer[Int]) = {
  var first = true
  val indexes = for (i <- 0 until a.length if first || a(i) >= 0) yield {
    if (a(i) < 0) first = false; i
  }
  for (j <- 0 until indexes.length) a(j) = a(indexes(j))
  a.trimEnd(a.length - indexes.length)
  a
}
println(removeAllButFirstNeg2(ArrayBuffer(2,1,-5,4,-8,0,0,5)))


def removeAllBut1stNeg3(a: ArrayBuffer[Int]) = {
  var first = true
  val indexes = for (i <- 0 until a.length if a(i) < 0)
    yield i
  for (j <- indexes.reverse.init)
    a.remove(j)
  a
}
println(removeAllBut1stNeg3(ArrayBuffer(2,1,-5,4,-8,0,-9,5,1)))

// ex.3.9
def ex3_9() = {
  java.util.TimeZone.getAvailableIDs
    .filter(s => s.contains("America"))
    .transform(s => s.stripPrefix("America/"))
    .sorted
}

// ex.3.10
def ex3_10() = {
  import java.awt.datatransfer._
  val flavors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]
  flavors.getNativesForFlavor(DataFlavor.imageFlavor).toArray.toBuffer
}

val oneL = List(1,2,3);
