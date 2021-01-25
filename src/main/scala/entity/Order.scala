package entity

import java.time.LocalDateTime

class Order (
              val customerName: String,
              val contact: String,
              val shippingAddress: String,
              val grandeTotal: BigDecimal,
              val placeOrderDate: LocalDateTime,
              var items: List[Item]
            ){
   def canEqual(a: Any) = a.isInstanceOf[Order]

  override def equals(that: Any): Boolean =
    that match {
      case that: Order => {
        that.canEqual(this) &&
          this.items == that.items &&
          this.placeOrderDate == that.placeOrderDate &&
          this.grandeTotal == that.grandeTotal &&
          this.customerName == that.customerName &&
          this.contact == this.contact &&
          this.shippingAddress == this.shippingAddress
      }
      case _ => false
    }

  override def hashCode: Int = {
    val prime = 31
    var result = 1
    result = prime * result + (if (items == null) 0 else items.hashCode)
    result + super.hashCode
  }
}
