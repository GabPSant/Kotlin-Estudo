/*
var --> Variavel mutável
val --> variavel imutável (preferivel)

val estudo:String? --> tem NullSafety
val estudo:String --> não tem NullSafety
 */
// class Anotacoes(var comeco:String) -- Pode criar classes dentro de arquivos
fun muitas(vararg comeco:String){
    for(c in comeco){
        println(c)
    }
}
fun soma(x:Int = 1,y:Int = 1):Int =  x+y
fun main(){
    var comeco:String? = null
    println(comeco)
    println("Resultado da soma: ${soma()}")
    muitas("comida","frutas","carne","abacaxi")
}