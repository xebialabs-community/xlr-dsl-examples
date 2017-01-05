def releaseVar = release.variables.find { it.key == 'localPasswordVariable'}
println "release password variable value: ${releaseVar.value}"

def myrelease = xlrRelease("Hello World! (started)") {
	  description "Sample release created from Groovy DSL"
	  phases {
	    phase ("Hello") {
	      tasks {
	        manual("Hello world!") {
	          description "_Hello_ there!"

	        }
	      }
	    }
	  }
}

println "Release started: ${myrelease.id}"

def releaseId = release.variables.find{it.key == 'releaseId'}
releaseId.value = myrelease.id
releaseApi.updateVariable(releaseId)

releaseApi.start(myrelease.id)

