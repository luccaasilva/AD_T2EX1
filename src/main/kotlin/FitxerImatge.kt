import java.io.File

class FitxerImatge(fEnt: File) {
    var f: File = File("")

    init {
        if (fEnt.name.contains(".bmp")) {
            f = fEnt;
        }
    }
    fun transformaNegatiu() {
        val original = f.readBytes()
        val fotoNegativa = File("resources/penyagolosa_n.bmp")
        for (i in original.indices) {
            original[i] = if (i < 54) continue else (255 - original[i]).toByte()
        }
        fotoNegativa.writeBytes(original)
    }


    fun transformaObscur() {
        val original = f.readBytes()
        val fotoOsurecida = File("resources/penyagolosa_o.bmp")
        for (i in original.indices) {
            original[i] = (if (i > 54) (original[i].toUByte() / 2U)
            else continue).toByte()
        }
        fotoOsurecida.writeBytes(original)
    }

    fun transformaBlancNegre() {
        val original = f.readBytes()
        val fotoEscalaDeGris = File("resources/penyagolosa_bn.bmp")
        for (i in 54..original.size - 3 step 3) {
            val r = original[i].toUByte()
            val g = original[i + 1].toUByte()
            val b = original[i + 2].toUByte()
            original[i] = ((r + g + b) / 3U).toByte()
            original[i + 1] = ((r + g + b) / 3U).toByte()
            original[i + 2] = ((r + g + b) / 3U).toByte()
        }
        fotoEscalaDeGris.writeBytes(original)
    }
}