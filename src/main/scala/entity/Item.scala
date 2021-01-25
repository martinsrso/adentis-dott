package entity

class Item(
            val cost: BigDecimal,
            val shippingFee: BigDecimal,
            val taxAmount: BigDecimal,
            val product: Product
          ) {
  def canEqual(a: Any) = a.isInstanceOf[Item]

  override def equals(that: Any): Boolean =
    that match {
      case that: Item => {
        that.canEqual(this) &&
          this.cost == that.cost &&
          this.shippingFee == that.shippingFee &&
          this.taxAmount == that.taxAmount &&
          this.product == that.product
      }
      case _ => false
    }

  override def hashCode: Int = {
    val prime = 31
    var result = 1
    result = prime * result + (if (product == null) 0 else product.hashCode)
    result + super.hashCode
  }
}


