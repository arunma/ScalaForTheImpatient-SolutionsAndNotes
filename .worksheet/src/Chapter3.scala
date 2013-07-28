import scala.collection.mutable.ArrayBuffer;
import scala.util.Sorting._
import scala.collection.JavaConversions.bufferAsJavaList
import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.mutable.Buffer
import util.Random
import java.awt.datatransfer._

object Chapter3 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(320); 
  val nums=new Array[Int](3);System.out.println("""nums  : Array[Int] = """ + $show(nums ));$skip(32); 
  val strs=new Array[String](3);System.out.println("""strs  : Array[String] = """ + $show(strs ));$skip(35); 
  
  val s=Array("Hello", "World");System.out.println("""s  : Array[String] = """ + $show(s ));$skip(17); 
  s(0)="Goodbye";$skip(4); val res$0 = 
  s;System.out.println("""res0: Array[String] = """ + $show(res$0));$skip(44); 
 
 
 
  var buff=ArrayBuffer(1,1,11,1,3,11);System.out.println("""buff  : scala.collection.mutable.ArrayBuffer[Int] = """ + $show(buff ));$skip(35); 
  var buff2=new ArrayBuffer[Int]();System.out.println("""buff2  : scala.collection.mutable.ArrayBuffer[Int] = """ + $show(buff2 ));$skip(15); val res$1 = 
  
  buff+=121;System.out.println("""res1: scala.collection.mutable.ArrayBuffer[Int] = """ + $show(res$1));$skip(15); val res$2 = 
  buff2+=(123);System.out.println("""res2: scala.collection.mutable.ArrayBuffer[Int] = """ + $show(res$2));$skip(30); 
  val a=Array("Super","mama");System.out.println("""a  : Array[String] = """ + $show(a ));$skip(23); 
  val array=a.toArray;System.out.println("""array  : Array[String] = """ + $show(array ));$skip(29); ;
  val abuffer=array.toBuffer;System.out.println("""abuffer  : scala.collection.mutable.Buffer[String] = """ + $show(abuffer ));$skip(69); 
  
  for (i<-(0 until buff.length).reverse){
  
  	println (buff(i))
  };$skip(52); val res$3 = 
  
  
  for (i<-0 until 10 if i%2==0) yield 2*i;System.out.println("""res3: scala.collection.immutable.IndexedSeq[Int] = """ + $show(res$3));$skip(44); 
  
  val myarr=ArrayBuffer(1,2,3,-4,5,-6,7);System.out.println("""myarr  : scala.collection.mutable.ArrayBuffer[Int] = """ + $show(myarr ));$skip(38); val res$4 = 
  
  myarr.filter(_ %2 ==0).map(_ *2);System.out.println("""res4: scala.collection.mutable.ArrayBuffer[Int] = """ + $show(res$4));$skip(32); 
  
  //Bad Way
 	var first=true;System.out.println("""first  : Boolean = """ + $show(first ));$skip(21); 
 	var n=myarr.length;System.out.println("""n  : Int = """ + $show(n ));$skip(10); 
 	var i=0;System.out.println("""i  : Int = """ + $show(i ));$skip(142); 
 	while (i<n){
 	
 		if (myarr(i)>=0) i+=1
 		else{
 			if (first) {first=false; i+=1}
 			else{
 				myarr.remove(i);n-=1;
 			}
 		}
 	
 	};$skip(11); val res$5 = 
 	
 	myarr;System.out.println("""res5: scala.collection.mutable.ArrayBuffer[Int] = """ + $show(res$5));$skip(21); 
 	
 	var first1=true;System.out.println("""first1  : Boolean = """ + $show(first1 ));$skip(119); 
 	
 	val indexes = for (i<-0 until myarr.length if first1 || myarr(i)>=0) yield{
 		if (myarr(i)<0) first=false; i
 	};System.out.println("""indexes  : scala.collection.immutable.IndexedSeq[Int] = """ + $show(indexes ));$skip(58); 
 
 
 //Common algorithms
 
 	val sum=Array(1,2,3,4,5).sum;System.out.println("""sum  : Int = """ + $show(sum ));$skip(31); 
 	val max=Array(1,2,3,4,5).max;System.out.println("""max  : Int = """ + $show(max ));$skip(40); 
 
  
  val sorted=myarr.sortWith(_ < _);System.out.println("""sorted  : scala.collection.mutable.ArrayBuffer[Int] = """ + $show(sorted ));$skip(27); 
  val sorted1=myarr.sorted;System.out.println("""sorted1  : scala.collection.mutable.ArrayBuffer[Int] = """ + $show(sorted1 ));$skip(31); 
  var tempArray=myarr.toArray;System.out.println("""tempArray  : Array[Int] = """ + $show(tempArray ));$skip(23); ;
  quickSort(tempArray);$skip(62); val res$6 = 
  //TempArray is sorted in place
  
  tempArray.mkString(":");System.out.println("""res6: String = """ + $show(res$6));$skip(34); val res$7 = 
  tempArray.mkString("<",":",">");System.out.println("""res7: String = """ + $show(res$7));$skip(23); val res$8 = 
  tempArray.toString();System.out.println("""res8: String = """ + $show(res$8));$skip(92); 
  
  
  //Interoperating with Java
   val command=ArrayBuffer("ls","-al", "/Users/Gabriel");System.out.println("""command  : scala.collection.mutable.ArrayBuffer[String] = """ + $show(command ));$skip(38); 
   val pb=new ProcessBuilder(command);System.out.println("""pb  : ProcessBuilder = """ + $show(pb ));$skip(39); 
   val cmd:Buffer[String]=pb.command();System.out.println("""cmd  : scala.collection.mutable.Buffer[String] = """ + $show(cmd ));$skip(137); 
   
   //Exercises
  
  //1.
 	 def randomArray(n:Int):Array[Int]={
 	 		(for (i<-0 until n) yield Random.nextInt(n)).toArray
 	 		
 	 };System.out.println("""randomArray: (n: Int)Array[Int]""");$skip(47); 
 	 
 	 println (randomArray(10).mkString(","));$skip(222); 
 	   
 
 	//2. swap adj in array
 		def swapArray(n:Array[Int]){
 		
 		
 		for (i<- 1 until n.length by 2){
 			println (i)
 			val temp=n(i)
 			n(i)=n(i-1)
 			n(i-1)=temp
 		
 		}
 	
 		println(n.mkString(","))
 	
 	};System.out.println("""swapArray: (n: Array[Int])Unit""");$skip(36); 
   
  swapArray(Array(1,2,3,4,5,6));$skip(253); 
 
  //3. for-yield
  def swapArrayFor(n:Array[Int]):Array[Int]={
 		
 		println (n.length)
 		
 		(for (i<- 0 until n.length)
 			
 			yield
 			if (i%2==0 && n.length ==i+1) n(i)
 			else if (i%2!=0) n(i-1)
 			else n(i+1)
 			
 		).toArray
 		
 	
 	};System.out.println("""swapArrayFor: (n: Array[Int])Array[Int]""");$skip(39); val res$9 = 
   
  swapArrayFor(Array(1,2,3,4,5,6));System.out.println("""res9: Array[Int] = """ + $show(res$9));$skip(33); val res$10 = 
  swapArrayFor(Array(1,2,3,4,5));System.out.println("""res10: Array[Int] = """ + $show(res$10));$skip(121); 
  
  //4.Array of integers - positive, zero and then negative
  val tempArray1 = Array(0, -1, 6, 7, -3, 5, 0, 3, -6, -9);System.out.println("""tempArray1  : Array[Int] = """ + $show(tempArray1 ));$skip(23); 
  println (tempArray1);$skip(55); 
  var orderedArray= for (i<-tempArray1 if i>0) yield i;System.out.println("""orderedArray  : Array[Int] = """ + $show(orderedArray ));$skip(25); 
  println (orderedArray);$skip(55); 
  orderedArray++=(for (i<-tempArray1 if i==0) yield i);$skip(39); 
  println (orderedArray.mkString(","));$skip(57); 
  
  orderedArray++=(for (i<-tempArray1 if i<0) yield i);$skip(39); 
  println (orderedArray.mkString(","));$skip(80); 
  
  
  //use map and filter
  
  val mapArray=tempArray1.filter(_ >0).toBuffer;System.out.println("""mapArray  : scala.collection.mutable.Buffer[Int] = """ + $show(mapArray ));$skip(37); val res$11 = 
  mapArray++=tempArray1.filter(_==0);System.out.println("""res11: Chapter3.mapArray.type = """ + $show(res$11));$skip(36); val res$12 = 
  mapArray++=tempArray1.filter(_<0);System.out.println("""res12: Chapter3.mapArray.type = """ + $show(res$12));$skip(24); 
  
  println (mapArray);$skip(79); 
  
  
  //5.Average of an array(double)
	val avgArray=Array[Double](1,3,5,7,9);System.out.println("""avgArray  : Array[Double] = """ + $show(avgArray ));$skip(38); 
	val avg=avgArray.sum/avgArray.length;System.out.println("""avg  : Double = """ + $show(avg ));$skip(95); 
		
		
  //6. Reverse sort order Array and ArrayBuffer
  	var unsortedArr=Array(2,4,5,2,1,45,9);System.out.println("""unsortedArr  : Array[Int] = """ + $show(unsortedArr ));$skip(43); val res$13 = 
		unsortedArr.sorted(Ordering.Int.reverse);System.out.println("""res13: Array[Int] = """ + $show(res$13));$skip(36); 
		unsortedArr=Array(2,4,5,2,1,45,9);$skip(98); 
   
    //Could also in-place sort using quicksort and reverse the array
		quickSort(unsortedArr);$skip(38); 
		println (unsortedArr.mkString(","));$skip(45); 
		val reverseSortedArray=unsortedArr.reverse;System.out.println("""reverseSortedArray  : Array[Int] = """ + $show(reverseSortedArray ));$skip(57); 
		//Buffer reverse
		println (unsortedArr.mkString(","));$skip(50); 
		val unsortedArrBuff=ArrayBuffer(2,4,5,2,1,45,9);System.out.println("""unsortedArrBuff  : scala.collection.mutable.ArrayBuffer[Int] = """ + $show(unsortedArrBuff ));$skip(35); val res$14 = 
		unsortedArrBuff.sortWith(_ > _ );System.out.println("""res14: scala.collection.mutable.ArrayBuffer[Int] = """ + $show(res$14));$skip(79); 
  
  		//7.Remove duplicates
	
		val distinctArray=Array(2,2,23,5,6,7,5,4,6,7);System.out.println("""distinctArray  : Array[Int] = """ + $show(distinctArray ));$skip(49); 
		println (distinctArray.distinct.mkString(","));$skip(125); 
  	//8. Skipping - I just don't like this question

		//9.Timezone sort
		val timeZones=java.util.TimeZone.getAvailableIDs();System.out.println("""timeZones  : Array[String] = """ + $show(timeZones ));$skip(92); val res$15 = 
		(timeZones.filter(_ startsWith "America/")).map(_ stripPrefix "America/").sortWith(_ < _);System.out.println("""res15: Array[String] = """ + $show(res$15));$skip(97); 
 	//10.Flavours
	val flavors=SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap];System.out.println("""flavors  : java.awt.datatransfer.SystemFlavorMap = """ + $show(flavors ));$skip(113); 
	val nativeFlavors=collection.JavaConversions.asScalaBuffer(flavors.getNativesForFlavor(DataFlavor.imageFlavor));System.out.println("""nativeFlavors  : scala.collection.mutable.Buffer[String] = """ + $show(nativeFlavors ))}
}
