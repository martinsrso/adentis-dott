package example

import java.time.{LocalDate, LocalDateTime, LocalTime, Month}
import java.util.concurrent.ThreadLocalRandom

object PlacedOrderDate {
  private val minDay = LocalDate.of(2018, Month.OCTOBER.getValue, 1).toEpochDay
  private val maxDay = LocalDate.now.toEpochDay

  def getRandomPlacedOrderDate: LocalDateTime = {
    val randomDay = ThreadLocalRandom.current.nextLong(minDay, maxDay)
    val randomDate = LocalDate.ofEpochDay(randomDay)
    LocalDateTime.of(randomDate, LocalTime.now)
  }
}
