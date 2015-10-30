## Server Return Codes
For each client request, a status code is returned to indicate the success or failure of the request. In this project, the following HTTP return codes are used.

### 200 - Success
The request has succeeded. The information returned with the response is dependent on the method used in the request. For example in a GET, an entity corresponding to the requested resource is sent in the response.

### 400 - Bad Request
The request could not be understood by the server due to malformed syntax. The client SHOULD NOT repeat the request without modifications.

### 404 - Not Found
The server has not found anything matching the Request-URI. 
