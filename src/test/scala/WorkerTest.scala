import entity.{Item, Order, Product}
import example.Data.calculateGrandTotal
import example.{Addresses, CustomerName, Items, PlacedOrderDate}
import org.scalatest.funsuite.AnyFunSuite
import worker.Worker

import java.time.{LocalDate, LocalDateTime, LocalTime, Month}
import java.util
import scala.collection.immutable.HashMap
import scala.collection.mutable.ListBuffer

class WorkerTest extends AnyFunSuite {
  val maxValue = Integer.MAX_VALUE

  val casesRange: HashMap[String, List[(Int, Int)]] = HashMap(
    "1-3" -> List((1, 3)),
    "1-3 4-7 8-12 >12" -> List((1, 3), (4, 7), (8, 12), (12, Integer.MAX_VALUE)),
    "12" -> List((12, Integer.MAX_VALUE))
  )
  test("Testing the range inputs") {
    casesRange.map(c => {
      assert(c._2 == Worker.mountRange(c._1))
    })
  }

  val mockItems = Items.generateItemsList
  var orders = ListBuffer[Order]()

  val order1 = new Order("Rafael", "rafael@gmail.com", "", null, LocalDateTime.parse("2016-01-01T00:00:00"), mockItems)
  val order2 = new Order("Rafael", "rafael@gmail.com", "", null, LocalDateTime.parse("2017-01-01T00:00:00"), mockItems)
  val order3 = new Order("Rafael", "rafael@gmail.com", "", null, LocalDateTime.parse("2018-01-01T00:00:00"), mockItems)
  val order4 = new Order("Rafael", "rafael@gmail.com", "", null, LocalDateTime.parse("2019-01-01T00:00:00"), mockItems)
  val order5 = new Order("Rafael", "rafael@gmail.com", "", null, LocalDateTime.parse("2020-01-01T00:00:00"), mockItems)

  orders += order1
  orders += order2
  orders += order3
  orders += order4
  orders += order5

  val startDate = LocalDateTime.parse("2018-01-01T00:00:00")
  val endDate = LocalDateTime.parse("2019-01-01T00:00:00")
  val casesFiltered: HashMap[List[Order], List[Order]] = HashMap(
    orders.toList -> orders.toList
  )
  test("Testing the filtered orders") {
    casesFiltered.map(c => {
      assert(c._1.equals(Worker.filterOrderInterval(startDate, endDate, c._2)))
    })
  }

  val casesCount: HashMap[Int, Int] = HashMap(
    5 -> 5
  )
  test("Testing the order counts") {
    casesCount.map(c => {
      assert(c._1 == Worker.countOrdersByInterval(startDate, orders.toList, 0, 12))
    })
  }

}
