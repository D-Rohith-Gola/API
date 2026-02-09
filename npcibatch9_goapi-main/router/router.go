package router

import (
	"myfiberapi/controller"

	"github.com/gofiber/fiber/v2"
)

func SetupRoutes(app *fiber.App) {
	api := app.Group("/users")
	api.Get("/", controller.GetUsers)
	api.Get("/:id", controller.GetUser)
	api.Get("/:name", controller.GetUserByName)
	api.Post("/", controller.CreateUser)
	api.Put("/:id", controller.UpdateUser)
	api.Delete("/:id", controller.DeleteUser)
}
