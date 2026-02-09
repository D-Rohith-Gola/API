package client

import (
	"bytes"
	"encoding/json"
	"fmt"
	"net/http"
	"time"

	"fiber-api-consumer/model"
)

const baseURL = "http://localhost:3050/users"

// const baseURL = "http://localhost:8080/api/v1/creditcard"

var httpClient = &http.Client{
	Timeout: 10 * time.Second,
}

func GetUsers() ([]model.User, error) {
	resp, err := httpClient.Get(baseURL)
	if err != nil {
		fmt.Println(err)
		return nil, err
	}
	defer resp.Body.Close()

	var users []model.User
	err = json.NewDecoder(resp.Body).Decode(&users)
	return users, err
}

func CreateUser(user model.User) (model.User, error) {
	body, _ := json.Marshal(user)

	resp, err := httpClient.Post(baseURL, "application/json", bytes.NewBuffer(body))
	if err != nil {
		fmt.Println(err)
		return user, err
	}
	defer resp.Body.Close()

	json.NewDecoder(resp.Body).Decode(&user)
	return user, nil
}

func UpdateUser(id string, user model.User) (model.User, error) {
	body, _ := json.Marshal(user)

	req, _ := http.NewRequest(http.MethodPut, baseURL+"/"+id, bytes.NewBuffer(body))
	req.Header.Set("Content-Type", "application/json")

	resp, err := httpClient.Do(req)
	if err != nil {
		fmt.Println(err)
		return user, err
	}
	defer resp.Body.Close()

	json.NewDecoder(resp.Body).Decode(&user)
	return user, nil
}

func DeleteUser(id string) error {
	req, _ := http.NewRequest(http.MethodDelete, baseURL+"/"+id, nil)
	resp, err := httpClient.Do(req)
	if err != nil {
		fmt.Println(err)
		return err
	}
	defer resp.Body.Close()

	if resp.StatusCode != http.StatusOK {
		return fmt.Errorf("failed to delete user")
	}
	return nil
}
