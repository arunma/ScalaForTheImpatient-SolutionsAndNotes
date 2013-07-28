import scala.math._
import BigInt.probablePrime
import util.Random

object Chapter1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(105); 
	val sqrtt=sqrt(3);System.out.println("""sqrtt  : Double = """ + $show(sqrtt ));$skip(23); ;
	val sqr=pow(sqrtt, 2);System.out.println("""sqr  : Double = """ + $show(sqr ));$skip(17); 
	val minus=3-sqr;System.out.println("""minus  : Double = """ + $show(minus ));$skip(13); val res$0 = 
	
	"crazy"*3;System.out.println("""res0: String = """ + $show(res$0));$skip(12); val res$1 = 
	
	10 max 2;System.out.println("""res1: Int = """ + $show(res$1));$skip(32); 
	
	val big=(BigInt(2) pow 1024);System.out.println("""big  : scala.math.BigInt = """ + $show(big ));$skip(28); val res$2 = 

	probablePrime(12, Random);System.out.println("""res2: scala.math.BigInt = """ + $show(res$2));$skip(37); val res$3 = 
	
	(BigInt(100,Random) toString(36));System.out.println("""res3: String = """ + $show(res$3));$skip(14); val res$4 = 
	
	"hello"(0);System.out.println("""res4: Char = """ + $show(res$4));$skip(14); val res$5 = 
	"hello".last;System.out.println("""res5: Char = """ + $show(res$5));$skip(19); val res$6 = 
	
	"hello".take(3);System.out.println("""res6: String = """ + $show(res$6));$skip(17); val res$7 = 
	"hello".drop(3);System.out.println("""res7: String = """ + $show(res$7));$skip(24); val res$8 = 
	
	"hello".takeRight(3);System.out.println("""res8: String = """ + $show(res$8));$skip(22); val res$9 = 
	"hello".dropRight(3);System.out.println("""res9: String = """ + $show(res$9));$skip(101); 
	
	
	val sample={for (i<-(1 to 10).par) yield {(BigInt.probablePrime(100,Random) toString(36))}}.seq;System.out.println("""sample  : scala.collection.immutable.Seq[String] = """ + $show(sample ))}
	

	
	
	
	
}
