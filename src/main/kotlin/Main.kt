data class Density(
    val code: String,
    val symptom: Symptom?,
    var believe: Double,
    var plau: Double,
)

data class CombinedDensity(
    var code: String = "",
    var symptom: Symptom? = null,
    var value: Double = 0.0,
    var taken: Boolean = false,
) {
    fun getSimilarDisease(combinedDensities: List<List<CombinedDensity>>): List<CombinedDensity> {
        val densities = mutableListOf<CombinedDensity>()

        for (i in 1 until combinedDensities.size) {
            for (j in 1 until combinedDensities[i].size) {
                val current = combinedDensities[i][j]
                if (!current.taken && current.symptom?.diseases == this.symptom?.diseases) {
                    densities.add(current)
                    current.taken = true
                }
            }
        }

        return densities
    }
}

fun combinedSimilarDisease(densities: List<Density>): List<Density> {
    val result = mutableMapOf<String, Density>()
    val checkedId = mutableMapOf<String, Boolean>()

    for (d1 in densities) {
        if (checkedId[d1.code] == true) continue
        result[d1.code] = d1

        for (d2 in densities) {
            if (checkedId[d2.code] == true) continue

            if (d1.code != d2.code && d1.symptom?.diseases == d2.symptom?.diseases) {
                d1.believe += d2.believe
                d1.plau += d2.plau

                checkedId[d1.code] = true
                checkedId[d2.code] = true
                result[d1.code] = d1
            }
        }
    }

    return result.values.toList()
}

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

    val selectedSymptoms: MutableList<Symptom> = mutableListOf(
        symptoms[0], symptoms[1], symptoms[2]
    )

    var densities = mutableListOf(
        getSingleDensity(selectedSymptoms)!!,
        getSingleDensity(selectedSymptoms)!!,
    )

    val combinedDensities: MutableList<MutableList<CombinedDensity>> = mutableListOf()

    val temp = densities[densities.size - 1]
    combinedDensities.add(
        mutableListOf(
            CombinedDensity(code = temp.code, symptom = temp.symptom, value = temp.believe),
            CombinedDensity(code = "${temp.code} (Theta)", symptom = null, value = 1 - temp.believe),
        )
    )
    densities.remove(temp)

    var totalValue = 0.0
    for (i in 0..densities.size) {
        var currentValue: Double
        val currentCombinedRow = mutableListOf<CombinedDensity>()
        val currentDensity = if (i >= densities.size) null else densities[i].copy()

        totalValue += currentDensity?.believe ?: 0.0

        val baseCombinedDensity = if (i >= densities.size) {
            currentValue = 1 - totalValue
            CombinedDensity("(Theta)", null, currentValue)
        } else {
            currentValue = currentDensity!!.believe
            CombinedDensity(currentDensity.code, currentDensity.symptom, currentValue)
        }

        currentCombinedRow.add(baseCombinedDensity)

        combinedDensities[0].forEachIndexed { j, it ->
            val combinedDensity = CombinedDensity(
                code = "${i}${j}",
                value = currentValue * it.value
            )

            if (currentDensity?.symptom != null && it.symptom != null) {
                combinedDensity.symptom = currentDensity.symptom.copy(
                    diseases = Symptom.intersectDisease(
                        currentDensity.symptom.diseases,
                        it.symptom!!.diseases
                    )
                )
            } else if (currentDensity?.symptom == null && it.symptom != null) {
                combinedDensity.symptom = it.symptom!!.copy()
            } else if (currentDensity?.symptom != null) {
                combinedDensity.symptom = currentDensity.symptom.copy()
            }

            currentCombinedRow.add(combinedDensity)
        }

        combinedDensities.add(currentCombinedRow)
    }

    densities.clear()

    combinedDensities.removeAt(0)
    combinedDensities.forEach {
        it.removeAt(0)
    }

    combinedDensities.forEach { row ->
        row.forEach { combinedDensity ->
            val density = Density(
                code = combinedDensity.code,
                symptom = combinedDensity.symptom,
                believe = combinedDensity.value,
                plau = 1 - combinedDensity.value
            )

            densities.add(density)
        }
    }

    densities = combinedSimilarDisease(densities).toMutableList()
    println("end")
}

private fun getSingleDensity(selectedSymptom: MutableList<Symptom>): Density? {
    if (selectedSymptom.isEmpty()) return null

    val current = selectedSymptom[0]
    val density = Density(
        code = current.code,
        symptom = current,
        believe = current.weight,
        plau = 1 - current.weight
    )

    selectedSymptom.remove(current)
    return density
}
