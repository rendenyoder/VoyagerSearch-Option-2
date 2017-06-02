# VoyagerSearch-Option-2
+ option 2 from voyager search's technical tasks
+ visit https://www.youtube.com/watch?v=fO_49sWAbnM&feature=youtu.be for demo video

## Instructions
+ 'cd solr-6.5.1/bin' then start the solr server with './solr start'
+ 'cd Option_2' then start spring with './gradlew bootRun'
+ visit 'http://localhost:8080/' to view the spring applications home page, where users will see things added/deleted from solr server
+ make a call to 'http://localhost:8080/add' to add random sample object
+ make a call to 'http://localhost:8080/delete/someIdHere' where 'someIdHere' is the integer value of the id of a solr document
