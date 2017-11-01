import scala.io.Source

object Missile{
def main(args:Array[String]){

val bs=Source.fromFile(args(0))
val lines= bs.getLines()

val Sales= lines.map(record=>{
val object=SalesRecord.parse(record)
if(object.isRight) (true, object.right.get)
else (false, record)
})

val GoodRecords=Sales.filter(_._1==true).map(_._2)
val BadRecords=Sales.filter(_._1==false).map(_._2)

GoodRecords.foreach(println)

bs.close()
}
}

case class SalesRecord(ID:Int,Name:String,Sal:Int){}

object SalesRecord{
def parse(x:String):Either[MalFormedException, SalesRecord]={
val y=x.split(",")
if(y.length!=3) Left(new MalFormedException)
else Right(SalesRecord(y(0).toInt,y(1),y(2).toInt))
}
}

class MalFormedException extend Exception{}
