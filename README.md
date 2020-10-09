This is a Room Reservation App built with ReactJS and Liferay's Headless APIs.

Dependencies:
Java 1.8

How to deploy.
1. Go to this project's root directory.
2. Execute blade server init
3. Execute blade server run
4. While the server is running, go to {projectroot}/modules and execute blade gw deploy.
5. Wait for build & deploy time... (10-15 minutes)
6. Once the modules are deployed, go to Liferay's main page and add the Reservation portlet (under samples) to the screen.

The instance of Liferay used for this project is DXP (enterprise version). 
You can always deploy in on the opensource one or migrate it to 7.3, given a few modifications to the code.
