package de.dhbwka.theoinf.datenstukturen

/**
 * Created by cem on 19.06.16.
 */
class KList<T> {

    private var value: T? = null
    private var next: KList<T>? = null

    constructor(value: T) {
        this.value = value
    }

    constructor() {
    }

    fun append(newValue: T) {
        if (value == null)
            value = newValue
        else if (next == null)
            next = KList(newValue)
        else
            next!!.append(newValue)
    }

    operator fun contains(value: T): Boolean {
        return this.value == value || next != null && next!!.contains(value)
    }

    fun length(): Int {
        return lengthWorker(1)
    }

    private fun lengthWorker(count: Int): Int {
        if (next == null)
            return count
        else
            return next!!.lengthWorker(count + 1)
    }

    operator fun get(number: Int): T? {
        if (number == 0)
            return value
        else if (next == null)
            return null
        else
            return next!![number - 1]
    }

    fun delete(element: T) {
        if (value === element) {
            value = next!!.value
            next = next!!.next
        } else if (next != null) next!!.delete(element)
    }

}
