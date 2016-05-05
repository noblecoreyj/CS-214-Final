testPatient = new Patient("John", "P.", "Doe", 55, [], [], [])

assert testPatient.firstName == "John"
assert testPatient.middleName == "P."
assert testPatient.lastName == "Doe"
assert testPatient.age == 55
assert testPatient.allergies == []
assert testPatient.illnesses == []
assert testPatient.medications == []

println "---Patient tests passed---"

Allergy testAllergy = new Allergy(123, "pollen", "cannot be exposed")

assert testAllergy.allergyCode == 123
assert testAllergy.allergen == "pollen"
assert testAllergy.description == "cannot be exposed"

println "---Allergy tests passed---"

Illness testIllness = new Illness(123, "flu", "stomach virus")

assert testIllness.illnessCode == 123
assert testIllness.illnessName == "flu"
assert testIllness.description == "stomach virus"

println "---Illness tests passed---"

Medication testMedication = new Medication(123, "lexapro", "20mg")

assert testMedication.medicationCode == 123
assert testMedication.medicationName == "lexapro"
assert testMedication.description == "20mg"

println "---Medication tests passed---"

testPatient.addToAllergies(testAllergy)
testPatient.addToIllnesses(testIllness)
testPatient.addToMedications(testMedication)