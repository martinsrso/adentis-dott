package entity

import java.time.LocalDateTime

class Product (
                val name: String,
                val category: String,
                val weightInGrams: Int,
                val price: Double,
                val createDate: LocalDateTime
              ) {
  def canEqual(a: Any) = a.isInstanceOf[Product]

  override def equals(that: Any): Boolean =
    that match {
      case that: Product => {
        that.canEqual(this) &&
          this.name == that.name &&
          this.category == that.category &&
          this.weightInGrams == that.weightInGrams &&
          this.price == that.price &&
          this.createDate == that.createDate
      }
      case _ => false
    }

  override def hashCode: Int = {
    val prime = 31
    var result = 1
    result = prime * result + (if (name == null) 0 else name.hashCode)
    result + super.hashCode
  }
}

