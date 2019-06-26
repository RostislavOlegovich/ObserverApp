package com.example.rostislav.observerapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val fruitList = mutableListOf<Fruit>()

    private val adapter = FruitAdapter(getList()) { element, state -> callBack(element,state)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fruitList.addAll(getList())
        recyclerView.adapter = adapter

        buttonAdd.setOnClickListener {
            adapter.addItem(addFruit())
        }

        buttonDelete.setOnClickListener {
            adapter.deleteItem(deleteFruit())

        }

        calculate()
    }

    private fun callBack(element: Fruit, state: State) {
        when (state) {
            is State.Added -> fruitList.add(element)
            is State.Removed -> fruitList.remove(element)
        }
        if (fruitList.size == 0)
            buttonDelete.isEnabled = false

        calculate()
    }


    private fun calculate() {

        val totalPrice = fruitList.sumBy { it.price }
        textViewTotal.text = totalPrice.toString()
    }

    private fun deleteFruit(): Fruit {
        val random = if(fruitList.size > 1) (0 until fruitList.size).random() else 0
        return getList()[random]
    }

    private fun addFruit(): Fruit {
        val random = (0..9).random()
        return getList()[random]
    }

    private fun getList() = mutableListOf(
        Fruit("Apple", 10),
        Fruit("Orange", 15),
        Fruit("Banana", 23),
        Fruit("Kiwi", 45),
        Fruit("Cherry", 60),
        Fruit("Mango", 160),
        Fruit("Peach", 44),
        Fruit("Lime", 111),
        Fruit("Pear", 32),
        Fruit("Blueberry", 71)
    )

}

