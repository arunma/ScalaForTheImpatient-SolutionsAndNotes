object ArrayAdjSwap {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(281); 
  	//Chapter 2. Problem 2
 	
 	def swapArray(n:Array[Int]):Array[Int]={
 		
 		println (n.length)
 		
 		(for (i<- 0 until n.length)
 			
 			yield
 			if (i%2==0 && n.length ==i+1) n(i)
 			else if (i%2!=0) n(i-1)
 			else n(i+1)
 			
 		).toArray
 		
 	
 	};System.out.println("""swapArray: (n: Array[Int])Array[Int]""");$skip(36); val res$0 = 
   
  swapArray(Array(1,2,3,4,5,6));System.out.println("""res0: Array[Int] = """ + $show(res$0));$skip(30); val res$1 = 
  swapArray(Array(1,2,3,4,5));System.out.println("""res1: Array[Int] = """ + $show(res$1))}
                            
  
  
}
