db.createUser({
  user: "fodase",
  pwd: "123#123",
  roles: [
    {
      role: "readWrite",
      db: "my_db"
    }
  ]
})
