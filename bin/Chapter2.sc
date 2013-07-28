object Chapter2 {

	for (i<-1 to 5) yield i                   //> res0: scala.collection.immutable.IndexedSeq[Int] = Vector(1, 2, 3, 4, 5)
	
	for (i<- 0 to 1;c<-"Hello") yield (c+i).toChar
                                                  //> res1: scala.collection.immutable.IndexedSeq[Char] = Vector(H, e, l, l, o, I, 
                                                  //| f, m, m, p)
	
	for (c<-"Hello"; i<-0 to 1) yield (c+i).toChar
                                                  //> res2: String = HIeflmlmop


//Exercises
	
	//Sol 1
	def signum(x:Int) = if (x>0) 1 else if (x<0) -1 else 0
                                                  //> signum: (x: Int)Int
	signum(-10)                               //> res3: Int = -1
	signum(10)                                //> res4: Int = 1
	signum(0)                                 //> res5: Int = 0
	
	
	
	//Sol 3
	var x:Unit={}                             //> x  : Unit = ()
	var y=0                                   //> y  : Int = 0
	x=y=1
	
	
	//Sol 4
	for (i<-10 to (0,-1)) println (i)         //> 10
                                                  //| 9
                                                  //| 8
                                                  //| 7
                                                  //| 6
                                                  //| 5
                                                  //| 4
                                                  //| 3
                                                  //| 2
                                                  //| 1
                                                  //| 0
	//Sol5
	def countdown (n:Int){
		for (i<-n to (0,-1)) println (i)
	
	}                                         //> countdown: (n: Int)Unit
	
	countdown(5)                              //> 5
                                                  //| 4
                                                  //| 3
                                                  //| 2
                                                  //| 1
                                                  //| 0
  //Sol 6
  var product=1;                                  //> product  : Int = 1
  for (ch<-"Hello") product*=ch
	println (product)                         //> 825152896
	
	
	//Sol 7
	product=1
	"Hello".foreach((ch:Char) => product*=ch)
	println (product)                         //> 825152896
	
	//Sol 8
	
	def productFunct(s:String)={
		var product=1
		s.foreach((ch:Char)=>product*=ch)
		product
	}                                         //> productFunct: (s: String)Int
	productFunct("Hello")                     //> res6: Int = 825152896
	
	
	//Sol 9
	def recursiveProduct(s:String):Int={
	
		if (s.size==0) 1
		else{
			s.head * recursiveProduct(s.tail)
		}
	
	}                                         //> recursiveProduct: (s: String)Int
	
	recursiveProduct("Hello")                 //> res7: Int = 825152896
	
	
	//Sol 10
	def power(x:Double, n:Int):Double={
	
		if (n>0 && n%2==0) {val y= power(x, n/2); y*y}
		else if (n>0) x * power (x, n-1)
		else if (n==0) 1
		else 1 / power (x, -n)
	}                                         //> power: (x: Double, n: Int)Double
	
	power (25,3)                              //> res8: Double = 15625.0
}