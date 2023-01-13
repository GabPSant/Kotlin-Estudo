// When Expression (Função when)
fun quando(objeto:Any){ // Estudo da função when
    when(objeto){
        // Quando chega num termo que é compativel vai parar de fazer o when
        is String -> println(objeto)// O "is" serve pra definir se for desse tipo
        !is Double -> println("Não é double")
        else -> println("Nossa, isso funciona")
    }
}
//When Statement (variavel when)
fun quandoVariavel(objeto:Any):Any {
    val estudo = when (objeto) {
        "Começo" -> 1
        2 -> 5
        7.8 -> "Cartman"
        else -> "Funcionou!"
    }
    return estudo
}
// Loop: for / Nos usamos o in para definir até onde vai o conjunto
fun para(){
    val bolos = listOf("cenoura","morango","chocolate") //listOf representa uma Lista/ArrayList
    for(bolo in bolos){
        println("Temos: bolo de $bolo!")
    }
}
// While e Do-While /
fun enquanto(){
    var lanche:Int = 0
    while(lanche <5){
        lanche++
    }
    println("Vôce está cheio depois de ${lanche} lanches")
    do{
        lanche--
    }while(lanche>0)
    println("Vôce está com fome (${lanche} lanches no estomago)")
}
//Iteratores
class Animal(val nome:String)
class Zoo(val animais:List<Animal>){
    operator fun iterator():Iterator<Animal>{ //Deve ser nomeado iterator para criar uma função de iteração
        return animais.iterator()
    }
}
fun main(){
    //Iterator
    val animais = listOf<Animal>(Animal("leão"),Animal("zebra"))
    val zoo = Zoo(animais)
    for(animal in zoo){
        println("Tem: ${animal.nome}")
    }

    quando(8)
    println(quandoVariavel("Começo"))
    para()
    enquanto()
}