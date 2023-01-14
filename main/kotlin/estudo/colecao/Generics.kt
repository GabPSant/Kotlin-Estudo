package estudo.colecao

class estudo<E>(vararg estudo:E){
    private val elementos = estudo.toMutableList()

    fun empurra(elemento:E) = elementos.add(elemento) // Adiciona um valor a lista
    fun observar():E = elementos.last() // Observa o ultimo valor
    fun remover():E = elementos.removeAt(elementos.size - 1) // Remove o ultimo valor
    fun taVazio() = elementos.isEmpty() //Avalia se a lista está vazia
    fun tamanho() = elementos.size //Mostra o tamanho da lista

    override fun toString() = "Mutable Stack (${elementos.joinToString()})"
}
fun <E>estudoListado(vararg elementos:E) = estudo(*elementos)
fun main(){
    /*val lista = estudo(0.62,3.14,5.6,47)
    println(lista.tamanho())
    lista.empurra(38)
    println(lista.tamanho())
    println(lista.taVazio())
    lista.remover()
    println(lista.observar())*/
    val conteudo = estudoListado(0.62,3.14,5.6,47.0)
    conteudo.empurra(38.0)
    println(conteudo.observar())
    println(conteudo.tamanho())
}