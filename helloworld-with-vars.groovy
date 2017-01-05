def releaseVar = release.variables.find { it.key == 'localPasswordVariable'}
println "release password variable value: ${releaseVar.value}"

def myrelease = xlrScript {
  release("Hello World! (started)") {
	  description "Sample release created from Groovy DSL"
	  phases {
	    phase ("Hello") {
	      color "#68b749"
	      tasks {
	        manual("Hello world!") {
	          description "_Hello_ there!\n\nPassword: `${releaseVar.value}`"

	        }
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

