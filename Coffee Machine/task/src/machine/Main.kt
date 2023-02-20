package machine

enum class Coffee(var water: Int, var milk: Int, var beans: Int, var price: Int){ // those are instances of enums
    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6);
}

class CoffeeMachine(var totalWater: Int = 400, var totalMilk: Int = 540, var totalBeans: Int = 120, var totalCups: Int = 9, var totalMoney: Int = 550, var actionRequested: Boolean = true) {
    /* those are class property declarations inside a constructor, I use it to init values and later to add or subtract from them
       class properties can be accessed by its name
     */
    fun remaining(){
        println()
        println("""
        The coffee machine has:
        $totalWater ml of water
        $totalMilk ml of milk
        $totalBeans g of coffee beans
        $totalCups disposable cups
        $$totalMoney of money
    """.trimIndent())
        println()
    }

    fun makeCoffee(water: Int, milk: Int, beans: Int, price: Int) {
        if (water > totalWater) {
            println("Sorry, not enough water!")
        } else if (milk > totalMilk) {
            println("Sorry, not enough milk!")
        } else if (beans > totalBeans) {
            println("Sorry, not enough beans!")
        } else if (totalCups < 1) {
            println("Sorry, not enough cups!")
        } else {
            println("I have enough resources, making you a coffee!")
            totalWater -= water
            totalMilk -= milk
            totalBeans -= beans
            totalCups--
            totalMoney += price
        }
    }

    fun buy() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
        when (readln()) {
            "1" -> makeCoffee(Coffee.ESPRESSO.water, Coffee.ESPRESSO.milk, Coffee.ESPRESSO.beans, Coffee.ESPRESSO.price)
            "2" -> makeCoffee(Coffee.LATTE.water, Coffee.LATTE.milk, Coffee.LATTE.beans, Coffee.LATTE.price)
            "3" -> makeCoffee(Coffee.CAPPUCCINO.water, Coffee.CAPPUCCINO.milk, Coffee.CAPPUCCINO.beans, Coffee.CAPPUCCINO.price)
            "back" -> return
            // Calling a function makeCoffee with passing values to declared function values
            // Coffee{enum class}.ESPRESSO{enum name}.water{enum value}
        }
        println("")
    }

    fun fill() {
        println()
        println("Write how many ml of water you want to add:")
        val filledWater = readln().toInt()
        println("Write how many ml of milk you want to add:")
        val filledMilk = readln().toInt()
        println("Write how many grams of coffee beans you want to add:")
        val filledCoffee = readln().toInt()
        println("Write how many disposable cups you want to add:")
        val filledCups = readln().toInt()
        println()
        totalWater += filledWater
        totalMilk += filledMilk
        totalBeans += filledCoffee
        totalCups += filledCups

    }

    fun take() {
        println()
        println("I gave you $$totalMoney")
        println()
        totalMoney = 0
    }

    fun getAction() {
        println("Write action (buy, fill, take, remaining, exit):")
        when (readln()) {
            "buy" ->  buy()
            "fill" -> fill()
            "take" -> take()
            "remaining" -> remaining()
            "exit" -> actionRequested = false
        }
    }

}
fun main() {
    val coffeeMachine = CoffeeMachine()
    while (coffeeMachine.actionRequested) { //actionRequested is a property of coffeeMachine object, inherited from class CoffeeMachine
        coffeeMachine.getAction() //calling getAction function from coffeeMachine object, inherited from class CoffeeMachine, after every function end, it will again call getAction function
    }
}