Project Setup Instructions:

	Install apache derby:
		As of writing this the project is using 10.9.1. If you update to a more recent version don't forget to update the derby.jar in the project to match your version.
		http://db.apache.org/derby/derby_downloads.html

		Follow the Installing and configuring Derby instructions here:
		https://builds.apache.org/job/Derby-docs/lastSuccessfulBuild/artifact/trunk/out/getstart/index.html
		
		Finally, you probably want to delete the data folder (thats the embedded database files) in the project if theres one already there. Hibernate will create the database for you anyway.
		
	Hard coded configuration!:
		There are some static variable in Controller.java that map files locations, and what realm to pull data from. Change them to suit. The whole retrieval section of code is pretty hacky and can be re-written/replaced.
	
	
TODO:

	I hate manually handling the hibernate session. I'm working on getting spring to manage all of that for us. It will be possible to just autowire a service in and use it without worrying about transactions and if the session it open when I get the configuration right.
	
	Implement lots of awesome functionality!