import entity.Order
import example.Data
import picocli.CommandLine
import picocli.CommandLine.{Parameters}
import worker.Worker

import java.time.LocalDateTime
import java.util.concurrent.Callable
import scala.collection.parallel.CollectionConverters.ImmutableIterableIsParallelizable


class DefaultParameter extends Callable[Int] {
  @Parameters(index = "0")
  private var firstDate: String = ""

  @Parameters(index = "1")
  private var secondDate: String = ""

  @Parameters(index = "2", defaultValue = "1-3 4-7 8-12 >12")
  private var ranges: String = ""

  def call(): Int = {
    val startDate = LocalDateTime.parse(firstDate.replace(" ", "T"))
    val endDate = LocalDateTime.parse(secondDate.replace(" ", "T"))

    val orders = Data.generateOrders
    val filteredOrders = Worker.filterOrderInterval(startDate, endDate, orders)

    val tuplesRanges = (Worker.mountRange(ranges))
    tuplesRanges.par.map(item => {
      if (item._2 == Integer.MAX_VALUE) {
        println(">" + item._1 + " months: " + Worker.countOrdersByInterval(startDate, filteredOrders, item._1, item._2) + " orders")
      } else {
        println(item._1 + "-" + item._2 + " months: " + Worker.countOrdersByInterval(startDate, filteredOrders, item._1, item._2) + " orders")
      }
    })
    0
  }
}

object OrderFilter {
  def main(args: Array[String]): Unit = {
    System.exit(new CommandLine(new DefaultParameter()).execute(args: _*))
  }
}
