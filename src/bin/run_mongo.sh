#  Start mongodb server

sudo mongod --auth --port 27017 

# Connect to mongodb by client
mongo --port 27017 -u "playSpring" -p "playSpring" --authenticationDatabase "admin" 