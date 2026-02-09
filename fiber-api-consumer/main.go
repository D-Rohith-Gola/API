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
	api.Post("/users", controller.CreateUsers)
	api.Put("/users/:id", controller.UpdateUsers)
	api.Delete("/users/:id", controller.DeleteUsers)

	log.Fatal(app.Listen(":8090"))
}
