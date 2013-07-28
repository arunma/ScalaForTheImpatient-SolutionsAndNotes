##Maps

- Default HashMap, also can get a tree map
- Default mutable map, immutable map through `scala.collection.mutable.Map` or `scala.collection.mutable.HashMap` (if you prefer the direct implementation)
- Operator `->` maps key to values

###Construction

```
val scores=Map("Arun" ->10, "Jason"->100, "Daisy"->50)

val scoresMutable=scala.collection.mutable.Map("Arun" ->10, "Jason"->100, "Daisy"->50)

val scoresMutableHashMap=scala.collection.mutable.HashMap("Arun"->10,"Jason"->100,"Daisy"->50)
	
val scoresMutableHMVariant=scala.collection.mutable.HashMap(("Arun",10),("Jason",100),("Daisy",50))

```

###Getting values from Map

```
	scores("Arun")
	
	scores.getOrElse("Arun", 0)
	//scores("Aruna")   //NoSuchElementException
 	scores.get("Aruna") //Returns None
	scores.getOrElse("Aruna", 0)
```

###Updating a map
```
	scoresMutable("Jason")=200
	scoresMutable("Aruna")=20
	scoresMutable+=("Super"->90,"Awesome"->23)
	scoresMutable
```

###Removing key and value
```
scoresMutable-="Aruna"
```

###Iterating through map

```
	
	for ((k,v) <- scores) println (k, v)
	
	//KeySet
	val keySet=scores.keySet  //ImmutableSet
	val values=scores.values   //return type Iterable
	
```	
	
###Inverse key and value

	for ((k,v)<-scores) yield (v,k)

###SortedMap - Balanced Trees

SortedMap has no mutable variants - Have to use java.util TreeMap if needed

```
scala.collection.immutable.SortedMap("Jason"->2423,"Arun"->22,"Daisy"->23232)
	
//for insertion order
scala.collection.mutable.LinkedHashMap("Jason"->2423,"Arun"->22,"Daisy"->23232)

```

###Interoperating with Java
//FROM JAVA

```
import scala.collection.JavaConversions.mapAsScalaMap
import scala.collection.JavaConversions.propertiesAsScalaMap
import scala.collection.JavaConversions.mapAsJavaMap

val sortedJavaMap:scala.collection.mutable.Map[String,Int]=new java.util.TreeMap[String,Int]
                                                  
val propertyMap:scala.collection.mutable.Map[String,String]=System.getProperties()
                                                  
//TO JAVA
val attrs=Map(FAMILY->"Serif", SIZE->12)
val font=new java.awt.Font(attrs)

```

###Tuples
	val tup=(1,3.14,"Fred")
	//Access
	tup._1 
	
###Zip
```
	val symbols=Array("<","-",">")
	val counts=Array(2,10,2)
	
	val names=Array("Arun","Daisy","Jason")
	val marks=Array("10","20","100")
	
	val zippedArray=symbols.zip(counts)
```

**Iterate as Tuple Array**

	for ((symbol,count)<-zippedArray) print (symbol *count)
	
**Convert to Map**

	val nameMark=names.zip(marks).toMap
	