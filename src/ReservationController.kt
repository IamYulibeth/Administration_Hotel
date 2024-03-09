class ReservationController {

    private val printer = Printer()
    private val reservationList = mutableListOf<Reservation>()

    fun createReservation(cliente: Cliente, room: Room) {
        printer.printMsg("Ingresa la fecha de entrada")
        val dateEntrada = readln()
        printer.printMsg("Ingrese la fecha de salida")
        val dateSalida = readln()
        printer.printMsg("Ingrese el número de noches")
        val totalNight = readln().toInt()

        val addedReservation = Reservation(
            room, cliente, dateEntrada, dateSalida, totalNight
        )

        addedReservation.calcularTotal()
        cliente.addReservation(addedReservation)
        reservationList.add(addedReservation)
    }

    fun showReservations() {
        if (reservationList.isEmpty()) {
            printer.printMsg("No hay habitaciones registradas")
        } else {
            var counter = 1
            for (reservation in reservationList) {
                printer.printMsg("$counter" + reservation.getReservationData())
                counter++
            }
        }
    }
}