package estudo
//Classes especiais
//Data Class --> Get e Set são desnecessários
data class Usuario(val nome:String, val id:Int){
    constructor(): this("",0)//definir valores padrões para o construtor
    //Permite no momento de avaliar os usuarios se tem alguma igualdade entre eles
    override fun equals(other: Any?) =
        other is Usuario && other.id == this.id && other.nome == this.nome
}
fun usuarios(){
    val usuario1 = Usuario("Gabriel",1)
    val usuario2 = Usuario("Vicente",2)
    val usuario3 = Usuario("Silvania",3)
    println("$usuario1\n$usuario2\n$usuario3")
    println("usuario1 == usuario2: ${usuario1 == usuario2}")
    println("usuario1 == usuario3: ${usuario1 == usuario3}")
    println("U1: ${usuario1.hashCode()}\nU2: ${usuario2.hashCode()}\nU3: ${usuario3.hashCode()}")
    //'copy' permite alterar as propriedades de um dado de classe pré-existente, tem um hashCode é diferente do original
    println("usuario1 (nome diferente): ${usuario1.copy("Harry")}")
    println("usuario1 (id diferente): ${usuario1.copy(id = 4)}")
    //'componente' permite pegar os valores em relação a ordem das variáveis
    println("usuario1\ncomponente1: ${usuario1.component1()}\ncomponente2: ${usuario1.component2()}")
}
//Enum Class
enum class Jogo{
    INICIAR,PERDER,GANHAR,REINICIAR,SAIR
}
fun modosJogo():String{
    val modo = Jogo.INICIAR
    val estado:String = when(modo){
        Jogo.INICIAR -> "Iniciando o jogo..."
        Jogo.PERDER -> "Você perdeu!"
        Jogo.GANHAR -> "Você ganhou!"
        Jogo.REINICIAR -> "Reiniciando o jogo..."
        Jogo.SAIR -> "Terminando essa rodada"
    }
    return estado
}
enum class  Cores(val index:Int){
    VERMELHO(0xFF0000),
    VERDE(0x00FF00),
    AZUL(0x0000FF),
    AMARELO(0xFFFF00);//Funções são separadas por ponto e virgula

    fun eVermelho() = (this.index and 0xFF0000 != 0)
}
fun avaliarCores(){
    val cor = Cores.VERMELHO
    println("$cor\n${cor.eVermelho()}\n${Cores.AMARELO.eVermelho()}\n${Cores.AZUL.eVermelho()}")
}
//Sealed Class
sealed class Mamifero(val nome:String)
class Gato(val nomeGato:String):Mamifero(nomeGato)
class Humano(val nomeHumano:String, val trabalho:String):Mamifero(nomeHumano)

fun mensagem(mamifero:Mamifero):String{
    return when(mamifero){
        is Gato -> "Ola ${mamifero.nome}"
        is Humano -> "Ola ${mamifero.nome}, você trabalha como um ${mamifero.trabalho}"
    }
}
//Object Keyword --> cria objetos diretamente, sem necessidade de uma classe
//Object Expretion --> Use como se fosse uma variável
fun custos(diasNormais:Int, diasFestivos:Int, diasEspeciais:Int):Unit{//Unit == void
    val custosDiarios = object{//Estanciamento do objeto
        var normais:Int = 30*diasNormais
        var festivos:Int = 50*diasFestivos
        var especiais:Int = 100*diasEspeciais
    }
    println("Custo total: $${custosDiarios.normais + custosDiarios.festivos + custosDiarios.especiais}")
}
//Object Declaration --> Use como se fosse uma classe
object Registro{
    fun pegarRegistro(usuario:String,senha:String){
        println("Usuario registrado\nnome: $usuario\nsenha: $senha")
    }
}
//Companion objects --> São chamados através de classes, permite o uso de objetos somentes no nivel do pacote
class Scout{
    companion object Batidas{
        fun numerosBatidas(quantidades:Int){
            for(i in 1.. quantidades) println("BONG")
        }
    }
}
fun main(){
    //usuarios() ->Data Class
    /*Enum Class
    println(modosJogo())
    avaliarCores()
     */
    /*Sealed Class
    val humano:Mamifero = Humano("Matheus","professor")
    val gato:Mamifero = Gato("Fabio")
    println("${mensagem(humano)}\n${mensagem(gato)}")
     */
    /*Object Keyword
    custos(5,10,3)//Criação do objeto
    Registro.pegarRegistro("Jesus","Judas")
    Scout.numerosBatidas(6)
    */
}
