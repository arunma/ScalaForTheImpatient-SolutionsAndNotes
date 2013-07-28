object Chapter2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(43); val res$0 = 

	for (i<-1 to 5) yield i;System.out.println("""res0: scala.collection.immutable.IndexedSeq[Int] = """ + $show(res$0));$skip(50); val res$1 = 
	
	for (i<- 0 to 1;c<-"Hello") yield (c+i).toChar;System.out.println("""res1: scala.collection.immutable.IndexedSeq[Char] = """ + $show(res$1));$skip(50); val res$2 = 
	
	for (c<-"Hello"; i<-0 to 1) yield (c+i).toChar;System.out.println("""res2: String = """ + $show(res$2));$skip(81); 


//Exercises
	
	//Sol 1
	def signum(x:Int) = if (x>0) 1 else if (x<0) -1 else 0;System.out.println("""signum: (x: Int)Int""");$skip(13); val res$3 = 
	signum(-10);System.out.println("""res3: Int = """ + $show(res$3));$skip(12); val res$4 = 
	signum(10);System.out.println("""res4: Int = """ + $show(res$4));$skip(11); val res$5 = 
	signum(0);System.out.println("""res5: Int = """ + $show(res$5));$skip(30); 
	
	
	
	//Sol 3
	var x:Unit={};System.out.println("""x  : Unit = """ + $show(x ));$skip(9); 
	var y=0;System.out.println("""y  : Int = """ + $show(y ));$skip(7); 
	x=y=1;$skip(48); 
	
	
	//Sol 4
	for (i<-10 to (0,-1)) println (i);$skip(72); 
	//Sol5
	def countdown (n:Int){
		for (i<-n to (0,-1)) println (i)
	
	};System.out.println("""countdown: (n: Int)Unit""");$skip(16); 
	
	countdown(5);$skip(27); 
  //Sol 6
  var product=1;System.out.println("""product  : Int = """ + $show(product ));$skip(32); ;
  for (ch<-"Hello") product*=ch;$skip(19); 
	println (product);$skip(24); 
	
	
	//Sol 7
	product=1;$skip(43); 
	"Hello".foreach((ch:Char) => product*=ch);$skip(19); 
	println (product);$skip(108); 
	
	//Sol 8
	
	def productFunct(s:String)={
		var product=1
		s.foreach((ch:Char)=>product*=ch)
		product
	};System.out.println("""productFunct: (s: String)Int""");$skip(23); val res$6 = 
	productFunct("Hello");System.out.println("""res6: Int = """ + $show(res$6));$skip(126); 
	
	
	//Sol 9
	def recursiveProduct(s:String):Int={
	
		if (s.size==0) 1
		else{
			s.head * recursiveProduct(s.tail)
		}
	
	};System.out.println("""recursiveProduct: (s: String)Int""");$skip(29); val res$7 = 
	
	recursiveProduct("Hello");System.out.println("""res7: Int = """ + $show(res$7));$skip(184); 
	
	
	//Sol 10
	def power(x:Double, n:Int):Double={
	
		if (n>0 && n%2==0) {val y= power(x, n/2); y*y}
		else if (n>0) x * power (x, n-1)
		else if (n==0) 1
		else 1 / power (x, -n)
	};System.out.println("""power: (x: Double, n: Int)Double""");$skip(16); val res$8 = 
	
	power (25,3);System.out.println("""res8: Double = """ + $show(res$8))}
}
