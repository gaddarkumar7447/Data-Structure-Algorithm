package code.missiongoogle.kotlin

import code.missiongoogle.oopsdesign.generic
import jdk.swing.interop.DispatcherWrapper
import java.util.*
import java.util.function.Predicate
import kotlin.coroutines.CoroutineContext


class Practices {}

enum class Colors(val a: Int, private val b: Int, private val c: Int) {
    RED(23, 45, 11),
    BLUE(12, 45, 32),
    GREEN(7, 3, 10);

    fun getAllValue() = a * b * c
}

fun getColor(colors: Colors) =
    when (colors) {
        Colors.GREEN -> "hsg"
        else -> {
            "jhsd"
        }
    }


fun getValueParse(a: Int) =
    when {
        a % 5 == 0 -> "Ram"
        a % 4 == 0 -> "Lakhan"
        else -> "$a"
    }

fun charA(c: Char) = when (c) {
    '*' -> "Star"
    else -> "No"
}


fun recognize(c: Char) =
    when (c) {
        in '0'..'9' -> "Its a digit"
        in 'A'..'Z' -> "Its a upper case latter"
        in 'a'..'z' -> "Its a lower case latter"
        else -> "I don't know"
    }

fun findTheArrayConcVal(nums: IntArray): Long {
    var sum: Long = 0
    for (i in 0 until nums.size / 2) {
        sum += (nums[i].toString() + nums[nums.size - i - 1].toString()).toInt()
    }

    return sum
}

fun nameNot(name: String) {
    fun getPhone(name: String, n: String) {
        println("name $name , $n")
    }
    getPhone(name, "roll")
}

class User(val name: String, val id: String, val roll: String) {
    fun User.currectName(name: String) {
        println("name valid $name")
    }

    fun validBeforeSave(function: () -> Unit) {
        println("Name is correct")
    }
}

fun user1(name: User) {
    name.validBeforeSave {}
}

interface Clickable {
    fun click()
    fun showOff() {
        println("Gada")
    }
}

interface Focusable {
    fun showOff() {
        println("Shoe off")
    }
}

class Button : Clickable, Focusable {
    override fun click() {
        println("Button click")
    }

    override fun showOff() {
        super<Focusable>.showOff()
        super<Clickable>.showOff()
    }
}

sealed class Exp() {
    class Sum(val a: Int) : Exp()
    class Mul(val b: Int) : Exp()
}

fun getNumber(o: Exp) {
    when (o) {
        is Exp.Sum -> println("Gaddar")
        is Exp.Mul -> "Mul"
        else -> "Nothind"
    }
}

object Users {
    fun getUser(): String {
        return "Gaddar" + "Kumar"
    }

}

class UserData {
    companion object DataGet {
        fun getDataFromCom() {
            println("get data")
        }
    }

    object G {
        fun getFF() {

        }
    }
}

class User1 private constructor(val name: String) {
    fun getName() {
        val name = User1("Gaddar")
    }

    companion object {
        fun getD() = User1("Gaddar")
    }
}

class User2(val name: String) {
    fun getName() {
        println("name : $name")
    }
}

data class Use(val name: String)
interface JsonFactory<T> {
    fun getMen(): T
}

class Json : JsonFactory<Use> {
    override fun getMen(): Use {
        return Use("name")
    }
}

sealed class U {
    val b1: String = "Gad"

    class B(val b: String) : U() {
        fun get() {
            val a = this.b
            val a1 = b1
        }
    }
}

class Student(val id: Int, val name: String, val age: Int)

fun getDataOfTheStudent(student: List<Student>) {
    student.forEach { it ->
        println(it.name)
    }
}

fun addDoubleValue(a: Double, b: Double): Double {
    return a + b
}

fun cHigh(a: Int, b: Int): Int {
    return a * b
}

// Higher order function
fun higherOderFunction(a: Int, b: Int, c: (Int, Int) -> Int): Int {
    val result = c(a, b)
    return a + b + result
}
fun minDistance(word1: String, word2: String): Int {
    val m = word1.length
    val n = word2.length
    val mat = Array(m + 1) { IntArray(n + 1) }
    for (i in 0..m) mat[i][0] = i
    for (j in 0..n) mat[0][j] = j
    for (i in 1..m) {
        for (j in 1..n) {
            if (word1[i - 1] == word2[j - 1]) {
                mat[i][j] = mat[i - 1][j - 1]
            } else {
                mat[i][j] = 1 + mat[i - 1][j].coerceAtMost(mat[i][j - 1]).coerceAtMost(mat[i - 1][j - 1])
            }
        }
    }
    return mat[m][n]
}

fun star(s : String){
    println(s.uppercase())
}

fun finWinner(array: Array<Array<Int>>): List<List<Int>> {
    println(array.contentDeepToString())
    return ArrayList()
}

fun Char.count(num : Int) : String{
    return toString().repeat(num)
}
fun count1(chars: Char, num: Int): String {
    return chars.toString().repeat(num)
}
data class Decl(val a : Int, val b: Int)
data class NameComponents(val name: String, val extension: String)

fun splitFilename(fullName: String): NameComponents {
    val (name, extension) = fullName.split('.', limit = 2)
    return NameComponents(name, extension)
}

val a : Int by lazy {
    12
}
val b = lazy {
    23
}
fun Char.getFind() : String{
    return toString().uppercase()
}
class Movie(val name : String, val id : Int)
fun productExceptSelf(nums : IntArray) : IntArray{
    val ans = IntArray(nums.size)
    val left = IntArray(nums.size)
    left[0] = 1
    for (i in 1 until nums.size){
        left[i] = nums[i - 1] * left[i - 1]
    }
    val right = IntArray(nums.size)
    right[nums.size - 1] = 1
    for (i in nums.size - 2 downTo  0){
        right[i] = nums[i + 1] * right[i + 1]
    }

    for (i in nums.indices){
        ans[i] = left[i] * right[i]
    }
    return ans
}

class Gen<T> {
    var arr = arrayOfNulls<Any>(10) as Array<T?>
    val aw : Array<Any?> = arrayOfNulls(10)
    var count = 0
    fun add(a: T) {
        arr[count++] = a
    }

     fun get(index: Int): T? {
        return arr[index]
    }
}
sealed class ApiResponce<T>(val data : T ?= null, val message : String? = null){
    class Success<T>(data : T ?= null) : ApiResponce<T>(data)
    class Loading<T>() : ApiResponce<T>()
    class Error<T>(error: String) : ApiResponce<T>(message = error)
}

enum class DAY{
    MONDAY,
    Tuesday,
    Wednesday, Thrusday,
    Friday;
    fun meth(){
        println("SME TASK")
    }
}

fun <T : Comparable<T>> genericMethod(num1 : T, num2 : T) : T{
    return if (num1 < num2) num1 else num2
}
fun <T> funName(name : T){
    println(name)
}
fun <K, V> funKeyAndValur(key : K, value : V){
    println("$key : $value")
}
class KeyValue <K, V>(val key: K, val value: V){

}
data class GenericClass<K, V>(var key: K, var value: V) {
}
internal data class Person(val name: String, val full_name: String)
interface Printer{
    fun print(message: String)
}
class PrintValue(private val message: String){
    private fun takeValue(printer: Printer){
        printer.print(message)
    }
    fun getValue(){
        takeValue(object : Printer {
            override fun print(message: String) {
                println(message)
            }
        })
    }
}


fun main(args: Array<String>) {
    println(Thread.activeCount())
    val list1 : List<Movie> = listOf(Movie("gaddar", 10), Movie("kumar", 11), Movie("chaudhary", 12))
    list1.stream().map { movie -> movie.name}.forEach { name -> println(name) }
    val predicate = Predicate { m: Movie -> m.id > 10 }

    list1.stream().filter(predicate).forEach { shoe -> println(shoe.name) }
    val printValue = PrintValue("Gaddar Kumar Chaudhary")
    printValue.getValue()

    println(Person("G", "Gaddar"))

    funKeyAndValur("String", 10)
    funKeyAndValur(10, "Value")

    println(funName(287))

    genericMethod("Gaddar", "Kumar")
    val get = Gen<Int>()
    get.add(10)
    get.add(20)
    get.add(30)
    println(get.get(1))

    val num = intArrayOf(2,3,4,5)
    println(productExceptSelf(num).contentToString())

    println(b.value)
    println("sdj $b")
    println(b.isInitialized())
    
    //println(splitFilename("gaddar.kill"))

//    val g = Decl(9,0)
//    val (u, _) = g
//    println(u)
    //println('A'.count(3))
    val a = 21
//    println("bbc" < "ba")

    (0 .. 10).forEach { print(it) }
    val ar = mutableListOf(1,12,3,25,42,5)
    ar.add(32)
    ar += 12
    ar -= arrayListOf(1,2,3,3,3,3,3).toSet()
   // println(ar)

    /*val flateList = listOf<String>("Gaddar", "Kumar", "chaudhary")
    println(flateList.flatMap { it.toList() })*/
    val aray = arrayOf(arrayOf(2,3,4), arrayOf(2,4,5,5,3))
    finWinner(aray)

    println(higherOderFunction(2, 3, ::cHigh))
    /*val doubleAddFun = ::addDoubleValue
    println(doubleAddFun(1212.1, 2.12))*/

    val student = listOf(Student(1,"Gaddar",3), Student(2,"Kumar",34))

    println(student.map(Student::name).filter { it.startsWith("K") })
    val listInteger : List<List<Int>> = ArrayList()
    val treeMap = TreeMap<Int, Int>()


    /*getDataOfTheStudent(student)

    val list1 = arrayListOf<Student>(Student(1,"Gaddar",3), Student(2,"Kumar",34))
    println(list1.map { ref -> ref.name })

    list1.map { it.age }*/


    /*val a11 = User1.getD()
    val linkedList = LinkedList<Int>()
    val sc = Scanner(System.`in`)
    val chara = sc.next()[0]
    println(chara.toString())*/

    /*for (i in 0 until 9){
        val value = sc.nextInt()
        linkedList.add(value)
    }*/

    //println(linkedList)
    /*val ip = readln()
    val tye = ip.toInt()
    println("Enter name : $ip")*/


    UserData.getDataFromCom()
    UserData.G.getFF()

    //println(Users.getUser())


    val a1 = Exp.Sum(1)
    getNumber(a1)

    val values = "[0, 6, 6, 9, 7]"
    val list = mutableListOf<Int>()
    val regex = Regex("[^\\d,-]")
    val cleanedValues = regex.replace(values, "")
    val valuesArray = cleanedValues.split(",").toTypedArray()
    list.addAll(valuesArray.map { it.toInt() }) //
    println("List : ${list[3]}")
    /*nameNot("Gaddar")
    val user = User("name", "s", "Er")
    user.validBeforeSave {  }
    user1(user)*/


    val nums = IntArray(4)
    var n = Array<String>(3) { "" }
    n = arrayOf("ahs")

    //println("12.345-6.A".split(".", ","))

    val array = listOf("args: ", *args)
    //println(array)


    val si = arrayOf<String>("Ga")

    //println(recognize('9'))
    // Queue<int[]> q = new LinkedList<>();

    val qu: Queue<IntArray> = LinkedList()

    /*for (i in 1 ..50){
        println(getValueParse(i))
    }*/

    fun isAlphabet(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
    //println(isAlphabet('L'))
    val map = mutableMapOf<String, String>()
    val a12: Map<Int, Int> = mapOf(1 to 100, 2 to 200)
    //println(a)

    map.put("ram", "lakhan")
    map.put("kab", "makhan")
    map["tak"] = "Lalana"
    map.put("cham", "lakhan")


    //println("Gaddar, ${if (args.size > 0) args[0] else "Hello"}")
    //println("${Colors.BLUE.getAllValue()}, ${Colors.GREEN.getAllValue()}")
}