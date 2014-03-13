import scala.math._
import BigInt.probablePrime
import util.Random

object Chapter1 {
	val sqrtt=sqrt(3);                        //> sqrtt  : Double = 1.7320508075688772
	val sqr=pow(sqrtt, 2)                     //> sqr  : Double = 2.9999999999999996
	val minus=3-sqr                           //> minus  : Double = 4.440892098500626E-16
	
	"crazy"*3                                 //> res0: String = crazycrazycrazy
	
	10 max 2                                  //> res1: Int = 10
	
	val big=(BigInt(2) pow 1024)              //> big  : scala.math.BigInt = 1797693134862315907729305190789024733617976978942
                                                  //| 3065727343008115773267580550096313270847732240753602112011387987139335765878
                                                  //| 9768814416622492847430639474124377767893424865485276302219601246094119453082
                                                  //| 9520850057688381506823424628814739131105408272371633505106845862982399472459
                                                  //| 38479716304835356329624224137216

	probablePrime(12, Random)                 //> res2: scala.math.BigInt = 3037
	
	(BigInt(100,Random) toString(36))         //> res3: String = 1x1br93540v2e5digp1w
	
	"hello".head                                //> res4: Char = h
	"hello".last                              //> res5: Char = o
	
	"hello".take(3)                           //> res6: String = hel
	"hello".drop(3)                           //> res7: String = lo
	
	"hello".takeRight(3)                      //> res8: String = llo
	"hello".dropRight(3)                      //> res9: String = he
	
	
	val sample={for (i<-(1 to 10).par) yield {(BigInt.probablePrime(100,Random) toString(36))}}.seq
                                                  //> sample  : scala.collection.immutable.Seq[String] = Vector(2f8hpmdai7l5kfi5od
                                                  //| ut, 2q1iaynxo1b7puo35i5d, 2oyczhor6enjfzde5yk1, 28e2762fpw56bq7upp2t, 215w0v
                                                  //| n87hjib56415dp, 2m0rcir5igevm3jke1wp, 39dxc2kksxy5brdiwo0h, 2budqn1306k79wj0
                                                  //| 7fov, 2xzwb0fzws6aqh5dj7lj, 2ksc3yb7isite8qb07nz)
	

	
	
	
	
}
