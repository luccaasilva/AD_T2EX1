import java.io.File

fun main(args: Array<String>) {
    val f = File("resources/penyagolosa.bmp")

    val file = FitxerImatge(f)
    file.transformaNegatiu()
    file.transformaObscur()
    file.transformaBlancNegre()
}