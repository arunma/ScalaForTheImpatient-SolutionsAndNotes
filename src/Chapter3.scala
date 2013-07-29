import scala.collection.mutable.ArrayBuffer;
import scala.util.Sorting._
import scala.collection.JavaConversions.bufferAsJavaList
import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.mutable.Buffer
import util.Random
import java.awt.datatransfer._

object Chapter3 {
  val nums=new Array[Int](3)                      //> nums  : Array[Int] = Array(0, 0, 0)
  val strs=new Array[String](3)                   //> strs  : Array[String] = Array(null, null, null)
  
  val s=Array("Hello", "World")                   //> s  : Array[String] = Array(Hello, World)
  s(0)="Goodbye"
  s                                               //> res0: Array[String] = Array(Goodbye, World)
 
 
 
  var buff=ArrayBuffer(1,1,11,1,3,11)             //> buff  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 1, 11, 1,
                                                  //|  3, 11)
  var buff2=new ArrayBuffer[Int]()                //> buff2  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer()
  
  buff+=121                                       //> res1: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 1, 11, 1, 3
                                                  //| , 11, 121)
  buff2+=(123)                                    //> res2: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(123)
  val a=Array("Super","mama")                     //> a  : Array[String] = Array(Super, mama)
  val array=a.toArray;                            //> array  : Array[String] = Array(Super, mama)
  val abuffer=array.toBuffer                      //> abuffer  : scala.collection.mutable.Buffer[String] = ArrayBuffer(Super, mama
                                                  //| )
  
  for (i<-(0 until buff.length).reverse){
  
  	println (buff(i))                         //> 121
                                                  //| 11
                                                  //| 3
                                                  //| 1
                                                  //| 11
                                                  //| 1
                                                  //| 1
  }
  
  
  for (i<-0 until 10 if i%2==0) yield 2*i         //> res3: scala.collection.immutable.IndexedSeq[Int] = Vector(0, 4, 8, 12, 16)
  
  val myarr=ArrayBuffer(1,2,3,-4,5,-6,7)          //> myarr  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 2, 3, -4
                                                  //| , 5, -6, 7)
  
  myarr.filter(_ %2 ==0).map(_ *2)                //> res4: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(4, -8, -12)
  
  //Bad Way
 	var first=true                            //> first  : Boolean = true
 	var n=myarr.length                        //> n  : Int = 7
 	var i=0                                   //> i  : Int = 0
 	while (i<n){
 	
 		if (myarr(i)>=0) i+=1
 		else{
 			if (first) {first=false; i+=1}
 			else{
 				myarr.remove(i);n-=1;
 			}
 		}
 	
 	}
 	
 	myarr                                     //> res5: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 2, 3, -4, 
                                                  //| 5, 7)
 	
 	var first1=true                           //> first1  : Boolean = true
 	
 	val indexes = for (i<-0 until myarr.length if first1 || myarr(i)>=0) yield{
 		if (myarr(i)<0) first=false; i
 	}                                         //> indexes  : scala.collection.immutable.IndexedSeq[Int] = Vector(0, 1, 2, 3, 
                                                  //| 4, 5)
 
 
 //Common algorithms
 
 	val sum=Array(1,2,3,4,5).sum              //> sum  : Int = 15
 	val max=Array(1,2,3,4,5).max              //> max  : Int = 5
 
  
  val sorted=myarr.sortWith(_ < _)                //> sorted  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(-4, 1, 2,
                                                  //|  3, 5, 7)
  val sorted1=myarr.sorted                        //> sorted1  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(-4, 1, 2
                                                  //| , 3, 5, 7)
  var tempArray=myarr.toArray;                    //> tempArray  : Array[Int] = Array(1, 2, 3, -4, 5, 7)
  quickSort(tempArray)
  //TempArray is sorted in place
  
  tempArray.mkString(":")                         //> res6: String = -4:1:2:3:5:7
  tempArray.mkString("<",":",">")                 //> res7: String = <-4:1:2:3:5:7>
  tempArray.toString()                            //> res8: String = [I@6baa9f99
  
  
  //Interoperating with Java
   val command=ArrayBuffer("ls","-al", "/Users/Gabriel")
                                                  //> command  : scala.collection.mutable.ArrayBuffer[String] = ArrayBuffer(ls, -
                                                  //| al, /Users/Gabriel)
   val pb=new ProcessBuilder(command)             //> pb  : ProcessBuilder = java.lang.ProcessBuilder@2b313906
   val cmd:Buffer[String]=pb.command()            //> cmd  : scala.collection.mutable.Buffer[String] = ArrayBuffer(ls, -al, /User
                                                  //| s/Gabriel)
   
   //Exercises
  
  //1.
 	 def randomArray(n:Int):Array[Int]={
 	 		(for (i<-0 until n) yield Random.nextInt(n)).toArray
 	 		
 	 }                                        //> randomArray: (n: Int)Array[Int]
 	 
 	 println (randomArray(10).mkString(","))  //> 0,9,7,0,2,6,8,2,3,4
 	   
 
 	//2. swap adj in array
 		def swapArray(n:Array[Int]){
 		
 		
 		for (i<- 1 until n.length by 2){
 			println (i)
 			val temp=n(i)
 			n(i)=n(i-1)
 			n(i-1)=temp
 		
 		}
 	
 		println(n.mkString(","))
 	
 	}                                         //> swapArray: (n: Array[Int])Unit
   
  swapArray(Array(1,2,3,4,5,6))                   //> 1
                                                  //| 3
                                                  //| 5
                                                  //| 2,1,4,3,6,5
 
  //3. for-yield
  def swapArrayFor(n:Array[Int]):Array[Int]={
 		
 		println (n.length)
 		
 		(for (i<- 0 until n.length)
 			
 			yield
 			if (i%2==0 && n.length ==i+1) n(i)
 			else if (i%2!=0) n(i-1)
 			else n(i+1)
 			
 		).toArray
 		
 	
 	}                                         //> swapArrayFor: (n: Array[Int])Array[Int]
   
  swapArrayFor(Array(1,2,3,4,5,6))                //> 6
                                                  //| res9: Array[Int] = Array(2, 1, 4, 3, 6, 5)
  swapArrayFor(Array(1,2,3,4,5))                  //> 5
                                                  //| res10: Array[Int] = Array(2, 1, 4, 3, 5)
  
  //4.Array of integers - positive, zero and then negative
  val tempArray1 = Array(0, -1, 6, 7, -3, 5, 0, 3, -6, -9)
                                                  //> tempArray1  : Array[Int] = Array(0, -1, 6, 7, -3, 5, 0, 3, -6, -9)
  println (tempArray1)                            //> [I@19632847
  var orderedArray= for (i<-tempArray1 if i>0) yield i
                                                  //> orderedArray  : Array[Int] = Array(6, 7, 5, 3)
  println (orderedArray)                          //> [I@6bffc686
  orderedArray++=(for (i<-tempArray1 if i==0) yield i)
  println (orderedArray.mkString(","))            //> 6,7,5,3,0,0
  
  orderedArray++=(for (i<-tempArray1 if i<0) yield i)
  println (orderedArray.mkString(","))            //> 6,7,5,3,0,0,-1,-3,-6,-9
  
  
  //use map and filter
  
  val mapArray=tempArray1.filter(_ >0).toBuffer   //> mapArray  : scala.collection.mutable.Buffer[Int] = ArrayBuffer(6, 7, 5, 3)
  mapArray++=tempArray1.filter(_==0)              //> res11: Chapter3.mapArray.type = ArrayBuffer(6, 7, 5, 3, 0, 0)
  mapArray++=tempArray1.filter(_<0)               //> res12: Chapter3.mapArray.type = ArrayBuffer(6, 7, 5, 3, 0, 0, -1, -3, -6, -
                                                  //| 9)
  
  println (mapArray)                              //> ArrayBuffer(6, 7, 5, 3, 0, 0, -1, -3, -6, -9)
  
  
  //5.Average of an array(double)
	val avgArray=Array[Double](1,3,5,7,9)     //> avgArray  : Array[Double] = Array(1.0, 3.0, 5.0, 7.0, 9.0)
	val avg=avgArray.sum/avgArray.length      //> avg  : Double = 5.0
		
		
  //6. Reverse sort order Array and ArrayBuffer
  	var unsortedArr=Array(2,4,5,2,1,45,9)     //> unsortedArr  : Array[Int] = Array(2, 4, 5, 2, 1, 45, 9)
		unsortedArr.sorted(Ordering.Int.reverse)
                                                  //> res13: Array[Int] = Array(45, 9, 5, 4, 2, 2, 1)
		unsortedArr=Array(2,4,5,2,1,45,9)
   
    //Could also in-place sort using quicksort and reverse the array
		quickSort(unsortedArr)
		println (unsortedArr.mkString(","))
                                                  //> 1,2,2,4,5,9,45
		val reverseSortedArray=unsortedArr.reverse
                                                  //> reverseSortedArray  : Array[Int] = Array(45, 9, 5, 4, 2, 2, 1)
		//Buffer reverse
		println (unsortedArr.mkString(","))
                                                  //> 1,2,2,4,5,9,45
		val unsortedArrBuff=ArrayBuffer(2,4,5,2,1,45,9)
                                                  //> unsortedArrBuff  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(
                                                  //| 2, 4, 5, 2, 1, 45, 9)
		unsortedArrBuff.sortWith(_ > _ )  //> res14: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(45, 9, 5, 4,
                                                  //|  2, 2, 1)
  
  		//7.Remove duplicates
	
		val distinctArray=Array(2,2,23,5,6,7,5,4,6,7)
                                                  //> distinctArray  : Array[Int] = Array(2, 2, 23, 5, 6, 7, 5, 4, 6, 7)
		println (distinctArray.distinct.mkString(","))
                                                  //> 2,23,5,6,7,4
  	//8. Skipping - I just don't like this question

		//9.Timezone sort
		val timeZones=java.util.TimeZone.getAvailableIDs()
                                                  //> timeZones  : Array[String] = Array(Etc/GMT+12, Etc/GMT+11, Pacific/Midway, 
                                                  //| Pacific/Niue, Pacific/Pago_Pago, Pacific/Samoa, US/Samoa, America/Adak, Ame
                                                  //| rica/Atka, Etc/GMT+10, HST, Pacific/Honolulu, Pacific/Johnston, Pacific/Rar
                                                  //| otonga, Pacific/Tahiti, SystemV/HST10, US/Aleutian, US/Hawaii, Pacific/Marq
                                                  //| uesas, AST, America/Anchorage, America/Juneau, America/Nome, America/Sitka,
                                                  //|  America/Yakutat, Etc/GMT+9, Pacific/Gambier, SystemV/YST9, SystemV/YST9YDT
                                                  //| , US/Alaska, America/Dawson, America/Ensenada, America/Los_Angeles, America
                                                  //| /Metlakatla, America/Santa_Isabel, America/Tijuana, America/Vancouver, Amer
                                                  //| ica/Whitehorse, Canada/Pacific, Canada/Yukon, Etc/GMT+8, Mexico/BajaNorte, 
                                                  //| PST, PST8PDT, Pacific/Pitcairn, SystemV/PST8, SystemV/PST8PDT, US/Pacific, 
                                                  //| US/Pacific-New, America/Boise, America/Cambridge_Bay, America/Chihuahua, Am
                                                  //| erica/Creston, America/Dawson_Creek, America/Denver, America/Edmonton, Amer
                                                  //| ica/Hermosillo, America
                                                  //| Output exceeds cutoff limit.
		(timeZones.filter(_ startsWith "America/")).map(_ stripPrefix "America/").sortWith(_ < _)
                                                  //> res15: Array[String] = Array(Adak, Anchorage, Anguilla, Antigua, Araguaina,
                                                  //|  Argentina/Buenos_Aires, Argentina/Catamarca, Argentina/ComodRivadavia, Arg
                                                  //| entina/Cordoba, Argentina/Jujuy, Argentina/La_Rioja, Argentina/Mendoza, Arg
                                                  //| entina/Rio_Gallegos, Argentina/Salta, Argentina/San_Juan, Argentina/San_Lui
                                                  //| s, Argentina/Tucuman, Argentina/Ushuaia, Aruba, Asuncion, Atikokan, Atka, B
                                                  //| ahia, Bahia_Banderas, Barbados, Belem, Belize, Blanc-Sablon, Boa_Vista, Bog
                                                  //| ota, Boise, Buenos_Aires, Cambridge_Bay, Campo_Grande, Cancun, Caracas, Cat
                                                  //| amarca, Cayenne, Cayman, Chicago, Chihuahua, Coral_Harbour, Cordoba, Costa_
                                                  //| Rica, Creston, Cuiaba, Curacao, Danmarkshavn, Dawson, Dawson_Creek, Denver,
                                                  //|  Detroit, Dominica, Edmonton, Eirunepe, El_Salvador, Ensenada, Fort_Wayne, 
                                                  //| Fortaleza, Glace_Bay, Godthab, Goose_Bay, Grand_Turk, Grenada, Guadeloupe, 
                                                  //| Guatemala, Guayaquil, Guyana, Halifax, Havana, Hermosillo, Indiana/Indianap
                                                  //| olis, Indiana/Knox, Ind
                                                  //| Output exceeds cutoff limit.
 	//10.Flavours
	val flavors=SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
                                                  //> flavors  : java.awt.datatransfer.SystemFlavorMap = java.awt.datatransfer.Sy
                                                  //| stemFlavorMap@114e3f41
	val nativeFlavors=collection.JavaConversions.asScalaBuffer(flavors.getNativesForFlavor(DataFlavor.imageFlavor))
                                                  //> nativeFlavors  : scala.collection.mutable.Buffer[String] = Buffer(TIFF)\
}