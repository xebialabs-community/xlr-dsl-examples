def myrelease = xlrScript {
  release("Hello World! (started)") {
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
}

releaseApi.start(myrelease.id)

