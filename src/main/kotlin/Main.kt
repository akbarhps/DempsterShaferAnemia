val symptoms: List<Symptom> = listOf(
    Symptom(
        code = "1",
        name = "Nafsu Makan Berkurang",
        value = 0.2,
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
        value = 0.2,
        diseases = listOf(Disease.INCLUSION_BODY_DISEASE, Disease.SEMBELIT, Disease.PENYAKIT_KULIT_PARASIT)
    ),
    Symptom(
        code = "3",
        name = "Berat Badan Menurun",
        value = 0.5,
        diseases = listOf(Disease.SARIAWAN, Disease.PENYAKIT_KULIT_PARASIT)
    ),
    Symptom(
        code = "4",
        name = "Pembengkakan Pada Mulut",
        value = 0.5,
        diseases = listOf(Disease.SARIAWAN, Disease.INFLUENZA)
    ),
    Symptom(
        code = "5",
        name = "Pembengkakan Pada Gusi",
        value = 0.8,
        diseases = listOf(Disease.SARIAWAN)
    ),
    Symptom(
        code = "6",
        name = "Perubahan Pada Warna Mulut",
        value = 0.7,
        diseases = listOf(Disease.SARIAWAN)
    ),
    Symptom(
        code = "7",
        name = "Badan Terlihat Membengkak",
        value = 0.4,
        diseases = listOf(Disease.SEMBELIT)
    ),
    Symptom(
        code = "8",
        name = "BAB Jarang",
        value = 0.5,
        diseases = listOf(Disease.SEMBELIT)
    ),
    Symptom(
        code = "9",
        name = "BAB Encer",
        value = 0.1,
        diseases = listOf(Disease.SEMBELIT)
    ),
    Symptom(
        code = "10",
        name = "Muntah-muntah",
        value = 0.5,
        diseases = listOf(Disease.PENYAKIT_KULIT_PARASIT)
    ),
    Symptom(
        code = "11",
        name = "Terdapat Kutu/Caplak di Badan",
        value = 0.9,
        diseases = listOf(Disease.PENYAKIT_KULIT_PARASIT)
    ),
    Symptom(
        code = "12",
        name = "Terdapat Cairan Pada Hidung",
        value = 0.8,
        diseases = listOf(Disease.INFLUENZA)
    ),
    Symptom(
        code = "13",
        name = "Bernafas Dengan Mulut Terbuka",
        value = 0.7,
        diseases = listOf(Disease.INFLUENZA)
    ),
    Symptom(
        code = "14",
        name = "Keluar Cairan Dari Hidung/Mulut",
        value = 0.9,
        diseases = listOf(Disease.INFLUENZA)
    ),
    Symptom(
        code = "15",
        name = "Nafas yang Berbunyi (Mendengkur)",
        value = 0.8,
        diseases = listOf(Disease.INFLUENZA)
    ),
    Symptom(
        code = "16",
        name = "Selalu Melihat Keatas (Stargazing)",
        value = 0.9,
        diseases = listOf(Disease.INCLUSION_BODY_DISEASE)
    ),
    Symptom(
        code = "17",
        name = "Tidak Dapat Berdiri",
        value = 0.6,
        diseases = listOf(Disease.INCLUSION_BODY_DISEASE)
    ),
    Symptom(
        code = "18",
        name = "Selalu Tergolek Kearah Belakang",
        value = 0.8,
        diseases = listOf(Disease.INCLUSION_BODY_DISEASE)
    ),
    Symptom(
        code = "19",
        name = "Tidak Merespon Gerakan",
        value = 0.2,
        diseases = listOf(Disease.INCLUSION_BODY_DISEASE)
    ),
    Symptom(
        code = "20",
        name = "Besar Mata Pupil Tidak Seimbang",
        value = 0.5,
        diseases = listOf(Disease.INCLUSION_BODY_DISEASE)
    ),
    Symptom(
        code = "21",
        name = "Mengalami Kelumpuhan",
        value = 0.6,
        diseases = listOf(Disease.INCLUSION_BODY_DISEASE)
    ),
    Symptom(
        code = "22",
        name = "Lendir Kental Dihidung",
        value = 0.9,
        diseases = listOf(Disease.INFLUENZA)
    ),
    Symptom(
        code = "23",
        name = "Bengkak Dibawah Mulut",
        value = 0.6,
        diseases = listOf(Disease.INFLUENZA)
    ),
    Symptom(
        code = "24",
        name = "Ada Massa Padat Di Kloaka (Anus)",
        value = 0.9,
        diseases = listOf(Disease.INCLUSION_BODY_DISEASE)
    ),
    Symptom(
        code = "25",
        name = "Rahang Bawah Bernanah",
        value = 0.7,
        diseases = listOf(Disease.SARIAWAN)
    ),
    Symptom(
        code = "26",
        name = "Ada Plak Kemerahan Di Gusi",
        value = 0.9,
        diseases = listOf(Disease.SARIAWAN)
    ),
    Symptom(
        code = "27",
        name = "Ada Benjol Dirahang Atas",
        value = 0.4,
        diseases = listOf(Disease.SARIAWAN)
    ),
    Symptom(
        code = "28",
        name = "Jalannya Berputar-putar",
        value = 0.7,
        diseases = listOf(Disease.INCLUSION_BODY_DISEASE)
    ),
    Symptom(
        code = "29",
        name = "Ada Jamur Dimulut",
        value = 0.2,
        diseases = listOf(Disease.SARIAWAN, Disease.INFLUENZA)
    ),
    Symptom(
        code = "30",
        name = "Kepala Terpelinting",
        value = 0.4,
        diseases = listOf(Disease.INCLUSION_BODY_DISEASE)
    ),
)

fun main() {
    val selectedSymptoms = symptoms.toMutableList()

    if (selectedSymptoms.size < 2) {
        val current = selectedSymptoms[0]
        val diseases = current.diseases.toString()
        println("Penyakit $diseases dengan presentase ${current.value}")
        return
    }

    var densities: MutableList<Density> = mutableListOf(
        generateDensityFromSymptom(selectedSymptoms)!!,
    )

    while (selectedSymptoms.size > 0) {
        densities.add(generateDensityFromSymptom(selectedSymptoms)!!)

        val densityTable: MutableList<MutableList<Density>> = generateCombinedDensityTable(densities)
        val newDensities: MutableList<Density> = generateDensitiesFromCombinedTable(densityTable)
        val totalConflict: Double = countTotalConflict(newDensities)

        densities = calculateDempsterShafer(newDensities, totalConflict).toMutableList()
    }

    densities.sortByDescending { it.value }
    densities.forEach {
        val diseases = it.diseases.toString()
        println("Penyakit $diseases dengan presentase ${it.value * 100}")
    }
}

/**
 * return density from first selected symptom
 * and delete the symptom from selected symptom
 */
private fun generateDensityFromSymptom(symptoms: MutableList<Symptom>): Density? {
    if (symptoms.isEmpty()) return null

    val current = symptoms[0]
    val density = Density(
        code = current.code,
        diseases = current.diseases,
        value = current.value,
    )

    symptoms.remove(current)
    return density
}

/**
 * generate combined density table
 * from densities
 */
fun generateCombinedDensityTable(densities: MutableList<Density>): MutableList<MutableList<Density>> {
    val combinedDensityTable: MutableList<MutableList<Density>> = mutableListOf(
        generateConstantCombinedDensity(densities)
    )

    var totalValue = 0.0

    // extra loop for add theta value (check table)
    for (i in 0..densities.size) {
        var currentValue: Double
        val currentCombinedRow = mutableListOf<Density>()
        val currentDensity = if (i >= densities.size) null else densities[i].copy()

        totalValue += currentDensity?.value ?: 0.0

        // base combined is the first density in every row
        val baseCombinedDensity = if (i >= densities.size) {
            currentValue = 1 - totalValue
            Density(
                code = "(Theta)",
                diseases = null,
                value = currentValue
            )
        } else {
            currentValue = currentDensity!!.value
            Density(
                code = currentDensity.code,
                diseases = currentDensity.diseases,
                value = currentValue
            )
        }

        currentCombinedRow.add(baseCombinedDensity)

        // calculate combined density (column 1...n)
        combinedDensityTable[0].forEachIndexed { j, second ->
            val combinedDensity = Density(
                code = "${i}${j}",
                value = currentValue * second.value,
                diseases = combineDiseases(currentDensity?.diseases, second.diseases)
            )

            currentCombinedRow.add(combinedDensity)
        }

        combinedDensityTable.add(currentCombinedRow)
    }

    return combinedDensityTable
}

/**
 * intersect diseases if there are same values
 */
private fun combineDiseases(first: List<Disease>?, second: List<Disease>?): List<Disease>? {
    if (first != null && second != null) {
        return Symptom.intersectDisease(first, second)
    }

    if (first != null) {
        return first.toList()
    }

    if (second != null) {
        return second.toList()
    }

    return null
}

/**
 * Generate constant combined density (row 1 in the combined density table)
 * and remove its value from original densities
 */
private fun generateConstantCombinedDensity(densities: MutableList<Density>): MutableList<Density> {
    val lastDensity = densities[densities.size - 1]

    val result = mutableListOf(
        Density(
            code = lastDensity.code,
            diseases = lastDensity.diseases,
            value = lastDensity.value
        ),
        Density(
            code = "${lastDensity.code} (Theta)",
            diseases = null,
            value = 1 - lastDensity.value
        ),
    )

    densities.removeAt(densities.size - 1)
    return result
}

/**
 * remove base density
 * and take combined density from table
 */
fun generateDensitiesFromCombinedTable(densityTable: MutableList<MutableList<Density>>): MutableList<Density> {
    val densities = mutableListOf<Density>()

    densityTable.removeAt(0)
    densityTable.forEach {
        it.removeAt(0)
    }

    densityTable.forEach { row ->
        for (combinedDensity in row) {
            if (combinedDensity.diseases == null) continue

            val density = Density(
                code = combinedDensity.code,
                diseases = combinedDensity.diseases,
                value = combinedDensity.value,
            )

            densities.add(density)
        }
    }

    densities.sortBy { it.diseases?.size }
    return densities
}

/**
 * if there is a density with no disease
 * then it is a conflict, count all conflict from
 * densities
 */
fun countTotalConflict(densities: MutableList<Density>): Double {
    var totalConflict = 0.0

    for (density in densities) {
        if (density.diseases == null) continue
        if (density.diseases.isNotEmpty()) continue

        totalConflict += density.value
    }

    return totalConflict
}

/**
 * add density value with the same disease
 * and divide by (1 - totalConflict)
 *
 * (totalValue) / (1 - totalConflict)
 */
fun calculateDempsterShafer(densities: List<Density>, totalConflict: Double): List<Density> {
    val result = mutableMapOf<String, Density>()
    val checkedId = mutableMapOf<String, Boolean>()

    for (d1 in densities) {
        if (checkedId[d1.code] == true) continue
        if (d1.diseases?.size == 0) continue
        result[d1.code] = d1

        for (d2 in densities) {
            if (checkedId[d2.code] == true) continue
            if (d1.code == d2.code) continue
            if (d1.diseases != d2.diseases) continue

            d1.value += d2.value

            checkedId[d1.code] = true
            checkedId[d2.code] = true
            result[d1.code] = d1
        }
    }

    result.forEach { it.value.value /= (1 - totalConflict) }
    return result.values.toList()
}