class Cliente(

    val name: String,
    val firstLastName: String,
    val secondLastName: String,
    val address: String,
    val rfc: String,
    val phoneNumber: Int,
    val email: String,
    private val reservationList: MutableList<Reservation> = mutableListOf()
) {
    fun getClienteData(): String {
        return "Nombre: $name $firstLastName $secondLastName RFC: $rfc Dirección: $address, Teléfono: $phoneNumber, Email: $email"
    }

    fun addReservation(reservation: Reservation) {
        reservationList.add(reservation)
    }
}