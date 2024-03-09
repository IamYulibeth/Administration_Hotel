class RoomController(private val printer: Printer) {

    private val roomList = mutableListOf<Room>()


    fun registerRoom() {
        printer.printMsg("Ingrese el número de la habitación:")
        val numRoom = readln().toInt()
        printer.printMsg("Ingrese el tipo de habitación:")
        val typeRoom = readln().toString()
        printer.printMsg("Capacidad de personas:")
        val capacityPerson = readln().toInt()
        printer.printMsg("Ingrese el precio por noche")
        val priceporNight = readln().toFloat()
        printer.printMsg("Descripción de la habitación:")
        val details = readln().toString()
        val isAvailable = true

        val addedRoom = Room( numRoom, typeRoom, true, capacityPerson, details, priceporNight, isAvailable)
        roomList.add(addedRoom)
    }

    fun modifyRoom(modifiedRoom: Room, index: Int) {
        if (index in roomList.indices) {
            roomList[index] = modifiedRoom
        } else {
            printer.printMsg("Índice de habotación no valido")
        }
    }

    fun getRoomByIndex(index: Int): Room? {
        return if (index in roomList.indices) {
            roomList[index]
        } else {
            printer.printMsg("Índice de habitación no válido")
            null
        }
    }

    fun showRoom() {
        if (roomList.isEmpty()) {
            printer.printMsg("No se encuentran habitaciones registradas")
        } else {
            var counter = 1
            for (room in roomList) {
                printer.printMsg("$counter" + room.getRoomData())
                counter++
            }
        }
    }

    fun areNotRoomRegistered(): Boolean = roomList.isEmpty()
}