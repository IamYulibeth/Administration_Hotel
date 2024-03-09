class Room(
    val numRoom: Int,
    val typeRoom: String,
    val disponibility: Boolean,
    val capacityPerson: Int,
    val description: String,
    val priceRoom: Float,
    val isAvailable: Boolean = true
) {
    fun getRoomData():String{
        return  "Número de habitación: $numRoom"
                "Tipo de habitación: $typeRoom"
                "Disponibilidad: $disponibility ${if (isAvailable) "Si" else "No"}"
                "Capacidad de personas: $capacityPerson"
                "Descripción de la habitación: $description"
                "Precio de la habitación: $priceRoom"
    }
}