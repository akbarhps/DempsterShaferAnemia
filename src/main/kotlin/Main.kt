data class Density(
    val code: String,
    val symptom: Symptom?,
    var value: Double,
)

data class CombinedDensity(
    var code: String = "",
    var symptom: Symptom? = null,
    var value: Double = 0.0,
)


fun main(args: Array<String>) {

    val symptoms: List<Symptom> = listOf(
        Symptom(
            code = "1",
            name = "Nafsu Makan Berkurang",
            weight = 0.2,
            diseases = listOf(
                Disease.SARIAWAN,
                Disease.INCLUSION_BODY_DISEASE,
                Disease.SEMBELIT,
                Disease.PENYAKIT_KULIT_PARASIT,
                Disease.INFLUENZA
            )
        ),
        Symptom(
            code = "2",
            name = "Wajah Terlihat Lesu",
            weight = 0.2,
            diseases = listOf(Disease.INCLUSION_BODY_DISEASE, Disease.SEMBELIT, Disease.PENYAKIT_KULIT_PARASIT)
        ),
        Symptom(
            code = "3",
            name = "Berat Badan Menurun",
            weight = 0.2,
            diseases = listOf(Disease.SARIAWAN, Disease.INFLUENZA)
        ),
        Symptom(
            code = "4",
            name = "Pembengkakan Pada Mulut",
            weight = 0.2,
            diseases = listOf(Disease.SARIAWAN, Disease.INFLUENZA)
        ),
        Symptom(
            code = "5",
            name = "Pembengkakan Pada Gusi",
            weight = 0.2,
            diseases = listOf(Disease.SARIAWAN)
        ),
        Symptom(
            code = "6",
            name = "Perubahan Pada Warna Mulut",
            weight = 0.2,
            diseases = listOf(Disease.SARIAWAN)
        ),
        Symptom(
            code = "7",
            name = "Badan Terlihat Membengkak",
            weight = 0.2,
            diseases = listOf(Disease.SEMBELIT)
        ),
        Symptom(
            code = "8",
            name = "BAB Jarang",
            weight = 0.2,
            diseases = listOf(Disease.SEMBELIT)
        ),
        Symptom(
            code = "9",
            name = "BAB Encer",
            weight = 0.2,
            diseases = listOf(Disease.SEMBELIT)
        ),
        Symptom(
            code = "10",
            name = "Muntah-muntah",
            weight = 0.2,
            diseases = listOf(Disease.PENYAKIT_KULIT_PARASIT)
        ),
        Symptom(
            code = "11",
            name = "Terdapat Kutu/Caplak di Badan",
            weight = 0.2,
            diseases = listOf(Disease.PENYAKIT_KULIT_PARASIT)
        ),
        Symptom(
            code = "12",
            name = "Terdapat Cairan Pada Hidung",
            weight = 0.2,
            diseases = listOf(Disease.INFLUENZA)
        ),
        Symptom(
            code = "13",
            name = "Bernafas Dengan Mulut Terbuka",
            weight = 0.2,
            diseases = listOf(Disease.INFLUENZA)
        ),
        Symptom(
            code = "14",
            name = "Keluar Cairan Dari Hidung/Mulut",
            weight = 0.2,
            diseases = listOf(Disease.INFLUENZA)
        ),
        Symptom(
            code = "15",
            name = "Nafas yang Berbunyi (Mendengkur)",
            weight = 0.2,
            diseases = listOf(Disease.INFLUENZA)
        ),
        Symptom(
            code = "16",
            name = "Selalu Melihat Keatas (Stargazing)",
            weight = 0.2,
            diseases = listOf(Disease.INCLUSION_BODY_DISEASE)
        ),
        Symptom(
            code = "17",
            name = "Tidak Dapat Berdiri",
            weight = 0.2,
            diseases = listOf(Disease.INCLUSION_BODY_DISEASE)
        ),
        Symptom(
            code = "18",
            name = "Selalu Tergolek Kearah Belakang",
            weight = 0.2,
            diseases = listOf(Disease.INCLUSION_BODY_DISEASE)
        ),
        Symptom(
            code = "19",
            name = "Tidak Merespon Gerakan",
            weight = 0.2,
            diseases = listOf(Disease.INCLUSION_BODY_DISEASE)
        ),
        Symptom(
            code = "20",
            name = "Besar Mata Pupil Tidak Seimbang",
            weight = 0.2,
            diseases = listOf(Disease.INCLUSION_BODY_DISEASE)
        ),
        Symptom(
            code = "21",
            name = "Mengalami Kelumpuhan",
            weight = 0.2,
            diseases = listOf(Disease.INCLUSION_BODY_DISEASE)
        ),
        Symptom(
            code = "22",
            name = "Lendir Kental Dihidung",
            weight = 0.2,
            diseases = listOf(Disease.INFLUENZA)
        ),
        Symptom(
            code = "23",
            name = "Bengkak Dibawah Mulut",
            weight = 0.2,
            diseases = listOf(Disease.INFLUENZA)
        ),
        Symptom(
            code = "24",
            name = "Ada Massa Padat Di Kloaka (Anus)",
            weight = 0.2,
            diseases = listOf(Disease.INCLUSION_BODY_DISEASE)
        ),
        Symptom(
            code = "25",
            name = "Rahang Bawah Bernanah",
            weight = 0.2,
            diseases = listOf(Disease.SARIAWAN)
        ),
        Symptom(
            code = "26",
            name = "Ada Plak Kemerahan Di Gusi",
            weight = 0.2,
            diseases = listOf(Disease.SARIAWAN)
        ),
        Symptom(
            code = "27",
            name = "Ada Benjol Dirahang Atas",
            weight = 0.2,
            diseases = listOf(Disease.SARIAWAN)
        ),
        Symptom(
            code = "28",
            name = "Jalannya Berputar-putar",
            weight = 0.2,
            diseases = listOf(Disease.INCLUSION_BODY_DISEASE)
        ),
        Symptom(
            code = "29",
            name = "Ada Jamur Dimulut",
            weight = 0.2,
            diseases = listOf(Disease.SARIAWAN, Disease.INFLUENZA)
        ),
        Symptom(
            code = "30",
            name = "Kepala Terpelinting",
            weight = 0.2,
            diseases = listOf(Disease.INCLUSION_BODY_DISEASE)
        ),
    )

    val selectedSymptoms = mutableListOf(symptoms[0], symptoms[1], symptoms[2])
//    if (selectedSymptoms.size < 2) return

    var densities: MutableList<Density> = mutableListOf(
        generateSingleDensity(selectedSymptoms)!!,
        generateSingleDensity(selectedSymptoms)!!,
    )

    val combinedDensityTable: MutableList<MutableList<CombinedDensity>> = mutableListOf(
        generateConstantCombinedDensity(densities)
    )

    var totalValue = 0.0

    // extra loop for add theta value (check table)
    for (i in 0..densities.size) {
        var currentValue: Double
        val currentCombinedRow = mutableListOf<CombinedDensity>()
        val currentDensity = if (i >= densities.size) null else densities[i].copy()

        totalValue += currentDensity?.value ?: 0.0

        val currentCombinedDensity = if (i >= densities.size) {
            currentValue = 1 - totalValue
            CombinedDensity("(Theta)", null, currentValue)
        } else {
            currentValue = currentDensity!!.value
            CombinedDensity(currentDensity.code, currentDensity.symptom, currentValue)
        }

        // calculate next combined density (column 1...n)
        combinedDensityTable[0].forEachIndexed { j, second ->
            val combinedDensity = CombinedDensity(
                code = "${i}${j}",
                value = currentValue * second.value,
                symptom = combineSimilarSymptom(currentDensity?.symptom, second.symptom)
            )
            currentCombinedRow.add(combinedDensity)
        }

        currentCombinedRow.add(currentCombinedDensity)
        combinedDensityTable.add(currentCombinedRow)
    }

    densities.clear()

    combinedDensityTable.removeAt(0)
    combinedDensityTable.forEach {
        it.removeAt(0)
    }

    combinedDensityTable.forEach { row ->
        row.forEach { combinedDensity ->
            val density = Density(
                code = combinedDensity.code,
                symptom = combinedDensity.symptom,
                value = combinedDensity.value,
            )

            densities.add(density)
        }
    }

    densities = combineSimilarDensities(densities).toMutableList()
    println("end")
}

/**
 * return density from first selected symptom
 * and delete the symptom from selected symptom
 */
private fun generateSingleDensity(selectedSymptom: MutableList<Symptom>): Density? {
    if (selectedSymptom.isEmpty()) return null

    val current = selectedSymptom[0]
    val density = Density(
        code = current.code,
        symptom = current,
        value = current.weight,
    )

    selectedSymptom.remove(current)
    return density
}

/**
 * Generate constant combined density (row 1 in the combined density table)
 * and remove its value from original densities
 * @param densities
 */
private fun generateConstantCombinedDensity(densities: MutableList<Density>): MutableList<CombinedDensity> {
    val lastDensity = densities[densities.size - 1]
    val result = mutableListOf(
        CombinedDensity(code = lastDensity.code, symptom = lastDensity.symptom, value = lastDensity.value),
        CombinedDensity(code = "${lastDensity.code} (Theta)", symptom = null, value = 1 - lastDensity.value),
    )

    densities.remove(lastDensity)
    return result
}

/**
 * check symptom similiar diseases
 * and then combine it
 */
private fun combineSimilarSymptom(first: Symptom?, second: Symptom?): Symptom? {
    if (first != null && second != null) {
        return first.copy(
            diseases = Symptom.intersectDisease(first.diseases, second.diseases)
        )
    }

    if (first != null) {
        return first.copy()
    }

    if (second != null) {
        return second.copy()
    }

    return null
}

/**
 * combine density with similar disease and then
 * add its value
 */
fun combineSimilarDensities(densities: List<Density>): List<Density> {
    val result = mutableMapOf<String, Density>()
    val checkedId = mutableMapOf<String, Boolean>()

    for (d1 in densities) {
        if (checkedId[d1.code] == true) continue
        checkedId[d1.code] = true
        result[d1.code] = d1

        for (d2 in densities) {
            if (checkedId[d2.code] == true) continue
            if (d1.code == d2.code) continue
            if (d1.symptom?.diseases != d2.symptom?.diseases) continue

            d1.value += d2.value

            checkedId[d2.code] = true
            result[d1.code] = d1
        }
    }

    return result.values.toList()
}
