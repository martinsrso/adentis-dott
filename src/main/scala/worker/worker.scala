package worker

import entity.Order

import java.time.LocalDateTime
import scala.collection.mutable.ListBuffer

object Worker {
  def countOrdersByInterval(startDate: LocalDateTime,
                            listOrder: List[Order],
                            startInterval: Int,
                            endInterval: Int
                           ): Int = {
    val compareStartDate = startDate.plusMonths(startInterval)
    val compareEndDate = startDate.plusMonths(endInterval)
    listOrder.filter((order: Order) => order.items
      .exists((item) =>
        item.product.createDate.isAfter(compareStartDate) &&
          item.product.createDate.isBefore(compareEndDate)))
      .size
  }

  def filterOrderInterval(
                           startDate: LocalDateTime,
                           endDate: LocalDateTime,
                           listOrder: List[Order]
                         ): List[Order] = {

    listOrder.filter((order: Order) => order.items
      .exists((item) =>
        item.product.createDate.isBefore(endDate) &&
          item.product.createDate.isAfter(startDate)))
  }

  def mountRange(ranges: String): List[(Int, Int)] = {
    val replaceRanges = ranges.replace(">", "")
    val arrRanges = replaceRanges.split(" ")
    var listTuples = new ListBuffer[(Int, Int)]()
    arrRanges.toList.foreach(item => {
      val intervals = item.split("-")
      if (intervals.size > 1) {
        listTuples.addOne((Integer.valueOf(intervals.toList.head), Integer.valueOf(intervals.toList.last)))
      } else {
        listTuples.addOne((Integer.valueOf(intervals.toList.head), Integer.MAX_VALUE))
      }
    })
    listTuples.toList
  }
}
