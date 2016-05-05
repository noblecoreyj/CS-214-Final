class Patient {
	def firstName, middleName, lastName, age, roster
	def allergies = []
	def illnesses = []
	def medications = []

	Patient(fn, mn, ln, ag, al, il, me) {
		this.firstName = fn
		this.middleName = mn
		this.lastName = ln
		this.age = ag
		this.allergies = al
		this.illnesses = il
		this.medications = me
		roster = new File("roster.txt")
		roster << ln + fn
		roster << "\n"
	}

	def setFirstName(fn) {
		firstName = fn
		println "First name updated"
	}

	def setMiddleName(mn) {
		this.middleName = mn
		println "Middle name updated"
	}

	def setLastName(ln) {
		this.lastName = ln
		println "Last name updated"
	}

	def setAge(ag) {
		this.age = ag
		println "Age updated"
	}

	def addToAllergies(al) {
		allergies.add(al)
		println "Allergy successfully added"
	}

	def addToIllnesses(il) {
		illnesses.add(il)
		println "Illness successfully added"
	}

	def addToMedications(me) {
		medications.add(me)
		println "Medication successfully added"
	}

	def savePatient() {
		def fileName = this.lastName + this.firstName + ".txt"
		def patientFile = new File(fileName)
		def overwriter = patientFile.newWriter()
		overwriter << this.firstName
		overwriter << "\n"
		overwriter << this.middleName
		overwriter << "\n"
		overwriter << this.lastName
		overwriter << "\n"
		overwriter << this.age
		overwriter << "\n"
		this.allergies.each { allergy ->
			overwriter << "-/-"
			overwriter << "\n"
			overwriter << allergy.allergyCode
			overwriter << "\n"
			overwriter << allergy.allergen
			overwriter << "\n"
			overwriter << allergy.description
			overwriter << "\n"
			overwriter << "-a-"
			overwriter << "\n"
		}
		this.illnesses.each { illness ->
			overwriter << "-//-"
			overwriter << "\n"
			overwriter << illness.illnessCode
			overwriter << "\n"
			overwriter << illness.illnessName
			overwriter << "\n"
			overwriter << illness.description
			overwriter << "\n"
			overwriter << "-i-"
			overwriter << "\n"
		}
		this.medications.each { medication ->
			overwriter << "-///-"
			overwriter << "\n"
			overwriter << medication.medicationCode
			overwriter << "\n"
			overwriter << medication.medicationName
			overwriter << "\n"
			overwriter << medication.description
			overwriter << "\n"
			overwriter << "-m-"
			overwriter << "\n"
		}
		overwriter << "\n"
		overwriter << "-end-"
		overwriter.close()
	}

	def readPatient(fileName) {
		def readArray = new File(fileName) as String[]
		this.firstName = readArray[0]
		this.middleName = readArray[1]
		this.lastName = readArray[2]
		this.age = readArray[3]
		def position = 4
		this.allergies = []
		this.illnesses = []
		this.medications = []
		while (true) {
			if (readArray[position] == "-/-") {
				def tempAllergyCode = readArray[position + 1]
				def tempAllergyName = readArray[position + 2]
				def tempAllergyDescription = readArray[position + 3]
				Allergy tempAllergy = new Allergy(tempAllergyCode, tempAllergyName, tempAllergyDescription)
				this.allergies.add(tempAllergy)
				position = position + 5
			}
			else {
				break
			}
		}
		while (true) {
			if (readArray[position] == "-//-") {
				def tempIllnessCode = readArray[position + 1]
				def tempIllnessName = readArray[position + 2]
				def tempIllnessDescription = readArray[position + 3]
				Illness tempIllness = new Illness(tempIllnessCode, tempIllnessName, tempIllnessDescription)
				this.illnesses.add(tempIllness)
				position = position + 5
			}
			else {
				break
			}
		}
		while (true) {
			if (readArray[position] == "-///-") {
				def tempMedicationCode = readArray[position + 1]
				def tempMedicationName = readArray[position + 2]
				def tempMedicationDescription = readArray[position + 3]
				Medication tempMedication = new Medication(tempMedicationCode, tempMedicationName, tempMedicationDescription)
				this.medications.add(tempMedication)
				position = position + 5
			}
			else {
				break
			}
		}
	}
}