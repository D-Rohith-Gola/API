package service

import (
	"fiber-api-consumer/client"
	"fiber-api-consumer/model"
)

func GetAllUsers() ([]model.User, error) {
	return client.GetUsers()
}

func AddUser(user model.User) (model.User, error) {
	return client.CreateUser(user)
}

func EditUser(id string, user model.User) (model.User, error) {
	return client.UpdateUser(id, user)
}

func RemoveUser(id string) error {
	return client.DeleteUser(id)
}