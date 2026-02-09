package controller

import (
	"api/config"
	"encoding/json"
	"fmt"
	"net/http"
)

type TokenRequest struct {
	ID        string  `json:"id"`
	Owner     string  `json:"owner"`
	Amount    float64 `json:"amount"`
	Timestamp string  `json:"timestamp"`
	NewOwner  string  `json:"newOwner"`
}

func CreateToken(w http.ResponseWriter, r *http.Request) {
	var req TokenRequest
	json.NewDecoder(r.Body).Decode(&req)

	contract := config.GetContract()
	_, err := contract.SubmitTransaction("CreateToken", req.ID, req.Owner, fmt.Sprintf("%.2f", req.Amount), req.Timestamp)
	if err != nil {
		http.Error(w, err.Error(), http.StatusInternalServerError)
		return
	}
	w.Write([]byte("Token created"))
}

func TransferToken(w http.ResponseWriter, r *http.Request) {
	var req TokenRequest
	json.NewDecoder(r.Body).Decode(&req)

	contract := config.GetContract()
	_, err := contract.SubmitTransaction("TransferToken", req.ID, req.NewOwner)
	if err != nil {
		http.Error(w, err.Error(), http.StatusInternalServerError)
		return
	}
	w.Write([]byte("Token transferred"))
}

func RedeemToken(w http.ResponseWriter, r *http.Request) {
	var req TokenRequest
	json.NewDecoder(r.Body).Decode(&req)

	contract := config.GetContract()
	_, err := contract.SubmitTransaction("RedeemToken", req.ID)
	if err != nil {
		http.Error(w, err.Error(), http.StatusInternalServerError)
		return
	}
	w.Write([]byte("Token redeemed"))
}
