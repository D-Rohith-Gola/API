
package main

import "github.com/hyperledger/fabric-contract-api-go/contractapi"

func main() {
	chaincode, err := contractapi.NewChaincode(new(SmartContract))
	if err != nil {
		panic("Could not create chaincode: " + err.Error())
	}
	if err := chaincode.Start(); err != nil {
		panic("Could not start chaincode: " + err.Error())
	}
}
