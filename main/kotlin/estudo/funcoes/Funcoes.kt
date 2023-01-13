package estudo

import jdk.incubator.foreign.ValueLayout.OfFloat

//Tipos de Funções Especiais ou de alto nível
//Infix Functions -> funções que tem um unico parametro
infix fun Int.repetir(frase:String) = frase.repeat(this)

val par = "Ferrari" to "Katrina" //'to' cria um par de valores
infix fun String.pares(outro:String) = Pair(this, outro)
val meuPar = "McLaren" pares "Lucas"

val sophia = Mulher("Sophia")
val claudia = Mulher("Claudia")
class Mulher(val nome:String){
    val GostaPessoa = mutableListOf<Mulher>()
    infix fun gosta(outro:Mulher) = GostaPessoa.add(outro) // -> Podem ser usados como extensões de classe
}

//Operator Fuctions -> "evolui" a função, permitindo o seu chamado com o simbolo de operação (precisa ser o operador)
operator fun Int.times(frase:String) = frase.repeat(this) //'times' é um operador
operator fun String.get(alcance:IntRange) = substring(alcance)
val string:String = "Sempre perdõe seus inimigos, nada os irrita mais"

//High Order Function -> Funções que usam outras funções como parametros e/ou retornam funções
//High Order Function (Operador)
fun calculo(x:Int,y:Int, operacao:(Int,Int) -> Int):Int{//Só coloque o tipo de resultado que você deseja usar
    return operacao(x,y)
}
/* '::' representa um operador de referência a metodos (method operaor reference)
    É usado para referenciar funções/metodos
 */
fun soma(x:Int,y:Int) = x+y
val somarResultado = calculo(5,4,::soma)
val multiplicacaoResultado = calculo(5,4){x,y -> x*y}// a lambda é usado para representar o tipo de cálculo
//High Order Function (Retorno)
fun operacao():(Int) ->Int{
    return ::quadrado
}
fun quadrado(x:Int) = x*x
val funcao = operacao()

//Lambda Function -> funções não declaradas, geralmente conectadas a uma váriavel
val caixaAlta1: (String) -> String = {frase:String -> frase.uppercase()} //todos os fatores bem definidos
val caixaAlta2: (String) -> String = {frase -> frase.uppercase()} //Já está definido no tipo variável
val caixaAlta3 = {frase:String -> frase.uppercase()}// Sem definição do tipo na variável
// val caixaAlta4 = {frase -> frase.uppercase()}, não funciona pois é impossivel saber sem pelo menos uma definição
val caixaAlta5:(String) -> String = {it.uppercase()} //para lambdas de uma parametro unico, podemos usar 'it'
val caixaAlta6:(String) -> String = String::uppercase //Se consiste em uma função unica é possivel usar '::'
//Extension Functions and Proprieties -> permite adicionar membros e/ou extensões a classes
data class Item(val nome:String, val preco:Float)
data class Ordem(val itens: Collection<Item>)
//maxByOrNull ->  retorna o maior valor de todos os elementos ou retorna null se não tiver elementos
//Nesse tem como definir qual vai retornar na função
//Para float adicione um F no final do número
fun Ordem.precoMaximo(): Float = this.itens.maxByOrNull { it.preco }?.preco ?: 0F
fun Ordem.produtoMaisCaro():String = this.itens.maxByOrNull { it.preco }?.nome ?: "Sem produtos"

val Ordem.listaDeItens:String
    get() = itens.joinToString { it.nome }
val organizar = Ordem(listOf(Item("Pão",25.0F),Item("Vinho", 29.0F),Item("Água",12.0F)))

//Extension Functions and Proprieties (Generics) -> É possivel usar com null safety
fun <A> A?.protecaoNull():String = this?.toString() ?: "Vazio"// não precisa definir o tipo de retorno, a função pode inferir

fun main(){
    /*Infix function
    println(2 repetir "Tchau ")
    println(par)
    println(meuPar)
    println(sophia gosta claudia)
    */
    /*Operator function
    println(2 * "Bye ")
    println(string[0..26])
    */
    /*High Order Function (Parametros)
    println("Calculos:\nResultado (soma) = $somarResultado\nResultado (multiplicador) = $multiplicacaoResultado")
     */
    // High Order Function (Retorno) -> println("O quadrado é: ${funcao(2)}")
    /*Lambda Function
    println("${caixaAlta1("Mãe")}\n${caixaAlta2("Mãe")}\n${caixaAlta3("Mãe")}\n${caixaAlta5("Mãe")}\n${caixaAlta6("Mãe")}")
     */
    /*Extension Functions and Proprieties
    println("Produto mais caro: ${organizar.produtoMaisCaro()}")
    println("Maior preço dos produtos: ${organizar.precoMaximo()}")
    println("Lista de produtos: ${organizar.listaDeItens}")
    */
    /*Extension Functions and Proprieties (Generics) e NullSafety
    println(null.protecaoNull())
    println(15.protecaoNull())
    println("Kotlin".protecaoNull())
    */
}