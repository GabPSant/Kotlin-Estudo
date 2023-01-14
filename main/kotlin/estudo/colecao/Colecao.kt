package estudo.colecao
//Lista (List)
private val usuarios:MutableList<Int> = mutableListOf()//Lista mutavel
private val usuariosRegistrados:List<Int> = usuarios//Lista imutavel, não pode adicionar elementos de forma posterior

fun lista(){
    usuarios.add(5)
    println("Usuarios registrados: $usuariosRegistrados")
    usuarios.forEach{//forEach permite fazer um loop para mostrar os usuarios dentro de uma regra especifica
         i -> println("Usuario: $i")
    }
}

//Conjunto (Set)
private val registros: MutableSet<String> = mutableSetOf("registro1","registro2","registro3")
private val registroNovo:String = "registro4"
private val registroConhecido:String = "registro2"
fun adicionarConjunto(novoRegistro:String):Boolean{
    return registros.add(novoRegistro)
}
fun conjuntoTeste(adicionado:Boolean):String{
    return if(adicionado) "adicionado com sucesso" else "O registro era duplicado ou não foi validado"
}

//Mapa (Map)
const val valorNeutro:Int = 15
val contados: MutableMap<Int,Int> = mutableMapOf(1 to 100, 2 to 100, 3 to 100)
val registrados: Map<Int,Int> = contados
val mesNome:Map<Int,String> = mapOf(
    1 to "Janeiro", 2 to "Fevereiro", 3 to "Março", 4 to "Abril", 5 to "Maio", 6 to "Junho",
    7 to "Julho", 8 to "Agosto", 9 to "Setembro", 10 to "Outobro", 11 to "Novembro", 12 to "Dezembro"
)
fun aumentarPontuacaoChave(chave:Int){
    if(registrados.containsKey(chave)){
        println("atualizando chave $chave...")
        contados[chave] = contados.getValue(chave) + valorNeutro
    }
    else{
        println("Essa chave não existe no arquivo")
    }
}
fun avaliarArquivo(){
    println("Arquivo:")
    registrados.forEach{
        a, b -> println("Chave $a - Valor: $b")
    }
}
/*Funções uteis (tecnicas para validar/geralmente são feitos como lambdas):
-- filter permite criar uma condição que defini organiza uma lista de tal maneira
Ex:
    val numeros:List<Int> = listOf(-3,-2,-1,0,1,2,3)
    val positivos:List<Int> = numeros.filter {x -> x>0}
    val negativos:List<Int> = numeros.filter {it<0}

-- map permite transformar a lista em relaxa a um principil
Ex:
    val numeros:List<Int> = listOf(-1,2,8,3,9)
    val dobro = numeros.map {x -> x*2} --> vai dobrar os numeros
    val triplicar = numeros.map {it*3} --> triplica os numeros

-- any, all, none verificam os valores de uma lista, retornando true ou false
Ex:
    val numeros:List<Int> = listOf(-7,-3,8,10,15)
    val checagemMinima = numeros.any {x>0} --> verifica se pelo menos um é aceito pela condição
    val checagemTotal = numeros.all {x%2 == 0} --> verifica se todos os valores estão validos
    val checagemNula = numeros.none {x < 30} --> verifica se nenhum dos valores está valido

-- flatMap permite a criacao de uma lista unica
Ex:
    val frutas = listOf("maça","laranja","banana","uvas")
    val roupas = listOf("camisas","calsas","jeans")
    val carrinho = listOf(frutas, roupas)
    val mapBag = cart.map { x } --> mostra como duas listas separadas dentro de uma lista
    val flatMapBag = cart.flatMap { x } --> mostra como uma lista unica contendo todos os elementos
 */
fun main(){
    //Lista
    lista()
    //Conjunto
    println("$registroNovo é valido: ${conjuntoTeste(adicionarConjunto(registroNovo))}")
    println("$registroConhecido é valido: ${conjuntoTeste(adicionarConjunto(registroConhecido))}")
    //Mapa
    avaliarArquivo()
    aumentarPontuacaoChave(2)
    aumentarPontuacaoChave(3)
    aumentarPontuacaoChave(4)
    avaliarArquivo()
    println(mesNome[5])
}