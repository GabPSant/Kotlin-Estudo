package estudo
//Ensina estudo de  Herança
//Herança Simples
open class Cao{//O modificador open para permitir o uso da classe e da função
    open fun latido(){
        println("wof wof")
    }
}
class Yorkshire:Cao(){ // O construtor de Cao é vazio
    override fun latido() {
        println("wif wif")
    }
}
//Herança Com Construtor Parametrizad
open class Tigre(val nome:String){
    fun mensagem(){
        println("Este é um tigre $nome")
    }
}
class TigreSiberiano:Tigre("siberiano")
//Herança Passando Argumentos do Construtor para a SuperClasse
open class NomeNacionalidade(val nome:String, val nacionalidade:String){
    fun registro(){
        println("$nome é $nacionalidade")
    }
}
class Individuo(nome:String, nacao:String):NomeNacionalidade(nome,nacao)
fun main(){
    val ola:Cao = Yorkshire()
    ola.latido()
    val animal:Tigre = TigreSiberiano()
    animal.mensagem()
    val pessoa:NomeNacionalidade = Individuo("Gabriel","brasileiro")
    pessoa.registro()
}