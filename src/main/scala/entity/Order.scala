package entity

import java.time.LocalDateTime

class Order (
              val customerName: String,
              val contact: String,
              val shippingAddress: String,
              val grandeTotal: BigDecimal,
              val placeOrderDate: LocalDateTime,
              var items: List[Item]
            )
