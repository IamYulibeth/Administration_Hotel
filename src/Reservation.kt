class Reservation(
    private val room: Room,
    val cliente: Cliente,
    private val dateEntrada: String,
    private val dateSalida: String,
    private var totalNight: Int,
    private var isCancelled: Boolean = false,
) {
    var priceTotal: Float = 0.0f

    init {
        calcularTotal()
    }

    fun calcularTotal() {
        priceTotal = room.priceRoom * totalNight
    }

    fun cancelBooking() {
        isCancelled = true
    }

    fun updateNights(totalNight: Int) {
        this.totalNight = totalNight
        calcularTotal()
    }

    fun getTotal(): Float = priceTotal



    fun getReservationData(): String {
        return "Habitación: $room" +
                "Cliente: $cliente"
                "Total de noches: $totalNight" +
                "Fechas: $dateEntrada, $dateSalida" +
                "Total a pagar: $priceTotal"
    }

}