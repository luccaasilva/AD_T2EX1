import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream


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
            original[i] = if (i > 54) (original[i] / 2).toByte()
            else continue
        }
        fotoOsurecida.writeBytes(original)
//        val f_in = FileInputStream(f)
//        val f_out = FileOutputStream("resources/penyagolosa_o.bmp")
//        var pixel = 0
//        for (i in 0..53) {
//            pixel = f_in.read()
//            f_out.write(pixel)
//        }
//        while (pixel != -1) {
//            pixel = f_in.read()
//            f_out.write(pixel / 2)
//        }



    }

    fun transformaBlancNegre() {

        val original = f.readBytes()
        val fotoEscalaDeGris = File("resources/penyagolosa_bn.bmp")
        var r: Byte
        var g: Byte
        var b: Byte
        for (i in 54..original.size - 3 step 3) {
            r = original[i]
            g = original[i + 1]
            b = original[i + 2]
            original[i] = ((r + g + b) / 3).toByte()
            original[i + 1] = ((r + g + b) / 3).toByte()
            original[i + 2] = ((r + g + b) / 3).toByte()
        }
        fotoEscalaDeGris.writeBytes(original)
//        val f_in = FileInputStream(f)
//        val f_out =
//            FileOutputStream("resources/penyagolosa_bn.bmp")
//        var pixel = 0
//        var r = 0
//        var g = 0
//        for (i in 0..53) {
//            pixel = f_in.read()
//            f_out.write(pixel)
//        }
//        while (pixel != -1) {
//            pixel = f_in.read()
//            r = f_in.read()
//            g = f_in.read()
//            f_out.write((pixel + r + g) / 3)
//            f_out.write((pixel + r + g) / 3)
//            f_out.write((pixel + r + g) / 3)
//        }
//

    }


}