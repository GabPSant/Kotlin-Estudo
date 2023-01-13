//Verificações de Igualdades: '==' e '==='
fun igualdade(){
    val autores = setOf("Shakespeare", "Hemingway", "Twain")
    val escritores = setOf("Twain", "Shakespeare", "Hemingway")

    println(autores == escritores)   //Avalia de forma autores.equals(escritores), sem avaliar a ordem dos elementos
    println(autores === escritores) //Avalia os valores e a ordem dos elementos
}
fun main(){
    igualdade()
}