package entity

import java.time.LocalDateTime

class Product (
                val name: String,
                val category: String,
                val weightInGrams: Int,
                val price: Double,
                val createDate: LocalDateTime
              )

