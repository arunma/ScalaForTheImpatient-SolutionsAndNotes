###Hierarchy

- Value classes cannot be instantiated  - Double, Float, Long, Int, Short, Char, Byte, Boolean, Unit(?)

![Hierarchy](http://www.artima.com/pins1ed/images/scalaHierarchy.jpg)

- for reference types, == is treated as an alias for the equals method

- for reference equality use eq, ne

- Nothing used in special cases when a return type of a method could be a value or an error

**Booster classes**

	String  - StringOps
	Int,Double,Char	- RichInt,RichDouble etc.
	
- Use BigInt, BigDecimal - much convenient that Java by using math operators
- To use a package that starts with scala., you can omit the scala prefix

	 	eg. math.sqrt(2) is the same as scala.math.sqrt(2)
	 	
###Conditional expressions

- if/else construct has a value. 
- `In fact, every expression has a type - the last statement`
- Assignment has a `Unit` value
- `val s= if (x>0) 1 else -1` - `s` can now be a value
- If two branches are different, then their common super type is returned
 	- `if (x>0) "positive" else -1` //returns `Any`
- x=y=1 //No - Assignments have `Unit` value

###Input and Output
- `readLine`, not others (`readInt`, `readDouble`, `readByte` etc) takes a prompt string.

```
val name=readLine("Your name : ")
print ("Your age :")
val age=readInt()
printf ("Hello, %s! Next year, you will be %d. \n", name, age+1)
```

###Loops
- while and do loops are same
- No analog for `for (initialise;test;update)` loops

**for loops**

	```
		 for (i<- 1 to n)		 
			r=r*i
			
	```	
		
-	the `for (i<-expr)` makes the variable i traverse all values of the expression to the right of the `<-`.
	
-	While traversing a string or array, you often need a range from 0 to n-1. In that case, use the `until` method instead of the `to` method.
	
	```
		val s="hello"
		var sum=0
		for (i<-0 until s.length)
			sum+=s(i)
	```
	In this example, there is actually no need to use indexes. You can directly loop over the characters
	
	``` 
		var sum=0
		for (ch<-"hello")
			sum+=ch
	```

-	Scala has no `break` or `continue` statements to break out of a loop.
	-	Use a Boolean control variable instead
	-	Use nested functions - you can return from the middle of a function
	-	Use the `break` method in the `Breaks` object:
	
		```
		import scala.util.control.Breaks._
		breakable{
			for (…){
				if (…) break; //Exits a breakable block
			}
		```
		Here, the control transfer is done by throwing and catching an exception, so you should avoid this mechanism when time is of the essence.
		
**Advanced `for` Loops and `for` comprehensions**

-	You can have multiple `generators` of the form `variable<-expression`. Separate them by semicolons.

	```
	for (i<-1 to 3; j<-1 to 3) print ((10 * i +j) + " ")
	//Prints 11 12 13 21 22 23 31 32 33
	```	
- Each `generator` can have a `guard`, a Boolean condition preceded by `if`

	```
	for (i<-1 to 3; j<-1 to 3 if i!=j) print ((10 * i + j)) + " "
	//Prints 12 13 21 23 31 32
	```
	
	
###Functions

Scala has functions in addition to methods. A method operates on an object, but a function doesn't.  In Java, you have to imitate them with static methods. 

To define a function, you specify the function's name, parameters and body like this:

	def abs(x: Double) = if (x>=0) x else -x
	
-	You must specify the types of all the parameters
-	As long as the function is not recursive, you need not specify the return type
-	Scala compiler determines the return type from the type of the expression to the right of the `=` symbol
-	With a recursive function, you must specify the return type.

```
	def fact(n:Int): Int=if (n<=0) 1 else n * fact(n-1)
```



###Default and Named Arguments###

	def decorate(str:String, left:String="[", right:String="]") =
		left+str+right

If you supply fewer arguments than there are parameters, the **defaults are applied from the `end`**. eg. `decorate("Hello",">>>[")` uses the default value of the right parameter, yielding `">>>[Hello]"`

You can also specify the parameter **names** when you supply the arguments. 

eg. 	`decorate (left="<<<", str="Hello", "right=">>>")`

`Note: The named arguments need not be in the same order as the parameters`

###Variable arguments


```
def sum(args:Int*) ={

	var result=0
	for (arg <- args) result+=arg
	result

}
```

The function receives a single parameter of type `Seq` (Chapter 13)

**Caveats**

-	If the sum function is called with one argument, that must be a single integer, not a range of integers.  The remedy is to tell the compiler that you want the parameter to be considered as an argument sequence.  Append `: _*` like this:

```
	val s=sum (1 to 5) //ERROR
	val s=sum(1 to 5: _*) //Consider 1 to 5 as an argument sequence
```

This call syntax is needed in an recursive definition: 

```
def recursiveSum(args:Int*):Int={

	if (args.length==0) 0
	else args.head + recursiveSum(args.tail :_*)

}

- head of the sequence is the initial element
- tail is a sequence of all other elements. That's again a `Seq` and we have to use :_* to convert it to an argument sequence
```

###Procedures
If the function body is enclosed in braces without a preceding = symbol, then the return type is `Unit`.  Such a function is called a procedure. A procedure returns no value (`no value` or `Unit` to be precise) and you only call it for its side-effect.

###Lazy values

```
	lazy val words=scala.io.Source.fromFile("/usr/dict/words").mkString

```

If the program never accesses words, the file is never opened. 

**Uses**

-	useful to delay costly initialisation statements
-	deals with circular dependencies
-	essential for developing lazy data structures (such as `Streams` - Chapter 13)
-	Lazy values are halfway between `val` and `def`  

```
Compare

	val words=scala.io.Source.fromFile("/user/dict/words").mkString
	//Evaluated as soon as words is defined
	
	lazy val words=scala.io.Source.fromFile("/user/dict/words").mkString
	//Evaluated the first time words is used
	
	def words=scala.io.Source.fromFile("/user/dict/words").mkString
	//Evaluated every time words is used

```

`Laziness is not cost-free.  Every time a lazy value is accessed, a method is called that checks, in a thread safe manner, whether the value has already been initialised`

###Exceptions

- As with Java, the objects that throw need to belong to a subclass of `java.lang.Throwable`.  

- Unlike Java, Scala has no `checked` exceptions.

- a `throw` expression has a special type `Nothing`. This is useful in if/else expressions. If one branch has a `Nothing`, the type of the `if/else` expression is the type of the other branch. 

```
eg. 
	if (x>=0) sqrt(x)
	else throw new IllegalArgumentException("x should not be negative")
	
the first branch has type `Double`, the second type has `Nothing`. Therefore, the if/else expression also has type Double.

```

the syntax for catching exceptions is modelled after the pattern matching syntax (Chapter 14)

```

	try{
		process (new URL("http://horstmann.com/fred-tiny.gif"))
	}
	catch{
		case _: MalformedURLException => println ("bad URL: "+url)
		case ex: IOException => ex.printStackTrace()
	}

```

**Caveats: **

-	As with Java, the more general exception types should come after the more specific ones. 

- 	Note that you can use `_` of the variable name if you don't need it.

-	The `try/finally` statement lets you dispose of a resource whether or not an exception has occured.  	



