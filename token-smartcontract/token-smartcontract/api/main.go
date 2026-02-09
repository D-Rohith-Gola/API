package main

import (
	"api/controller"
	"log"
	"net/http"
)

func main() {
	http.HandleFunc("/create", controller.CreateToken)
	http.HandleFunc("/transfer", controller.TransferToken)
	http.HandleFunc("/redeem", controller.RedeemToken)

	log.Println("Server listening on port 8080...")
	log.Fatal(http.ListenAndServe(":8080", nil))
}
