# UpiControllerApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createAccount**](UpiControllerApi.md#createAccount) | **POST** /api/v1/upi | Create Account
[**deleteAccount**](UpiControllerApi.md#deleteAccount) | **DELETE** /api/v1/upi/{e} | Delete Account by Email
[**editAccount**](UpiControllerApi.md#editAccount) | **PUT** /api/v1/upi/{e} | Edit account details by email
[**viewAccount**](UpiControllerApi.md#viewAccount) | **GET** /api/v1/upi/{e} | Get account details by email
[**viewAllAccount**](UpiControllerApi.md#viewAllAccount) | **GET** /api/v1/upi | Get all account details

<a name="createAccount"></a>
# **createAccount**
> String createAccount(body)

Create Account

Create Account

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UpiControllerApi;


UpiControllerApi apiInstance = new UpiControllerApi();
Account body = new Account(); // Account | 
try {
    String result = apiInstance.createAccount(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UpiControllerApi#createAccount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Account**](Account.md)|  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="deleteAccount"></a>
# **deleteAccount**
> String deleteAccount(e)

Delete Account by Email

Delete complete account details using the email ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UpiControllerApi;


UpiControllerApi apiInstance = new UpiControllerApi();
String e = "e_example"; // String | 
try {
    String result = apiInstance.deleteAccount(e);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UpiControllerApi#deleteAccount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **e** | **String**|  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="editAccount"></a>
# **editAccount**
> String editAccount(body, e)

Edit account details by email

Edit account details using the email ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UpiControllerApi;


UpiControllerApi apiInstance = new UpiControllerApi();
Account body = new Account(); // Account | 
String e = "e_example"; // String | 
try {
    String result = apiInstance.editAccount(body, e);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UpiControllerApi#editAccount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Account**](Account.md)|  |
 **e** | **String**|  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="viewAccount"></a>
# **viewAccount**
> String viewAccount(e)

Get account details by email

Fetches complete account details using the email ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UpiControllerApi;


UpiControllerApi apiInstance = new UpiControllerApi();
String e = "e_example"; // String | 
try {
    String result = apiInstance.viewAccount(e);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UpiControllerApi#viewAccount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **e** | **String**|  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="viewAllAccount"></a>
# **viewAllAccount**
> AccountsListResponse viewAllAccount()

Get all account details

Fetches complete account details

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UpiControllerApi;


UpiControllerApi apiInstance = new UpiControllerApi();
try {
    AccountsListResponse result = apiInstance.viewAllAccount();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UpiControllerApi#viewAllAccount");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**AccountsListResponse**](AccountsListResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml

