class MenuController {
    private val printer = Printer()
    private val reservationController = ReservationController()
    private val clienteController = ClienteController()
    private val roomController = RoomController(printer)

    fun showMenu() {
        printer.apply {
            printMsg("Ingrese una opción.")
            printMsg("1.- Registrar habitación.")
            printMsg("2.- Registrar cliente.")
            printMsg("3.- Crear reservación.")
            printMsg("4.- Mostrar habitaciones.")
            printMsg("5.- Mostrar clientes.")
            printMsg("6. Mostrar reservaciones.")

            val selectedOption = readln().toInt()
            validateOptions(selectedOption)
        }
    }

    private fun validateOptions(selectedOption: Int) {
        when (selectedOption) {
            1 -> {
                roomController.registerRoom()
                println("")
                showMenu()
            }

            2 -> {
                clienteController.registerCliente()
                println("")
                showMenu()
            }

            3 -> {
                selectRoomAndCliente()
                println("")
                showMenu()
            }

            4 -> {
                roomController.showRoom()
                println("")
                showMenu()
            }

            5 -> {
                clienteController.showClientes()
                println("")
                showMenu()
            }

            6 -> {
                reservationController.showReservations()
                println("")
                showMenu()
            }
        }
    }

    private fun selectRoomAndCliente() {
        if (clienteController.areNotClientRegistered()) {
            printer.printMsg("No se encuentran clientes registrados")
            showMenu()
            return
        }

        if (roomController.areNotRoomRegistered()) {
            printer.printMsg("No se encuentran clientes registrados")
            showMenu()
            return
        }

        printer.printMsg("Selecciona un cliente")
        clienteController.showClientes()

        val selectedClienteIndex = readln().toInt()
        val cliente = clienteController.getClienteByIndex(selectedClienteIndex - 1)

        printer.printMsg("Seleccione una habitación")
        roomController.showRoom()
        val selectedRoomIndex = readln().toInt()
        val room = roomController.getRoomByIndex(selectedRoomIndex - 1)

        if (room != null){
            reservationController.createReservation(cliente, room)
        } else {
            printer.printMsg("Habitación no válida")
        }
    }
}
