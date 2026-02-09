
package main

import (
	"encoding/json"
	"fmt"
	"github.com/hyperledger/fabric-contract-api-go/contractapi"
)

type SmartContract struct {
	contractapi.Contract
}

type Token struct {
	ID        string  `json:"id"`
	Owner     string  `json:"owner"`
	Amount    float64 `json:"amount"`
	Status    string  `json:"status"`
	Timestamp string  `json:"timestamp"`
}

func (s *SmartContract) CreateToken(ctx contractapi.TransactionContextInterface, id string, owner string, amount float64, timestamp string) error {
	token := Token{ID: id, Owner: owner, Amount: amount, Status: "CREATED", Timestamp: timestamp}
	tokenBytes, _ := json.Marshal(token)
	return ctx.GetStub().PutState(id, tokenBytes)
}

func (s *SmartContract) TransferToken(ctx contractapi.TransactionContextInterface, id string, newOwner string) error {
	tokenBytes, err := ctx.GetStub().GetState(id)
	if err != nil || tokenBytes == nil {
		return fmt.Errorf("token %s does not exist", id)
	}
	var token Token
	json.Unmarshal(tokenBytes, &token)
	token.Owner = newOwner
	token.Status = "TRANSFERRED"
	updatedBytes, _ := json.Marshal(token)
	return ctx.GetStub().PutState(id, updatedBytes)
}

func (s *SmartContract) RedeemToken(ctx contractapi.TransactionContextInterface, id string) error {
	tokenBytes, err := ctx.GetStub().GetState(id)
	if err != nil || tokenBytes == nil {
		return fmt.Errorf("token %s does not exist", id)
	}
	var token Token
	json.Unmarshal(tokenBytes, &token)
	token.Status = "REDEEMED"
	updatedBytes, _ := json.Marshal(token)
	return ctx.GetStub().PutState(id, updatedBytes)
}

func (s *SmartContract) ReadToken(ctx contractapi.TransactionContextInterface, id string) (*Token, error) {
	tokenBytes, err := ctx.GetStub().GetState(id)
	if err != nil || tokenBytes == nil {
		return nil, fmt.Errorf("token %s not found", id)
	}
	var token Token
	json.Unmarshal(tokenBytes, &token)
	return &token, nil
}
