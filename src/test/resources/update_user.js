update user

use admin

db.updateUser("playSpring",{
  roles: [
    { role: "readWrite", db: "local" } 
  ]
})