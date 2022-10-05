import java.io.File

class FitxerImatge(fEnt: File) {
    var f: File = File("")

    init {
        f=fEnt
        if (fEnt.name.contains(".bmp")) {
            f = fEnt;
        }
    }

    fun transformaNegatiu() {
        val original = f.readBytes()
        val fotoNegativa = File("resources/penyagolosa_n.bmp")
        for (i in original.indices) {
            if (i < 54) original[i] = (255 - original[i]).toByte()
            else continue
        }
        fotoNegativa.writeBytes(original)

    }
}

fun transformaObscur() {
    // Transformar a una imatge més fosca i guardar en _o.bmp

}

fun transformaBlancNegre() {
    // Transformar a una imatge en blanc i negre i guardar en _bn.bmp


}