import scala.collection.JavaConversions.mapAsScalaMap
import scala.collection.JavaConversions.propertiesAsScalaMap
import scala.collection.JavaConversions.mapAsJavaMap
import java.awt.font.TextAttribute._
import scala.collection.mutable.Map
import scala.collection.immutable.SortedMap
import scala.collection.mutable.LinkedHashMap
import java.util.Calendar._

object Chapter4 {

	//Construction
	val scores=Map("Arun" ->10, "Jason"->100, "Daisy"->50)
                                                  //> scores  : scala.collection.mutable.Map[String,Int] = Map(Daisy -> 50, Arun -
                                                  //| > 10, Jason -> 100)
	val scoresMutable=scala.collection.mutable.Map("Arun" ->10, "Jason"->100, "Daisy"->50)
                                                  //> scoresMutable  : scala.collection.mutable.Map[String,Int] = Map(Daisy -> 50,
                                                  //|  Arun -> 10, Jason -> 100)
	val scoresMutableHashMap=scala.collection.mutable.HashMap("Arun"->10,"Jason"->100,"Daisy"->50)
                                                  //> scoresMutableHashMap  : scala.collection.mutable.HashMap[String,Int] = Map(D
                                                  //| aisy -> 50, Arun -> 10, Jason -> 100)
	
	val scoresMutableHMVariant=scala.collection.mutable.HashMap(("Arun",10),("Jason",100),("Daisy",50))
                                                  //> scoresMutableHMVariant  : scala.collection.mutable.HashMap[String,Int] = Map
                                                  //| (Daisy -> 50, Arun -> 10, Jason -> 100)
  //Getting values from Map
	scores("Arun")                            //> res0: Int = 10
	
	scores.getOrElse("Arun", 0)               //> res1: Int = 10
	//scores("Aruna")   //NoSuchElementException
 	scores.get("Aruna") //Returns None        //> res2: Option[Int] = None
	scores.getOrElse("Aruna", 0)              //> res3: Int = 0
	
	//Updating a map
	scoresMutable("Jason")=200
	scoresMutable("Aruna")=20
	scoresMutable+=("Super"->90,"Awesome"->23)//> res4: Chapter4.scoresMutable.type = Map(Awesome -> 23, Super -> 90, Daisy -
                                                  //| > 50, Arun -> 10, Aruna -> 20, Jason -> 200)
	scoresMutable                             //> res5: scala.collection.mutable.Map[String,Int] = Map(Awesome -> 23, Super -
                                                  //| > 90, Daisy -> 50, Arun -> 10, Aruna -> 20, Jason -> 200)
  //Removing key and value
  scoresMutable-="Aruna"                          //> res6: Chapter4.scoresMutable.type = Map(Awesome -> 23, Super -> 90, Daisy -
                                                  //| > 50, Arun -> 10, Jason -> 200)

	//Iterating through map
	
	for ((k,v) <- scores) println (k, v)      //> (Daisy,50)
                                                  //| (Arun,10)
                                                  //| (Jason,100)
	
	//KeySet
	val keySet=scores.keySet  //ImmutableSet  //> keySet  : scala.collection.Set[String] = Set(Daisy, Arun, Jason)
	val values=scores.values   //return type Iterable
                                                  //> values  : Iterable[Int] = HashMap(50, 10, 100)
	
	
	
	//Inverse key and value
	for ((k,v)<-scores) yield (v,k)           //> res7: scala.collection.mutable.Map[Int,String] = Map(50 -> Daisy, 100 -> Ja
                                                  //| son, 10 -> Arun)
                                                  
                                                  
	//SortedMap - Balanced Trees
	//SortedMap has no mutable variants - Have to use java.util TreeMap if needed
	scala.collection.immutable.SortedMap("Jason"->2423,"Arun"->22,"Daisy"->23232)
                                                  //> res8: scala.collection.immutable.SortedMap[String,Int] = Map(Arun -> 22, Da
                                                  //| isy -> 23232, Jason -> 2423)
	
	//for insertion order
	scala.collection.mutable.LinkedHashMap("Jason"->2423,"Arun"->22,"Daisy"->23232)
                                                  //> res9: scala.collection.mutable.LinkedHashMap[String,Int] = Map(Jason -> 242
                                                  //| 3, Arun -> 22, Daisy -> 23232)

	//Interoperating with Java
	//FROM JAVA
	//scala.collection.JavaConversions.mapAsScalaMap
	val sortedJavaMap:scala.collection.mutable.Map[String,Int]=new java.util.TreeMap[String,Int]
                                                  //> sortedJavaMap  : scala.collection.mutable.Map[String,Int] = Map()
                                                  
	//val propertyMap:scala.collection.mutable.Map[String,String]=System.getProperties()
                                                  
	//TO JAVA
	//val attrs=Map(FAMILY->"Serif", SIZE->12)
	//val font=new java.awt.Font(attrs)
                   
	//TUPLE
	val tup=(1,3.14,"Fred")                   //> tup  : (Int, Double, String) = (1,3.14,Fred)
	//Access
	tup._1                                    //> res10: Int = 1
	
	//Pattern matching
	val (number,duble,str)=tup                //> number  : Int = 1
                                                  //| duble  : Double = 3.14
                                                  //| str  : String = Fred
	//If you are not interested in the double value
	val (num,_,stri)=tup                      //> num  : Int = 1
                                                  //| stri  : String = Fred
	
	//Zip
	val symbols=Array("<","-",">")            //> symbols  : Array[String] = Array(<, -, >)
	val counts=Array(2,10,2)                  //> counts  : Array[Int] = Array(2, 10, 2)
	
	val names=Array("Arun","Daisy","Jason")   //> names  : Array[String] = Array(Arun, Daisy, Jason)
	val marks=Array("10","20","100")          //> marks  : Array[String] = Array(10, 20, 100)
	
	val zippedArray=symbols.zip(counts)       //> zippedArray  : Array[(String, Int)] = Array((<,2), (-,10), (>,2))
	
	//Iterate as Tuple Array
	for ((symbol,count)<-zippedArray) print (symbol *count)
                                                  //> <<---------->>
	//Convert to Map
	val nameMark=names.zip(marks).toMap       //> nameMark  : scala.collection.immutable.Map[String,String] = Map(Arun -> 10,
                                                  //|  Daisy -> 20, Jason -> 100)
                              
	//EXERCISES
	//1.
	val gizmos:Map[String,Double]=Map("Samsung Galaxy S4 Zoom"-> 1000, "Mac Pro"-> 6000.10, "Google Glass"->2000)
                                                  //> gizmos  : scala.collection.mutable.Map[String,Double] = Map(Samsung Galaxy 
                                                  //| S4 Zoom -> 1000.0, Google Glass -> 2000.0, Mac Pro -> 6000.1)
  val discountedGizmos=(for ((k,v)<-gizmos) yield (k, v*0.9))
                                                  //> discountedGizmos  : scala.collection.mutable.Map[String,Double] = Map(Samsu
                                                  //| ng Galaxy S4 Zoom -> 900.0, Google Glass -> 1800.0, Mac Pro -> 5400.09)
  //Variation using mapValues
  val discGizmos1=gizmos.mapValues(_*0.9)         //> discGizmos1  : scala.collection.Map[String,Double] = Map(Samsung Galaxy S4 
                                                  //| Zoom -> 900.0, Google Glass -> 1800.0, Mac Pro -> 5400.09)
  
  //Variation using only map function
  //val discGizmos2=gizmos.map((_,v) =>v*0.9)
  
	//2.
  val countMap=Map[String,Int]()                  //> countMap  : scala.collection.mutable.Map[String,Int] = Map()
	val in=new java.util.Scanner(new java.io.File("/Users/Gabriel/localprojects/ImpatientScala/myfile.txt"))
                                                  //> in  : java.util.Scanner = java.util.Scanner[delimiters=\p{javaWhitespace}+]
                                                  //| [position=0][match valid=false][need input=false][source closed=false][skip
                                                  //| ped=false][group separator=\,][decimal separator=\.][positive prefix=][nega
                                                  //| tive prefix=\Q-\E][positive suffix=][negative suffix=][NaN string=\Q?\E][in
                                                  //| finity string=\Q°\E]
	while (in.hasNext()) {
	
		val currentKey=in.next
		countMap.getOrElseUpdate(currentKey,0)
		countMap(currentKey)+=1
	
	
	}
	println (countMap)                        //> Map(wonderful -> 1, boy -> 1, ma -> 1, whatever -> 1, super -> 2, hello -> 
                                                  //| 3)
	//Nice variation
	val countMap1=Map[String,Int]() withDefaultValue(0)
                                                  //> countMap1  : scala.collection.mutable.Map[String,Int] = Map()
	val in1=new java.util.Scanner(new java.io.File("/Users/Gabriel/localprojects/ImpatientScala/myfile.txt"))
                                                  //> in1  : java.util.Scanner = java.util.Scanner[delimiters=\p{javaWhitespace}+
                                                  //| ][position=0][match valid=false][need input=false][source closed=false][ski
                                                  //| pped=false][group separator=\,][decimal separator=\.][positive prefix=][neg
                                                  //| ative prefix=\Q-\E][positive suffix=][negative suffix=][NaN string=\Q?\E][i
                                                  //| nfinity string=\Q°\E]
	while (in1.hasNext()) countMap1(in1.next)+=1
	println (countMap1)                       //> Map(wonderful -> 1, boy -> 1, ma -> 1, whatever -> 1, super -> 2, hello -> 
                                                  //| 3)
	//3. With Immutable Map
  var countMap3=Map[String,Int]() withDefaultValue(0)
                                                  //> countMap3  : scala.collection.mutable.Map[String,Int] = Map()
	val in3=new java.util.Scanner(new java.io.File("/Users/Gabriel/localprojects/ImpatientScala/myfile.txt"))
                                                  //> in3  : java.util.Scanner = java.util.Scanner[delimiters=\p{javaWhitespace}+
                                                  //| ][position=0][match valid=false][need input=false][source closed=false][ski
                                                  //| pped=false][group separator=\,][decimal separator=\.][positive prefix=][neg
                                                  //| ative prefix=\Q-\E][positive suffix=][negative suffix=][NaN string=\Q?\E][i
                                                  //| nfinity string=\Q°\E]
	while (in3.hasNext()) {
		val currentKey=in3.next
		val currentCount=countMap3(currentKey)
		//println (currentKey, currentCount)
		countMap3=countMap3 - currentKey + (currentKey -> (currentCount+1))
	}
	println (countMap3)                       //> Map(wonderful -> 1, boy -> 1, ma -> 1, whatever -> 1, hello -> 3, super -> 
                                                  //| 2)
                                                  
	//4. With Sorted Map
  var countMap4=SortedMap[String,Int]() withDefaultValue(0)
                                                  //> countMap4  : scala.collection.immutable.Map[String,Int] = Map()
	val in4=new java.util.Scanner(new java.io.File("/Users/Gabriel/localprojects/ImpatientScala/myfile.txt"))
                                                  //> in4  : java.util.Scanner = java.util.Scanner[delimiters=\p{javaWhitespace}+
                                                  //| ][position=0][match valid=false][need input=false][source closed=false][ski
                                                  //| pped=false][group separator=\,][decimal separator=\.][positive prefix=][neg
                                                  //| ative prefix=\Q-\E][positive suffix=][negative suffix=][NaN string=\Q?\E][i
                                                  //| nfinity string=\Q°\E]
	while (in4.hasNext()) {
		val currentKey=in4.next
		val currentCount=countMap4(currentKey)
		//println (currentKey, currentCount)
		countMap4=countMap4 - currentKey + (currentKey -> (currentCount+1))
	}
	println (countMap4)                       //> Map(boy -> 1, hello -> 3, ma -> 1, super -> 2, whatever -> 1, wonderful -> 
                                                  //| 1)
	
	//5. With java.util.TreeMap
  var countMap5=new java.util.TreeMap[String,Int]() withDefaultValue(0)
                                                  //> countMap5  : scala.collection.mutable.Map[String,Int] = Map()
	val in5=new java.util.Scanner(new java.io.File("/Users/Gabriel/localprojects/ImpatientScala/myfile.txt"))
                                                  //> in5  : java.util.Scanner = java.util.Scanner[delimiters=\p{javaWhitespace}+
                                                  //| ][position=0][match valid=false][need input=false][source closed=false][ski
                                                  //| pped=false][group separator=\,][decimal separator=\.][positive prefix=][neg
                                                  //| ative prefix=\Q-\E][positive suffix=][negative suffix=][NaN string=\Q?\E][i
                                                  //| nfinity string=\Q°\E]
	while (in5.hasNext()) {
		val currentKey=in5.next
		val currentCount=countMap5(currentKey)
		//println (currentKey, currentCount)
		countMap5=countMap5 - currentKey + (currentKey -> (currentCount+1))
	}
	println (countMap5)                       //> Map(hello -> 3, super -> 2, ma -> 1, whatever -> 1, boy -> 1, wonderful -> 
                                                  //| 1)
	//6. LinkedHashMap
	val linkedMap=LinkedHashMap[String,Int]() //> linkedMap  : scala.collection.mutable.LinkedHashMap[String,Int] = Map()
	linkedMap+=("Monday" -> MONDAY)           //> res11: Chapter4.linkedMap.type = Map(Monday -> 2)
	linkedMap+=("Tuesday" -> TUESDAY)         //> res12: Chapter4.linkedMap.type = Map(Monday -> 2, Tuesday -> 3)
	linkedMap+=("Wednesday" -> WEDNESDAY)     //> res13: Chapter4.linkedMap.type = Map(Monday -> 2, Tuesday -> 3, Wednesday -
                                                  //| > 4)
	linkedMap+=("Thursday" -> THURSDAY)       //> res14: Chapter4.linkedMap.type = Map(Monday -> 2, Tuesday -> 3, Wednesday -
                                                  //| > 4, Thursday -> 5)
	linkedMap+=("Friday" -> FRIDAY)           //> res15: Chapter4.linkedMap.type = Map(Monday -> 2, Tuesday -> 3, Wednesday -
                                                  //| > 4, Thursday -> 5, Friday -> 6)
	linkedMap+=("Saturday" -> SATURDAY)       //> res16: Chapter4.linkedMap.type = Map(Monday -> 2, Tuesday -> 3, Wednesday -
                                                  //| > 4, Thursday -> 5, Friday -> 6, Saturday -> 7)
	linkedMap+=("Sunday" -> SUNDAY)           //> res17: Chapter4.linkedMap.type = Map(Monday -> 2, Tuesday -> 3, Wednesday -
                                                  //| > 4, Thursday -> 5, Friday -> 6, Saturday -> 7, Sunday -> 1)
  println (linkedMap)                             //> Map(Monday -> 2, Tuesday -> 3, Wednesday -> 4, Thursday -> 5, Friday -> 6, 
                                                  //| Saturday -> 7, Sunday -> 1)

	//7.Java properties
	val sysProps2:Map[String,String]=System.getProperties()
                                                  //> sysProps2  : scala.collection.mutable.Map[String,String] = Map(java.runtime
                                                  //| .name -> Java(TM) SE Runtime Environment, sun.boot.library.path -> /System/
                                                  //| Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Libraries, java.vm.vers
                                                  //| ion -> 20.51-b01-456, awt.nativeDoubleBuffering -> true, gopherProxySet -> 
                                                  //| false, mrj.build -> 11M4508, java.vm.vendor -> Apple Inc., java.vendor.url 
                                                  //| -> http://www.apple.com/, path.separator -> :, java.vm.name -> Java HotSpot
                                                  //| (TM) 64-Bit Server VM, file.encoding.pkg -> sun.io, sun.java.launcher -> SU
                                                  //| N_STANDARD, user.country -> US, sun.os.patch.level -> unknown, java.vm.spec
                                                  //| ification.name -> Java Virtual Machine Specification, user.dir -> /Users/Ga
                                                  //| briel/apps/eclipse kepler scala/Eclipse Kepler Scala.app/Contents/MacOS, ja
                                                  //| va.runtime.version -> 1.6.0_51-b11-456-11M4508, java.awt.graphicsenv -> app
                                                  //| le.awt.CGraphicsEnvironment, java.endorsed.dirs -> /System/Library/Java/Jav
                                                  //| aVirtualMachines/1.6.0.
                                                  //| Output exceeds cutoff limit.
	val maxSizeAnd10Buffer1=sysProps2.keySet.maxBy(_ size).length+10
                                                  //> maxSizeAnd10Buffer1  : Int = 39
	val formatString="%"+maxSizeAnd10Buffer1+"s  | %s";
                                                  //> formatString  : String = %39s  | %s
  for((k,v) <- sysProps2) println(formatString.format(k,v))
                                                  //>                       java.runtime.name  | Java(TM) SE Runtime Environment
                                                  //|                   sun.boot.library.path  | /System/Library/Java/JavaVirtual
                                                  //| Machines/1.6.0.jdk/Contents/Libraries
                                                  //|                         java.vm.version  | 20.51-b01-456
                                                  //|               awt.nativeDoubleBuffering  | true
                                                  //|                          gopherProxySet  | false
                                                  //|                               mrj.build  | 11M4508
                                                  //|                          java.vm.vendor  | Apple Inc.
                                                  //|                         java.vendor.url  | http://www.apple.com/
                                                  //|                          path.separator  | :
                                                  //|                            java.vm.name  | Java HotSpot(TM) 64-Bit Server V
                                                  //| M
                                                  //|                       file.encoding.pkg  | sun.io
                                                  //|                       sun.java.launcher  | SUN_STANDARD
                                                  //|                            user.country  | US
                                                  //|                      sun.os.patch.level  | unknown
                                                  //|              java.vm.specification.name  | Java Virtual Machine Specificati
	
	//Based on a smart solution from https://github.com/dirkraft/ScalaImpatient-AnswersAndNotes/blob/master/src/exercises/Chapter4.scala
	val sysProps1:Map[String,String]=System.getProperties()
                                                  //> sysProps1  : scala.collection.mutable.Map[String,String] = Map(java.runtime
                                                  //| .name -> Java(TM) SE Runtime Environment, sun.boot.library.path -> /System/
                                                  //| Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Libraries, java.vm.vers
                                                  //| ion -> 20.51-b01-456, awt.nativeDoubleBuffering -> true, gopherProxySet -> 
                                                  //| false, mrj.build -> 11M4508, java.vm.vendor -> Apple Inc., java.vendor.url 
                                                  //| -> http://www.apple.com/, path.separator -> :, java.vm.name -> Java HotSpot
                                                  //| (TM) 64-Bit Server VM, file.encoding.pkg -> sun.io, sun.java.launcher -> SU
                                                  //| N_STANDARD, user.country -> US, sun.os.patch.level -> unknown, java.vm.spec
                                                  //| ification.name -> Java Virtual Machine Specification, user.dir -> /Users/Ga
                                                  //| briel/apps/eclipse kepler scala/Eclipse Kepler Scala.app/Contents/MacOS, ja
                                                  //| va.runtime.version -> 1.6.0_51-b11-456-11M4508, java.awt.graphicsenv -> app
                                                  //| le.awt.CGraphicsEnvironment, java.endorsed.dirs -> /System/Library/Java/Jav
                                                  //| aVirtualMachines/1.6.0.
                                                  //| Output exceeds cutoff limit.
	val maxSizeAnd10Buffer=sysProps1.keySet.maxBy(_ size).length+10
                                                  //> maxSizeAnd10Buffer  : Int = 39
	
  for((k,v) <- sysProps1) println(k+(" "*(maxSizeAnd10Buffer-k.size))+"|  "+v)
                                                  //> java.runtime.name                      |  Java(TM) SE Runtime Environment
                                                  //| sun.boot.library.path                  |  /System/Library/Java/JavaVirtualM
                                                  //| achines/1.6.0.jdk/Contents/Libraries
                                                  //| java.vm.version                        |  20.51-b01-456
                                                  //| awt.nativeDoubleBuffering              |  true
                                                  //| gopherProxySet                         |  false
                                                  //| mrj.build                              |  11M4508
                                                  //| java.vm.vendor                         |  Apple Inc.
                                                  //| java.vendor.url                        |  http://www.apple.com/
                                                  //| path.separator                         |  :
                                                  //| java.vm.name                           |  Java HotSpot(TM) 64-Bit Server VM
                                                  //| 
                                                  //| file.encoding.pkg                      |  sun.io
                                                  //| sun.java.launcher                      |  SUN_STANDARD
                                                  //| user.country                           |  US
                                                  //| sun.os.patch.level                     |  unknown
                                                  //| java.vm.specification.name             |  Java Virtual Machine Specificatio
                                                  //| n
                                                  //| us
                                                  //| Output exceeds cutoff limit.
  
	//8.Minmax
	def minmax(values:Array[Int])=(values.min, values.max)
                                                  //> minmax: (values: Array[Int])(Int, Int)
	
	//9.Less than, Equal, Greater than
	 def lteqgt(values:Array[Int], v:Int)={
	  
	  (values.count(_ <  v),
	  values.count(_ == v),
	  values.count(_ >  v))
  }                                               //> lteqgt: (values: Array[Int], v: Int)(Int, Int, Int)
	
  def main(args: Array[String]) {
	  println (Dummy.lteqgt(Array(1,4,5,4,23,56,3), 5));
  }                                               //> main: (args: Array[String])Unit
  
  //10."Hello".zip("World")
                                                  
}