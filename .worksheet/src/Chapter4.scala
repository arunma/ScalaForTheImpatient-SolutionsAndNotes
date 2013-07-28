import scala.collection.JavaConversions.mapAsScalaMap
import scala.collection.JavaConversions.propertiesAsScalaMap
import scala.collection.JavaConversions.mapAsJavaMap
import java.awt.font.TextAttribute._
import scala.collection.mutable.Map
import scala.collection.immutable.SortedMap
import scala.collection.mutable.LinkedHashMap
import java.util.Calendar._

object Chapter4 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(450); 

	//Construction
	val scores=Map("Arun" ->10, "Jason"->100, "Daisy"->50);System.out.println("""scores  : scala.collection.mutable.Map[String,Int] = """ + $show(scores ));$skip(88); 
	val scoresMutable=scala.collection.mutable.Map("Arun" ->10, "Jason"->100, "Daisy"->50);System.out.println("""scoresMutable  : scala.collection.mutable.Map[String,Int] = """ + $show(scoresMutable ));$skip(96); 
	val scoresMutableHashMap=scala.collection.mutable.HashMap("Arun"->10,"Jason"->100,"Daisy"->50);System.out.println("""scoresMutableHashMap  : scala.collection.mutable.HashMap[String,Int] = """ + $show(scoresMutableHashMap ));$skip(103); 
	
	val scoresMutableHMVariant=scala.collection.mutable.HashMap(("Arun",10),("Jason",100),("Daisy",50));System.out.println("""scoresMutableHMVariant  : scala.collection.mutable.HashMap[String,Int] = """ + $show(scoresMutableHMVariant ));$skip(44); val res$0 = 
  //Getting values from Map
	scores("Arun");System.out.println("""res0: Int = """ + $show(res$0));$skip(31); val res$1 = 
	
	scores.getOrElse("Arun", 0);System.out.println("""res1: Int = """ + $show(res$1));$skip(83); val res$2 = 
	//scores("Aruna")   //NoSuchElementException
 	scores.get("Aruna");System.out.println("""res2: Option[Int] = """ + $show(res$2));$skip(30); val res$3 =  //Returns None
	scores.getOrElse("Aruna", 0);System.out.println("""res3: Int = """ + $show(res$3));$skip(48); 
	
	//Updating a map
	scoresMutable("Jason")=200;$skip(27); 
	scoresMutable("Aruna")=20;$skip(44); val res$4 = 
	scoresMutable+=("Super"->90,"Awesome"->23);System.out.println("""res4: Chapter4.scoresMutable.type = """ + $show(res$4));$skip(15); val res$5 = 
	scoresMutable;System.out.println("""res5: scala.collection.mutable.Map[String,Int] = """ + $show(res$5));$skip(52); val res$6 = 
  //Removing key and value
  scoresMutable-="Aruna";System.out.println("""res6: Chapter4.scoresMutable.type = """ + $show(res$6));$skip(66); 

	//Iterating through map
	
	for ((k,v) <- scores) println (k, v);$skip(54); 
	
	//KeySet
	val keySet=scores.keySet;System.out.println("""keySet  : scala.collection.Set[String] = """ + $show(keySet ));$skip(51);   //ImmutableSet
	val values=scores.values;System.out.println("""values  : Iterable[Int] = """ + $show(values ));$skip(64); val res$7 =    //return type Iterable
	
	
	
	//Inverse key and value
	for ((k,v)<-scores) yield (v,k);System.out.println("""res7: scala.collection.mutable.Map[Int,String] = """ + $show(res$7));$skip(290); val res$8 = 
                                                  
                                                  
	//SortedMap - Balanced Trees
	//SortedMap has no mutable variants - Have to use java.util TreeMap if needed
	scala.collection.immutable.SortedMap("Jason"->2423,"Arun"->22,"Daisy"->23232);System.out.println("""res8: scala.collection.immutable.SortedMap[String,Int] = """ + $show(res$8));$skip(106); val res$9 = 
	
	//for insertion order
	scala.collection.mutable.LinkedHashMap("Jason"->2423,"Arun"->22,"Daisy"->23232);System.out.println("""res9: scala.collection.mutable.LinkedHashMap[String,Int] = """ + $show(res$9));$skip(186); 

	//Interoperating with Java
	//FROM JAVA
	//scala.collection.JavaConversions.mapAsScalaMap
	val sortedJavaMap:scala.collection.mutable.Map[String,Int]=new java.util.TreeMap[String,Int];System.out.println("""sortedJavaMap  : scala.collection.mutable.Map[String,Int] = """ + $show(sortedJavaMap ));$skip(334); 
                                                  
	//val propertyMap:scala.collection.mutable.Map[String,String]=System.getProperties()
                                                  
	//TO JAVA
	//val attrs=Map(FAMILY->"Serif", SIZE->12)
	//val font=new java.awt.Font(attrs)
                   
	//TUPLE
	val tup=(1,3.14,"Fred");System.out.println("""tup  : (Int, Double, String) = """ + $show(tup ));$skip(18); val res$10 = 
	//Access
	tup._1;System.out.println("""res10: Int = """ + $show(res$10));$skip(50); 
	
	//Pattern matching
	val (number,duble,str)=tup;System.out.println("""number  : Int = """ + $show(number ));System.out.println("""duble  : Double = """ + $show(duble ));System.out.println("""str  : String = """ + $show(str ));$skip(71); 
	//If you are not interested in the double value
	val (num,_,stri)=tup;System.out.println("""num  : Int = """ + $show(num ));System.out.println("""stri  : String = """ + $show(stri ));$skip(41); 
	
	//Zip
	val symbols=Array("<","-",">");System.out.println("""symbols  : Array[String] = """ + $show(symbols ));$skip(26); 
	val counts=Array(2,10,2);System.out.println("""counts  : Array[Int] = """ + $show(counts ));$skip(43); 
	
	val names=Array("Arun","Daisy","Jason");System.out.println("""names  : Array[String] = """ + $show(names ));$skip(34); 
	val marks=Array("10","20","100");System.out.println("""marks  : Array[String] = """ + $show(marks ));$skip(39); 
	
	val zippedArray=symbols.zip(counts);System.out.println("""zippedArray  : Array[(String, Int)] = """ + $show(zippedArray ));$skip(85); 
	
	//Iterate as Tuple Array
	for ((symbol,count)<-zippedArray) print (symbol *count);$skip(55); 
	//Convert to Map
	val nameMark=names.zip(marks).toMap;System.out.println("""nameMark  : scala.collection.immutable.Map[String,String] = """ + $show(nameMark ));$skip(161); 
                              
	//EXERCISES
	//1.
	val gizmos:Map[String,Double]=Map("Samsung Galaxy S4 Zoom"-> 1000, "Mac Pro"-> 6000.10, "Google Glass"->2000);System.out.println("""gizmos  : scala.collection.mutable.Map[String,Double] = """ + $show(gizmos ));$skip(62); 
  val discountedGizmos=(for ((k,v)<-gizmos) yield (k, v*0.9));System.out.println("""discountedGizmos  : scala.collection.mutable.Map[String,Double] = """ + $show(discountedGizmos ));$skip(72); 
  //Variation using mapValues
  val discGizmos1=gizmos.mapValues(_*0.9);System.out.println("""discGizmos1  : scala.collection.Map[String,Double] = """ + $show(discGizmos1 ));$skip(129); 
  
  //Variation using only map function
  //val discGizmos2=gizmos.map((_,v) =>v*0.9)
  
	//2.
  val countMap=Map[String,Int]();System.out.println("""countMap  : scala.collection.mutable.Map[String,Int] = """ + $show(countMap ));$skip(106); 
	val in=new java.util.Scanner(new java.io.File("/Users/Gabriel/localprojects/ImpatientScala/myfile.txt"));System.out.println("""in  : java.util.Scanner = """ + $show(in ));$skip(125); 
	while (in.hasNext()) {
	
		val currentKey=in.next
		countMap.getOrElseUpdate(currentKey,0)
		countMap(currentKey)+=1
	
	
	};$skip(20); 
	println (countMap);$skip(71); 
	//Nice variation
	val countMap1=Map[String,Int]() withDefaultValue(0);System.out.println("""countMap1  : scala.collection.mutable.Map[String,Int] = """ + $show(countMap1 ));$skip(107); 
	val in1=new java.util.Scanner(new java.io.File("/Users/Gabriel/localprojects/ImpatientScala/myfile.txt"));System.out.println("""in1  : java.util.Scanner = """ + $show(in1 ));$skip(46); 
	while (in1.hasNext()) countMap1(in1.next)+=1;$skip(21); 
	println (countMap1);$skip(79); 
	//3. With Immutable Map
  var countMap3=Map[String,Int]() withDefaultValue(0);System.out.println("""countMap3  : scala.collection.mutable.Map[String,Int] = """ + $show(countMap3 ));$skip(107); 
	val in3=new java.util.Scanner(new java.io.File("/Users/Gabriel/localprojects/ImpatientScala/myfile.txt"));System.out.println("""in3  : java.util.Scanner = """ + $show(in3 ));$skip(204); 
	while (in3.hasNext()) {
		val currentKey=in3.next
		val currentCount=countMap3(currentKey)
		//println (currentKey, currentCount)
		countMap3=countMap3 - currentKey + (currentKey -> (currentCount+1))
	};$skip(21); 
	println (countMap3);$skip(133); 
                                                  
	//4. With Sorted Map
  var countMap4=SortedMap[String,Int]() withDefaultValue(0);System.out.println("""countMap4  : scala.collection.immutable.Map[String,Int] = """ + $show(countMap4 ));$skip(107); 
	val in4=new java.util.Scanner(new java.io.File("/Users/Gabriel/localprojects/ImpatientScala/myfile.txt"));System.out.println("""in4  : java.util.Scanner = """ + $show(in4 ));$skip(204); 
	while (in4.hasNext()) {
		val currentKey=in4.next
		val currentCount=countMap4(currentKey)
		//println (currentKey, currentCount)
		countMap4=countMap4 - currentKey + (currentKey -> (currentCount+1))
	};$skip(21); 
	println (countMap4);$skip(103); 
	
	//5. With java.util.TreeMap
  var countMap5=new java.util.TreeMap[String,Int]() withDefaultValue(0);System.out.println("""countMap5  : scala.collection.mutable.Map[String,Int] = """ + $show(countMap5 ));$skip(107); 
	val in5=new java.util.Scanner(new java.io.File("/Users/Gabriel/localprojects/ImpatientScala/myfile.txt"));System.out.println("""in5  : java.util.Scanner = """ + $show(in5 ));$skip(204); 
	while (in5.hasNext()) {
		val currentKey=in5.next
		val currentCount=countMap5(currentKey)
		//println (currentKey, currentCount)
		countMap5=countMap5 - currentKey + (currentKey -> (currentCount+1))
	};$skip(21); 
	println (countMap5);$skip(63); 
	//6. LinkedHashMap
	val linkedMap=LinkedHashMap[String,Int]();System.out.println("""linkedMap  : scala.collection.mutable.LinkedHashMap[String,Int] = """ + $show(linkedMap ));$skip(33); val res$11 = 
	linkedMap+=("Monday" -> MONDAY);System.out.println("""res11: Chapter4.linkedMap.type = """ + $show(res$11));$skip(35); val res$12 = 
	linkedMap+=("Tuesday" -> TUESDAY);System.out.println("""res12: Chapter4.linkedMap.type = """ + $show(res$12));$skip(39); val res$13 = 
	linkedMap+=("Wednesday" -> WEDNESDAY);System.out.println("""res13: Chapter4.linkedMap.type = """ + $show(res$13));$skip(37); val res$14 = 
	linkedMap+=("Thursday" -> THURSDAY);System.out.println("""res14: Chapter4.linkedMap.type = """ + $show(res$14));$skip(33); val res$15 = 
	linkedMap+=("Friday" -> FRIDAY);System.out.println("""res15: Chapter4.linkedMap.type = """ + $show(res$15));$skip(37); val res$16 = 
	linkedMap+=("Saturday" -> SATURDAY);System.out.println("""res16: Chapter4.linkedMap.type = """ + $show(res$16));$skip(33); val res$17 = 
	linkedMap+=("Sunday" -> SUNDAY);System.out.println("""res17: Chapter4.linkedMap.type = """ + $show(res$17));$skip(22); 
  println (linkedMap);$skip(79); 

	//7.Java properties
	val sysProps2:Map[String,String]=System.getProperties();System.out.println("""sysProps2  : scala.collection.mutable.Map[String,String] = """ + $show(sysProps2 ));$skip(66); 
	val maxSizeAnd10Buffer1=sysProps2.keySet.maxBy(_ size).length+10;System.out.println("""maxSizeAnd10Buffer1  : Int = """ + $show(maxSizeAnd10Buffer1 ));$skip(53); 
	val formatString="%"+maxSizeAnd10Buffer1+"s  | %s";System.out.println("""formatString  : String = """ + $show(formatString ));$skip(60); ;
  for((k,v) <- sysProps2) println(formatString.format(k,v));$skip(193); 
	
	//Based on a smart solution from https://github.com/dirkraft/ScalaImpatient-AnswersAndNotes/blob/master/src/exercises/Chapter4.scala
	val sysProps1:Map[String,String]=System.getProperties();System.out.println("""sysProps1  : scala.collection.mutable.Map[String,String] = """ + $show(sysProps1 ));$skip(65); 
	val maxSizeAnd10Buffer=sysProps1.keySet.maxBy(_ size).length+10;System.out.println("""maxSizeAnd10Buffer  : Int = """ + $show(maxSizeAnd10Buffer ));$skip(81); 
	
  for((k,v) <- sysProps1) println(k+(" "*(maxSizeAnd10Buffer-k.size))+"|  "+v);$skip(71); 
  
	//8.Minmax
	def minmax(values:Array[Int])=(values.min, values.max);System.out.println("""minmax: (values: Array[Int])(Int, Int)""");$skip(163); 
	
	//9.Less than, Equal, Greater than
	 def lteqgt(values:Array[Int], v:Int)={
	  
	  (values.count(_ <  v),
	  values.count(_ == v),
	  values.count(_ >  v))
  };System.out.println("""lteqgt: (values: Array[Int], v: Int)(Int, Int, Int)""");$skip(94); 
	
  def main(args: Array[String]) {
	  println (Dummy.lteqgt(Array(1,4,5,4,23,56,3), 5));
  };System.out.println("""main: (args: Array[String])Unit""")}
  
  //10."Hello".zip("World")
                                                  
}
