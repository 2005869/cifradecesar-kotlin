import java.util.Scanner

val chave: Int = 13
var opcao: Int = 0
val scanner = Scanner(System.`in`)

fun main(args: Array<String>) {

    println("Digite a opção desejada:\n\n1 - Codificar\n2 - Decodificar\n0 - Sair\n")

    opcao = scanner.nextLine().toInt()

    when (opcao) {
        1 -> codificar()
        2 -> decodificar()
        0 -> return
    }
}

fun codificar() {
    println("Digite a frase a ser codificada")
    var frase: String = scanner.nextLine()
    var fraseCodificada: String = ""
    var decLetra: Int

    for (letra in frase) {
        decLetra = letra.code
        var decNovo: Int = decLetra + chave

        if (letra == ' ') {
            fraseCodificada += ' '
        } else if (decNovo > 122) {
            var diferenca: Int = decNovo - 122
            fraseCodificada += (65 + diferenca).toChar()
        } else {
            fraseCodificada += (letra + chave)
        }
    }
    print(fraseCodificada)
}

fun decodificar() {
    println("Digite a frase a ser decodificada")
    var fraseCodificada: String = scanner.nextLine()
    var fraseDecodificada: String = ""
    var decLetra: Int

    for (letra in fraseCodificada) {
        decLetra = letra.code
        var decNovo: Int = decLetra - chave
        if (letra == ' ') {
            fraseDecodificada += ' '
        } else if (decNovo < 65) {
            var diferenca: Int = 65 - decNovo
            fraseDecodificada += (122 - diferenca).toChar()
        } else {
            fraseDecodificada += letra - chave
        }
    }
    print(fraseDecodificada)
}
