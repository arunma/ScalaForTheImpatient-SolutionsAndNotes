import scala.collection.JavaConversions.propertiesAsScalaMap
import scala.collection.mutable.Map

object Dummy {
  
  def lteqgt(values:Array[Int], v:Int)={
	  
	  (values.count(_ <  v),
	  values.count(_ == v),
	  values.count(_ >  v))
  }
	
  def main(args: Array[String]) {
	  println (Dummy.lteqgt(Array(1,4,5,4,23,56,3), 5));
  }

}