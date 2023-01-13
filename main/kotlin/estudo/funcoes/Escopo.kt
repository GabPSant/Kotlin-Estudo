package estudo.funcoes

//Funções de Escopo
/*let
--> permite retornar uma linha de codigo, relacionado a uma variável sem a necessidade de criar uma função, também
    é possivel avaliar se a váriavel é null ou não
 */
val vazio = "texto".let{
    println(it)//it é o valor padrão que representa a variável
    it.isEmpty()
}
fun mostrarNaoVazio(frase:String?){//A string pode contem parametros null
    frase?.let{//Se for null não vai fazer o programa
        print("\t")
        println(it)
    }
}
fun mostrarAmbosNaoVazios(frase1:String?,frase2:String?){
    frase1?.let{primeiraFrase -> // criar um nome customizado ao inves do padrão ('it')
        frase2?.let{segundaFrase ->
            println("$primeiraFrase : $segundaFrase")
        }
    }
}
//run -> como let, mas usa 'this' para representar a variável (mais fácil para chamar as operações da variável)
fun pegarTamanhoVazio(frase:String?){
    println("para \"$frase\": ")
    frase?.run{//Se for null não faz o programa
        println("\ttá vazio? " + isEmpty())//não precisa chamar a variavel por conta do 'this'
        println("\ttamanho = $length")
        length
    }
}
//with ->permite usar as operações de variavel sem ser necessário um representador de variável
class Configuracao(val host:String ,val post:Int)
val configuracao = Configuracao(host = "127.0.0.1", post = 9000)
fun Com(){
    with(configuracao){
        println("$host : $post")
    }
    //Ao inves de: println("${configuracao.host} : ${configuracao.post})
}
//apply -> permite a inicialização direta de objetos (object), avalia os objetos como se fossem 'this'
data class Pessoa(var nome:String, var idade:Int, var trabalho:String){
    constructor(): this("",0,"")// Cria um valor padrão por construtor
}
val jake = Pessoa()
val frase:String = jake.apply{
    nome = "Jake"
    idade = 30
    trabalho = "Desenvolvedor Android"
}.toString()
//also -> parecido com "apply", mas referencia por 'it'
fun mostrarUsuario(novo:Pessoa){
    println("Uma nova pessoa (${novo.nome})entrou no sistema")
}
val jose = Pessoa("jose",45,"Desenvolvedor Windows").also{
    mostrarUsuario(it)
}
fun main(){
    /*  let
    println("está vazio? R: $vazio")
    mostrarNaoVazio(null); mostrarNaoVazio("minha frase")
    mostrarAmbosNaoVazios("Primeira","Segunda")
     */
    /*  run
    pegarTamanhoVazio(null)
    pegarTamanhoVazio("")
    pegarTamanhoVazio("alguma frase Kotlin")
    */
    // with -> Com()
    // apply -> println(frase)
    // also -> println(jose)
}
