class Driver {
	static void main(String... args)
	{
		Scanner s = new Scanner(System.in)
		Patient currentPatient = new Patient("sample", "sample", "sample", 1000, [], [], [])
		println "Hello. Welcome to Corey's EMR Program."
		while (true)
		{
			sleep(2000)
			println ""
			println "Please choose a command:"
			println ""
			println "add <patient, allergy, illness, medication>"
			println "edit <first, middle, last, age>"
			println "list <allergies, illnesses, medications>"
			println "load"
			println "summary"
			println ""
			def command = s.nextLine()
			def commandArray = command.split()
			if (commandArray[0].toLowerCase() == "add")
			{
				if (commandArray[1].toLowerCase() == "patient")
				{
					currentPatient.savePatient()
					println "Please enter the patient's first name:"
					def tempFirst = s.nextLine()
					println "Please enter the patient's middle name:"
					def tempMiddle = s.nextLine()
					println "Please enter the patient's last name:"
					def tempLast = s.nextLine()
					println "Please enter the patient's age:"
					def tempAge = s.nextLine()
					Patient newPatient = new Patient(tempFirst, tempMiddle, tempLast, tempAge, [], [], [])
					currentPatient = newPatient
					println "Patient added successfully"
					currentPatient.savePatient()
				}
				else if (commandArray[1].toLowerCase() == "allergy")
				{
					println "Please enter the allergy code:"
					def tempACode = s.nextLine()
					println "Please enter the allergen:"
					def tempAllergen = s.nextLine()
					println "Please enter the description:"
					def tempADescription = s.nextLine()
					Allergy tempAllergy = new Allergy(tempACode, tempAllergen, tempADescription)
					currentPatient.addToAllergies(tempAllergy)
				}
				else if (commandArray[1].toLowerCase() == "illness")
				{
					println "Please enter the illness code:"
					def tempICode = s.nextLine()
					println "Please enter the illness name:"
					def tempIName = s.nextLine()
					println "Please enter the description:"
					def tempIDescription = s.nextLine()
					Illness tempIllness = new Illness(tempICode, tempIName, tempIDescription)
					currentPatient.addToIllnesses(tempIllness)
				}
				else if (commandArray[1].toLowerCase() == "medication")
				{
					println "Please enter the medication code:"
					def tempMCode = s.nextLine()
					println "Please enter the medication name:"
					def tempMName = s.nextLine()
					println "Please enter the description:"
					def tempMDescription = s.nextLine()
					Medication tempMedication = new Medication(tempMCode, tempMName, tempMDescription)
					currentPatient.addToMedications(tempMedication)
				}
			}
			else if (commandArray[0].toLowerCase() == "edit")
			{

				if (commandArray[1].toLowerCase() == "first")
				{
					println "Please enter a new first name:"
					def newFirst = s.nextLine()
					currentPatient.setFirstName(newFirst)
				}
				else if (commandArray[1].toLowerCase() == "middle")
				{
					println "Please enter a new middle name:"
					def newMiddle = s.nextLine()
					currentPatient.setMiddleName(newMiddle)
				}
				else if (commandArray[1].toLowerCase() == "last")
				{
					println "Please enter a new last name:"
					def newLast = s.nextLine()
					currentPatient.setLastName(newLast)
				}
				else if (commandArray[1].toLowerCase() == "age")
				{
					println "Please enter a new age:"
					def newAge = s.nextLine()
					currentPatient.setAge(newAge.toInteger())
				}
				else
				{
					println "Invalid command."
				}
			}
			else if (command.toLowerCase() == "allergy")
			{
				println "Please enter the allergy code:"
				def tempACode = s.nextLine()
				println "Please enter the allergen:"
				def tempAllergen = s.nextLine()
				println "Please enter the description:"
				def tempADescription = s.nextLine()
				Allergy tempAllergy = new Allergy(tempACode, tempAllergen, tempADescription)
				currentPatient.addToAllergies(tempAllergy)
			}
			else if (command.toLowerCase() == "illness")
			{
				println "Please enter the illness code:"
				def tempICode = s.nextLine()
				println "Please enter the illness name:"
				def tempIName = s.nextLine()
				println "Please enter the description:"
				def tempIDescription = s.nextLine()
				Illness tempIllness = new Illness(tempICode, tempIName, tempIDescription)
				currentPatient.addToIllnesses(tempIllness)
			}
			else if (command.toLowerCase() == "medication")
			{
				println "Please enter the medication code:"
				def tempMCode = s.nextLine()
				println "Please enter the medication name:"
				def tempMName = s.nextLine()
				println "Please enter the description:"
				def tempMDescription = s.nextLine()
				Medication tempMedication = new Medication(tempMCode, tempMName, tempMDescription)
				currentPatient.addToMedications(tempMedication)
			}
			else if (commandArray[0].toLowerCase() == "list")
			{
				if (commandArray[1].toLowerCase() == "allergies")
				{
					if (currentPatient.allergies == [])
					{
						println "No allergies found"
					}
					else
					{
						currentPatient.allergies.each { allergy ->
							println allergy.allergen
							println allergy.description
						}
					}
				}
				else if (commandArray[1].toLowerCase() == "illnesses")
				{
					if (currentPatient.illnesses == [])
					{
						println "No illnesses found"
					}
					else
					{
						currentPatient.illnesses.each { illness ->
							println illness.illnessName
							println illness.description
						}
					}
				}
				else if (commandArray[1].toLowerCase() == "medications")
				{
					if (currentPatient.medications == [])
					{
						println "No medications found"
					}
					else
					{
						currentPatient.medications.each { medication ->
							println medication.medicationName
							println medication.description
						}
					}
				}
				else
				{
					println "Invalid command."
				}
			}
			else if (commandArray[0].toLowerCase() == "load")
			{
				currentPatient.savePatient()
				try
				{
					println "Please enter the name of the patient, in LastFirst format:"
					def file = s.nextLine()
					currentPatient.readPatient(file + ".txt")
					println	"Patient loaded successfully"
				} catch (java.io.FileNotFoundException e) {
					println "Patient not found."
				}
			}
			else if (commandArray[0].toLowerCase() == "summary")
			{
				println "Name: " + currentPatient.firstName + " " + currentPatient.middleName + " " + currentPatient.lastName
				println "Age: " + currentPatient.age
				println "Allergies:"
				if (currentPatient.allergies == [])
				{
					println "No allergies found"
				}
				else
				{
					currentPatient.allergies.each { allergy ->
						println allergy.allergen
						println allergy.description
					}
				}
				println "Illnesses:"
				if (currentPatient.illnesses == [])
				{
					println "No illnesses found"
				}
				else
				{
					currentPatient.illnesses.each { illness ->
						println illness.illnessName
						println illness.description
					}
				}
				println "Medications:"
				if (currentPatient.medications == [])
				{
					println "No medications found"
				}
				else
				{
					currentPatient.medications.each { medication ->
						println medication.medicationName
						println medication.description
					}
				}
			}
			else if (commandArray[0].toLowerCase() == "exit")
			{
				currentPatient.savePatient()
				break
			}
			else
			{
				println "Invalid command."
			}
		}
	}
}