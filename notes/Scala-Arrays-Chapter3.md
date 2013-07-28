##Arrays

###Fixed Length Arrays

**Don't' use `new` when supplying initial values**

```
val nums=new Array[Int](3)     //> nums  : Array[Int] = Array(0, 0, 0)
val strs=new Array[String](3)  //> strs  : Array[String] = Array(null, null, null)
  
val s=Array("Hello", "World")  //> s  : Array[String] = Array(Hello, World)
s(0)="Goodbye"
s                              //> res0: Array[String] = Array(Goodbye, World)
 
 

```
###Variable Length Arrays
```
  var buff=ArrayBuffer(1,1,11,1,3,11)             
  var buff2=new ArrayBuffer[Int]()                
  
  buff+=121                                       
  buff2+=(123)                                    
  val a=Array("Super","mama")   
  
  //Convert Array to ArrayBuffer and back                  
  val array=a.toArray                           
  val abuffer=array.toBuffer     
                   
```

###Looping in reverse

```
 for (i<-(0 until buff.length).reverse){
  
  	println (buff(i))
  }
```

###Transforming Arrays aka for(…) yield

The `for(…) yield` loop creates a new collection of the same type as the original collection. If you started with an array, you'll get an array.  If you started with an array buffer, it returns an array buffer.

The result contains the expressions after the yield, one for each iteration of the loop.

**Conditional Transformation**

You wanted to process the elements that matches a particular condition.  This is achieved with a guard: an `if` inside the `for`. 

(Double every even element, dropping the odd ones)

`Functional way - prefer map and filter over guards (if) and yield`

```

  for (i<-0 until 10 if i%2==0) yield 2*i
  
  val myarr=Array(1,2,3,4,5,6,7)
  

  
  myarr.filter(_ %2 ==0).map(_ *2)
  
  
```

###Common Algorithms
 
 ```
 val myarr=ArrayBuffer(1,2,3,-4,5,-6,7)
 
 val sum=Array(1,2,3,4,5).sum
 val max=Array(1,2,3,4,5).max
 
  
 val sorted=myarr.sortWith(_ < _)
 val sorted1=myarr.sorted
 var tempArray=myarr.toArray;
 quickSort(tempArray)
 //TempArray is sorted in place
  
  
  

```

###ToString
```
tempArray.mkString(":")              //> res6: String = -4:1:2:3:5:7
tempArray.mkString("<",":",">")      //> res7: String = <-4:1:2:3:5:7>
tempArray.toString()                 //> res8: String = [I@27b15692
```
###Reading the scaladoc
Pg 35 of Scala for the Impatient

```
def count(p: (A) => Boolean) :Int

```
This method takes a predicate, a function from A to Boolean. It counts for how many elements the function is true. For example, `a.count(_ > 0)` counts how many elements of `a` are positive.

```
def += (elem:A): ArrayBuffer.this.type

elem:A = Parameter
ArrayBuffer.this.type= return type
```

This method returns `this` which allows you to chain calls, for example: b+=4 -=3

When you work with an ArrayBuffer[A], you can just think of the method as

`def+= (elem:A):ArrayBuffer(A)`

If someone forms a subclass of `ArrayBuffer`, then the return type of += is that subclass




