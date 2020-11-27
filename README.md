This is a Room Reservation App built with ReactJS and Liferay's Headless APIs.

Dependencies:
Java 1.8
Blade CLI https://help.liferay.com/hc/en-us/articles/360017885232-Installing-Blade-CLI-

How to deploy.
1. Go to this project's root directory.
2. Execute blade server init
3. Execute blade server run
4. While the server is running, go to {projectroot}/modules and execute blade gw deploy.
5. Wait for build & deploy time... (10-15 minutes)
6. Once the modules are deployed, go to Liferay's main page and add the Reservation portlet (under samples) to the screen.
