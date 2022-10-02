data class Symptom(
    val code: String,
    val name: String,
    val value: Double,
    var diseases: List<Disease>,
)
