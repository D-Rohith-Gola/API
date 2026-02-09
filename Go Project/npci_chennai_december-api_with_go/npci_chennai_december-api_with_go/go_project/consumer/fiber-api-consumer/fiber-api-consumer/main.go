package main

import (
	"log"

	"fiber-api-consumer/controller"
	"github.com/gofiber/fiber/v2"
)

func main() {
	app := fiber.New()

	api := app.Group("/api")
	api.Get("/users", controller.GetUsers)
	api.Post("/users", controller.CreateUser)
	api.Put("/users/:id", controller.UpdateUser)
	api.Delete("/users/:id", controller.DeleteUser)

	log.Fatal(app.Listen(":8080"))
}