package example

import entity.Item
import entity.Product

import java.time.{LocalDate, LocalDateTime, LocalTime, Month}
import java.util
import scala.collection.mutable.ListBuffer
import scala.util.Random


//  val cost: BigDecimal,
//  val shippingFee: BigDecimal,
//  val taxAmount: BigDecimal,
//  val product: Product
object Items {
  private val mockItems = new util.ArrayList[Item]

  protected def populateItems(): Unit = if (mockItems.size() < 15) {
    // 1 - 3 months
    val product1 = new Product("butter", "food", 500, 2.0D, LocalDateTime.of(LocalDate.of(2020, Month.MARCH, 20), LocalTime.of(0, 0, 0)))
    mockItems.add(new Item(BigDecimal.valueOf(1L) + BigDecimal.valueOf(6L) + product1.price, 1D, BigDecimal.valueOf(6L), product1))
    val product2 = new Product("flour", "food", 1000, 0.65D, LocalDateTime.of(LocalDate.of(2020, Month.FEBRUARY, 1), LocalTime.of(0, 0, 0)))
    mockItems.add(new Item(BigDecimal.valueOf(1L) + BigDecimal.valueOf(6L) + product2.price, 1D, BigDecimal.valueOf(6L), product2))
    val product3 = new Product("sugar", "food", 1000, 0.9D, LocalDateTime.of(LocalDate.of(2020, Month.JANUARY, 1), LocalTime.of(0, 0, 0)))
    mockItems.add(new Item(BigDecimal.valueOf(1L) + BigDecimal.valueOf(6L) + product3.price, 1D, BigDecimal.valueOf(6L), product3))

    // 4 - 6 months
    val product4 = new Product("water", "food", 1000, 0.45D, LocalDateTime.of(LocalDate.of(2019, Month.DECEMBER, 1), LocalTime.of(0, 0, 0)))
    mockItems.add(new Item(BigDecimal.valueOf(1L) + BigDecimal.valueOf(6L) + product4.price, BigDecimal.valueOf(1L), BigDecimal.valueOf(6L), product4))

    val product5 = new Product("rice", "food", 1000, 0.80D, LocalDateTime.of(LocalDate.of(2019, Month.NOVEMBER, 1), LocalTime.of(0, 0, 0)))
    mockItems.add(new Item(BigDecimal.valueOf(1L) + BigDecimal.valueOf(6L) + product5.price, BigDecimal.valueOf(1L), BigDecimal.valueOf(6L), product5))

    val product6 = new Product("black beans", "food", 1000, 1.25D, LocalDateTime.of(LocalDate.of(2019, Month.OCTOBER, 1), LocalTime.of(0, 0, 0)))
    mockItems.add(new Item(BigDecimal.valueOf(1L) + BigDecimal.valueOf(6L) + product6.price, BigDecimal.valueOf(1L), BigDecimal.valueOf(6L), product6))
    // 7 - 12 months
    val product7 = new Product("shampoo", "higene", 1000, 1.0D, LocalDateTime.of(LocalDate.of(2019, Month.SEPTEMBER, 1), LocalTime.of(0, 0, 0)))
    mockItems.add(new Item(BigDecimal.valueOf(3L) + BigDecimal.valueOf(12L) + product7.price, BigDecimal.valueOf(3L), BigDecimal.valueOf(12L), product7))

    val product8 = new Product("toothpaste", "higene", 300, 0.9D, LocalDateTime.of(LocalDate.of(2019, Month.AUGUST, 1), LocalTime.of(0, 0, 0)))
    mockItems.add(new Item(BigDecimal.valueOf(3L) + BigDecimal.valueOf(12L) + product8.price, BigDecimal.valueOf(3L), BigDecimal.valueOf(12L), product8))

    val product9 = new Product("soap", "higene", 150, 0.35D, LocalDateTime.of(LocalDate.of(2019, Month.JULY, 1), LocalTime.of(0, 0, 0)))
    mockItems.add(new Item(BigDecimal.valueOf(3L) + BigDecimal.valueOf(12L) + product9.price, BigDecimal.valueOf(3L), BigDecimal.valueOf(12L), product9))
    val product10 = new Product("deodorant", "higene", 350, 2.4D, LocalDateTime.of(LocalDate.of(2019, Month.JUNE, 1), LocalTime.of(0, 0, 0)))
    mockItems.add(new Item(BigDecimal.valueOf(3L) + BigDecimal.valueOf(12L) + product10.price, BigDecimal.valueOf(3L), BigDecimal.valueOf(12L), product10))
    val product11 = new Product("toothbrush", "higene", 100, 1.3D, LocalDateTime.of(LocalDate.of(2019, Month.APRIL, 1), LocalTime.of(0, 0, 0)))
    mockItems.add(new Item(BigDecimal.valueOf(3L) + BigDecimal.valueOf(12L) + product11.price, BigDecimal.valueOf(3L), BigDecimal.valueOf(12L), product11))
    val product12 = new Product("hair gel", "higene", 11000, 0.80D, LocalDateTime.of(LocalDate.of(2019, Month.MARCH, 1), LocalTime.of(0, 0, 0)))
    mockItems.add(new Item(BigDecimal.valueOf(3L) + BigDecimal.valueOf(12L) + product12.price, BigDecimal.valueOf(3L), BigDecimal.valueOf(12L), product12))
    // > 12 months
    val product13 = new Product("lcd television", "electronics", 15000, 300.0D, LocalDateTime.of(LocalDate.of(2018, Month.DECEMBER, 1), LocalTime.of(0, 0, 0)))
    mockItems.add(new Item(BigDecimal.valueOf(10L) + BigDecimal.valueOf(23L) + product13.price, 10L, BigDecimal.valueOf(23L), product13))
    val product14 = new Product("nintendo switch", "electronics", 1000, 150.0D, LocalDateTime.of(LocalDate.of(2018, Month.NOVEMBER, 1), LocalTime.of(0, 0, 0)))
    mockItems.add(new Item(BigDecimal.valueOf(10L) + BigDecimal.valueOf(23L) + product14.price, BigDecimal.valueOf(10L), BigDecimal.valueOf(23L), product14))
    val product15 = new Product("Samsung Galaxy", "electronics", 300, 450.0D, LocalDateTime.of(LocalDate.of(2018, Month.OCTOBER, 1), LocalTime.of(0, 0, 0)))
    mockItems.add(new Item(BigDecimal.valueOf(10L) + BigDecimal.valueOf(23L) + product15.price, BigDecimal.valueOf(10L), BigDecimal.valueOf(23L), product15))
  }

  def generateRandomItemsList: List[Item] = {
    populateItems()
    val itemList = ListBuffer[Item]()
    val listSize = new Random().nextInt(5) + 1

    for (i <- 0 to listSize)
      itemList += mockItems.get(new Random().nextInt(mockItems.size))

    itemList.toList
  }

  def generateItemsList: List[Item] = {
    populateItems()
    val itemList = ListBuffer[Item]()

    for (i <- 0 to mockItems.size()-1)
      itemList += mockItems.get(i)

    itemList.toList
  }
}
