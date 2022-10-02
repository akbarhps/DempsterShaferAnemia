data class Symptom(
    val code: String,
    val name: String,
    val value: Double,
    var diseases: List<Disease>,
) {
    companion object {
        fun intersectDisease(x: List<Disease>, y: List<Disease>): List<Disease> {
            return x.intersect(y.toSet()).toList()
        }
    }

}

