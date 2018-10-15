package edu.fullerton.ecs.cpsc411.kotlincustomadapterlistview

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

data class Person(val name: String, val email: String)

// Courtesy of <https://www.fakenamegenerator.com/>
val people = arrayOf(
    Person("Victor S. Balch", "VictorSBalch@rhyta.com"),
    Person("Robert S. Morgan", "RobertSMorgan@jourrapide.com "),
    Person("Corine J. Day", "CorineJDay@armyspy.com "),
    Person("David P. Craig", "DavidPCraig@jourrapide.com "),
    Person("Stella R. Kingsley", "StellaRKingsley@dayrep.com "),
    Person("Leonor C. Coleman", "LeonorCColeman@jourrapide.com"),
    Person("Gregory B. Peck", "GregoryBPeck@jourrapide.com"),
    Person("Alex R. Brady", "AlexRBrady@dayrep.com"),
    Person("Patrice S. Ponce", "PatriceSPonce@rhyta.com"),
    Person("Eva D. Simmons", "EvaDSimmons@jourrapide.com"),
    Person("David V. Higgins", "DavidVHiggins@rhyta.com"),
    Person("Beatrice J. Hernadez", "BeatriceJHernadez@dayrep.com")
)

class PersonAdapter(context: Context, objects: Array<Person>) : ArrayAdapter<Person>(context, android.R.layout.simple_list_item_2, android.R.id.text1, objects) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val row = super.getView(position, convertView, parent)

        val text1 = row.findViewById<TextView>(android.R.id.text1)
        val text2 = row.findViewById<TextView>(android.R.id.text2)

        text1.text = people[position].name
        text2.text = people[position].email

        return row
    }
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = PersonAdapter(this, people)

        listView.adapter = adapter
        listView.setOnItemClickListener { _, _, position, _->
            textView.text = "\"${people[position].name}\" <${people[position].email}>"
        }
    }
}
